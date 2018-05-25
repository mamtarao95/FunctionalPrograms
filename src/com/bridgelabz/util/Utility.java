package com.bridgelabz.util;

import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.datastructureprograms.LinkedList;
import com.bridgelabz.datastructureprograms.LinkedStack;

public class Utility {

	public static int count = 0;
	public static int permutationCount=0;
	public static int TOTAL=0;
	public static int indexOfArray=0;
	public static int temp=0;
	public static int index=0;
	public static ArrayList <Integer> arrayList=new  ArrayList <Integer>();
	LinkedList<String> list = new LinkedList<String>();
	LinkedList<Integer> ilist = new LinkedList<Integer>();
	public static Scanner scanner = new Scanner(System.in);
	public static Random ran = new Random();

	/*
	 * Method to take user input as string
	 */
	public static String userInputString() {
		String str = scanner.next();
		return str;
	}

	/*
	 * Method to take user input as integer
	 */
	public static int userInputInteger() {
		return scanner.nextInt();
	}
	
	/*
	 * Method to take user input as double
	 */
	public static Double userInputDouble() {
		return scanner.nextDouble();
	}

	/*
	 * Method to take user input as boolean
	 */
	public static boolean userInputBoolean() {
		return scanner.nextBoolean();
	}
	
	

	
	/**
	 * Method to replace the a string with the user input name
	 * @param temp
	 * @return
	 */
	public static String replaceUserName(String temp) {
		System.out.println("Enter your name: ");
		return temp.replace("<<username>>", userInputString());
	}

	
	
	/**
	 * Method to calculate percentage of head vs tail in the given number of trials
	 * @param timesofflip
	 */
	public static void genPercentage(int timesofflip) {
		float head = 0;
		float tail = 0;
		float headPercent;
		float tailPercent;
		for (int i = 1; i <= timesofflip; i++) {
			if (Math.random() < 0.5)
				head++;
			else
				tail++;
		}

		headPercent = (head * 100) / timesofflip;
		tailPercent = (tail * 100) / timesofflip;
		System.out.println("number of times head appeared: " + head);
		System.out.println("number of times tail appeared: " + tail);
		System.out.println("head percentage: " + headPercent + "%");
		System.out.println("tail percentage: " + tailPercent + "%");
	}

	
	/**
	 * Method to check given year is leap year or not
	 * @param year
	 * @return
	 */
	public static String checkLeapYear(String year) {
		 boolean isleap=false;
		 
		 if(year.length()==4){
			 int yr=Integer.parseInt(year);
			 if (yr % 4 == 0) {
					if (yr % 100 == 0) {
						if (yr % 400 == 0) {
							isleap=true;
						} else {
							isleap= false;
						}
					} else {
						isleap=true;
					}
				} else {
					isleap=false;
				}
		}
		 if(isleap) {
			 return  "It is a leap year";
		 }
		 else {
			 return "It is not a leap year";
		 }
		}
	
	
	/**
	 * Method to print all powers of two
	 * @param power
	 */
	public static void printPower(int power) {
		if (power < 31) {
			System.out.println("The table of power of 2 till " + power + ": ");
			for (int i = 1; i <= power; i++) {
				int res = twoPower(i);
				System.out.println("2^" + i + "= " + res);
			}
		} 
		else {
			System.out.println("Enter value less than 32!!");
		}
	}

	/*
	 * method to find power of two for each number
	 */
	public static int twoPower(int i) {
		int temp = 1;
		for (int x = 1; x <= i; x++) {
			temp = temp * 2;
		}
		return temp;
	}

	
	
	/*
	 * Method to find Harmonic number 
	 * @param number
	 * @return
	 */
	public static double findHarmonic(int number) {
		double output = 0;

		for (double i = 1; i<=number; i++) {
			double x = 1 / i;
			output = output + x;
		}
		return output;
	}
	
	
	
	/**
	 * Method to find prime factors using brute's force
	 * @param num
	 */
	
	public static void findPrime(int num) {
		int[] prime = new int[num];

		for (int i = 2; i <= num ; i++) {
			if (num % i == 0) {
				prime[count] = i;
				count++;
				}
			}
	System.out.println("the prime factors of " + num + " are : ");
		for (int x = 0; x < count; x++) {
			System.out.println(prime[count]);
		}
	}
	

	
	
	
	/*
	 * Method to take 2D array elements in integer,double or string type from user
	 * and store it in memory
	 * @return
	 */
	public static double[][] arrayElement() {
		System.out.println("enter number of rows");
		int m = userInputInteger();
		System.out.println("enter number of columns");
		int n = userInputInteger();
		double[][] ar = new double[m][n];
		System.out.println("enter " + (m * n) + " elements of the 2D array: ");
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print("enter ar[" + i + "][" + j + "] = ");
				ar[i][j] = userInputDouble();
				}
		}
		return ar;
	}

	
	
	
	/**
	 * Method to print the number of triplet whose sum is zero and also outputs the
	 * total number of count
	 */
  public static void sumTriplet(int num) {
		int[] ar = new int[num];
		System.out.println("Enter " + num + " integers: ");
		for (int i = 0; i < num; i++) {
			ar[i] = userInputInteger();
		}
		int count = 0;
		for (int i = 0; i <= ar.length - 3; i++) {
			for (int j = i + 1; j <= ar.length - 2; j++) {
				for (int k = j + 1; k <= ar.length - 1; k++) {
					if (ar[i] + ar[j] + ar[k] == 0) {
						count++;
						System.out.println("{ " + ar[i] + ", " + ar[j] + ", " + ar[k] + " }");
					}
				}
			}
		}
		if (count!= 0)
			System.out.println("there are a total of " + count + " number of triplet whose sum counts to zero");
		else
			System.out.println("There are no triplets found in the given array!!");
}

	
	/**
	 * Method to calculate Euclid distance of given point from the origin
	 * @param x
	 * @param y
	 * @return
	 */
	public static double calcEuclid(double x, double y) {
		double sum = ((x*x)) + ((y*y));
		return Math.sqrt(sum);
	}

	
	
	/**
	 * To check whether the coupon numbers entered by user are distinct or not
	 * @param num
	 * @return integer array
	 */
	public static int randomGen(int[] ar,int num) {
		int count=0;
		for (int i = 0; i < num; i++) {
			ar[i] = ran.nextInt(num);
			count++;
			if (i != 0) {
				for(int j = i - 1; j >= 0; j--) {
					if (ar[i] == ar[j])
						i--;
			}
		}
		
	}
		for(int x=0 ; x<ar.length;x++) {
			System.out.println(ar[x]);
		}
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Method to return the all possible random numbers need to be generated to get
	 * all n distinct coupons
	 * 
	 * @param num
	 * 
	 * @return
	 */

	
	/**
	 * Method to return all possible permutation of given string
	 * @param ch
	 * @param key
	 */
	
	public static void permutation(char[] ch, int key) {

		if (key == ch.length) {
			permutationCount++;
			for (int i = 0; i < ch.length; i++) {
				System.out.print(ch[i]);
			
				}
			System.out.println();
			
		}

		else {
			for (int i = key; i < ch.length; i++) {
				swap(ch,key,i);
				permutation(ch, key + 1);
				swap(ch,key,i);
				}
			}
	     }

	public static char[] swap(char[] ch,int key,int i) {
		char temp = ch[key];
		ch[key] = ch[i];
		ch[i] = temp;
		
		return ch;
	}
	
	
	
	/**
	 * Method to calculate the elapsed time in milliseconds
	 */
	public static void elapsedTime() {
		System.out.println("To start stopwatch, type 1");
		userInputInteger();
		long startTime = System.currentTimeMillis();
		System.out.println("To stop stopwatch, type 0");
		userInputInteger();
		double estimatedTime = System.currentTimeMillis() - startTime;
		double seconds=estimatedTime/1000;
		System.out.println(seconds + "s");
	}

	
	/**
	 * Method to play tic-tac-toe
	 * @param row1
	 * @param col1
	 */
	public static void letsPlay(int row1, int col1) {
		int[][] ar = formTable(row1, col1);
		System.out.println("Enter the row and col number in which you want to insert X");
		int a = 0;
		
		while (a!=2) {
			System.out.println("Enter the row:");
			int row = userInputInteger();
			System.out.println("Enter the col:");
			int col = userInputInteger();
			ar[row][col] = 88;
			show(ar);
			a = winnerUser(ar);
			computer(ar, row, col);
		}
		System.out.println("Youwon");
	}

	/*
	 * Method to trigger computer's turn(randomly generated)
	 * @param row
	 * @param col
	 */
	public static void computer(int[][] ar, int row, int col) {
		int comrow = ran.nextInt(3);
		int comcol = ran.nextInt(3);
		if (comrow == row && comcol == col) {
			computer(ar, row, col);
		}
		System.out.println("System turn ..!!");
		ar[comrow][comcol] = 48;
		show(ar);
	}

	/*
	 * Method to decide who is the winner
	 * @param ar
	 * @return
	 */
	public static int winnerUser(int[][] ar) {
		int i = 0;

		for (i = 0; i < 3; i++) {
			int j = 0;
			int count = 0;
			while (j < 3) {
				if (ar[i][j] == 88) {
					j++;
					count++;
				} else
					j++;
			}
			if (count == 3) {
				return 2;
			}

			for (int x = 0; x < 3; x++) {
				int y = 0;
				int count1 = 0;
				while (y < 3) {
					if (ar[y][x] == 88) {
						y++;
						count1++;
					} else
						y++;
				}
				if (count1 == 3) {
					return 2;
				}
				if (ar[0][0] == 88 && ar[1][1] == 88 && ar[2][2] == 88
						|| ar[0][2] == 88 && ar[1][1] == 88 && ar[2][0] == 88) {
					return 2;
				}
			}
		}
		return 0;
	}

	
	/*
	 * Method to display reference play board
	 * @param row
	 * @param col
	 * @return
	 */
	public static int[][] formTable(int row1, int col1) {
		int[][] ar = new int[row1][col1];

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				ar[i][j]=42;
				System.out.print("[" + i + "][" + j + "]  ");
			}
			System.out.println();
			System.out.println();
		}
		return ar;
	}

	/*
	 * Method to display modified play board after each of the player's turn
	 * @param ar
	 */
	public static void show(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print((char)ar[i][j]);
			}
			System.out.println();
		}
	}

	
	
	/**
	 * Method to find roots of the quadratic equation
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static double[] findRoots(double a, double b, double c) {
		double delta = Math.abs((b * b) - (4 * a * c));
		double root1 = ((-b) + Math.sqrt(delta)) / (2 * a);
		double root2 = ((-b) - Math.sqrt(delta)) / (2 * a);
		double[] ar = {root1,root2};
		return ar;
	}

	
	
	/**
	 * Method to calculate wind chill based on given temperature 'temp' and wind
	 * speed 'wind'
	 * @param temp
	 * @param wind
	 * @return
	 */
	public static double calcWindChill(double temp, double wind) {
		return 35.74 + (0.6215 * temp) + (((0.4275 * temp) - 35.75) * Math.pow(wind, 0.16));
	}

	
	
	/*
	 * Method to calculate percentage of win and loss
	 * @param $stake
	 * @param $goal
	 * @param plays
	 */
	public static void gambling(double stake, double goal, int plays) {
		double win = 0;
      for (int i = 1; i <= plays; i++) {
			double cash=stake;
			while(cash>0 && cash<goal) {
			if (Math.random() < 0.5) {
					cash -= 1;
				} 
			else {
			cash += 1;
			}
		}
		if(cash==goal) {
				win++;
					}
			}

		double winP = (win * 100)/ plays;
		double lossP = (100) - (winP);
		System.out.println("NO of times he/she wins: " + win + " out of " + plays + " no. of plays ");
		if (winP>lossP) {
			System.out.println("reached goal/win");
			System.out.println("win percentage: " + winP+"%");
			System.out.println("loss percentage: " + lossP+"%");

		} else {
			System.out.println("coudn't reach goal/loss");
			System.out.println("win percentage: " + winP+"%");
			System.out.println("loss percentage: " + lossP+"%");
		}

	}
	
	//*********************************************************************
	
	
	
	/**
	 * Method to check whether the two strings are anagrams or not
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isAnagram(String s1,String s2) {
        int count=0;
		for(int x=0 ; x<s1.length(); x++){
			for(int y=0 ; y<s2.length(); y++) {
				if(s1.charAt(x)==s2.charAt(y)) {
					count++;
					}
				}
			}
		
			if(count==s1.length()) {
				return true;
				}
			else {
				return false;
			}
		}
	
	
	
	/**
	 * Method to print all the prime numbers between 0 to 1000
	 * @param num
	 */
	public static int[] printPrime(){
		int[] array=new int[1000];
		for (int num = 0; num <= 1000; num++) {
			int count=0;
			for(int i=2 ; i<=num ;i++ ){
				if(num%i==0){
					count++;
					}
		       }
			if(count==1) {
				TOTAL++;
					array[indexOfArray]=num;
			    	indexOfArray++;
			    }
			    
			}	
		return array;
		}
		

		

		
		
		
	
	
	
	
	/**
	 * Method to check pairs of prime numbers which are anagram
	 * @param num1
	 * @param num2
	 */
	public static void checkAnag(){
		
		int[] array = Utility.printPrime();
		for (int i = 0; i < 167; i++) {
			for(int j=i+1 ; j< 168; j++) {
				String s1= Integer.toString(array[i]);
				String s2= Integer.toString(array[j]);
				int count=0;
				for(int x=0 ; x<s1.length(); x++){
					for(int y=0 ; y<s2.length(); y++) {
						if(s1.charAt(x)==s2.charAt(y) ){
							count++;
						}
					}
				}
					if(count==s1.length()) {
						System.out.println(s1 +" & "+ s2);
					}
				}
			
			
				}
			}
	
	/**
	 * Method to check whether a given number is pallindrome
	 * @param num
	 *//*
	public static void checkPallindrome(){
		
		int[] array = Utility.printPrime();
		for (int i = 0; i < 167; i++) {
		String s1= String.valueOf(array[i]);
		int lastIndex=s1.length()-1;
		String res="";
		for(int j=lastIndex ; j>=0 ; j--) {
	    	res=res+s1.charAt(i);
	    	}
	    if (res.equals(s1)) {
	    	System.out.println(s1 +" is a pallindrome ");
	    }
		}
	}*/
	
	
	
	/**
	 * Method to perform binary search to find the integer element 
	 * @param ar
	 * @param element
	 * @return
	 */
	public static int binSearchInt(int[] ar , int element){
		int start=0;
		int end =ar.length-1;
		 
		while (start <= end){
		     int mid = start + (end-start)/2;
		            if (ar[mid]==element)
		                return mid;
		            if (ar[mid]<(element))
		                start = mid + 1;
		            else
		                end = mid - 1;
		     }
		        return -1;
	}
	
	
	/**
	 * Method to perform binary search to find the string element 
	 * @param ar
	 * @param element
	 * @return
	 */
	
	public static int binSearchStr(String[] ar, String element){
		
		int start=0;
		int end =ar.length-1;
		 
		while (start <= end){
		      int mid = start + (end-start)/2;
	
		            if (ar[mid].equals(element))
		                return mid;
		            if (ar[mid].compareTo(element)<0)
		                start = mid + 1;
		            else
		                end = mid - 1;
		     }
		        return -1;
		}
	
	
	public static <T extends Comparable<T>> void  binSearchGenerics(T[] ar , T element){
		int start=0;
		int end =ar.length-1;
		 
		while (start<=end){
		     int mid = start + (end-start)/2;
		            if (ar[mid].compareTo(element)==0)
		      System.out.println("Element found at " + "index " + mid);
		            if (ar[mid].compareTo(element)<0)
		                start = mid + 1;
		            else
		                end = mid - 1;
		     }
		
	}
	
	/**
	 * Method to perform insertion sort on integer
	 * @param size
	 * @return
	 */
	public static int[] insertSortInt(int[] array) {
	
	for(int i=1 ; i<array.length ;i++) {
		int key=array[i];
		int j=i-1;
		while(j>=0 && key<array[j]) {
			array[j+1]=array[j];
			j=j-1;
		}
		array[j+1]=key;
	}
return array;
	}

	/*
	 * Method to perform insertion sort in string
	 */
	public static String[] insertSortStr(int size) {
		String[] str=new String[size];
		System.out.println("Enter the elements in the array");
		
		for(int i=0 ; i<size ; i++){
			str[i]=userInputString();
		}
		
		for(int i=1 ; i<size ;i++) {
			String key=str[i];
			int j=i-1;
			while(j>=0 && (key.compareTo(str[j])<0)) {
				str[j+1]=str[j];
				j=j-1;
			}
			str[j+1]=key;
		}
	return str;
		}

	
	/**
	 * Generic insertion sort that takes both string and integer as input
	 * @param size
	 * @return
	 */
	public static <T extends Comparable<T>> T[] insertSortGen(T[] ar) {
	for(int i=1 ; i<ar.length ;i++) {
		T key=ar[i];
		int j=i-1;
		while(j>=0 && key.compareTo(ar[j])<0) {
			ar[j+1]=ar[j];
			j=j-1;
		}
		ar[j+1]=key;
	}
return ar;
	}
	
	
	
/**
 * Method to perform bubble sort on integer 
 * @param size
 * @return
 */
public static int[] bubbleSortInt(int size) {
	int[] ar=new int[size];
	System.out.println("Enter the elements in the array");
	
	for(int i=0 ; i<size ; i++){
		ar[i]=userInputInteger();
	}
	
	for(int i=0;i<size-1;i++) {
		for(int j=i+1 ; j<size ;j++) {
			if(ar[i]>ar[j]) {
				int temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
			}
		}
	}
	return ar;
	}

/*
 * Method to perform bubble sort in string
 * 
 */
public static String[] bubbleSortStr(int size) {
	String[] ar=new String[size];
	System.out.println("Enter the elements in the array");
	
	for(int i=0; i<size ; i++) {
		ar[i]=userInputString();
	}
	
	for(int i=0;i<size-1;i++) {
		for(int j=i+1 ; j<size ;j++) {
			if(ar[i].compareTo(ar[j]) >0) {
				String temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
			}
		}
	}
	return ar;
	}


/**
 * Generic method for bubble sort: takes both string and integer as input
 * @param ar
 * @return
 */
public static <T extends Comparable<T>> T[] bubbleSortGen(T[] array) {
	for(int i=0;i<array.length-1;i++) {
		for(int j=i+1 ; j<array.length ;j++) {
			
			if(array[i].compareTo(array[j])>0) {
				T temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
	}
	return array;
	}

/**
 * Method to play guess game
 * @param num
 */
    public static int guessGame(int low,int high) {
		            if (high - low == 1) {
		                return low;
		            }
		            int mid = low + (high - low) / 2;
		            System.out.println("Is it less than " + mid);
		            if (userInputBoolean()) {
		                return guessGame(low,mid);
		            }
		            else {
		            return guessGame(mid,high);
		            }
		        }


 
    /**
     *  Method to find a word using binary search froma file
     * @throws IOException
     */
    public static void searchWord() throws IOException{
    	BufferedReader in = new BufferedReader(new FileReader("/home/administrator/Documents/test"));
        String str;
        while((str = in.readLine())!= null){
            String[] arr = str.split("");
            for(int i=0 ; i<str.length() ; i++){
                arr[i] = in.readLine();
            }
            System.out.println(arr[2]);

    
    System.out.println("Enter the word you want to search for:");
    String s1=scanner.next();
    int result=binSearchStr(arr, s1);
	if (result == -1)
		System.out.println("Element not present");
	else
		System.out.println("Element found at " + "index " + result);
    
    }in.close();
    }
    
    
	/**Method to perform merge sort
	 *
	 * @param ar
	 * @param l
	 * @param r
	 */
   
 public static String[] mergeArray(String[] left, String[] right) {
        String[] merged = new String[left.length+right.length];
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        int comp = 0;
        while (lIndex < left.length || rIndex < right.length) {
            if (lIndex == left.length) {
                merged[mIndex++] = right[rIndex++];
            } else if (rIndex == right.length) {
                merged[mIndex++] = left[lIndex++];
            } else {  
                comp = left[lIndex].compareTo(right[rIndex]);
                if (comp > 0) {
                    merged[mIndex++] = right[rIndex++];
                } else if (comp < 0) {
                    merged[mIndex++] = left[lIndex++];
                } else { 
                    merged[mIndex++] = left[lIndex++];
                }
            }   
        }
        return merged;
    }
    
  
        
       public static void merge(String arr[], int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;
            String L[] = new String [n1];
            String R[] = new String [n2];
     
            for (int i=0; i<n1; ++i)
                L[i] = arr[l + i];
            for (int j=0; j<n2; ++j)
                R[j] = arr[m + 1+ j];
            int i = 0, j = 0,k = l;
        
            while (i < n1 && j < n2){
                if (L[i].compareTo(R[j])<=0) {
                    arr[k] = L[i];
                    i++;
                }
                else{
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }
     
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
     
            while (j < n2){
                arr[k] = R[j];
                j++;
                k++;
            }
        }
     
       
        public static void sort(String arr[], int l, int r) {
            if (l < r) {
                int m = (l+r)/2;
                sort(arr, l, m);
                sort(arr , m+1, r);
                merge(arr, l, m, r);
            }
        }
                
  public static void printArray(String arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
     
       

   /**
   Method to find the day of the week using gregorian calender
    * @param day
    * @param month
    * @param year
    * @return
    */
    public static String dayOfWeek(int day, int month, int year) {
    	int y1=year-(14 - month)/12;
    	int x = y1 + y1 /4 - y1 /100 + y1 /400;
    	int m1 = month + 12*((14 - month ) / 12) - 2;
    	int d1= ( day + x + (31*m1) / 12) % 7;
    	String res="";
    	
    	switch(d1) {
    	case 0:res=res+"Sunday";
    	break;
    	case 1:res=res+"Monday";
    	break;
    	case 2:res=res+"Tuesday";
    	break;
    	case 3:res=res+"Wednesday";
    	break;
    	case 4:res=res+"Thursday";
    	break;
    	case 5:res=res+"Friday";
    	break;
    	case 6:res=res+"Saturday";
    	break;
    	default:res=res+"error";
    	break;
	}
    	return res;
   }
    	
    	
    	
   /**
    * Method for temperature conversion : celsius to farenheit and vice versa
    * @param choice
    * @return
    */
    public static double temperatureConversion(int choice) {
	   if(choice==1) {
		   System.out.println("Enter temerature in celsius");
		   double faren=(userInputDouble() *( 9/5)) + 32 ;
		   return faren;
	   }
	   else if(choice==2) {
		   System.out.println("Enter temerature in farenheit");
		   double cel=(userInputDouble()-31)*(5/9);
		   return cel;
	   }
	   else {
		   return -1;
	   }
   } 
   
    	
    	
    /**
     * Method to calculate monthly payment
     * @param P
     * @param Y
     * @param R
     * @return
     */
    public static double monthlyPayment(double P, double Y, double R){
	  double n=12*Y;
	  double r=R/(12*100);
	  double pwr = Math.pow((1+r), (-n));
	  return (P*r) / (1-pwr);
	 }
    	
 
    	/**
    	 * Method to find square root using Newton's raphson's method
    	 * @param t
    	 * @param num
    	 * @return
    	 */
    	public static double sqrt(double t,double num) {
    		double epsilon=1e-15;
    		
    		if( ( Math.abs( ((t*t)-num)/t ) > (epsilon*t))){
    			return t;
    			}
    		else {
    			double replace=(num + (t*t) )/(2*t);
        		sqrt(replace,num);
    		}
    		return -1;
    		}
    	
    	
    	
    	
    	/**
    	 * Method to convert decimal to binary
    	 * @param num
    	 * @return
    	 */
    	public static StringBuilder toBinary(int num) {
    		String out="";
    	
    		while(num!=0) {
    			int rem =num%2;
    			out=rem+out;
    			num=num/2;
    		}
    		
    		int size=out.length();
    		int temp=size;
    			while(size%4!=0) {
    				size++;
    		}
    			int diff=size-temp;
    			for(int i=1;i<=diff;i++) {
    			out='0'+out;
    			}
    			
    			int count=0;
    			StringBuilder sb=new StringBuilder(out);
    			for(int i=0;i<out.length();i++) {
    				count++;
    				if(count==5) {
    					sb.insert(i," ");
    					count=0;
    				} 
    			}
    			return sb;
    		}
    	
    	
    	/*
    	 * 
    	 */
    	
    	/**
    	 * Method to swap the binary digit based on nibbles
    	 * @param num
    	 * @return
    	 */
    	public static int binary(int num) {
    		if(num<127) {
    		StringBuilder str=toBinary(num);
    		String newstr=str.toString();
    		System.out.println(newstr);
    		String[] array= new String[newstr.length()];
    		array=newstr.split(" ");
    		
    			String temp=array[0];
    			array[0]=array[1];
    			array[1]=temp;
    			String strBack="";
    			for(int i=0 ; i< array.length ; i++) {
    			strBack+=array[i];
    		}
    			strBack=strBack.replaceAll("\\s","");
    			System.out.println("After swapping: ");
    			System.out.println(strBack);
    		return binToDecimal(strBack);
  			}
  			else return -1;
    	}
    	
    	
    	
    
    	/**
    	 * Method to convert binary to decimal
    	 * @param string
    	 * @return
    	 */
    	public static int binToDecimal(String string) {
    		int num=Integer.parseInt(string);
    		int count=0;
    		int out=0;
    		while(num!=0) {
    			int rem=num%10;
    			out=out+rem*pow(2,count++);
    			num=num/10;
    			
    		}
    		return out;
    	}
    	
    	/*
    	 * Method to calculate power of 2
    	 */
    	public static int pow(int num,int power) {
    		int out=1;
    		for(int i=0;i<power;i++) {
    			out=out*num;
    		}
    		return out;
    	}
    	

   
	
    /**
     * Method to generate denominations of currency
     * @param num
     */
    
    public static void generateChange(int num) {
    	int[] ar= {1,2,5,10,50,100,500,1000};
    
    	for(int i=0;i<ar.length;i++) {
    		if(num==ar[i]) {
    			System.out.println("The ");
    			System.out.println(num);
    			return;
    		}
    		}
    	
    	for(int i=0;i<ar.length;i++) {		
    	for(int j=i+1;j<ar.length;j++) {
    			if(num<ar[j] && num>ar[i] || num>ar[i]) {
    				temp=ar[i];	
    				index=i;
    				break;
    			}
    			}}
    	
    	System.out.println(temp);
    		int goal=num-temp;
    		for(int i=index;i>=0;i--) {
    			if(goal==ar[i]) {
    				System.out.println(ar[i]);
    				return;
    			}
    			
    		}
    		generateChange(goal);
    	 }
    	
    	
    
    /**
     * Method to read a file to linked list,search the word and save the linked list back to file 
     * @return 
     * @throws FileNotFoundException 
     * 
     */
	public  <T extends Comparable<T>> void unOrderedList() throws FileNotFoundException {
   
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
		 writer.print((T) list.getNth(i)+",");
	 }
	writer.close();
   	
}
    
    
    /**
     * Method to read a file to linked list,search the integer and save the linked list back to file
     * @throws FileNotFoundException
     */
    public  <T extends Comparable<T>> void orderedList() throws FileNotFoundException {
	File file=new File("/home/administrator/Documents/test2");
    FileReader fileReader=null;
    BufferedReader bufferedReader=null;
    try {
   	 String word=null;
   	 fileReader=new FileReader(file);
   	 bufferedReader=new  BufferedReader(fileReader);
   	
   	 while((word=bufferedReader.readLine())!=null) {
   		String[] array=word.split(",");
   		System.out.println("Reading from the file.....");
   		for(int i=0;i<array.length;i++) {
      		 System.out.println(array[i]);
      }
   		
   		int array1[]=new int[array.length];
   		for(int i=0;i<array.length;i++) {
   		 array1[i]=Integer.parseInt(array[i]);
   }
   		
   		int[] sortedArray=Utility.insertSortInt(array1);
   		for(int i=0;i<sortedArray.length;i++) {
   			 ilist.add(sortedArray[i]);
   		 }
   	 }
    }
   catch (Exception e) {
        e.printStackTrace();
   }
    System.out.println("Contents of linked list...");
    ilist.display();
    System.out.println("Enter the word you want to search");
    int integerToSearch=Utility.userInputInteger();
    
    
    //If the word is found, remove word from list and save back the file
    if(ilist.search(integerToSearch)) {
   	 System.out.println("Word found!!");
   	 System.out.println("The modified list is");
   	 ilist.remove(integerToSearch);
   	 ilist.display(); 
    }
    
  //If the word is not found, add word to the list and save back the file
    else {
   	 ilist.addSorted(integerToSearch);
   	 ilist.display();
		}
    
    
    //save modified list to the file
    PrintWriter writer = new PrintWriter("/home/administrator/Documents/test2");
	 for(int i=0;i<ilist.getCount();i++) {
		 writer.print((T) ilist.getNth(i)+",");
	 }
	writer.close();
    }
    
    
    
    
   /**
    * Method to check balanced expression based on parenthesis using stack push() and pop()  
    */
public static <T extends Comparable<T>> void checkParenthesis() {
	   LinkedStack<String> linkedStack=new LinkedStack<String>();
	   String expression="(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
	  int count=0;
	   for(int i=0; i<expression.length() ; i++) {
		   if(expression.charAt(i)  == '(') {
			 linkedStack.push(String.valueOf(i));
			 count++;
			 }
		   
		   else if(expression.charAt(i)==')') {
			   linkedStack.pop();
			   count--;
		   }
		  
		   }
	   
	   if(count==0) {
		   System.out.println("The arithmetic expression is Balanced expression");
	   }
	   else {
		   System.out.println("The arithmetic expression is Unbalanced expression");
	   }
	   
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    	
    	
   
    	

    
    	
    
    
    
    
    
    
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
    
    
    
    
    
    	


    
   


	
	
	

    








	

	


