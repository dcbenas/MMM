package com.example.hackathongame;
import java.util.Random;

public class CommonCreature implements Creature{
	
	private String name, imageID;
	private int[] stats = new int[3];
	protected int[] rollSet = new int[4];
	protected int rarity;
	private final int attkprob = 60, healprob = 30;
	
	public CommonCreature (String nameID, int rarityID, int[] statList, int[] rolls){
		this.name = nameID;
		this.rarity = rarityID;
		this.stats = statList;
		this.setRollSet(rolls);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int[] getStats() {
		return stats;
	}

	@Override
	public int getRarity() {
		return rarity;
	}

	@Override
	public String getImageID() {
		return imageID;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	@Override
	public void setImageID(String imgID) {
		this.imageID = imgID;
	}

	public int[] getRollSet() {
		return rollSet;
	}

	public void setRollSet(int[] rolls) {
		this.rollSet = rolls;
	}
	
	protected int getSpecialProbability(int attkProb, int healProb, int rare){
		return (100-(attkProb + healProb))/rare;
	}
	
	public int[] getMoveSet() {
		Random rand = new Random();
		int output=0; //slot output
		int[] moveset = new int[rarity];
		for(int i = 0; i < rarity; i++){
			int n = rand.nextInt(101);
			if (n <= attkprob) //0-60
				output = 0;
			else if (n <= attkprob + healprob) //61-90
				output = 1;
			else if (n <= attkprob + healprob + getSpecialProbability(attkprob, healprob, rarity)) //91-100
				output = rollSet[0];
			moveset[i] = output;
		}
		return moveset;
	}
}
