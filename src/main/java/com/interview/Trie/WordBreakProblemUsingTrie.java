package com.interview.Trie;

import java.util.HashMap;
import java.util.Map;


public class WordBreakProblemUsingTrie {

	class TrieNode {

		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;

	public WordBreakProblemUsingTrie() {
		root = new TrieNode();
	}

	public void insert(String str) {
		TrieNode current = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			TrieNode node = current.children.get(c);
			if (node == null) {
				node = new TrieNode();
				current.children.put(c, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public boolean search(TrieNode root, String str) {
		TrieNode current = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			TrieNode node = current.children.get(c);

			if (node == null)
				return false;
			current = node;
		}
		return current.endOfWord;
	}
	boolean wordBreak(String str, TrieNode root) 
	{ 
	    int size = str.length(); 
	  
	    // Base case 
	    if (size == 0)  return true; 
	  
	    // Try all prefixes of lengths from 1 to size 
	    for (int i=1; i<=size; i++) 
	    { 
	        // The parameter for search is str.substr(0, i) 
	        // str.substr(0, i) which is prefix (of input 
	        // string) of length 'i'. We first check whether 
	        // current prefix is in dictionary. Then we 
	        // recursively check for remaining string 
	        // str.substr(i, size-i) which is suffix of 
	        // length size-i 
	        if (search(root, str.substring(0, i)) && 
	            wordBreak(str.substring(i, size), root)) 
	            return true;
	    } 
	  
	    // If we have tried all prefixes and none 
	    // of them worked 
	    return false; 
	} 
	
	public static void main(String[] args) {
		String[] dictionary = {"mobile","samsung","sam", 
                "sung","man","mango", 
                "icecream","and","go","i", 
                "like","ice","cream"};
		
		WordBreakProblemUsingTrie trie = new WordBreakProblemUsingTrie();
		for (int i = 0; i < dictionary.length; i++) 
	       trie.insert(dictionary[i]);
		
		System.out.println(trie.wordBreak("samsung", trie.root));
	}

}
