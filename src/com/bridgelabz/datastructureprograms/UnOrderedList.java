package com.bridgelabz.datastructureprograms;

import com.bridgelabz.datastructureprograms.LinkedList;

public class UnOrderedList {
	public static <T extends Comparable<T>> void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("mam");
		list.add("tam");
	
		
		list.display();
		list.displayMid();
		
int s=list.getCount();
    System.out.println(s);
   /* boolean res=list.search(1);
    System.out.println(res);*/

	}
	}


