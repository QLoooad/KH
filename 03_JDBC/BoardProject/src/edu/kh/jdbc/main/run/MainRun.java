package edu.kh.jdbc.main.run;

import edu.kh.jdbc.main.view.MainView;

public class MainRun {
	public static void main(String[] args) {
		
		// 객체를 1회용으로 사용
		new MainView().mainMenu();
	}
}
