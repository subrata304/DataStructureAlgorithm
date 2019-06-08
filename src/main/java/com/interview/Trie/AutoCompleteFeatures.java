package com.interview.Trie;

import java.util.HashMap;
import java.util.Map;

public class AutoCompleteFeatures {

	public static void main(String[] args) {
		AutoCompleteFeatures trie = new AutoCompleteFeatures();
		trie.insert("abc");trie.insert("abcd");
		trie.insert("agil");trie.insert("bcde");trie.insert("abkh");
		trie.insert("bcdf");trie.insert("abdef");
		trie.getAutoCompleteWords("ab");
	}
	private class TrieNode{

		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;

	public AutoCompleteFeatures() {
		root = new TrieNode();
	}

	public void insert(String str) {
		TrieNode current = root;
		for(int i = 0; i < str.length(); i ++) {
			char c = str.charAt(i);
			TrieNode node = current.children.get(c);
			if(node == null) {
				node = new TrieNode();
				current.children.put(c, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public boolean search(String str) {
		TrieNode current = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			TrieNode node = current.children.get(c);

			if(node == null) return false;
			current = node;
		}
		return current.endOfWord;
	}
	
	public void getAutoCompleteWords(String word) {
		
		TrieNode current = root;
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = current.children.get(c);
			if(node == null) System.out.println("No Words with prefix " + word);
			
			current = node;
		}
		
		getWords(current);
		
	}

	private void getWords(TrieNode current) {

		if(current.endOfWord) return;
		
		for(Character c : current.children.keySet()) {
			getWords(current.children.get(c));
		}
		
	}
	
}
