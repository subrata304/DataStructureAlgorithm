package com.interview.Miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Informational links:
 * 1. https://stackoverflow.com/questions/13987948/finding-k-most-common-words-in-a-file-memory-usage
 * 2. https://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
 * 3. https://stackoverflow.com/questions/185697/the-most-efficient-way-to-find-top-k-frequent-words-in-a-big-word-sequence
 * 4. http://javaworldwide.blogspot.com/2015/09/find-k-most-frequent-words-from-file.html 
 */

public class TopKFrequentWords {

	//Approach 1 - Hashmap and Sorting
	
	/*
	 * Time Complexity: O(NlogN), where N is the length of words. 
	 * We count the frequency of each word in O(N)time, then we sort the given words in O(NlogN) time.
	 * Space Complexity: O(N)
	 */
	
	public static List<String> topKFrequent1stApproach(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
	}
	
	
	//Approach 2 - HashMap and Min Heap
	
	/*
	 * Time Complexity: O(Nlogk), where N is the length of words. 
	 * We count the frequency of each word in O(N) time, 
	 * then we add N words to the heap, each in O(logk) time. 
	 * Finally, we pop from the heap up to k times. 
	 * As k≤N, this is O(Nlogk) in total.
	 */
	public static List<String> topKFrequent2ndApproach(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> result = new ArrayList<>();
        
        while (!heap.isEmpty()) {
        	result.add(heap.poll());
        }
        
        Collections.reverse(result);
        return result;
    }
	
	public static void main(String[] args) {
		String[] arr = {"the", "day", "is", "sunny", "the", "the",
				"the", "sunny", "is", "is"};
		int k = 4;
		
		List<String> list1 = topKFrequent1stApproach(arr, k);
		
		List<String> list2 = topKFrequent2ndApproach(arr, k);
		
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		
	}
	
}
