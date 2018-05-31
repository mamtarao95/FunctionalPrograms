package com.bridgelabz.objectorientedprgms;

import com.bridgelabz.util.Utility;

public class DeckOfCards {
	public static void main(String[] args) {
		int[] deck = new int[52];
	    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack","Queen","King"};
	    
    String[][] array=Utility.playCard(suits,ranks,deck);
    
  //Print the array
  		for(int i=0; i <4;i++) {
  			for(int j=0 ; j<9;j++ ) {
  				System.out.print(array[i][j]+", ");
  				
  			}
  			System.out.println();
	    
		}

}
}

	
	
		
		
		

	
	
	
	
	
	
	

