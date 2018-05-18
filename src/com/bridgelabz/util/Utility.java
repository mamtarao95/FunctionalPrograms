package com.bridgelabz.util;

import java.util.Scanner;
import java.util.Random;

public class Utility {
	
	static Scanner scanner = new Scanner(System.in);
	
	/*
	 * Method to take user input as string
	 */
	public static String userInputString() {
		return scanner.nextLine();
	}
	
	/*
	 * Method to take user input as string
	 */
	public static int userInputInteger() {
		return scanner.nextInt();
	}

	
	
	/**
	 * Method to replace the a string with the user input name
	 * @param temp
	 * @return
	 */
	public static String replaceUserName(String temp) {
		System.out.println("Enter your name: ");
		String name = scanner.next();
		String res = temp.replace("<<username>>", name);
		return res;
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
		for(int i = 1; i <= timesofflip; i++) {
			if(Math.random() < 0.5)
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
	public static boolean isLeap(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
					}
				else {
					return false;
				}
			}
           else {
				return true;
			}
		}
		else {
			return false;
		}

	}
	
	
	
	/**
	 * Method to print each power of two
	 * @param power
	 */
	public void printPower(int power) {
		System.out.println("The table of power of 2 till " + power + ": ");

		for (int i = 1; i <= power; i++) {
			int res = twoPower(i);
			System.out.println("2^" + i + "= " + res);
		}

	}

	/*
	 * Method to find harmonic number
	 */
	public double findHarmonic(int number) {
		double output = 0;

		for (double i = 1; i <= number; i++) {
			double x = 1 / i;
			output = output + x;
		}
		return output;
	}

	/*
	 * method to find power of two for each number//
	 */
	public int twoPower(int i) {
		int temp = 1;
		for (int x = 1; x <= i; x++) {
			temp = temp * 2;
		}
		return temp;
	}

	/*
	 * Method to find prime factors using brute's force
	 */
	static int count = 0;

	public void findPrime(int num) {
		int[] prime = new int[num];

		for (int i = 2; i <= num / 2; i++) {

			if (num % i == 0) {

				prime[count] = i;
				count++;
			}

		}
		System.out.print("the prime factors of " + num + " are : ");
		for (int x = 0; x < count; x++) {

			System.out.print(prime[x] + " ");

		}
	}

	/*
	 * Method to take 2D array elements in integer,double or string type from user
	 * and store it in memory
	 */
	public double[][] arrayElement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of rows");
		int m = sc.nextInt();
		System.out.println("enter number of columns");
		int n = sc.nextInt();
		/*
		 * double two dimensional array variable
		 */
		double[][] ar = new double[m][n];
		System.out.println("enter " + (m * n) + " elements of the 2D array: ");
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {

				System.out.print("enter ar[" + i + "][" + j + "] = ");
				ar[i][j] = sc.nextDouble();
			}
		}
		sc.close();
		return ar;

	}

	/*
	 * Method to print the number of triplet whose sum is zero and also outputs the
	 * total number of count
	 */

	public void sumTriplet(int[] ar) {
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
		if (count != 0)
			System.out.println("there are a total of " + count + " number of triplet whose sum counts to zero");
		else
			System.out.println("There are no triplets found in the given array!!");

	}

	/*
	 * Method to calculate euclid distance of given point from the origin
	 * 
	 */
	public double calcEuclid(double x, double y) {
		double sum = (Math.pow(x, 2)) + (Math.pow(x, 2));
		System.out.println(sum);
		return Math.sqrt(sum);

	}

	/*
	 * To print random number count to get n distinct coupon number
	 */
	public int randomGen(int[] ar) {
		int count = 0;
		int c = 0;
		Random ran = new Random();

		while (count != ar.length) {
			int code = ran.nextInt(100);
			c++;
			for (int i = 0; i < ar.length; i++) {
				if (code == ar[i]) {
					count++;
				}
			}
		}

		return c;

	}

	/*
	 * Method to return all possible permutation of given string
	 */

	
	  public void permutation(char[] ch, int key) { 
	  if (key == ch.length) { 
	  for(int i = 0; i < ch.length; i++) { System.out.print(ch[i]); }
	  System.out.println();
	  
	  }
	  
	 else {
	 char temp = ch[key];
	  ch[key]=ch[i];
	  ch[i]=temp;
	  
	 permutation(ch, key + 1);
	  temp = ar[key];
	 ch[key]=ch[i];
	  ch[i]=temp;
	 
	  
	  
	  }
	  
	 * } }
	

	/*
	 * Method to calculate the elapsed time in milliseconds
	 */
	public void elapsedTime() {
		System.out.println("To start stopwatch, type start");
		scanner.next();
		long startTime = System.currentTimeMillis();

		System.out.println("To start stopwatch, type end");
		scanner.next();
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(estimatedTime + "ms");
	}

	/*
	 * 
	 */

	public void letsPlay(int row1, int col1) {
		int[][] ar = formTable(row1, col1);

		System.out.println("Enter the row and col number in which you want to insert X");
		System.out.println("Enter the row:");
		int row = sc.nextInt();
		System.out.println("Enter the col:");
		int col = sc.nextInt();

		ar[row][col] = 'X';

	}

	/**
	 * @param row
	 * @param col
	 * @return
	 */
	public int[][] formTable(int row1, int col1) {
		int[][] ar = new int[row1][col1];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print("[" + i + "][" + j + "]  ");

			}
			System.out.println();
			System.out.println();
		}
		return ar;

	}

	/*
	 * Method to find roots of the quadratic equation
	 */

	public double[] findRoots(double a, double b, double c) {
		double delta = Math.abs((b * b) - (4 * a * c));
		double root1 = ((-b) + Math.sqrt(delta)) / (2 * a);
		double root2 = ((-b) - Math.sqrt(delta)) / (2 * a);
		double[] ar = { root1, root2 };
		return ar;
	}

	/*
	 * 
	 */

	public double calcWindChill(double temp, double wind) {
		double windChill = 35.74 + (0.6215 * temp) + (((0.4275 * temp) - 35.75) * Math.pow(wind, 0.16));
		return windChill;
	}


	/**
	 * Method to calculate percentage of win and loss
	 * @param $stake
	 * @param $goal
	 * @param plays
	 */
	public void gambling(double stake, double goal, int plays) {
		int win = 0;

		for (int i = 1; i <= plays; i++) {
			while (stake != goal) {
				if (Math.random() < 0.5) {
					stake -= 1;
				}
				else {
					stake += 1;
					win++;
				}
			}
		}
		double winP = (win * 100) / plays;
		double lossP = (100) - (winP);
		System.out.println("NO of times he/she wins: " + win + " out of " + plays + " no. of plays ");
		if (stake == goal) {
			System.out.println("reached goal/win");
			System.out.println("win percentage: " + winP);
			System.out.println("loss percentage: " + lossP);

		} else {
			System.out.println("coudn't reach goal/loss");
			System.out.println("win percentage: " + winP);
			System.out.println("loss percentage: " + lossP);
		}

	}

}
