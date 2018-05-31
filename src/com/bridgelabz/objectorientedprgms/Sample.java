package com.bridgelabz.objectorientedprgms;

public class Sample {
public static void main(String[] args) {
	String[] ar={"10-dyyy","2-rrr","5-yugyu"};
	String [] arr=sort(  ar);
	
	for(int i=0 ; i<arr.length;i++){
		System.out.println(arr[i]);
	}
	
}


public static String[] sort(String[] array1D) {
	   
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
		return array1D;
  }
}
