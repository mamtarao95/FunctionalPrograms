package com.bridgelabz.util;
import java.util.Scanner;
import java.util.Random;
public class Utility
{
	Scanner sc=new Scanner(System.in);
	
	/*
	 * Method to replace the a string with the user input name
	 *  
	 * @param String to take reference to replace user name
	 * @return modified string which contains user name
	 */
	public String replaceUserName(String temp)
	{
		System.out.println("Enter your name: ");
		/*
		 * String variable to store the user name taken as input from user
		 */
		String name=sc.next();
		
		/*
		 *String  variable to store the modified string
		 */
		String res=temp.replace("<<username>>",name);
		sc.close();
		
		
		return res;
	    	
	}
	
	
	/*
	 * Method to calculate percentage of head vs tail in the given number of trials
	 * 
	 *  @param int to give reference of no. of trials
	 */
	public void genPercentage(int timesofflip)
	
	{
		/*
		 * initialise variables
		 */
		float head=0;
		float tail=0;
		float headPercent;
		float tailPercent;
		for(int i=0 ; i<timesofflip ; i++)
		  {
		   double flip=Math.random();
		      if(flip<=0.5)
		        head++;
		      else
		        tail++;
		  }

		headPercent= ((head/timesofflip))*100;
		tailPercent= ((tail/timesofflip))*100;
		System.out.println("number of times head appeared: " + head);
		System.out.println("number of times tail appeared: " + tail);
		System.out.println("head percentage: "+ headPercent+"%");
		System.out.println("tail percentage: "+ tailPercent+"%");
	}
	
	
	
	/**
	 * @param year
	 * @return
	 */
	public boolean isLeap(int year)
	{
		
		if(year%4==0) {
			if(year%100==0){  
			if(year%400==0) {
			           
			return true;
				  
			 }
			else
			{
			return false;
			}}
			 
			else
			{
				return true;
			}}

		
			else{
				return false;
				}
		
	}
	
	
	/*
	 * Method to print each power of two
	 */
	public void printPower(int power)
	{
	System.out.println("The table of power of 2 till "+ power+ ": ");
	  
	/*
	 * Loop to print each power of two
	 */
	for(int i=1;i<=power;i++)
	   {
	     int res=twoPower(i);
	      System.out.println("2^"+i+"= "+res);
       }

	}
	
	/*
	 * method to find power of two for each number//
	 */
	public int twoPower(int i)
	{
	int temp=1;
	   for(int x=1;x<=i;x++)
	     {
	      temp=temp*2;
	      }
	return temp;
    }

	/*
	 * Method to take 2D array elements in integer,double 
	 * or string type from user and store it in memory
	 */
	public double[][] arrayElement()
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter number of rows");
	int m=sc.nextInt();
	System.out.println("enter number of columns");
	int n=sc.nextInt();
	/*
	 * double two dimensional array variable
	 */
	double[][] ar=new double[m][n];
	System.out.println("enter "+(m*n)+" elements of the 2D array: ");
	for(int i=0 ; i<ar.length ; i++)
	{
		for(int j=0 ; j<ar[i].length; j++)
		{

			System.out.print("enter ar["+i+"]["+j+"] = " );
			ar[i][j]=sc.nextDouble();
		}
	}
	sc.close();
	return ar;
	
	}
	
	/*
	 * Method to print the number of triplet whose sum is zero and also outputs the total number of count
	 */
	
	public void sumTriplet(int[] ar)
	{
		int count=0;
		for(int i=0 ; i<=ar.length-3;i++)
		{
			for(int j=i+1 ; j<=ar.length-2 ; j++)
			{
				for(int k=j+1 ; k<=ar.length-1 ; k++)
				{
					if(ar[i]+ar[j]+ar[k] == 0)
					{
						count++;
						System.out.println("{ "+ar[i]+ ", "+ar[j]+", "+ar[k]+" }");
					}
				}
			}
		}
		if(count!=0)
		System.out.println("there are a total of "+ count + " number of triplet whose sum counts to zero");
		else
		System.out.println("There are no triplets found in the given array!!");
		
	}
	
	/*
	 * Method to calculate euclid distance of given point from the origin 
	 * 
	 */
	public double calcEuclid(double x, double y)
	{
		double sum=( Math.pow(x, 2) )+( Math.pow(x, 2));
		System.out.println(sum);
		return Math.sqrt(sum);
		
	}
	
	
	/*
	 * 
	 */
	public int randomGen(int[] ar)
	{
		int count=0;
		int c=0;
		Random ran=new Random();
		while(count!=ar.length)
		{
		int code = ran.nextInt(100);
		c++;
		System.out.println(code);
		for(int i=0 ; i< ar.length;i++)
		{
			if(code==ar[i])
			{
				count++;
			}
		}
		}
		
		return c;
		
	}
	
	/*
	 * 
	 */
	/* Function to swap values at two pointers */
	/*public void swap(char *x, char *y)
	{
	    char temp;
	    temp = *x;
	    *x = *y;
	    *y = temp;
	}
	 
	/* Function to print permutations of string
	   This function takes three parameters:
	   1. String
	   2. Starting index of the string
	   3. Ending index of the string. */
	/*public void permute(String str, int start, int end)
	 {
	   if (start == end)
	     System.out.println(str);
	   else
	   {
	       for (int i = start; i <= end; i++)
	       {
	          swap((str+start), (str+i));
	          permute(str, start+1, end);
	          swap((str+start), (str+i)); //backtrack
	       }
	   }
	}*/
	
	/*
	 * Method to calculate the elapsed time in milliseconds 
	 */
	public void elapsedTime()
	{
		System.out.println("To start stopwatch, type start");
		sc.next();
		long startTime = System.currentTimeMillis();
		
		System.out.println("To start stopwatch, type end");
		sc.next();
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(estimatedTime+"ms");
	}
	
	/*
	 * 
	 */
	
	public void letsPlay(int row1,int col1)
	{
		int[][] ar=formTable(row1,col1);
		
		System.out.println("Enter the row and col number in which you want to insert X");
		System.out.println("Enter the row:");
		int row = sc.nextInt();
		System.out.println("Enter the col:");
		int col = sc.nextInt();
		
		ar[row][col]='X';
		

		
		
		
		
		
		
		
		
		
		
		
		}

	
	/**
	 * @param row
	 * @param col
	 * @return
	 */
	public int[][] formTable(int row1, int col1)
	{
		int[][] ar=new int[row1][col1];
		for(int i=0 ;i<ar.length;i++)
		{
			for(int j=0;j<ar[i].length;j++)
			{
				System.out.print( "[" +i+ "][" +j+ "]  ");
			
			}
			System.out.println();
			System.out.println();
		}
		return ar;
		
	}
	
	
	/*
	 * Method to find roots of the quadratic equation
	 */
	
	public double[] findRoots(double a,double b,double c)
	{
		
		double delta= Math.abs((b*b)-(4*a*c));
		double root1 = ((-b) + Math.sqrt(delta))/(2*a);
		double root2 = ((-b) - Math.sqrt(delta))/(2*a);
		double[] ar= {root1,root2};
		return ar;
		
		
		
	}
	
	/*
	 * 
	 */
	
	public double calcWindChill(double temp, double wind)
	{
    double windChill = 35.74 + (0.6215*temp) + ( ((0.4275*temp) - 35.75)*Math.pow(wind,0.16));
	return windChill;	
	}
	
	
	/*
	 * Method to calculate percentage of win and loss
	 */
	
	/**
	 * @param $stake
	 * @param $goal
	 * @param plays
	 */
	public void gambling(double stake, double goal , int plays)
	{
	int win=0;
    
	for(int i=1 ; i<=plays ; i++)
	{

	while(stake!=goal)
	{
	double prob=Math.random();

	if(prob<0.5)
	{
	stake-=1;
	}

	else
	{
    stake+=1;
	win++;
	}
	}
	}
	 double winP=((win/plays)*100);
	 double lossP=(100)-(winP);
	System.out.println("NO of times he/she wins: "+ win+ " out of " + plays+ " no. of plays ");
	if(stake==goal)
	{
	System.out.println("reached goal/win");
	System.out.println("win percentage: "+ winP);
	System.out.println("loss percentage: "+ lossP);

	}
	else
	{
	System.out.println("coudn't reach goal/loss");
	System.out.println("win percentage: "+ winP);
	System.out.println("loss percentage: "+ lossP);
	}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
	}


