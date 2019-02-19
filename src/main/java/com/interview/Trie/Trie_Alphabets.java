package com.interview.Trie;

public class Trie_Alphabets {

	// Alphabet size (# of symbols) 
	static final int ALPHABET_SIZE = 26; 

	// trie node 
	static class TrieNode 
	{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 

		// isEndOfWord is true if the node represents 
		// end of a word 
		boolean isEndOfWord; 

		TrieNode(){ 
			isEndOfWord = false; 
			for (int i = 0; i < ALPHABET_SIZE; i++) 
				children[i] = null; 
		} 
	}; 

	static TrieNode root;  

	// If not present, inserts key into trie 
	// If the key is prefix of trie node,  
	// just marks leaf node 
	static void insert(String key) 
	{ 
		int level; 
		int length = key.length(); 
		int index; 

		TrieNode pCrawl = root; 

		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - 'a'; 
			if (pCrawl.children[index] == null) 
				pCrawl.children[index] = new TrieNode(); 

			pCrawl = pCrawl.children[index]; 
		} 

		// mark last node as leaf 
		pCrawl.isEndOfWord = true; 
	} 

	// Returns true if key presents in trie, else false 
	static boolean search(String key) 
	{ 
		int level; 
		int length = key.length(); 
		int index; 
		TrieNode pCrawl = root; 

		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - 'a'; 

			if (pCrawl.children[index] == null) 
				return false; 

			pCrawl = pCrawl.children[index]; 
		} 

		return (pCrawl != null && pCrawl.isEndOfWord); 
	} 

	public static void main(String args[]) 
	{ 

		root = new TrieNode(); 

		insert("abc");insert("abcd");insert("agil");insert("bcde");insert("bcdf");

		if(search("abcddd")) 
			System.out.println("Found"); 
		else System.out.println("Not Found"); 


	} 
}
