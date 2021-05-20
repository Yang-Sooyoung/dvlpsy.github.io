

public class User { // 틀

	String name;	// 이름
	int age;		// 나이
	String hobby;	// 취미
	
	public User(String name, int age, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	/* 게터 세터 영역 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	// 클래스의 생성자
//	public User (String _name, int _age, String _hobby) { //매개변수
//		this.name = _name; // this : 클래스의 변수들을 가르킴
//		this.age = _age; 
//		this.hobby = _hobby;
//	}

}
