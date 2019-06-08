package com.interview.Miscellaneous;

import java.math.BigInteger;

//0(logn) Time Complexity 
public class BigIntegerPower {

	static int recCycle = 0;

	public static int power(int x, int y) {
		System.out.println(" Recursion Call depth : " + ++recCycle);
		int temp;
		if (y == 0)
			return 1;
		temp = power(x, y / 2);

		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	public static BigInteger powerBigInteger(BigInteger exp, BigInteger base) {
		System.out.println(" Recursion Call depth : " + ++recCycle);
		
		BigInteger temp;
		
		if (base.compareTo(BigInteger.ZERO) == 0)
			return BigInteger.ONE;
		
		temp = powerBigInteger(exp, base.divide(BigInteger.valueOf(2)));

		if (base.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0)
			return temp.multiply(temp);
		else {
			if (base.compareTo(BigInteger.ZERO) > 0)
				return exp.multiply(temp).multiply(temp);
			else
				return (temp.multiply(temp)).divide(exp);
		}
	}
	public static void main(String[] args) {
		int x = 2;
		int y = -3;

		System.out.println(powerBigInteger(BigInteger.valueOf(12), BigInteger.valueOf(19)));
	}

}
