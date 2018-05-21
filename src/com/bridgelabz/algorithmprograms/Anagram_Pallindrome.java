package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class Anagram_Pallindrome extends Utility {
	
	public static void main(String[] args) {
		
		for (int i = 0; i<Utility.arrayList.length; i++) {
			for(int j=i+1 ; j<=arrayList.length ; j++) {
			Utility.checkAnag(i,j);
		}
			Utility.checkPallindrome(i);
	}
	}
	

}
