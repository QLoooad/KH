package edu.kh.game.service;


import edu.kh.game.dto.Player;

public class Service {
	
	private Player p1 = new Player("당신", 5, 0, 1, 5, 7);
	private String[] p1Item = new String[5];
	//name, hp, defense, power, stamina, floor, item1, item2, item3, item4, item5
	
	public int viewHp() {
		int hp = p1.getHp();
		return hp;
	}
	
	public int viewStamina() {
		int stamina = p1.getStamina();
		return stamina;
	}
	
	public int viewFloor() {	//현재 층
		int floor = p1.getFloor();
		return floor;
	}
	
	public void moveFloor(boolean move) {	//층 이동
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
	
	public void addItem(int index, String itemName) {	//원하는 빈칸에 입력 가능
		p1.setItem(index, itemName);
	}
	 
	public void useItem(int index) {	//사용하면 삭제"null"로 변경
		p1.getItem(index);
		p1.setItem2(index);
	}
	
	public String getItem(int index) {//아이템 로드
		return p1.getItem(index);
	}
	

	
	
}
