package com.bridgelabz.algorithmprograms;
import java.io.*;
import java .util.ArrayList;

import com.bridgelabz.util.Utility;
public class WordList {

    public static void main(String[] args) throws IOException {
     File file=new File("/home/administrator/Documents/test");
     FileReader fr=null;
     int count=0;
     ArrayList<String> a=new ArrayList<String>();
     BufferedReader fo=null;
     try {
    	 fr=new FileReader(file);
    	 fo=new  BufferedReader(fr);
    	 String word=fo.readLine();
    	 System.out.println(word);
    	 while(word!=null) {
    		 String[] str=word.split(",");
    		 for(int i=0;i<str.length;i++) {
    			 count++;
    			 a.add(str[i]);
    		 }
    		 break;
    	 }
     }
    catch (Exception e) {
         e.printStackTrace();
    }
     String[] str1=new String[count];
     for(int i=0; i<a.size();i++) {
    	 str1[i]=a.get(i);
     }
     System.out.println("enter the word you want to search");
     String word=Utility.userInputString();
    int result= Utility.binSearchStr(str1,word);
     if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at " + "index " + result);
     }
    
  

}

