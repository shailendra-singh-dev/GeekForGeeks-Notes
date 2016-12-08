package data_structures;

import java.util.HashMap;

//Taken from https://leetcode.com/articles/implement-trie-prefix-tree/
public class TrieNode {

	private boolean isEnd;

	private int size = 26;

	private TrieNode[] links = null;

	public TrieNode() {
		links = new TrieNode[size];
	}

	public boolean contains(char ch) {
		return links[ch - 'a'] != null;
	}

	public void insert(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd() {
		isEnd = true;
	}

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	public TrieNode[] getChildren() {
		return links;
	}
}
