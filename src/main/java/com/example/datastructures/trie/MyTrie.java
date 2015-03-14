package com.example.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alvaro on 14/03/15.
 */
public class MyTrie {
	private boolean empty = true;
	private List<String> values = new ArrayList<>();
	private LevelCounter levelCounter = new LevelCounter();
	private Map<Character, String> suffixes = new HashMap<>();

	public boolean isEmpty () {
		return empty;
	}

	public MyTrie add (final String value) {
		empty = false;
		if (hasSuffixAlreadyPresent(value)) {
			this.suffixes.put(value.charAt(0), value.substring(0));
		} else {
			this.values.add(value);
		}
		return this;
	}

	private boolean hasSuffixAlreadyPresent (final String value) {
		return value.length() > 1 && this.values.contains(String.valueOf(value.charAt(0)));
	}

	public boolean contains (final String value) {
		if (hasSuffixAlreadyPresent(value)) {
			levelCounter.oneMore();
			levelCounter.oneMore();
			final String suffix = suffixes.get(value.charAt(0));
			return suffix.equals(value);
		}
		for (String current : values) {
			levelCounter.oneMore();
			if (current.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		this.levelCounter = levelCounter;
	}
}
