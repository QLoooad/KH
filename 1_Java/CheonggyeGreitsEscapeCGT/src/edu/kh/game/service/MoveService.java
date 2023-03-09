package edu.kh.game.service;

import edu.kh.game.dto.*;
import java.util.*;

public class MoveService extends Building {
	
	private Service gameService = new Service();
	private Building Building = new Building();
	
	Random random = new Random();

	/*
	 * 7 옥상정원 6 회의실1 회의실2 강당 화장실 탕비실 5 회의실1 회의실2 강당 화장실 탕비실 4 신한라이프 회장실 대회의실 강당 탕비실
	 * 3 회의실 강의실 화장실 탕비실 2 회의실 강의실 화장실 탕비실 1 로비
	 * 
	 * 탕비실: 아이템이 랜덤으로 등장 / 좀비 확률 0% 화장실: 좀비 확률 10% 강의실: 좀비 확률 30% 회의실: 좀비 확률 50% 강당:
	 * 좀비 확률 70% 대회의실: 좀비 확률 80% - 회의실 상속 회장실: 좀비 확률 100% 로비: 경비좀비 100% 출현
	 */

	int ZombieRandomSpawnSpawn;
	int KeyGen;

	// 탕비실
	

	// 화장실
	public void toilet() {
		ZombieRandomSpawnSpawn = random.nextInt(100)+1;
      if(ZombieRandomSpawnSpawn>=1 && ZombieRandomSpawnSpawn<=10) {// 좀비 발생
    	  
      }else // 좀비를 마주치지 못함
      
         
      gameService.addItem(gameService.whatItem());//방 입장 시 확률로 아이템 획득
   }

	// 강의실
	public void classRoom() {
      ZombieRandomSpawn = random.nextInt(100)+1;
      if(ZombieRandomSpawn>=1 && ZombieRandomSpawn<=30); // 좀비 발생
      else // 좀비를 마주치지 못함
      
   }

	// 회의실(대회의실)
	public void conference() {
      ZombieRandomSpawn = random.nextInt(100)+1;
      if(ZombieRandomSpawn>=1 && ZombieRandomSpawn<=50); // 좀비 발생
      else // 좀비를 마주치지 못함
      
   }

	// 강당
	public void auditorium() {
      ZombieRandomSpawn = random.nextInt(100)+1;
      if(ZombieRandomSpawn>=1 && ZombieRandomSpawn<=80); // 좀비 발생
      else // 좀비를 마주치지 못함
   }

	// 회장실
	public void chiefRoom() {
		ZombieRandomSpawn = random.nextInt(100) + 1;
		if (ZombieRandomSpawn >= 1 && ZombieRandomSpawn <= 100)
			; // 무조건 좀비 발생
	}

	// 로비
	public void lobby() {
		// 경비좀비와의 맞다이
	}

	// 층 마다 키 하나 발생
	public void keyGen() {

		for (int i = 1; i < list.get(i).length; i++) {
			int keyRoom = random.nextInt(list.get(i).length);
			list.get(i).set(keyRoom, 1);
			if (i = 5)
				break;
		}
	}

	// 키가 있을 경우 아래층 이동 가능

}