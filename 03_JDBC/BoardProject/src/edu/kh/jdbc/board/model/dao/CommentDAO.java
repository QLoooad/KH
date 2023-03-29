package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;

public class CommentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	public CommentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 댓글 목록 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception {
		List<Comment> commentList = new ArrayList<>();
		
		try {
			// SQL 작성 properties
			String sql = prop.getProperty("selectCommentList");
			
			// SQL 수행 후 결과 반환
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			// 1행씩 접근 후 컬럼 값 얻어와 옮겨담기
			while(rs.next()) {
				Comment c = new Comment();
				
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				
				commentList.add(c);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return commentList;
	}
	
	/** 다음 댓글 번호 조회 SQL 수행 
	 * @param conn
	 * @return commentNo
	 * @throws Exception
	 */
	public int nextCommentNo(Connection conn) throws Exception {
		int commentNo = 0;

		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = prop.getProperty("nextCommentNo");
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				commentNo = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		// 5.결과반환
		return commentNo;
	}


	public int insertComment(Connection conn, String comment, int memberNo, int boardNo) throws Exception {
		 // 내용, 게시글 번호, 로그인 회원 번호를 이용해
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, comment);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public Comment checkCommentNo(Connection conn, int commentNo) throws SQLException {
		Comment comment = null;
		try {
			String sql = prop.getProperty("checkCommentNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNo);
			
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				
				int getMemberNo = rs.getInt(1);
				
				
				comment = new Comment();
				
				comment.setMemberNo(getMemberNo);
			} 
		} finally {
			close(rs);
			close(pstmt);
		}
		return comment;
	}


	public int updateComment(Connection conn, String reComment, int commentNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reComment);
			pstmt.setInt(2, commentNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int checkCommentInTheBoard(Connection conn, int boardNo, int commentNo) throws Exception {
		int comment = 0;
		try {
			String sql = prop.getProperty("checkCommentInTheBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, commentNo);
			
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				
				comment = rs.getInt(1);
				
			} 
		} finally {
			close(rs);
			close(pstmt);
		}
		return comment;
	
	}


	public int deleteComment(Connection conn, int commentNo) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	
}
