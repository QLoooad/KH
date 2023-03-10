package edu.kh.game.run;

import java.util.Random;

import edu.kh.game.dto.Player;
import edu.kh.game.service.Service;
import edu.kh.game.view.GameView;

public class GameRun {
	
	private Player p1 = new Player("당신", 5, 0, 1, 5, 7, false);
	private String[] p1Item = new String[5];
	
	public void itemView()  {
		
		System.out.println("[현재 소지 중인 아이템 목록]");
		for(int i = 0; i < p1Item.length; i++) {
			if(p1Item[i].equals(null)) {
				System.out.println("");
			}else {
				System.out.println(i+1 + ". " +  "\"" + p1Item[i] + "\"");
			}
		}
	}

	public static void main(String[] args) throws NullPointerException{
		
		Service gameService = new Service();
		
		
		for(String s : gameService.p1Item) {
			System.out.println(s);
		}
		
//		itemView();
		
//		GameView view = new GameView();
//		
//		view.displayMenu();
	}
}
