package com.interview.Miscellaneous;

import java.util.Scanner;

/*
 * Identify Comments and print them from a existing Java code
 */

public class IndentifyingComments {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String multiPleLinesComment = "", line;
		while (in.hasNextLine()) {
			line = in.nextLine();
			if (line.contains("//")) {
				System.out.println(line.substring(line.indexOf("//"), line.length()).trim());
			}
			if (line.contains("/*") && line.contains("*/")) {
				System.out.println(line.trim());
			}
			else if (line.contains("/*")) {
				do {
					multiPleLinesComment += line.trim() + "\n";
					line = in.nextLine();
				} while (!line.contains("*/"));
				multiPleLinesComment += line.trim();
				System.out.println(multiPleLinesComment.trim());
				multiPleLinesComment = "";
			}else {
				System.out.println(line);
			}
		}
	}
}
