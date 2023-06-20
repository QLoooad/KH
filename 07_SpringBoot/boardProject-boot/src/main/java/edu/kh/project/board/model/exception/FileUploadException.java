package edu.kh.project.board.model.exception;

// 사용자 정의 예외를 만드는 방법
// -> Exception 관련 클래스 상속

// tip. unchecked exception을 상속 받아 구현
// RuntimeException 상속을 받아서 구현

//unchecked exception : 예외 처리 선택
//checked exception: 예외 처리 필수

// 예외처리 : try-catch / trows
public class FileUploadException extends RuntimeException{
	
	public FileUploadException() {
		super("파일 업로드 중 예외 발생");
	}
	
	public FileUploadException(String message) {
		super(message);
	}
	
	

}
