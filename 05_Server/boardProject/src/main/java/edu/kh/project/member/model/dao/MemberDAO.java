package edu.kh.project.member.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.project.common.JDBCTemplate;
import edu.kh.project.member.model.dto.Member;

public class MemberDAO {
	


	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public  MemberDAO() {
		try {
			prop = new Properties();
			// Map<String, String> 형태의 객체, XML 입출력 특화
			
			String filePath
				= JDBCTemplate.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
			
			
			// driver.xml 파일 읽어오기
			prop.loadFromXML(new FileInputStream(filePath));
			// -> XML 파일에 작성된 내용이 Properties 객체에 모두 저장됨
			
			// XML 에서 읽어온 값을 모두 Sring 변수에 저장
//			String drive = prop.getProperty("driver");
//			String url = prop.getProperty("url");
//			String user = prop.getProperty("user");
//			String password = prop.getProperty("password");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}


	/** 로그인 서비스
	 * @param conn
	 * @param inputEmail
	 * @param inputPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, String inputEmail, String inputPw) throws Exception{
		
		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt(1));
				loginMember.setMemberEmail(rs.getString(2));
				loginMember.setMemberNickname(rs.getString(3));
				loginMember.setMemberTel(rs.getString(4));
				loginMember.setMemberAddress(rs.getString(5));
				loginMember.setProfileImage(rs.getString(6));
				loginMember.setAuthority(rs.getInt(7));
				loginMember.setEnrollDate(rs.getString(8));
				
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return loginMember;
	}
	
}
