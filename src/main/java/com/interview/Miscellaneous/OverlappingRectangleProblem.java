package com.interview.Miscellaneous;

/*
 * https://www.geeksforgeeks.org/find-two-rectangles-overlap/
 */
public class OverlappingRectangleProblem {

	static class Point { 
		  
        int x, y; 
    }

	static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
		// If one rectangle is on left side of other
		
		/*
		 * ___     ___
		 *|___|   |___|
		 * 
		 *  Two rectangles might be like this position. 
		 */
		if (l1.x > r2.x || l2.x > r1.x) {
			return false;
		}

		/*
		 *  ___
		 * |___| 
		 *  ____
		 * |____|
		 * 
		 * Two rectangles might be like this position.
		 */
		// If one rectangle is above other
		if (l1.y < r2.y || l2.y < r1.y) {
			return false;
		}

		return true;
	}
	
	public static void main(String[] args) {
		Point l1 = new Point(), r1 = new Point(), l2 = new Point(), r2 = new Point();
		l1.x = 2;
		l1.y = 10;
		r1.x = 3;
		r1.y = 5;
		l2.x = 2;
		l2.y = 3;
		r2.x = 3;
		r2.y = 1;

		if (doOverlap(l1, r1, l2, r2)) {
			System.out.println("Rectangles Overlap");
		} else {
			System.out.println("Rectangles Don't Overlap");
		}
	}

}
