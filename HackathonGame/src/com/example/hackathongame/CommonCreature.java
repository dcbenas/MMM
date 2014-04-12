package com.example.hackathongame;

public class CommonCreature implements Creature{
	
	private String name, imageID;
	private String[] stats = new String[3];
	private int[] rollSet = new int[4];
	private int rarity;
	
	public CommonCreature (String nameID, int rarityID, String[] statList, int[] rolls){
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
	public String[] getStats() {
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

}
