package edu.kh.game.view;

import java.util.Scanner;

import edu.kh.game.service.Service;
import edu.kh.game.dto.*;

public class GameView {
	static Scanner sc = new Scanner(System.in);
	public static String name;
	public static Service gameService = new Service();
	public static Building floor = new Building();

	/*
	 * 인트로, 아웃트로 NOTATION - ●(내레이션)● - [(게임 설명)] - 대화는 처음에 두 칸 띄우고, 한 마디 뒤에는
	 * enter(); - 한 루틴 진행 후에는 clearScreen();
	 */

	// 화면 5행 개행
	public static void clearScreen() {
		for (int i = 0; i < 5; i++)
			System.out.println("");
	}

	// 대화 출력 엔터
	public static void enter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("");
		sc.nextLine();
	}

	// 플레이어 이름 짓기
	public static void playerNameSet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[플레이어 이름을 지어주세요.]");
		System.out.print("이름: ");
		name = sc.next();
		Player p1 = new Player(name);
	}

	// 시작메뉴 화면
	public void displayMenu() {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃====================================┃");
		System.out.println("┃      Cheong-gye Greits Escape      ┃");
		System.out.println("┃====================================┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃  /     /       / /   /     /   /   ┃");
		System.out.println("┃1. 게임 시작   Game Start   /      /┃");
		System.out.println("┃2. 게임 종료   Exit  /     /  /  /  ┃");
		System.out.println("┃    / /      /        /      /   /  ┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                     dev_20230313   ┃");
		System.out.println("┃                     JYH/PJW/JBS    ┃");
		System.out.println("┃                     JSY/CGT/LSJ    ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println();
		System.out.println("[게임을 시작하려면 1을 입력해주세요.]");
		System.out.println("[게임을 종료하려면 2를 입력해주세요.]");

		boolean startCheck = true;
		Scanner sc = new Scanner(System.in);

		while (startCheck) {
			System.out.print("입력: ");
			String startInput = sc.nextLine();
			if (startInput.equals("1")) {
				clearScreen();
				playerNameSet(); /* 플레이어 이름 짓기 */
				clearScreen();
				System.out.printf("[%s님, 게임을 시작합니다.]\n", name);
				for (int i = 3; i >= 1; i--) {
					try {
						System.out.print(i + "     ");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				clearScreen();
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("┃            Game Start              ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				displayIntro(); /* 게임 인트로 */
				break;
			} else if (startInput.equals("2")) {
				clearScreen();
				System.out.println("[게임이 종료됩니다.]");
				for (int i = 3; i >= 1; i--) {
					try {
						System.out.print(i + "     ");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				clearScreen();
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("┃               Exit                 ┃");
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

				// 이스터에그
				String easteregg = sc.next();
				if (easteregg.toUpperCase().equals("HI")) {
					System.out.println("?: ...");
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("백동현 강사님 바~보");
				}
				break;
			} else if (!(startInput.equals("1") || startInput.equals("2"))) {
				System.out.println("[1 또는 2를 입력해주세요.]");
				startCheck = true;
			}
		}
	}

	// 게임 인트로
	public void displayIntro() {
		System.out.println("●평화로운 청계 그레이츠 빌딩 옥상정원●");
		enter();
		System.out.println("  \"정말 기분 좋은 오후야~\"");
		enter();
		System.out.println("  \"그러게 정말 오늘 날씨도 맑고 정말 상쾌하다!\"");
		enter();
		System.out.println("  \"그런데 어디선가 이상한 소리가 들리지 않아?\"");
		enter();
		System.out.println("  \"응? 이상한 소리?\"");
		enter();
		System.out.println("  \"(비명소리) 끄아아악!\"");
		enter();
		System.out.println("  \"뭐지?\"");
		enter();
		System.out.println("  \"(안내방송) 비상, 비상. 빌딩 내부에 있으신 분은\n" + "  모두 빌딩 밖으로 대피해주시기 바랍니다.\"");
		enter();
		System.out.println("  \"으악!?\"");
		enter();
		System.out.println("  \"???\"");
		enter();
		System.out.println("  \"좀.. 좀비다!\"");
		enter();
		System.out.println("  \"모두 뛰어!\"");
		enter();
		System.out.printf("●이윽고 %s은(는) 옥상정원 구석으로\n" + "  대피에 성공한다.●\n", name);
		enter();
		System.out.printf("●하지만 %s은(는) 이 많은 좀비를 뚫고\n" + "  1층까지 무사히 도달할 수 있을까?●", name);
		enter();
		clearScreen();
		displayGame();

	}

	public void displayGame() {
		
		int input = 0;
		String straight = "┃";
		while (viewFloor() > 1) {
			if (viewHp() == 0) {
				dead();
				break;
			} else {
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
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
				System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.print("메뉴 선택 >> ");

				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				

				switch (input) {
				case 0:
					if (checkKey() == false) {
						break;
					}
					if (gameService.viewFloor() == 2) {
						gameService.moveFloor(true);
						lastFloor();
						break;
					}
					gameService.moveFloor(true);
					
					break;
				case 1:
					clearScreen();
					checkingRoom(0);
					
					break;
				case 2:
					checkingRoom(1);
					clearScreen();
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
					itemMenu();
					break;

				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");

				}
			}
		}

	}

	/////////////////////////////////////////////////////////////////////////
	public void checkedRoom() {
		clearScreen();

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
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				break;
			case 9:
				itemMenu();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////
	public void keyGet() {
		clearScreen();

		int input = 0;
		while (input != 1) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("    나이스!                          ");
			System.out.println("    키를 획득하였습니다.                ");
			System.out.println("    ■■■■        ■ ■ ■ ");
			System.out.println("   ■   ■■      ■■ ■ ■                             ");
			System.out.println("   ■   ■■■■■■■■■■ ■ ■                             ");
			System.out.println("   ■   ■■      ■■ ■ ■                             ");
			System.out.println("    ■■■■        ■ ■ ■                   ");
			System.out.println("                           ");
			System.out.println("    1.돌아가기                                  ");
			System.out.println("                                     ");
			System.out.println("                          ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				break;

			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	//////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
	public void noKey() {
		clearScreen();

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
			System.out.println("                           ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				break;

			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

///////////////////////////////////////////////////////////////////////////////
	public void yesKey() {
		clearScreen();

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
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				break;

			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////   

	public void checkRoom() {
		clearScreen();
		int input = 0;
		String straight = "┃";
		while (input != 1 && input != 2) {
			if ((int) (Math.random() * 100) <= 60) {
				System.out.println();
				System.out.println();
				System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
				System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.println("                                     ");
				System.out.println("    좀비가 나타났습니다.                ");
				System.out.println("                                     ");
				System.out.println("                                     ");
				System.out.println("    1.공격하기                       ");
				System.out.println("    2.도망가기                                  ");
				System.out.println("                                     ");
				System.out.println("    9. 아이템 사용                       ");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
				System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();

				switch (input) {
				case 1:
					Attackview();
					break;
				case 2:
					run();
					break;

				case 9:
					itemMenu();
					break;

				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
			} else {
				while (input != 1) {
					System.out.println();
					System.out.println();
					System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
					System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(),
							viewFloor());
					System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
					System.out.println("                                     ");
					System.out.println("    다행히 좀비는 없었다.                ");
					System.out.println("                                     ");
					System.out.println("                                     ");
					System.out.println("                           ");
					System.out.println("    1.돌아가기                                  ");
					System.out.println("                                     ");
					System.out.println("    9. 아이템 사용                       ");
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
					System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
					System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
					System.out.print("메뉴 선택 >> ");
					input = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행문자 제거
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();

					switch (input) {
					case 1:
						break;
					case 9:
						itemMenu();
						break;
					default:
						System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
					}
				}
			}
		}

	}
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////

	public void lastFloor() { // 1층 구현
		clearScreen();
		int input = 0;
		String straight = "┃";
		while (input != 1) {

			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    이제 나가기만 하면 된다.               ");
			System.out.println("                   ");
			System.out.println("                                     ");
			System.out.println("                               ");
			System.out.println("                                      ");
			System.out.println("    1.나가기                               ");
			System.out.println("                        ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				// some();
				zeroZom3();
				break;

			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	public void cantRun() {
		clearScreen();
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    여기서 도망친다면 탈출 할 수                 ");
			System.out.println("    없습니다.                        ");
			System.out.println("                                     ");
			System.out.println("                                      ");
			System.out.println("                                      ");
			System.out.println("    1.돌아가기                                 ");
			System.out.println("                           ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:

				break;

			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	public void canRun() {
		clearScreen();
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    도망에 성공하였습니다.                 ");
			System.out.println("                           ");
			System.out.println("                                     ");
			System.out.println("                                      ");
			System.out.println("                                      ");
			System.out.println("    1.돌아가기                                 ");
			System.out.println("                           ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:

				break;

			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	public void zeroZom3() {
		clearScreen();
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("    나가기 직전 건물의 수호자      ");
			System.out.println("    경비 좀비가 나타났습니다.                 ");
			System.out.println("    경비 좀비는 일반 좀비와는 다르게                        ");
			System.out.println("    강해보입니다.                                 ");
			System.out.println("                                      ");
			System.out.println("    1.공격하기                                  ");
			System.out.println("    2.도망가기                                 ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				bossAttackview();
				zeroZom2();
				break;
			case 2:
				cantRun();
				break;
			case 9:
				itemMenu();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	public void zeroZom2() {
		clearScreen();
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    경비 좀비는 타격을 입었지만                   ");
			System.out.println("    아직 쓰러지지 않습니다.                        ");
			System.out.println("                                     ");
			System.out.println("                                      ");
			System.out.println("    1.공격하기                                  ");
			System.out.println("    2.도망가기                                 ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				bossAttackview();
				zeroZom1();
				break;
			case 2:
				cantRun();
				break;
			case 9:
				itemMenu();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	public void zeroZom1() {
		clearScreen();
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    누적된 피해로 인해                  ");
			System.out.println("    경비 좀비는 휘청거립니다.                        ");
			System.out.println("                                     ");
			System.out.println("                                      ");
			System.out.println("    1.공격하기                                  ");
			System.out.println("    2.도망가기                                 ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				bossAttackview();
				zeroZom0();
				break;
			case 2:
				cantRun();
				break;
			case 9:
				itemMenu();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	public void dead() {
		clearScreen();
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    당신은 죽었습니다.                  ");
			System.out.println("    좀비가 되어 '그들'과 같은 사냥감을                        ");
			System.out.println("    찾아다닙니다.                                 ");
			System.out.println("                                      ");
			System.out.println("                                     ");
			System.out.println("    1. 인트로 화면으로 돌아가기                             ");
			System.out.println("                            ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1: displayMenu();
			
			
			
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	public void zeroZom0() {
		clearScreen();
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    경비 좀비를 처리했습니다.                  ");
			System.out.println("                           ");
			System.out.println("                                     ");
			System.out.println("                                      ");
			System.out.println("    1.나가기                                  ");
			System.out.println("                                     ");
			System.out.println("                          ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:

				// ending();
				break;

			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

///////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
	public void out() {
		clearScreen();
		int input = 0;
		String straight = "┃";
		int zom = 3;
		while (zom != 0) {

			while (input != 1 && input != 2) {
				if ((int) (Math.random() * 100) <= 60) {
					System.out.println();
					System.out.println();
					System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
					System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(),
							viewFloor());
					System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
					System.out.println("                                     ");
					System.out.println("    좀비가 나타났습니다.                ");
					System.out.println("                                     ");
					System.out.println("                                     ");
					System.out.println("    1.공격하기                       ");
					System.out.println("    2.도망가기                                  ");
					System.out.println("                                     ");
					System.out.println("    9. 아이템 사용                       ");
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
					System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
					System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
					System.out.print("메뉴 선택 >> ");
					input = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행문자 제거
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();

					switch (input) {
					case 1:
						Attackview();
						break;
					case 2:
						run();

						break;
					case 9:
						itemMenu();
						break;
					default:
						System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
					}
				}
			}
		}
	}

	public void Attackview() {
		clearScreen();
		int input = 0;
		String straight = "┃";
		if (gameService.attack()) {
			while (input != 1 && input != 9) {
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
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
				System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();

				switch (input) {
				case 1:

					break;
				case 9:
					itemMenu();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
			}
		} else {
			while (input != 1 && input != 9) {
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
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
				System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();

				switch (input) {
				case 1:

					break;
				case 9:
					itemMenu();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////
	public void bossAttackview() {
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
				System.out.println("    재빠르게 회피하고                 ");
				System.out.println("    좀비를 공격하였습니다.                        ");
				System.out.println("                                     ");
				System.out.println("                           ");
				System.out.println("    1.돌아가기                                  ");
				System.out.println("                                     ");
				System.out.println("    9. 아이템 사용                       ");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
				System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();

				switch (input) {
				case 1:

					break;
				case 9:
					itemMenu();
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
				System.out.println("    서로 공격을 주고 받았습니다.                ");
				System.out.println("                            ");
				System.out.println("                                     ");
				System.out.println("                           ");
				System.out.println("    1.돌아가기                                  ");
				System.out.println("                                     ");
				System.out.println("    9. 아이템 사용                       ");
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
				System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
				System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();

				switch (input) {
				case 1:

					break;
				case 9:
					itemMenu();
					break;
				default:
					System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
				}
			}
		}
	}

	public void itemMenu() {
		clearScreen();
		int input = 0;
		String straight = "┃";

		System.out.println();
		System.out.println();
		System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
		System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
		System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
		System.out.println("    사용할 아이템을 선택해 주세요.                          ");
		gameService.itemView();
		System.out.println("                                 ");
		System.out.println("                                 ");
		System.out.println("                                      ");

		System.out.println("                                    ");
		System.out.println("    9. 돌아가기                       ");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("메뉴 선택 >> ");
		input = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		switch (input) {
		case 1:
			useItem(1);
			break;
		case 2:
			useItem(2);
			break;
		case 3:
			useItem(3);
			break;
		case 4:
			useItem(4);
			break;
		case 5:
			useItem(5);
			break;

		case 9:
//	      itemUse();
			break;
		default:
			System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");

		}
	}

	/////////////////////////////////////////////////////////////////////////////

	public void runcheck() {
		clearScreen();
		int input = 0;
		while (input != 1 && input != 2 && input != 9) {
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
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				Attackview();
				break;
			case 2:
				run();
				break;
			case 9:
				itemMenu();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	/////// 탕비실
	public void tang() {
		
		int input = 0;
		while (input != 1) {
			String straight = "┃";
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
			System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.println("                                     ");
			System.out.println("    탕비실에서 체력과 스태미너를                ");
			System.out.println("    회복합니다                        ");
			System.out.println("                                     ");
			System.out.println("                                      ");
			System.out.println("    1. 돌아가기                                  ");
			System.out.println("                                     ");
			System.out.println("    9. 아이템 사용                       ");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
			System.out.printf("┃열쇠 : %s┃방어구 :        ┃\n", viewKey());
			System.out.println("┃━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			switch (input) {
			case 1:
				clearScreen();

				break;
			case 9:
				itemMenu();
				clearScreen();
				break;
			default:
				System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
			}
		}
	}

	private void checkingRoom(int i) {
		if (viewFloor() - 1 == 6 || viewFloor() - 1 == 0) {
			System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
		} else {
			if (floor.getFloor(viewFloor() - 1, i).equals("탕비실")) {
				if (floor.getFloor(viewFloor() - 1, i).equals(floor.getFloor2(viewFloor() - 1, i))) {
					checkedRoom();
				} else {
					gameService.addItem(gameService.whatItem());
					gameService.tang();
					tang();
					if (floor.keyCheck(viewFloor() - 1, i).equals("열쇠를 발견하였습니다.")) {
						gameService.getKey();
						keyGet();
					}
				}
			} else {
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
					keyGet();
				}
			}

		}

	}

	private void run() {
		boolean i = gameService.run();

		if (i == false) {
			runcheck();
		} else {
			canRun();
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

	private String viewKey() {
		if (gameService.viewKey() == true) {
			return "키가 있습니다.";
		} else {
			return "키가 없습니다.";
		}

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