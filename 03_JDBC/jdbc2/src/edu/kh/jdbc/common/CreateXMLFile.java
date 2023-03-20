package edu.kh.jdbc.common;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

public class CreateXMLFile {

	public static void main(String[] args) {

		// XML(eXtensible Markup Language) : 확장된 마크업 언어 ([마크업]기술 언어,형식)
		//  -> 단순화된 데이터 기술 형식
		
		// XML에 저장되는 데이터 형식은 Map (key : value) 형식
		// key : value 모두 String
		// Map <String : String>
		
		// Properties 컬렉션
		// - Map의 후손 클래스
		// - key : value 가 모두 String Map >> Map <String : String>
		// - XML 파일을 읽고 쓰는데 특화된 메서드 제공
		
		Scanner sc = new Scanner(System.in);
		
		// Properties
		Properties prop = new Properties();
		// // key : value 모두 String 고정, 제네릭 선언 x
		
		System.out.print("생성 파일 이름 : ");
		String fileName = sc.nextLine();
		
		// FileOutputStream
		try {
			FileOutputStream fos = new FileOutputStream(fileName + ".xml");
			
			// Properties 객체를 이용해 XML 파일 만들기
			// storeToXML (바이트출력스트림, 설명)
			prop.storeToXML(fos, fileName + ".xml file");
			
			System.out.println(fileName + ".xml 파일 생성");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
