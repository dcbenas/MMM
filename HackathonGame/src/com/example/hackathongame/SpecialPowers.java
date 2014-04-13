package com.example.hackathongame;

public class SpecialPowers {
	private static int[] powersArray = {2,1,10,100,1000,10000};
	public static int[] decodeMS(int[] MS){
		int [] decoded = new int[2];
		for(int i = 0; i < MS.length-1; i++){
			if (MS[i] == 1){
				//heal
				decoded[1] = 1;
			}
			else{
				//dmg
				decoded[0] += powersArray[MS[i]];
			}
		}
		
		return decoded;
	}
}
