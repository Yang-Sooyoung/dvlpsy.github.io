$(document).ready(function() {

    // ------------------------------------------------------------------ 변수 파트 ---------------------------------------------------------------
    // ----------------------------------------------------------------- 맵 변수 파트 -------------------------------------------------------------
    // 맵 배열 
    // - 0: 몬스터가 다니는 길
    // - 1: 타워가 설치될 수있는 공간
    var map_arr = [
        [0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0],
        [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1, 1, 1, 1, 1, 1, 1, 1],
        [1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1, 1, 1, 1, 1, 1, 1, 1],
        [1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1, 1, 1, 1, 1, 1, 1, 1],
        [1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1 ,1, 1, 1, 1, 1, 1, 1, 1]
    ];
    // 맵 테이블 생성 변수
    var html = "";
    // 타이머 변수
    var minute = 2;         // 분
    var second = 0;         // 초
    var timer = null;       // 타이머 인터버 지정 변수
    var t_cnt = 1;          // 라운드
    var timer_on = false;   // 타이머 실행 여부
    
    // 라이프 저장 변수
    var life_cnt = 10;  // 초기값

    // 글로벌 골드 변수
    var gold = 50;  // 초기값

    // ---------------------------------------------------------------- 몹 변수 파트 ---------------------------------------------------------------
    // 몹 이름, 이미지 경로 정보 저장 변수
    var mob_name = ["rats", "bats", "snake", "slime", "skeleton", "normal_orc", "orc_warrior", "orc_spearman", "orc_thief"];
    var mob_img_loca = [
        "./images/monster_image/m_rats.png",
        "./images/monster_image/m_bats.png",
        "./images/monster_image/m_snake.png",
        "./images/monster_image/m_slime.png",
        "./images/monster_image/m_skeleton.png",
        "./images/monster_image/m_normal_orc.png",
        "./images/monster_image/m_orc_warrior.png",
        "./images/monster_image/m_orc_spearman.png",
        "./images/monster_image/m_orc_thief.png"
    ];
    // 몹 생성 푸시용 변수
    var mob_arr = [];
    var mob_timeout = [];
    // 라운드당 몹 개체수 저장 변수
    // 쥐, 박쥐, 뱀, 슬라임, 스켈레톤, 기본오크, 오크전사, 오크스피어맨, 오크시프 순서
    var round_mob_cnt = [
        [1, 0, 0, 0, 0, 0, 0, 0, 0],    //1
        [3, 1, 0, 0, 0, 0, 0, 0, 0],    //2
        [5, 3, 0, 0, 0, 0, 0, 0, 0],    //3
        [5, 5, 1, 0, 0, 0, 0, 0, 0],    //4  
        [5, 5, 3, 1, 0, 0, 0, 0, 0],    //5 
        [5, 5, 5, 3, 0, 0, 0, 0, 0],    //6 
        [5, 5, 5, 5, 1, 0, 0, 0, 0],    //7
        [5, 5, 5, 5, 3, 0, 0, 0, 0],    //8
        [5, 5, 5, 5, 5, 0, 0, 0, 0],    //9
        [5, 5, 5, 5, 7, 1, 0, 0, 0],    //10
        [5, 5, 5, 5, 9, 3, 0, 0, 0],    //11
        [5, 5, 5, 5, 9, 5, 0, 0, 0],    //12
        [5, 5, 5, 5, 9, 5, 1, 0, 0],    //13
        [5, 5, 5, 5, 9, 7, 3, 1, 0],    //14
        [5, 5, 5, 5, 9, 9, 5, 3, 0],    //15
        [5, 5, 5, 5, 9, 9, 7, 5, 1],    //16
        [5, 5, 5, 5, 9, 9, 9, 7, 3],    //17
        [5, 5, 5, 5, 9, 9, 9, 7, 5],    //18
        [5, 5, 5, 5, 9, 9, 9, 9, 9],    //19
        [10, 10, 10, 10, 10, 10, 10, 10, 10]    //20
    ];
    var create_line = 0;        //생성 라인 번호
    var c_circle = 1000;        //생성 추기
    // 몹 MAX 체력 저장 배열
    var mob_health = [];
    // 시체 정보 보관 배열
    var dead_arr = [];

    // --------------------------------------------------------------- 타워 변수 파트 -------------------------------------------------------------
    // 타워 개체 배열 변수, 이미지 경로
    var t_cls = ["warrior", "ranger", "rogue", "cleric", "wizard"];
    var t_img_loca = [
        "./images/tower_img/t_warrior.png",
        "./images/tower_img/t_ranger.png",
        "./images/tower_img/t_rogue.png",
        "./images/tower_img/t_cleric.png",
        "./images/tower_img/t_wizard.png"
    ];

    //타워 설치 관련 변수
    var select_area="";     //타워 건설 Area 저장
    var tw_arr = [];        //타워 정보 저장

    

    // ------------------------------------------------------------------ 함수 파트 ---------------------------------------------------------------
    //맵 테이블 생성
    for(var i = 0; i<14 ; i++){//tr 가로
        html += "<tr>";
        for(var j = 0; j<24 ; j++){//td 세로 한칸
            // 맵의 정보를 저장한 배열에서 길과 설치필드 값을 구분하여 클래스 부여
            if( map_arr[i][j] == 0 ) {
                html += "<td class=\"road\" id=\""+ i + "_" + j +"\"></td>";
            }
            else {
                html += "<td class=\"build mtd\" id=\""+ i + "_" + j +"\"></td>";
            }
        }
        html += "</tr>";
        d=0;
    } // 맵 생성 for문 마지막
    // 생성한 맵을 #coor에 추가
    $("#coor").html(html);

    // 타이머 초기화
	$(".minute").html(minute);
    $(".second").html("00");

    // 스타트 버튼 클릭 이벤트 지정
	$("#startBtn").on("click", function() {
        // timer_on이 false 일때만 실행
        if(!timer_on) {
            // 버튼 문구를 END ROUND로 변경
            $("#startBtn").html("END ROUND");
            timer_on = true;
            // 몹 배열에 할당
            create_mob();
            // 몹 배열 랜덤 정렬
            // sort() 안에 인자로 들어가는 함수는 배열안의 값을 비교하는 기준이 되는 함수
            // 랜덤 - 랜덤을 인자로 넘기므로 배열 정렬로 랜덤으로 실행됨
            mob_arr.sort(function() {
                return Math.random() - Math.random();
            });
            // 몹 id 재배열 - 앞에서부터 m_N 으로 지정 - 개발용
            for(var i = 0; i < mob_arr.length; i++) {
                mob_arr[i].id = "m_"+i;
            }
            // 몹 배열의 크기 저장 변수
            var length = mob_arr.length;
            // 몹의 MAX 체력 저장 - 체력바 구현 사용하기 위해
            for(var i = 0; i < length; i++) {
                mob_health[i] = mob_arr[i].hp;
            }
            // 몹 div 추가
            for(var i = 0; i < length; i++) {
                create(i);
            }
            // 몹 이동
            for(var i = 0; i< length; i++) {
                move(i);
            }
            // 타이머 인터버 지정
            timer = setInterval(function () {
                // 시체 배열이 몹배열의 크기와 똑같아 지면 비움
                if(dead_arr.length == length) {
                    dead_arr = [];
                    // 모든 시체를 html에서 제거(2초의 딜레이)
                    $(".dead").each(function() {
                        $(this).fadeOut( 2000, function() {
                            $(this).remove();
                        });
                    });
                }
                // 설정
                $(".minute").html(minute);
                
                // 초가 한자리 수 일때 앞에 0을 붙여 자리수 맞춤
                if(second < 10) {
                    $(".second").html("0" + second);
                } else {
                    $(".second").html(second);
                }
                
                // 라운드 표시
                $(".roundcnt").html("ROUND " + t_cnt);
                
                // 분과 초가 0이 되면 라운드 종료
                if(second == 0 && minute == 0){
                    t_cnt++;
                    $(".roundcnt").html("ROUND " + t_cnt);
                    alert('라운드 종료.');
                    timer_on = false;
                    clearInterval(timer); /* 타이머 종료 */
                    
                    minute = 2;
                    $(".minute").html(minute);
                    $(".second").html("00");

                    // 몹, 체력 배열 초기화
                    mob_arr = [];
                    mob_health = [];
                }else{
                    second--;
                    // 분처리
                    if(second < 0){
                        minute--;
                        second = 59;
                    }
                }
            }, 1000); /* millisecond 단위의 인터벌 */
        }
        // 조기 종료를 위한 코드
        // 타이머가 돌아가고 있으면서 몹 배열과 시체 배열의 크기가 0보다 작거나 같다면
        else if(timer_on && mob_arr.length <=0 && dead_arr.length <= 0) {
            // 버튼 문구 START로 변경
            $("#startBtn").html("START");
            t_cnt++;
            $(".roundcnt").html("ROUND" + t_cnt);
            alert('라운드 종료.');
            timer_on = false;
            clearInterval(timer); /* 타이머 종료 */
            
            minute = 2;
            second = 0;
            $(".minute").html(minute);
            $(".second").html("00");

            // 몹 체력 배열 초기화
            mob_health = [];
        }
    }); // 스타트 버튼 클릭 이벤트 지정 마지막

    // 맵 격자 표시 생성 이벤트
    $("#checkbtn").on("click", function(){
        // 체크시
		if($("#checkbtn").is(":checked") == true){
            // 맵의 td에 makegrid 클래스 추가
            $(".mtd").addClass('makegrid');
            // 설치 가능 영역에 isbuild 클래스 추가
			$(".build").addClass('isbuild');
        }
        // 체크 해제시
		else {
            // 위에서 추가한 클래스 제거
            $(".mtd").removeClass('makegrid');
			$(".build").removeClass('isbuild');
		}
    }); // 맵 격자 표시 생성 이벤트 마지막
    
    // 라이프 계산 함수 - 몹이 마지막에 가서 지워지면 실행
	function map_life() {
        // 라이프를 1 깎음
        life_cnt--;
        // 라이프 표시
		$(".life").html("LIFE : "+life_cnt);	
        
        // 라이프가 0이라면 모든 몹의 animation 중지 후 사망 alert 호출
		if(life_cnt == 0){
			$(".mob").stop();
            t_cnt = 1;
            $(".roundcnt").html("ROUND1");
			
			for(var i = 0 ; i < mob_timeout.length ; i++) {
				clearTimeout(mob_timeout[i]);
			}
			mob_timeout = [];
            $(".mob").remove();
            mob_arr = [];
            mob_health = [];
            
            clearTimeout(timer);
            $(".minute").html("2");
            $(".second").html("00");
            
			setTimeout(function() {alert("사망!");}, 500);	
		}
	}




    // 몹 객체 생성 함수
    function mob_info(num) {
        var mob_hp = 0;         // 몹 체력
        var mob_speed_s = 0;    // 짧은 구간 몹 속도
        var mob_speed_l = 0;    // 긴 구간 몹 속도
        var mob_gold = 0;       // 몹이 드랍하는 골드
        var m_scale=0;          // 이미지 방향 지정용 -> 좌우가 통일되지 않아서 여기서 지정
        
        // 몹의 종류별 스탯 부여
        switch(mob_name[num]) {
            case "rats":
                mob_hp = 70;
                mob_speed_s = 2560;
                mob_speed_l = 7000;
                mob_gold = 5;
                m_scale = -1;
                break;
            case "bats":
                mob_hp = 70;
                mob_speed_s = 2560;
                mob_speed_l = 6000;
                mob_gold = 6;
                m_scale = -1;
                break;
            case "snake":
                mob_hp = 1000;
                mob_speed_s = 2560;
                mob_speed_l = 7500;
                mob_gold = 7;
                m_scale = -1;
                break;
            case "slime":
                mob_hp = 1500;
                mob_speed_s = 2560;
                mob_speed_l = 13500;
                mob_gold = 8;
                m_scale = -1;
                break;
            case "skeleton":
                mob_hp = 5000;
                mob_speed_s = 2560;
                mob_speed_l = 12500;
                mob_gold = 9;
                m_scale = 1;
                break;
            case "normal_orc":
                mob_hp = 13000;
                mob_speed_s = 2560;
                mob_speed_l = 10500;
                mob_gold = 10;
                m_scale = 1;
                break;
            case "orc_warrior":
                mob_hp = 15000;
                mob_speed_s = 2560;
                mob_speed_l = 11500;
                mob_gold = 11;
                m_scale = 1;
                break;
            case "orc_spearman":
                mob_hp = 18000;
                mob_speed_s = 2560;
                mob_speed_l = 9500;
                mob_gold = 12;
                m_scale = 1;
                break;
            case "orc_thief":
                mob_hp = 15000;
                mob_speed_s = 2560;
                mob_speed_l = 8500;
                mob_gold = 13;
                m_scale = 1;
                break;
        }

        var obj = {
            id: "",
            name: mob_name[num],
            img_loca: mob_img_loca[num],
            hp: mob_hp,
            ss: mob_speed_s,
            sl: mob_speed_l,
            gold: mob_gold,
            X: 0,
            Y: -128,
            inter : null,
            m_s : m_scale,
            m_x : 0,
            m_y : 0,
        };

        return obj;
    } // 몹 객체 생성 함수 마지막

    //몹 이미지 무한 재생
    function mob_sprite(mob) {
        if( mob.X <= 0) {
            mob.X -= 64;
        }
        if(mob.X <= -640) {
            mob.X = 0;
        }

        $("#"+mob.id).css("background-position-x", mob.X+"px");
        $("#"+mob.id).css("background-position-y", mob.Y+"px");

        // 몹의 top, left 좌표를 저장
        mob.m_x = $("#"+mob.id).offset().top;
        mob.m_y = $("#"+mob.id).offset().left;
    }
    
    // 라운드별 몬스터 생성 함수
    function create_mob() {
        // 몹의 종류만큼 반복
        for(var i = 0; i < 9; i++) {
            // 각 라운드당 몹의 개수는 round_mob_cnt 배열에 한라인씩 저장되어있음
            // t_cnt -> 라운드
            var mob_cnt = round_mob_cnt[t_cnt-1][i];
            // 라운드당 몹의 개수 만큼 반복
            for(var j = 0; j < mob_cnt; j++) {
                mob_arr.push(mob_info(i));
            }
        }
    }

    // 몬스터 생성 중 죽으면 기존 id가 달라져서 못찾는 이슈 있음
    // 생성과 이동을 분리하고 라운드 시작시 전부 생성해두고 보이는 방식 채용으로 이슈 해결
    // 몬스터 html 추가 함수
    function create(num) {
        var mob = mob_arr[num];
        var mob_div = "<div id=\"" + mob.id + "\"><div id=\"hp_bar_wrap\"><div id=\"hp_bar\"></div></div></div>";
        
        $(".map_table").append(mob_div);
        $("#"+mob.id).addClass('mob_hidden');
        
        //몹 이미지 설정
        $("#"+mob.id).css({"background-image":"url("+mob.img_loca+")"});
        //몹 인터버 설정
        mob.inter = setInterval(mob_sprite, 100, mob);
    }

    // 몬스터 이동 함수
    function move(num) {
        var mob = mob_arr[num];
        setTimeout(function() {
            $("#"+mob.id).removeClass('mob_hidden');
            $("#"+mob.id).addClass('mob');

            // 0번 라인 생성
            if(create_line == 0) {
                create_line = 1;
                $("#" + mob.id).css("transform", "scaleX("+mob.m_s+")");
                $("#" + mob.id).fadeIn(500 ,function() {
                    $("#"+mob.id).animate({"top":"+=256px"}, mob.ss, function() {
                        $("#"+mob.id).animate({"left":"+=1280px"}, mob.sl, function() {
                            mob.m_s *= -1;
                            $("#" + mob.id).css("transform", "scaleX("+mob.m_s+")");
                            $("#"+mob.id).animate({"top":"+=256px"}, mob.ss, function() {
                                $("#"+mob.id).animate({"left":"-=1344px"}, mob.sl, function() {
                                    $("#"+mob.id).animate({"top":"+=320px"}, mob.ss, function() {
                                        $("#"+mob.id).fadeOut(300, function() {
                                            clearInterval(mob.inter);
                                            $("#"+mob.id).remove();
                                            map_life();
                                            dead_arr.push(mob);
                                            for(var i = 0; i < mob_arr.length; i++) {
                                                if(mob.id == mob_arr[i].id) {
                                                    mob_arr.splice(i, 1);
                                                }
                                            }
                                        });
                                    });
                                });
                            });
                        });
                    });   
                }); 
            }
            // 1번 라인 생성
            else {
                create_line = 0;
                $("#" + mob.id).css("transform", "scaleX("+mob.m_s+")");
                //시작 위치 변경
                $("#"+mob.id).css("left", 192+"px");
                $("#"+mob.id).fadeIn(500 ,function() {
                    $("#"+mob.id).animate({"top":"+=192px"}, mob.ss, function() {
                        $("#"+mob.id).animate({"left":"+=1280px"}, mob.sl, function() {
                            mob.m_s *= -1;
                            $("#" + mob.id).css("transform", "scaleX("+mob.m_s+")");
                            $("#"+mob.id).animate({"top":"+=384px"}, mob.ss, function() {
                                $("#"+mob.id).animate({"left":"-=1344px"}, mob.sl, function() {
                                    $("#"+mob.id).animate({"top":"+=256px"}, mob.ss, function() {
                                        $("#"+mob.id).fadeOut(300, function() {
                                            clearInterval(mob.inter);
                                            $("#"+mob.id).remove();
                                            map_life();
                                            dead_arr.push(mob);
                                            for(var i = 0; i < mob_arr.length; i++) {
                                                if(mob.id == mob_arr[i].id) {
                                                    mob_arr.splice(i, 1);
                                                }
                                            }
                                        });
                                    });
                                });
                            });
                        });
                    }); 
                });
            }
        }, c_circle*(num+1));   // 생성주기 = 생성주기(초) * 해당 배열의 번호+1 -> 이렇게 하면 한번에 타임아웃을 지정하되 일정한 간격으로 나오게 가능
    } // 몬스터 이동 함수 마지막



    //타워 객체 생성 함수
    function tower_info(num) {
        var t_ad = 0;       //데미지, 초당 데미지
        var t_as = 0;       //공격 속도, 초당 공격횟수
        var t_ar = 0;       //공격 사거리
        var t_price = 0;    //타워 가격
        var t_y;            //여, 남 랜덤 정의

        // 랜덤으로 1, 2 값을 가져옴
        var rand = Math.floor(Math.random() *2 + 1);
        // 1이면 남자
        if(rand == 1) {
            t_y = 0;
        }
        // 2이면 여자
        else {
            t_y = -128;
        }

        // 각 클래스별 스탯 부여
        switch(t_cls[num]) {
            case "warrior":
                t_ad = 5;
                t_as = 2;
                t_ar = 1;
                t_price = 10;
                break;
            case "ranger":
                t_ad = 10;
                t_as = 1;
                t_ar = 2;
                t_price = 20;
                break;
            case "rogue":
                t_ad = 25;
                t_as = 2;
                t_ar = 1;
                t_price = 50;
                break;
            case "cleric":
                t_ad = 15;
                t_as = 1;
                t_ar = 2;
                t_price = 120;
                break;
            case "wizard":
                t_ad = 12;
                t_as = 1;
                t_ar = 3;
                t_price = 200;
                break;
        }

        var obj = {
            id: select_area,    // 타워의 위치 id
            cls: t_cls[num],    // 타워의 클래스
            img_loca: t_img_loca[num],  // 타워의 클래스에 따른 이미지 경로
            ad: t_ad,           // 타워의 공격력
            as: t_as,           // 타워의 공격 속도
            ar: t_ar,           // 타워의 공격 사거리
            X:0,                // 타워 이미지의 position-x
            Y:t_y,              // 타워 이미지의 position-y
            isattack:false,     // 타워 공격 여부
            inter:null,         // 타워 이미지 재생 저장 
            a_t : 0,            // 타워 사거리의 top
            a_l : 0,            // 타워 사거리의 left
            a_r : 0,            // 타워 사거리의 right
            a_b : 0,            // 타워 사거리의 bottom
            cost : t_price      // 타워 가격
        };
        return obj;
    }

    // 설치할 필드 선택
    $(".build").each(function() {
        $(this).on("click", function() {
            // 선택을 바꿨을때 기존 선택 필드가 있다면 기존 선택 필드의 isselect 클래스 제거
            if(select_area != "") {
                $("#"+select_area).removeClass('isselect');
            }
            // 선택한 필드에 isselect 클래스 부여
            $(this).addClass('isselect');
            // select_area 값 저장
            select_area = $(this).attr("id");
        });
    });

    // 필드에 타워 설치
    $(".btnC").on("click", function() {
        // 위치를 지정하지 않았을 때 설치를 진행하지 않고 alert
        if(select_area == "") {
            alert("위치를 지정해주세요");
            return 0;
        }
        tw_arr.push(tower_info($(this).attr("id")));

        //타워 배열의 마지막 값 호출 변수
        var last_arr = tw_arr[tw_arr.length - 1];
        var i_url = "url("+last_arr.img_loca+")";

        if(gold >= last_arr.cost) {
            // 설치 후 현재 골드에서 타워 골드 뺴기
            gold -= last_arr.cost;
            // 현재 골드 표시
            $(".gold").html("GOLD : "+gold);

            // 해당 타워의 이미지 설정
            $("#"+select_area).css({"background-image":i_url, "background-repeat":"no-repeat", "background-color":"#00000000", "background-position-x":last_arr.X, "background-position-y":last_arr.Y});
            // 설치 후 해당 필드의 클래스를 바꿈
            $("#"+select_area).attr("class", "tower");
            // 타워가 설치되어있는 장소의 id값을 저장
            last_arr.id = select_area;
            // 기존에 있던 클릭 이벤트 연결을 지움(타워 설치 이벤트)
            $(".tower").off("click");
            // 지정장소 초기화
            select_area = "";
            // 타워의 공격 사거리 좌표 저장
            last_arr.a_t = $("#"+last_arr.id).offset().top - (64*last_arr.ar);          // 사거리의 위쪽 MAX
            last_arr.a_r = $("#"+last_arr.id).offset().left + (64*last_arr.ar) + 64;    // 사거리의 오른쪽 MAX
            last_arr.a_b = $("#"+last_arr.id).offset().top + (64*last_arr.ar) + 64;     // 사거리의 아래쪽 MAX
            last_arr.a_l = $("#"+last_arr.id).offset().left - (64*last_arr.ar);         // 사거리의 왼쪽 MAX
            
            // 이미지 변경 인터버 추가
            setInterval(change_img, 80, last_arr);
            // 공격 감지 인터버 추가
            last_arr.inter = setInterval(attack_monster, 100);
    
            // 타워 호버 이벤트 호출 - 사거리 표시
            t_hover(last_arr);
        }
    });

    // 이미지 좌표 변경 함수
    function change_img(last_arr) {
        // 타워가 공격 중일때 Y값 변경
        // 여자, 남자 냐에 따라 시작 지점이 다름
        if(last_arr.isattack) {
            if(last_arr.Y == -128 || last_arr.Y == -192) {
                last_arr.Y = -192;
            }
            else {
                last_arr.Y = -64;
            }
        }
        // 공격 중이지 않을때
        else {
            if(last_arr.Y == -192 || last_arr.Y == -128) {
                last_arr.Y = -128;
            }
            else {
                last_arr.Y = 0;
            }
        }

        // 연속적으로 X 좌표 변경
        if( last_arr.X <= 0) {
            last_arr.X -= 64;
        }
        if(last_arr.X <= -640) {
            last_arr.X = 0;
        }

        $("#"+last_arr.id).css("background-position-x", last_arr.X+"px");
        $("#"+last_arr.id).css("background-position-y", last_arr.Y+"px");
    }

    // 타워 호버 이벤트
    function t_hover(last_arr) {
        $(".tower").each(function() {
            // 타워에 호버시 해당 타워의 사거리를 보여줌
            $(this).hover(
                // mouseover
                function() {
                    var id = $(this).attr("id");
                    var a = id.split("_");
                    // 타워 갯수 만큼 반복
                    for(var i = 0; i < tw_arr.length; i++) {
                        if(id == last_arr.id) {
                            // 타워와 사거리를 기준으로 최대 최소 행렬 값을 저장하여 반복문 실행
                            var min_j = (a[0]/1)-(last_arr.ar);
                            var max_j = (a[0]/1)+(last_arr.ar);
                            var min_k = (a[1]/1)-(last_arr.ar);
                            var max_k = (a[1]/1)+(last_arr.ar);
                            for(var j = min_j; j <= max_j; j++) {
                                for(var k = min_k; k <= max_k; k++) {
                                    $("#"+j+"_"+k).addClass('tower_hover');
                                }
                            }
                        }
                    }
                }, 
                // mouseout
                function() {
                    // tower_hover 클래스를 가진 모든 요소의 tower_hover 클래스 제거
                    $(".tower_hover").each(function() {
                        $(this).removeClass('tower_hover');
                    });
                }
            );
        });
    }

    // 공격 체크
    function attack_monster() {
        // 공격은 timer_on이 true 즉, 라운드가 시작됬을때 실행
        if(timer_on) {
            // 타워 갯수 만큼 반복
            for(var i = 0; i < tw_arr.length; i++) {
                var tw = tw_arr[i];
                // 몹 개체수 만큼 반복
                for(var j = 0; j < mob_arr.length; j++) {
                    var mob = mob_arr[j];

                    // 타격 범위안에 들어왔을때 - 몹의 x, y 좌표가 타워의 상하좌우 사거리 좌표 안으로 들어왔을때
                    if(tw.a_t <= mob.m_x && tw.a_b > mob.m_x && tw.a_l <= mob.m_y && tw.a_r > mob.m_y) {
                        // 해당 타워를 공격 상태로 바꿈
                        tw.isattack = true;
                        // 몹이 있는 방향으로 타워의 좌우 변경 
                        // - scaleX는 이미지를 배율로 키워 보여주는데 1이면 일반 크기, -1이면 X 반전의 이미지를 보여줌
                        if((tw.a_l + (64 * tw.ar) + 32) > mob.m_y) {
                            $("#"+ tw.id).css("transform", "scaleX(-1)");
                        }
                        else {
                            $("#"+ tw.id).css("transform", "scaleX(1)");
                        }

                        // 몹의 체력이 0보다 높다면
                        if(mob.hp > 0) {
                            // 데미지를 줘서 몹의 체력을 깎음
                            mob.hp -= ((tw.ad/10) * tw.as);
                            // 몹 체력 바 함수 실행
                            health(j);

                            // 몹의 체력이 0이거나 더 아래일 경우
                            if(mob.hp <=0) {
                                // 공격을 중지
                                tw.isattack = false;
                                 
                                // 몹의 animation을 멈춤
                                $("#"+mob.id).stop();
                                // 몹 이미지 재생을 제거
                                clearInterval(mob.inter);
                                mob.inter = null;
                                // 해당 몹의 정보를 시체 배열에 추가
                                mob.X = 0;
                                dead_arr.push(mob);
                                // 해당 몹의 드랍골드만큼 골드를 추가 하고 표시
                                gold += mob.gold;
                                $(".gold").html("GOLD : "+gold);
                                
                                // 몹이 죽었을때 시체 생성
                                dead(dead_arr.length-1);

                                // 해당 몹 div 제거
                                $("#"+mob.id).remove();
                                // 해당 몹의 배열값과 체력 배열값 제거
                                mob_arr.splice(j, 1);
                                mob_health.splice(j, 1);
                            } 
                        }
                        // 공격을 마친뒤 다시 몹을 0번부터 체크함(몹 for 강제 종료)
                        break; 
                    }
                    // 범위안에 없다면
                    else {
                        // 공격을 중지함
                        tw.isattack = false;
                    }
                }
                // 몹 배열의 길이가 0보다 작다면 공격중지 - 마지막 몬스터가 죽어도 가끔 공격을 중지하지 않는 이슈 해결
                if(mob_arr.length <= 0) {
                    tw.isattack = false;
                } 
            }
        }
    }

    // 시체 이미지 설정
    function dead(i) {
        var d_html = "<div id=\"dead_"+dead_arr[i].id+"\"></div>";
        // 시체 맵테이블에 추가
        $(".map_table").append(d_html);
        $("#dead_"+dead_arr[i].id).addClass('dead');
        // 이미지 경로 지정
        $("#dead_"+dead_arr[i].id).css("background-image", "url("+dead_arr[i].img_loca+")");
        // 이미지 포지션 지정
        $("#dead_"+dead_arr[i].id).css("background-position-x", 0);
        $("#dead_"+dead_arr[i].id).css("background-position-y", -256);
        // 이미지의 생성 위치 지정 -> 몬스터가 죽었던 top, left 자리
        $("#dead_"+dead_arr[i].id).css("top", dead_arr[i].m_x);
        $("#dead_"+dead_arr[i].id).css("left", dead_arr[i].m_y);
        
        dead_arr[i].inter = dead_img(("#dead_"+dead_arr[i].id), i);
    }
    // 시체 이미지 재생
    function dead_img(id, n) {
        setTimeout(function() {
            // 시체 배열이 0보다 클때
            if(dead_arr.length > 0) {
                // 이미지를 처음부터 끝까지 재생 단, 반복하지 않음
                if( dead_arr[n].X > -640 &&dead_arr[n].X <= 0) {
                    dead_arr[n].X -= 64;
                }
                else {
                    dead_arr[n].X = -640;
                    // clearInterval(dead_arr[n].inter);
                    // dead_arr[n].inter = null;
                }
                // 몹의 방향대로 시체도 같은 방향으로 생성
                $(id).css("transform", "scaleX("+dead_arr[n].m_s+")");
                $(id).css("background-position-x", dead_arr[n].X);
                
                return dead_img(id, n);
            }
        }, 100);
    }

    // 몹의 체력 바 함수
    function health(n) {
        // 현재 체력을 퍼센트로 저장 -> (몹 현재 체력 / 몹 MAX 체력) * 100 = 현재 체력 퍼센트
        var now_hp = Math.floor((mob_arr[n].hp / mob_health[n]) * 100);
        var hp_color = "";
        // 퍼센트가 70 초과일 때
        if(now_hp > 70) {
            hp_color = "#299c3c";
        }
        // 퍼센트가 70 이하 30초과일 때
        else if(now_hp <= 70 && 30 < now_hp) {
            hp_color = "#F2CB07";
        }
        // 퍼센트가 30 이하일 때
        else {
            hp_color = "#FF3E3E"
        }
        // 체력바의 색을 지정색으로 변경
        $("#"+mob_arr[n].id+"> #hp_bar_wrap > #hp_bar").css("background-color", hp_color);
        // 체력바의 길이를 퍼센트만큼으로 변경
        $("#"+mob_arr[n].id+"> #hp_bar_wrap > #hp_bar").css("width", now_hp+"%");
    }
});