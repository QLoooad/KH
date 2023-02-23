package edu.kh.polymorphism.ex2.dto;
			//추상 클래스 상속 시 abstract 메서드도 상속되는데
			//미완성 상태이므로 구현하라고 에러 발생
public class Person extends Animal {

	
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String type, String eatType, String name, int age) {
		super(type, eatType);
		this.name = name;
		this.age = age;
	}

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
	
	//toString() 자동완성
	// alt + [shift] + s > s
	@Override
	public String toString() {
		return super.toString() + " / " + name + " / " + age;
	}

	// 상속 받은 추상 메서드 강제 구현(오버라이딩)
	@Override
	public void breath() {
		System.out.println("코와 입으로 숨을 쉰다.");
	}
	
	
	
	
	
	

}
