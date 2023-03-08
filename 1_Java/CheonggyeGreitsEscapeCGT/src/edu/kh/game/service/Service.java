package edu.kh.game.service;


import edu.kh.game.dto.Player;

public class Service {
	
	private Player p1 = new Player("당신", 5, 0, 1, 5, 7, false);
	private String[] p1Item = new String[5];
	//name, hp, defense, power, stamina, floor, item1, item2, item3, item4, item5
	
	public int viewHp() {//현재 HP
		int hp = p1.getHp();
		return hp;
	}
	
	public int viewStamina() {//현재 스테미나
		int stamina = p1.getStamina();
		return stamina;
	}
	
	public int viewFloor() {	//현재 층
		int floor = p1.getFloor();
		return floor;
	}
	
	public void moveFloor(boolean move) {	//층 이동 아래로
		p1.setFloor(p1.getFloor()-1);
	}
	
	public int getPlayerHp(int getPlayerHp) {	//플레이어 힐
		int nowHp = p1.getHp()+getPlayerHp;
		p1.setHp(nowHp);
		return p1.getHp();
	}
	
	public int hitPlayer(int damage) {	//플레이어 맞음
		int nowHp = p1.getHp()-damage;
		p1.setHp(nowHp);
		return p1.getHp();
	}
	
	public int getStamina(int getStamina) {	//스테미나 획득
		int nowStamina = p1.getStamina()+getStamina;
		p1.setStamina(nowStamina);
		return p1.getStamina();
	}
	
	public int useStamina(int useStamina) {	//스테미나 사용
		int nowStamina = p1.getStamina()-useStamina;
		p1.setStamina(nowStamina);
		return p1.getStamina();
	}
	
	public int getPlayerDefense(int getPlayerDefense) {	//플레이어 방어 획득
		int nowDefense = p1.getDefense()+getPlayerDefense;
		p1.setDefense(nowDefense);
		return p1.getDefense();
	}
	
	public int usePlayerDefense(int usePlayerDefense) {	//플레이어 방어 사용(필요?)
		int nowDefense = p1.getDefense()+usePlayerDefense;
		p1.setDefense(nowDefense);
		return p1.getDefense();
	}
	
	//아이템 랜덤값 들어오면 해당 아이템을 null배열 or "" 에 넣어주기
	public void addItem(int itemNum) {
		String item = "";
		if(itemNum == 1) item = "의료상자";
		if(itemNum == 2) item = "붕대";
		if(itemNum == 3) item = "빵";
		if(itemNum == 4) item = "컵라면";
		if(itemNum == 5) item = "커피";
		if(itemNum == 6) {
			item = "열쇠";
			p1.setKey(true);
		}
		
		if(itemNum >= 1 && itemNum <= 5) {
			for(int i = 0; i < p1Item.length-1; i++) {
				if(p1Item[i] == null){
					p1Item[i] = item;
					break;
				}
			}
		}
		
		System.out.printf("%d을/를 얻었습니다.", item);
	}
	
	public void useItem(int itemNum) {//해당인덱스 1~5까지 고르면 사용
		itemNum -= 1;
		if(p1Item[itemNum].equals("의료상자")) {
			int nowHp = p1.getHp()+1;
			p1.setHp(nowHp);
			int nowStamina = p1.getStamina()+1;
			p1.setStamina(nowStamina);
			System.out.println("체력 +1\n스테미나 +1");
			p1Item[itemNum] = null;
		}
		if(p1Item[itemNum].equals("붕대")) {
			int nowHp = p1.getHp()+1;
			p1.setHp(nowHp);	
			System.out.println("체력 +1");
			p1Item[itemNum] = null;
		}
		if(p1Item[itemNum].equals("빵")) {
			int nowHp = p1.getHp()+1;
			p1.setHp(nowHp);
			System.out.println("체력 +1");
			p1Item[itemNum] = null;
		}
		if(p1Item[itemNum].equals("컵라면")) {
			int nowHp = p1.getHp()+1;
			p1.setHp(nowHp);
			System.out.println("체력 +1");
			p1Item[itemNum] = null;
		}
		if(p1Item[itemNum].equals("커피")) {
			int nowStamina = p1.getStamina()+1;
			p1.setStamina(nowStamina);
			System.out.println("스테미나 +1");
			p1Item[itemNum] = null;
		}

		
	}
	 
	public void useKey() { //키 사용
		p1.setKey(false);
	}
	
	
}
