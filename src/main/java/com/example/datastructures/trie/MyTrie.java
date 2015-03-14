package com.example.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaro on 14/03/15.
 */
public class MyTrie {
	private boolean empty = true;
	private List<String> values = new ArrayList<String>();

	public boolean isEmpty () {
		return empty;
	}

	public MyTrie add (final String value) {
		empty = false;
		this.values.add(value);
		return this;
	}

	public boolean contains (final String value) {
		return this.values.contains(value);
	}
}
