package com.bridgelabz.algorithmprograms;

public class Max {

	public static void main(String[] args) {

		String x = "aa";
		String y = "bb";
		String z = "cc";
		String res = findMax(x, y, z);
		System.out.println(res);

	}

	public static int findMax(int x, int y, int z) {
		if (x > y && x > z) {
			return x;
		} else if (y > z && y > x) {
			return y;
		} else {
			return z;
		}
	}

	public static <S extends Comparable<S>> S findMax(S x, S y, S z) {
		if (x.compareTo(y) > 0 && x.compareTo(z) > 0) {
			return x;
		} else if (y.compareTo(x) > 0 && y.compareTo(z) > 0) {
			return y;
		} else {
			return z;
		}
	}

	/*
	 * public static <T extends Comparable<T>> T findMax(T x,T y, T z){ return
	 * (x.compareTo(y)>0&& x.compareTo(z)>0 ? x: (y.compareTo(z)>0&&
	 * y.compareTo(x)>0) ? y:z); }
	 */

}
