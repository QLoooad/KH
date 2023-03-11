package edu.kh.game.run;

import java.util.Random;

import edu.kh.game.dto.Player;
import edu.kh.game.service.Service;
import edu.kh.game.view.GameView;

public class GameRun {
	
	private Player p1 = new Player("당신", 5, 0, 1, 5, 7, false);
	
	
//	public void itemView()  {
//		
//		System.out.println("[현재 소지 중인 아이템 목록]");
//		for(int i = 0; i < p1Item.length; i++) {
//			if(p1Item[i] != (null)) {
//				System.out.println(i+1 + ". " +  "\"" + p1Item[i] + "\"");
//			}
//		}
//	}

	public static void main(String[] args) throws NullPointerException{
		
		String[] p1Item = new String[5];
		
		p1Item[0] = "의료상자";
		p1Item[1] = "컵라면";
		p1Item[2] = "빵";
		p1Item[4] = "커피";
		System.out.println("테스트");
		System.out.println("[현재 소지 중인 아이템 목록]");
		for(int i = 0; i < p1Item.length; i++) {
			if(p1Item[i] != (null)) {
				System.out.println(i+1 + ". " +  "\"" + p1Item[i] + "\"");
			}else {
				System.out.println(i+1 + ". " +  "-----");
			}
		}
		
//		itemView();
		
//		GameView view = new GameView();
//		
//		view.displayMenu();
	}
}
