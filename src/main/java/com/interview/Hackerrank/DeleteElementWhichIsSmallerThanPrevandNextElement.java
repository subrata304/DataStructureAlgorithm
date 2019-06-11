package com.interview.Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DeleteElementWhichIsSmallerThanPrevandNextElement {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 20, 5, 30, 4, 20, 60);
		updateList(list);
	}

	public static void updateList(List<Integer> list) {

		List<Integer> listTemp = list;
		Stack<Integer> s = new Stack<>();
		s.push(listTemp.get(0));
		int lastCount = 0;
		int count = 0;
		while (true) {
			for (int i = 1; i < listTemp.size() - 1; i++) {

				if (!s.empty() && s.peek() > listTemp.get(i) && listTemp.get(i) < listTemp.get(i + 1)) {
					//list.remove(listTemp.get(i));
					continue;
				} else {
					s.push(listTemp.get(i));
				}

			}

			s.push(listTemp.get(listTemp.size() - 1));
			if (s.size() == 2) {
				// System.out.println(s);
				System.out.println(listTemp.toString());
				/*
				 * Iterator<Integer> it = list.iterator(); while (it.hasNext()) { Integer
				 * integer = it.next(); if (!listTemp.contains(integer)) { it.remove(); } }
				 */
				list.retainAll(listTemp);
				System.out.println(list.toString());
				return;
			}
			count = s.size();
			if (lastCount == count) {
				// System.out.println(s);
				System.out.println(listTemp.toString());
				Iterator<Integer> it = list.iterator();
				/*
				 * while (it.hasNext()) { Integer integer = it.next(); if
				 * (!listTemp.contains(integer)) { it.remove(); } }
				 */
				list.retainAll(listTemp);
				System.out.println(list.toString());
				return;
			} else {
				lastCount = count;
			}
			listTemp = new ArrayList<>();
			for (Integer item : s) {
				listTemp.add(item);
			}
			s = new Stack<>();
			s.push(listTemp.get(0));
		}
	}
}
