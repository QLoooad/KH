package edu.kh.game.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.game.service.Service;


public class GameView {
	
	private Scanner sc = new Scanner(System.in);
	private Service gameService = new Service();
	
	public void displayMenu() {
		int input = 0;
		String straight = "┃";
//		addItem(1, "컵라면");
//		System.out.println(gameService.getItem(0));
		gameService.useItem(0);
//		System.out.println(gameService.getItem(0));
		gameService.moveFloor(true);
		System.out.println("viewFloor1 : " + viewFloor());
		gameService.moveFloor(true);
		System.out.println("viewFloor2 : " + viewFloor());
		
		do {
			try {
				System.out.printf( "가%38s\n", straight);
				System.out.printf( "ss%38s\n", straight);
				System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf( "┃HP : %d/5┃STN : %d/5   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━┳━━━━━━━━━━━━━┫");
				System.out.println("┃가나다라마바사아자차카타┃-보유 아이템-┃");
				System.out.printf( "┃나                      ┃가나다라마바 ┃\n");
				System.out.println("┃다                      ┃             ┃");
				System.out.println("┃라                      ┃             ┃");
				System.out.println("┃마                      ┃             ┃");
				System.out.println("┃바                      ┃             ┃");
				System.out.println("┃사                      ┃             ┃");
				System.out.println("┃아                      ┃             ┃");
				System.out.println("┃자                      ┃             ┃");
				System.out.println("┃차                      ┃             ┃");
				System.out.println("┃카                      ┃             ┃");
				System.out.println("┃타                      ┃             ┃");
				System.out.println("┃파                      ┃             ┃");
				System.out.println("┃하                      ┃             ┃");
				System.out.println("┃가                      ┃             ┃");
				System.out.println("┃나                      ┃             ┃");
				System.out.println("┃다                      ┃             ┃");
				System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━┛");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine();	//입력 버퍼 개행문자 제거
				System.out.println();
				
				switch (input) {
				case 1 : hitPlayer(1); break;
				case 2 : viewHp(); break;
				case 3 :  break;
				case 4 :  break;
				case 5 :  break;
				case 6 :  break;
				case 7 :  break;
				case 8 :  break;
				case 9 :  break;
				case 0 : System.out.println("[프로그램 종료]");break;
				default : System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
				
			}catch(InputMismatchException e){
				System.out.println("[잘못된 형식의 입력입니다.]");
				sc.nextLine();//입력버퍼에 잘못 입력된 내용 제거
				input = -1;//반복문 종료 방지
			}
		}while(input != 0);
		
	}
	
	private int viewHp() {
		return gameService.viewHp();
	}
	
	private int viewStamina() {
		return gameService.viewStamina();
	}
	
	private int viewFloor() {
		return gameService.viewFloor();
	}
	
	public void moveFloor(boolean move) {	//층 이동
		gameService.moveFloor(move);
	}
	
	private int hitPlayer(int damage) {
		
		return gameService.hitPlayer(damage);
	}
	
//	private void addItem(int index, String itemName) {	//원하는 빈칸에 입력 가능
//		gameService.addItem(index-1, itemName);//사용자 편의 array[index-1]
//	}
	
	public void useItem(int index) {	//사용하면 삭제"null"로 변경
		gameService.useItem(index-1);
	}

}
