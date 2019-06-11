package com.interview.StackAndQueue;

import java.util.StringTokenizer;

public class SuperStack {

	public static void main(String[] argv) {

		String[] cmds = { "14", "PUSH 4", "POP", "PUSH 3", "PUSH 5", "PUSH 2", "INC 3 1", "POP", "PUSH 1", "INC 2 2",
				"PUSH 4", "POP", "POP", "PUSH 10", "PUSH 11" };

		String cmd = null;

		int[] stk = new int[100];
		int here = -1;
		int n = Integer.parseInt(cmds[0]);
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(cmds[i], " ");
			cmd = st.nextToken();

			if ("POP".compareTo(cmd) == 0) {
				if (here == 0) {
					here--; // Do POP
					System.out.println("EMPTY");
				} else {
					here--; // Do POP
					System.out.println(stk[here]);
				}
			} else if ("PUSH".compareTo(cmd) == 0) {
				stk[++here] = Integer.parseInt(st.nextToken()); // Do PUSH
				System.out.println(stk[here]);
			} else if ("INC".compareTo(cmd) == 0) {
				int t = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				for (int k = 0; k < t; k++) {
					stk[k] = stk[k] + d;
				}
				System.out.println(stk[here]);
			}
		}
		/*
		 * System.out.println("-Top---------------------------"); for (int i = here; i
		 * >= 0; i--) { System.out.println(stk[i]); }
		 * System.out.println("-Bottom------------------------");
		 */
	}
}
