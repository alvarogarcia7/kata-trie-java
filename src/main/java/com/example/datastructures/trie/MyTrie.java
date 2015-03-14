package com.example.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alvaro on 14/03/15.
 */
public class MyTrie {
	private boolean empty = true;
	private List<String> values = new ArrayList<>();
	private LevelCounter levelCounter = new LevelCounter();

	public boolean isEmpty () {
		return empty;
	}

	public MyTrie add (final String value) {
		empty = false;
		this.values.add(value);
		return this;
	}

	public boolean contains (final String value) {
		for (String current : values) {
			levelCounter.oneMore();
			if(current.equals(value)){
				return true;
			}
		}
		return false;
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		this.levelCounter = levelCounter;
	}
}
