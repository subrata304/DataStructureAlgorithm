package com.interview.Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie_MoreThanAlphabets {

	public static void main(String[] args) {
		Trie_MoreThanAlphabets trie = new Trie_MoreThanAlphabets();
		trie.insert("abc");trie.insert("abcd");
		trie.insert("agil");trie.insert("bcde");trie.insert("bcdf");

		System.out.println(trie.search("agil"));
		System.out.println(trie.delete("agil"));
		System.out.println(trie.search("agil"));

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

	public Trie_MoreThanAlphabets() {
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

	public boolean delete(String word) {
		 return delete(root, word, 0);
	}

	/**
	 * Returns true if parent should delete the mapping
	 */
	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			//when end of word is reached only delete if currrent.endOfWord is true.
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			//if current has no other mapping then return true
			return current.children.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

		//if true is returned then delete the mapping of character and trienode reference from map.
		if (shouldDeleteCurrentNode) {
			current.children.remove(ch);
			//return true if no mappings are left in the map.
			return current.children.size() == 0;
		}
		return false;
	}

}


