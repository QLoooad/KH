package edu.kh.objectarray.dto;

public class Student {
	
	private int grade;		//학년
	private int classRoom;	//반
	private int number;		//번호
	private String name;	//이름
	
	private int kor;	//국어점수
	private int eng;	//영어점수
	private int math;	//수학점수
	
	//생성자
	public Student() {//	기본 생성자
		
	}
	
	//매개변수 생성(오버라이딩)
	public Student(int grade, int classRoom, int number, String name) {
		
		//this
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.name = name;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	//객체의 필드 값을 하나의 문자열 형태로 반환하는 매서드
	public String toString() {	
		return String.format("%d학년 %d반 %d번 %s [%d, %d, %d]", 
				grade, classRoom, number, name, kor, eng, math);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
