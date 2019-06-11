package com.interview.Hackerrank;

public class CountingHolesfromNumber {

	public static void main(String[] args) {
		int num = 630;
		int holes = 0;
		while (num > 0) {
			int lastDigit = num % 10;
			num = num / 10;
			System.out.println(lastDigit);

			switch (lastDigit) {
			case 1:
			case 2:
			case 3:
			case 5:
			case 7:
				holes = holes + 0;
				break;
			case 0:
			case 4:
			case 6:
			case 9:
				holes = holes + 1;
				break;
			case 8:
				holes = holes + 2;
				break;
			}
		}
		System.out.println(holes);
	}
}
