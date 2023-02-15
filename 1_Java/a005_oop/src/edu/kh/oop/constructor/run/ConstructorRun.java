package edu.kh.oop.constructor.run;

import edu.kh.oop.constructor.dto.Member;

public class ConstructorRun {

	public static void main(String[] args) {

		// 회원 생성
		Member mem1 = new Member();
		
		//매개변수 생성자를 이용해서 Member 객체 생성
		Member mem2 = new Member("User11", "159753asd", "김김김", 49);
		Member mem3 = new Member("User19991");
		
		System.out.println(Member.programName);
		
		System.out.println("--------");
		
		
		
		
	}

}
