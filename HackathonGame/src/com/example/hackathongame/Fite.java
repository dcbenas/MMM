package com.example.hackathongame;

public class Fite {
	private int turn = 1; 
	private int dmg, heal = 0;
	private int phealth, aihealth;
	private int[] pMoveset, aiMoveset;
	public void doFight(CommonCreature player, CommonCreature AI){
		pMoveset = new int[player.getRarity()];
		phealth = player.getStats()[0];
		aiMoveset = new int[AI.getRarity()];
		aihealth = AI.getStats()[0];
		
		while (phealth > 0 && aihealth > 0){
			if (turn%2 != 0){
				pMoveset = player.getMoveSet();
				interpretMS(pMoveset);
				applyDmg(dmg);
				applyHeal(heal);			
			}
			else{
				aiMoveset = AI.getMoveSet();
				interpretMS(aiMoveset);
				applyDmg(dmg);
				applyHeal(heal);
			}
			turn++;
		}
	}
	
	public void interpretMS(int[] msToInterpret){
		//set dmg, set heal vars
	} 
	public void applyDmg(int damage){
		phealth -= damage;
		damage = 0;
	} 
	public void applyHeal(int healz){
		aihealth += healz;
		healz = 0;
	}	
}