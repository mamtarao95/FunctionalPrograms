package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.Utility;

public class TaskScheduling {
	
	public static void main(String[] args) {
		System.out.println("Enter the number of processes");
       
        int n=Utility.userInputInteger();
        int process[]= new int[n];
     
        int burst_Time[]= new int[n];
        int deadLine[]=new int[n];
        for(int i=0 ; i<n ; i++) {
        	 System.out.println("Enter the burst time for "+(i+1)+" process");
        	 burst_Time[i]=Utility.userInputInteger();
        	 System.out.println("Enter the deadline(quantum)time for "+(i+1)+" process");
        	 deadLine[i]=Utility.userInputInteger();
        	 }
    
        int completionTime[]=new int[n];

        int[] overShootTime=Utility.overShootTime(process, n, burst_Time,deadLine, completionTime);
        System.out.println("The overshoot time for each of the "+n+" processes is:");
        for(int i=0 ; i<overShootTime.length;i++) {
                System.out.println(overShootTime[i]);
        }

}

}
