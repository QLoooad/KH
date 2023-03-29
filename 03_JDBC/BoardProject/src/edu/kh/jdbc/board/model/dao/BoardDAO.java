package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Board;

public class BoardDAO {
	//test
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// XML 불러와서 담기
	private Properties prop;

	public BoardDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
			// Properties 객체에
			// key:value 형식으로 xml 내용이 저장됨
			// prop.getProperty("key") 호출
			// value (SQL) 반환

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/** 
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoard(Connection conn) throws Exception {
		
		List<Board> boardList = new ArrayList<>();
				
		try {
			// SQL 작성 properties
			String sql = prop.getProperty("selectAllBoard");
			
			// SQL 수행 후 결과 반환
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 1행씩 접근 후 컬럼 값 얻어와 옮겨담기
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
	            int commentCount = rs.getInt("COMMENT_COUNT");
			
	            Board board = new Board();
	            
	            board.setBoardNo(boardNo);
	            board.setBoardTitle(boardTitle);
	            board.setMemberName(memberName);
	            board.setReadCount(readCount);
	            board.setCreateDate(createDate);
	            board.setCommentCount(commentCount);
	            
	            boardList.add(board);
	            
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		
		}
		
		return boardList;
	}

	/** 게시글 상세 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int input) throws Exception{
		
		Board board = null;
		
		try {
		
			String sql = prop.getProperty("selectBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				
				String boardContent = rs.getNString("BOARD_CONTENT");
				int memberno = rs.getInt("MEMBER_NO");
				
				board = new Board();
				
				board.setBoardNo(boardNo);
	            board.setBoardTitle(boardTitle);
	            board.setMemberName(memberName);
	            board.setReadCount(readCount);
	            board.setCreateDate(createDate);
	            
	            board.setBoardContent(boardContent);
	            board.setMemberNo(memberno);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return board;
	}

	public int updateReadCount(Connection conn, int input) throws Exception{
		int result = 0;

		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = prop.getProperty("updateReadCount");
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, input);

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		// 5.결과반환
		return result;
	}

	public int updateBoard(Connection conn, String boardTitle, String boardContent, int boardNo) throws Exception{
		int result = 0;

		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = prop.getProperty("updateBoard");
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);

			result = pstmt.executeUpdate();

		} finally {

			close(pstmt);
		}

		// 5.결과반환
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		int result = 0;

		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = prop.getProperty("deleteBoard");
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();
			// DDL(CREATE, ALTER, DROP) 수행도 가능
			// RESULT -1
		} finally {

			close(pstmt);
		}

		// 5.결과반환
		return result;
	}

	/** 다음 게시글 번호 조회 SQL 수행 
	 * @param conn
	 * @return boardNo
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception {
		int boardNo = 0;

		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = prop.getProperty("nextBoardNo");
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				boardNo = rs.getInt(1);
			}

		} finally {

			close(rs);
			close(stmt);
		}

		// 5.결과반환
		return boardNo;
	}

	/** 게시글 삽입
	 * @param conn
	 * @param boardTitle
	 * @param boardContent
	 * @param memberNo
	 * @param boardNo
	 * @return result
	 */
	public int insertBoard(Connection conn, String boardTitle, 
			String boardContent, int memberNo, int boardNo) throws Exception {
		
		int result = 0;
		
		try {
			// 2. PreaparedStatement 생성
			// 2.1 SQL 작성
			String sql = prop.getProperty("insertBoard");
			// 2.2 PreaparedStatement 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.setInt(4, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {

			close(pstmt);
		}

		// 5.결과반환
		
		return result;
	}



	
}
