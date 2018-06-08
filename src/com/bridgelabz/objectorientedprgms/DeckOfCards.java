/******************************************************************************
 *  Purpose:Program DeckOfCards.java , to initialize deck of cards using Random method and then
	distribute 9 Cards to 4 Players and Print the Cards the received by the 4 Players
	using 2D Array...
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
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

	
	
		
		
		

	
	
	
	
	
	
	

