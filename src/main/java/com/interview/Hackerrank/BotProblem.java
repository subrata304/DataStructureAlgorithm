package com.interview.Hackerrank;

public class BotProblem {

	public static void main(String[] args) {
		System.out.println(canReach(1, 2, 2, 1));
	}

	public static String canReach(int x1, int y1, int x2, int y2) {
		// Write your code here
		if (x1 == x2 && y1 == y2) {
			return "Yes";
		}
		if (x1 > x2 || y1 > y2) {
			return "No";
		}
		return ("Yes".equals(canReach(x1 + y1, y1, x2, y2)) || "Yes".equals(canReach(x1, y1 + x1, x2, y2))) ? "Yes"
				: "No";

	}
}
