/*******************************************************************************
 *  Purpose: This method search a number using the hashing key value pair 
 *
 *  @author  BridgeLabz
 *  @version 1.0
 *  @since   06-08-2017
 *
 ******************************************************************************/
package com.bridgelabz.datastructureprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.bridgelabz.util.Utility;

public class HashingMain {
	public static void main(String[] args) throws Exception {
		File file = new File("/home/administrator/Documents/Hashtest");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			String word = null;
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			while ((word = bufferedReader.readLine()) != null) {
				String[] array = word.split(",");
				System.out.println("Reading from the file.....");
				for (int i = 0; i < array.length; i++) {
					System.out.println(array[i]);
				}

				int array1[] = new int[array.length];
				for (int i = 0; i < array.length; i++) {
					array1[i] = Integer.parseInt(array[i]);
				}
				
				new HashTableChaining(11);
				int[] sortedArray = Utility.insertSortInt(array1);
				for (int i = 0; i < sortedArray.length; i++) {
					HashTableChaining.insert(sortedArray[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Contents of hash list...");
		HashTableChaining.printHashTable ();
		
		
		System.out.println("Enter the word you want to search");
		int integerToSearch = Utility.userInputInteger();
		
		if(HashTableChaining.contains(integerToSearch)) {
			HashTableChaining.remove(integerToSearch);
		}
		
		else {
			HashTableChaining.insert(integerToSearch);
		}
		HashTableChaining.printHashTable ();
		
	
		
	}

}
