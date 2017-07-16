package data_structures.trie;

import java.util.HashMap;
import java.util.Map;

import data_structures.TrieNode;

public class Trie {

	private TrieNode root;

	public void insert(String str) {
		TrieNode node = root;
		for (char ch : str.toCharArray()) {
			if (!node.contains(ch)) {
				node.insert(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	public TrieNode searchPrefix(String str) {
		TrieNode node = root;
		for (char ch : str.toCharArray()) {
			if (node.contains(ch)) {
				node = node.get(ch);
			}
		}
		return node;
	}

	public boolean search(String str) {
		TrieNode node = searchPrefix(str);
		return node != null && node.isEnd();
	}
}
