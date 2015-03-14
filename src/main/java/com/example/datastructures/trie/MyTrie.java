package com.example.datastructures.trie;

/**
 * Created by alvaro on 14/03/15.
 */
public class MyTrie {
	private boolean empty = true;

	public boolean isEmpty () {
		return empty;
	}

	public MyTrie add (final String value) {
		empty = false;
		return this;
	}
}
