package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class Anagram {
	public static void main(String[] args) {
		System.out.println("Enter a string");
		String string1=Utility.userInputString();
		System.out.println("Enter another string");
		String string2=Utility.userInputString();
	
		if(Utility.isAnagram(string1,string2)) {
			System.out.println("The two strings are anagrams");
		}
		else {
			System.out.println("The two strings are not anagrams");
		}
	}

}
