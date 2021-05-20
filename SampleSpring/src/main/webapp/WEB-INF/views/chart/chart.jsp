<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chart Sample</title>
<!-- jQuery Script -->
<script type="text/javascript" 
		src="resources/script/jquery/jquery-1.12.4.min.js"></script>
		
<!-- highcharts Script -->
<script src="resources/script/highcharts/highcharts.js"></script>
<script src="resources/script/highcharts/modules/exporting.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	getData();
	
	$("#reloadBtn").on("click", function() {
		getData();
	});
	
	$("body").on("click", "input[name='typeBtn']", function(){
		$("#chartType").val($(this).attr("id"));
		getData();
	});
});

function getData() {
	var params =  $("#getForm").serialize();
	$.ajax({
		type : "post",
		url : "getChartData",
		dataType : "json",
		data : params,
		success : function(result) {
			makeChart(result.list);
		},
		error : function(request,status,error) {
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

function makeChart(list) {
	$('#container').highcharts({
        chart: {
            type: $("#chartType").val(),
            zoomType: 'x'
        },
        colors: ['#5CB3FF', '#D462FF', '#FBB917', '#00B3A2', '#FB558A', 
                 '#2870E3', '#FF8F00', '#B5BF07', '#3F9D00', '#CE3C92'],
        title: {
            text: 'SampleChart'
        },
        subtitle: {
            text: '- Sample -'
        },
        xAxis: {
            labels: {
                formatter: function() {
                    return this.value; // clean, unformatted number for year
                }
            }
        },
        yAxis: {
            title: {
                text: 'yPos'
            },
            labels: {
                formatter: function() {
                    return this.value +'k';
                }
            }
        },
        tooltip: {
            pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>in {point.x}'
        },
        plotOptions: {
            area: {
                pointStart: 1,
                marker: {
                    enabled: false,
                    symbol: 'circle',
                    radius: 2,
                    states: {
                        hover: {
                            enabled: true
                        }
                    }
                }
            }
        },
        series: list
    });
	
	/* $("tspan").each(function(){
		if($(this).html() == "Highcharts.com") {
			$(this).remove();
		}
	}); */
}
</script>
</head>
<body>
<input type="hidden" id="chartType" value="column"/>
<form action="#" id="getForm">
사이즈 : <input type="text" name="size" value="5" />
시리즈 : <input type="text" name="series" value="2" />
</form>
<input type="button" value="리로드" id="reloadBtn"/>
<input type="button" value="컬럼" id="column" name="typeBtn"/>
<input type="button" value="바" id="bar" name="typeBtn"/>
<input type="button" value="에리어" id="area" name="typeBtn"/>
<input type="button" value="라인" id="line" name="typeBtn"/>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</body>
</html>