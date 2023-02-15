package edu.kh.oop.field.pack1;

import edu.kh.oop.field.pack2.FieldTest2;
import edu.kh.oop.field.pack2.FieldTest3;

public class FieldRun extends FieldTest3{
						//상속

	public static void main(String[] args) {

		//f1, f2 는 같은 패키지 = import없이 사용가능
		FieldTest1 f1 = new FieldTest1();
		FieldTest2 f2 = new FieldTest2();
		
		//f3는 다른패키지에 존재 = import 필요
		FieldTest3 f3 = new FieldTest3();
		
		
		//접근제한자 확인
		System.out.println(f1.v1); // public
		System.out.println(f1.v2); // protected
		System.out.println(f1.v3); // (default)
//		System.out.println(f1.v4); // private
//		The field FieldTest1.v4 is not visible
//		private 은 다른 클래스에서 보이지않음
		
		System.out.println(f2.v1); // public
//		System.out.println(f2.v2); // protected
//		System.out.println(f2.v3); // (default)
//		System.out.println(f2.v4); // private
//		패키지가 다른 feildTest2는 public 만 접근 가능, 나머지 불가능
		
	}
	
	public void ex() {
		
		FieldTest3 t3 = new FieldTest3();
		
		System.out.println(t3.v1);	//public
//		System.out.println(t3.v2);	//protected
		
		System.out.println(v2);
		//FieldRun이 FieldTest3상속
		//FieldTest3의 필드를 FieldRun이 자신의것처럼 사용가능
	}

}
