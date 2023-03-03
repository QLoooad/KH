package edu.kh.io.run;

import edu.kh.io.service.IOService;

public class IORun {
	public static void main(String[] args) {
		
		IOService service = new IOService();
		
//		service.byteOutPut();
//		service.charOutput();
//		service.byteInput();
//		service.charInput();
//		service.fileCopy();
//		service.objectOutput();
//		service.objectInput();
//		service.listOutput();
		service.listInput();
		
		
		// stream(스트림) : 데이터 통로(단방향)
		
		//바이트 기반 스트림
		//1byte 단위로 데이터 입/출력 스트림
		//1byte 문자 text
		//이미지, 영상, 파일 등 문자가 아닌 데이터/파일
		
		//문자 기반 스트림
		//문자 단위로 데이터를 입 / 출력하는 스트림
		//문자로 이루어진 text, 채팅, 코드
		
	}
	
		
		
		
		
		
		
		
		
		
		
		
}

