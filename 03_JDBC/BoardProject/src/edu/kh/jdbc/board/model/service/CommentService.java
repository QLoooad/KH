package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Comment;

public class CommentService {

	private CommentDAO CommentDao = new CommentDAO();

	public int insertComment(String comment, int memberNo, int boardNo) throws Exception {
		Connection conn = getConnection();
		
		
		int result = CommentDao.insertComment(conn, comment, memberNo, boardNo);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	/** 댓글 작성자 멤버 넘버 조회 서비스
	 * @param commentNo
	 * @param memberNo
	 * @return
	 * @throws SQLException 
	 */
	public Comment checkCommentNo(int commentNo) throws Exception {
		Connection conn = getConnection();
		
		Comment comment = CommentDao.checkCommentNo(conn, commentNo);
		
		close(conn);
		
		return comment;	
	}

	public int updateComment(String reComment, int commentNo) throws Exception {
		Connection conn = getConnection();
		
		int result = CommentDao.updateComment(conn, reComment, commentNo);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkCommentInTheBoard(int boardNo, int commentNo) throws Exception {
		Connection conn = getConnection();
		
		int comment = CommentDao.checkCommentInTheBoard(conn, boardNo, commentNo);
		
		close(conn);
		
		return comment;	
	}

	public int deleteComment(int commentNo) throws Exception {
		Connection conn = getConnection();
		
		int result = CommentDao.deleteComment(conn, commentNo);
		
		//트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
