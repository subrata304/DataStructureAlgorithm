package com.interview.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Find Median of running integers
 */
public class FindMedianOfRunningNumbers {
	
	public static void main(String[] args) {
		
		PriorityQueue<Float> minHeap = new PriorityQueue<>();
		PriorityQueue<Float> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		Scanner scanner  = new Scanner(System.in);
		
		/*
		 * Step 1: Each Element is added to MinHeap First
		 * Step 2: Min element is poped from MinHeap and pushed to MaxHeap
		 * [This assures all elements in minHeap are greater than maxHeap]
		 * Step 3: Two Heaps needs to be balanced w.r.t Size.
		 */
		while(scanner.hasNextInt()) {
			
			float number = scanner.nextInt();
			
			minHeap.offer(number);
			maxHeap.offer(minHeap.poll());
			
			if(maxHeap.size() > minHeap.size()) {
				minHeap.offer(maxHeap.poll());
			}
			
			if(minHeap.size() > maxHeap.size()) {
				System.out.println("The median is: "+ minHeap.peek());
			}else {
				float median = ( minHeap.peek() + maxHeap.peek())/2;
				System.out.println("The Median is: "+ median);
			}
			
		}
	}

}
