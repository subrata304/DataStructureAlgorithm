package com.interview.Miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheCustomImpl<K, V> {

	int capacity;
	Map<K, Node<K,V>> map = new HashMap<>();
	Node<K, V> head = null;
	Node<K, V> end = null;

	public LRUCacheCustomImpl(int capacity) {
		this.capacity = capacity;
	}

	public V get(K key) {
		if (map.containsKey(key)) {
			Node<K, V> n = map.get(key);
			delete(n);
			setHead(n);
			return n.value;
		}

		return null;
	}

	/* This method will delete the node */
	public void delete(Node<K, V> node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			end = node.prev;
		}

	}

	/* This method will make passed node as head */
	public void setHead(Node<K, V> node) {
		node.next = head;
		node.prev = null;

		if (head != null)
			head.prev = node;

		head = node;

		if (end == null)
			end = head;
	}

	public void put(K key, V value) {
		if (map.containsKey(key)) {
			// update the old value
			Node<K, V> old = map.get(key);
			old.value = value;
			delete(old);
			setHead(old);
		} else {
			Node<K, V> newNode = new Node<>(key, value);
			if (map.size() >= capacity) {

				map.remove(end.key);
				// remove last node
				delete(end);
				setHead(newNode);

			} else {
				setHead(newNode);
			}

			map.put(key, newNode);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		LRUCacheCustomImpl<Integer, Integer> lrucache = new LRUCacheCustomImpl<>(4);
		lrucache.put(1, 100);
		lrucache.put(10, 99);
		lrucache.put(15, 98);
		lrucache.put(10, 97);
		lrucache.put(12, 96);
		lrucache.get(15);
		lrucache.put(18, 95);
		lrucache.put(1, 94);
		

		System.out.println(lrucache.get(1));
		System.out.println(lrucache.get(10));
		System.out.println(lrucache.get(15));

	}
}

class Node<K, V> {
	K key;
	V value;
	Node<K, V> prev;
	Node<K, V> next;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
}