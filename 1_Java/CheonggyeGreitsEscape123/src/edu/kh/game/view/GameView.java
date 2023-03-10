package edu.kh.game.view;

import java.util.Scanner;

import edu.kh.game.service.Service;
import edu.kh.game.dto.*;


public class GameView {

	private Scanner sc = new Scanner(System.in);
	private Service gameService = new Service();
	private Building floor = new Building();

	public void displayGame() {
		int input = 0;
		String straight = "┃";

		while (viewFloor() > 0) {


			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.printf("           " + floor.getRoom(viewFloor() - 1));
			System.out.println("                                     ");
			System.out.printf("    0. 아래 층(%dF)                      \n", viewFloor() - 1);
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("                                     ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 0:
				if (checkKey() == false) {

					break;
				}
				gameService.moveFloor(true);
				break;
			case 1:
				checkingRoom(0);
				break;
			case 2:
				checkingRoom(1);
				break;
			case 3:
				checkingRoom(2);
				break;
			case 4:
				checkingRoom(3);
				break;
			case 5:
				checkingRoom(4);
				break;
			case 6:
				break;

			case 9:
//            itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");

			}
		}

	}

	/////////////////////////////////////////////////////////////////////////
	public void checkedRoom() {

		int input = 0;
		while (input != 1) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    이미 들어간 방이거나                 ");
			System.out.println("    들어갈 수 없는 방입니다.              ");
			System.out.println("                                     ");
			System.out.println("                           ");
			System.out.println("    1.돌아가기                                  ");
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				break;
			case 9:
//	      itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	//////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	public void noKey() {

		int input = 0;
		while (input != 1) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    키 없음                ");
			System.out.println("              ");
			System.out.println("                                     ");
			System.out.println("                           ");
			System.out.println("    1.돌아가기                                  ");
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				break;
			case 9:
//itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

///////////////////////////////////////////////////////////////////////////////
	public void yesKey() {

		int input = 0;
		while (input != 1) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    키를 사용하여 내려감               ");
			System.out.println("              ");
			System.out.println("                                     ");
			System.out.println("    1. 내려가기                       ");
			System.out.println("                                    ");
			System.out.println("                                     ");
			System.out.println("                          ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				break;
			case 9:
//itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////   

	public void checkRoom() {
		int input = 0;
		String straight = "┃";
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("             좀비가 나타났습니다.                ");
			System.out.println("                                     ");
			System.out.println("                                     ");
			System.out.println("    1.공격하기                       ");
			System.out.println("    2.도망가기                                  ");
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				Attackview();
				break;
			case 2:
				run();

				break;
			case 9:
//      itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		} else {
			while (input != 1) {
				System.out.println();
				System.out.println();
				System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.println("                                     ");
				System.out.println("            아무것도 없었다                ");
				System.out.println("                                     ");
				System.out.println("                                     ");
				System.out.println("                           ");
				System.out.println("    1.돌아가기                                  ");
				System.out.println("                                     ");
				System.out.println("    9. 아이템 사용                       ");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();

				switch (input) {
				case 1:
					break;
				case 9:
//      itemUse();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
			}
		}
	}
	//////////////////////////////////////////////////////////////////
	public void aaaaaaaaaaaaaaaa() {
		int input = 0;
		String straight = "┃";
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("            강의실에 입장했습니다                ");
			System.out.println("            졸음이 쏟아집니다.       ");
			System.out.println("                                     ");
			System.out.println("    1.쉬기                           ");
			System.out.println("    2.나가기                                  ");
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				aaaaaaaaa5a();
				break;
			case 2:
				
				break;
			case 9:
//	      itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}
	public void aaaaaaaaa5a() {
		int input = 0;
		String straight = "┃";
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("            백동현강사님 좀비를 만났습니다.                ");
			System.out.println("                                    ");
			System.out.println("                                     ");
			System.out.println("    1.공부하기                       ");
			System.out.println("    2.도망가기                                  ");
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				
				break;
			case 2:
				run();

				break;
			case 9:
//	      itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}
	
	//////////

	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	public void Zerofloor() {
		int input = 0;
		String straight = "┃";
		if ((int) (Math.random() * 100) <= 60) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("             좀비가 나타났습니다.                ");
			System.out.println("                                     ");
			System.out.println("                                     ");
			System.out.println("    1.공격하기                       ");
			System.out.println("    2.도망가기                                  ");
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();

			switch (input) {
			case 1:
				Attackview();
				break;
			case 2:
				run();

				break;
			case 9:
//	      itemUse();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	public void Attackview() {
		int input = 0;
		String straight = "┃";
		if (gameService.attack()) {
			while (input != 1) {
				System.out.println();
				System.out.println();
				System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.println("                                     ");
				System.out.println("    재빠르게 회피하고 좀비를                ");
				System.out.println("    처리했습니다.                        ");
				System.out.println("                                     ");
				System.out.println("                           ");
				System.out.println("    1.돌아가기                                  ");
				System.out.println("                                     ");
				System.out.println("    9. 아이템 사용                       ");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();

				switch (input) {
				case 1:

					break;
				case 9:
//      itemUse();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
			}
		} else {
			while (input != 1) {
				System.out.println();
				System.out.println();
				System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.println("                                     ");
				System.out.println("    공격을 당했지만                ");
				System.out.println("    좀비를 처리했습니다                        ");
				System.out.println("                                     ");
				System.out.println("                           ");
				System.out.println("    1.돌아가기                                  ");
				System.out.println("                                     ");
				System.out.println("    9. 아이템 사용                       ");
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();

				switch (input) {
				case 1:

					break;
				case 9:
//       itemUse();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////

	public void runcheck() {
		int input = 0;
		String straight = "┃";
		System.out.println();
		System.out.println();
		System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
		System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
		System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
		System.out.println("                                     ");
		System.out.println("          도망에 실패했습니다.                ");
		System.out.println("          좀비에게 피해를 입습니다.                        ");
		System.out.println("                                     ");
		System.out.println("    1.공격하기                                  ");
		System.out.println("    2.도망가기                                  ");
		System.out.println("                                     ");
		System.out.println("    9. 아이템 사용                       ");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("메뉴 선택 >> ");
		input = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		System.out.println();

		switch (input) {
		case 1:
			Attackview();
			break;
		case 2:
			run();
			break;
		case 9:
//      itemUse();
			break;
		default:
			System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");

		}
	}

	/////////////////////////////////////////////////////////////////////////
	public void itemview() {
		int input = 0;
		String straight = "┃";
		System.out.println();
		System.out.println();
		System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
		System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
		System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
		System.out.println("                                     ");
		System.out.println("                         ");
		System.out.println("                                 ");
		System.out.println("                                     ");
		System.out.println("    1.공격하기                                  ");
		System.out.println("    2.도망가기                                  ");
		System.out.println("                                     ");
		System.out.println("    9. 아이템 사용                       ");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("메뉴 선택 >> ");
		input = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		System.out.println();

		switch (input) {
		case 1:
			Attackview();
			break;
		case 2:
			run();
			break;
		case 9:
//      itemUse();
			break;
		default:
			System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");

		}
	}

//////////////////////////////////////////////////////////
	private void checkingRoom(int i) {
		if (viewFloor() - 1 == 6 || viewFloor() - 1 == 0) {
			System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
		} else {
			if (floor.getFloor(viewFloor() - 1, i).equals("탕비실")) {
				gameService.addItem(gameService.whatItem());
			}

			if (floor.getFloor(viewFloor() - 1, i).equals(floor.getFloor2(viewFloor() - 1, i))) {
				checkedRoom();
			} else {
				floor.getFloor(viewFloor() - 1, i);
				System.out.println(floor.getFloor(viewFloor() - 1, i));
				floor.setFloor(viewFloor() - 1, i, floor.getFloor(viewFloor() - 1, i));
				checkRoom();
			}
			if (floor.keyCheck(viewFloor() - 1, i).equals("열쇠를 발견하였습니다.")) {
				gameService.getKey();
			}
		}

	}

	private void run() {
		boolean i = gameService.run();

		if (i == false) {
			runcheck();
		} else {
		}
	}

	private boolean checkKey() {
		if (gameService.isKey() == true) {
			yesKey();
			return true;
		}
		noKey();
		return false;
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

	public void moveFloor(boolean move) { // 층 이동
		gameService.moveFloor(move);
	}

	private int hitPlayer(int damage) {

		return gameService.hitPlayer(damage);
	}

	public void useItem(int index) { // 사용하면 삭제"null"로 변경
		gameService.useItem(index - 1);
	}

}