package com.bridgelabz.util;

import java.util.Scanner;
import java.util.Random;

public class Utility {

	static Scanner scanner = new Scanner(System.in);
	static Random ran = new Random();

	/*
	 * Method to take user input as string
	 */
	public static String userInputString() {
		return scanner.nextLine();
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

	
	
	/**
	 * Method to replace the a string with the user input name
	 * @param temp
	 * @return
	 */
	public static String replaceUserName(String temp) {
		System.out.println("Enter your name: ");
		String res = temp.replace("<<username>>", userInputString());
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
		 
		 if(year.length()==4)
		 {
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
	static int count = 0;
	public static void findPrime(int num) {
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
		double sum = (Math.pow(x, x)) + (Math.pow(y, y));
		return Math.sqrt(sum);
	}

	
	
	/**
	 * To check whether the coupon numbers entered by user are distinct or not
	 * @param num
	 * @return integer array
	 */
	public static int[] checkDistinct(int num) {
		int[] ar = new int[num];
		System.out.println("Enter " + num + " distinct coupons: ");

		for (int i = 0; i < num; i++) {
			ar[i] = Utility.userInputInteger();
			if (i != 0) {
				for (int j = i - 1; j >= 0; j--) {
					if (ar[i] == ar[j]) {
						System.out.println("You have entered duplicate values.Please start again!!");
						checkDistinct(num);
					}
				}
			}
		}
		return ar;
	}

	/**
	 * Method to return the all possible random numbers need to be generated to get
	 * all n distinct coupons
	 * 
	 * @param num
	 * 
	 * @return
	 */
	public static int randomGen(int num) {
		int[] ar = checkDistinct(num);
		int match = 0;
		int codeCount = 0;

		while (match != ar.length) {
			int code = ran.nextInt(100);
			codeCount++;
			for (int i = 0; i < ar.length; i++) {
				if (code == ar[i]) {
					match++;
				}
			}
		}
		return codeCount;
	}

	/**
	 * Method to return all possible permutation of given string
	 * @param ch
	 * @param key
	 */
	public static void permutation(char[] ch, int key) {

		if (key == ch.length) {
			for (int i = 0; i < ch.length; i++) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}

		else {
			for (int i = 0; i < ch.length; i++) {
				char temp = ch[key];
				ch[key] = ch[i];
				ch[i] = temp;

				permutation(ch, key + 1);

				temp = ch[key];
				ch[key] = ch[i];
				ch[i] = temp;
			}
		}
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
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(estimatedTime + "ms");
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
		
		while (a != 2) {
			System.out.println("Enter the row:");
			int row = userInputInteger();
			System.out.println("Enter the col:");
			int col = userInputInteger();
			ar[row][col] = 2;
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
		ar[comrow][comcol] = 1;
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
				if (ar[i][j] == 2) {
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
					if (ar[y][x] == 2) {
						y++;
						count1++;
					} else
						y++;
				}
				if (count1 == 3) {
					return 2;
				}
				if (ar[0][0] == 2 && ar[1][1] == 2 && ar[2][2] == 2
						|| ar[0][2] == 2 && ar[1][1] == 2 && ar[2][0] == 2) {
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
				System.out.print(ar[i][j]);
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
			while (stake != goal) {
				if (Math.random() < 0.5) {
					stake -= 1;
				} else {
					stake += 1;
					win++;
				}
				break;
			}
		}
		double winP = (win * 100)/ plays;
		double lossP = (100) - (winP);
		System.out.println("NO of times he/she wins: " + win + " out of " + plays + " no. of plays ");
		if (stake == goal) {
			System.out.println("reached goal/win");
			System.out.println("win percentage: " + winP+"%");
			System.out.println("loss percentage: " + lossP+"%");

		} else {
			System.out.println("coudn't reach goal/loss");
			System.out.println("win percentage: " + winP+"%");
			System.out.println("loss percentage: " + lossP+"%");
		}

	}

}
