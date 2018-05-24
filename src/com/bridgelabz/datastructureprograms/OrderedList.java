package com.bridgelabz.datastructureprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OrderedList {
	public static <T extends Comparable<T>> void main(String[] args) throws IOException {
		LinkedList<String> list = new LinkedList<String>();
		
		 File file=new File("/home/administrator/Documents/test2");
	     FileReader fileReader=null;
	     BufferedReader bufferedReader=null;
	     try {
	    	 String word=null;
	    	 fileReader=new FileReader(file);
	    	 bufferedReader=new  BufferedReader(fileReader);
	    	
	    	 while((word=bufferedReader.readLine())!=null) {
	    		int[] array=word.split(",");
	    		 for(int i=0;i<str.length;i++) {
	    			 list.add(str[i]);
	    		 }
	    		 break;
	    	 }
	     }
	    catch (Exception e) {
	         e.printStackTrace();
	    }
		
		

}
}