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
   
   
  /* public String[] sort(String[] array1D) {
	   
	 for (int i = 0; i < array1D.length - 1; i++) {
			for (int j = i + 1; j < array1D.length; j++) {
				String stra=array1D[i];
				String[] str1=stra.split("\\-");
				
				int a=Integer.parseInt(str1[0]);
				
				String strb=array1D[j];
				String[] str2=strb.split("\\-");
			
				int b=Integer.parseInt(str2[0]);
				
				
				if (a > b) {
					String temp = array1D[i];
					array1D[i] = array1D[j];
					array1D[j] = temp;
				}
			}
		}
	 for(int i=0 ; i<array1D.length;i++){
			System.out.println(array1D[i]);
		}
		return array1D;*/
   }
   
   
   
   
   
   
   
   
    
    
	


