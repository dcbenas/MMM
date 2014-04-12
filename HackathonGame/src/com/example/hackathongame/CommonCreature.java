package com.example.hackathongame;

public class CommonCreature implements Creature{
	
	private String name, imageID;
	private String[] stats = new String[3];
	private String[] rollSet = new String[4];
	private int rarity;
	
	public CommonCreature (String nameID, int rarityID, String[] statList){
		this.name = nameID;
		this.rarity = rarityID;
		this.stats = statList;
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

}
