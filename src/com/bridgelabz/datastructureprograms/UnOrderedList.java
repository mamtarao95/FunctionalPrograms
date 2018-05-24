package com.bridgelabz.datastructureprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.bridgelabz.datastructureprograms.LinkedList;
import com.bridgelabz.util.Utility;

public class UnOrderedList {
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void main(String[] args) throws IOException {
		LinkedList<String> list = new LinkedList<String>();
		
		 File file=new File("/home/administrator/Documents/test1");
	     FileReader fileReader=null;
	     BufferedReader bufferedReader=null;
	     try {
	    	 String word=null;
	    	 fileReader=new FileReader(file);
	    	 bufferedReader=new  BufferedReader(fileReader);
	    	
	    	 while((word=bufferedReader.readLine())!=null) {
	    		 String[] str=word.split(",");
	    		 for(int i=0;i<str.length;i++) {
	    			 list.add(str[i]);
	    		 }
	    		 break;
	    	 }
	     }
	    catch (Exception e) {
	         e.printStackTrace();
	    }
	     list.display();
	     System.out.println("Enter the word you want to search");
	     String wordToSearch=Utility.userInputString();
	     
	     //If the word is found, remove word from list and save back the file
	     if(list.search(wordToSearch)) {
	    	 System.out.println("Word found!!");
	    	 System.out.println("The modified list is");
	    	 list.remove(wordToSearch);
	    	 list.display(); 
	     }
	     //If the word is not found, add word to the list and save back the file
	     else {
	    	 list.addLast(wordToSearch);
	    	 list.display();
			}
	     //save modified list to the file
	     PrintWriter writer = new PrintWriter("/home/administrator/Documents/test1");
    	 for(int i=0;i<list.getCount();i++) {
    		 writer.print((T) list.GetNth(i)+",");
    	 }
		writer.close();
	    	
	}
}
	     
	     
	     

	
	


