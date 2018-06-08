package com.bridgelabz.objectorientedprgms;


import java.util.Arrays;

import com.bridgelabz.datastructureprograms.LinkedQueue;
import com.bridgelabz.util.Utility;

public class Player {
	
	int[] deck = new int[52];
    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack","Queen","King"};
	
   public  void PlayerObject(int playerNumber){
		LinkedQueue<String> linkedQueue= new LinkedQueue<String>();
		
		String[][] array=Utility.playCard(suits,ranks,deck);
		
		String[] array1D=new String[9];
		for(int i=0 ; i<9 ;i++ ) {
			array1D[i]= array[playerNumber-1][i];
			
		}
	
	Arrays.sort(array1D);
		
		for(int i=0;i<array1D.length;i++) {
			linkedQueue.enQueue(array1D[i]);
		}
		int size=linkedQueue.getSize();
		for(int i=0;i<size;i++) {
			System.out.println(linkedQueue.deQueue());
		}
		
}
   
   public static void main(String[] args) {
	   Player obj=new Player();
	   System.out.println("Player1: ");
	   obj. PlayerObject(1);
	   System.out.println();
	   
	   System.out.println("Player2: ");
	   obj. PlayerObject(2);
	   System.out.println();
	   
	   System.out.println("Player3: ");
	   obj. PlayerObject(3);
	   System.out.println();
	   
	   System.out.println("Player4: ");
	   obj. PlayerObject(4);
	   
   }
   
}
   
   
   
    
    
	


