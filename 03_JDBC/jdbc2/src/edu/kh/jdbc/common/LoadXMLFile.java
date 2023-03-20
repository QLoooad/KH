package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class LoadXMLFile {
	public static void main(String[] args) {
		
		try {
			// Properties 객체 생성
			Properties prop = new Properties();
			
			// FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream("driver.xml"); 
			
			// FileInputStream 에 연결된 xml 파일을 읽어와
			// Properties 객체에 저장
			prop.loadFromXML(fis);
			
//			System.out.println(prop.toString());
			
			// Property : 속성, 성질
			// Properties.getProperty("key") : key 에 해당하는 value 얻음
			
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			
			// DB 연결 테스트 (Connection 얻기) 
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pw); 
			
			System.out.println(conn);
			
			conn.close();
			
			/*		왜 XML 같은 외부 파일을 이용해 DB정보를 얻나
			 * 1. 코드 중복제거
			 * 2. 별도 관리 용이
			 * 		- 별도 파일을 이용하기에 공통된 코드로 관리 가능
			 * 3. 코드 수정으로 인한 재컴파일 과정을 없애기 위해
			 * 		- 코드 한글자라도 수정 시 java 전체가 컴파일을 다시 진행
			 * 		- 코드수정을 하지 않기에 재컴파일 시간 단축
			 * 4. SQL 작성/관리에 용이
			 * 		- XML 파일에 작성된 문자열은 형태 그대로를 읽어오게 됨
			 * */
			Statement stmt = null; 
			ResultSet rs = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
