package com.interview.Miscellaneous;

import java.util.Scanner;

/*
 * Identify Comments and print them from a existing Java code
 */

public class IndentifyingComments {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String mine = "", read;
		while (in.hasNextLine()) {
			read = in.nextLine();
			if (read.contains("//")) {
				System.out.println(read.substring(read.indexOf("//"), read.length()).trim());
			}
			if (read.contains("/*") && read.contains("*/")) {
				System.out.println(read.trim());
			}
			else if (read.contains("/*")) {
				do {
					mine += read.trim() + "\n";
					read = in.nextLine();
				} while (!read.contains("*/"));
				mine += read.trim();
				System.out.println(mine.trim());
				mine = "";
			}else {
				System.out.println(read);
			}
		}
	}
}
