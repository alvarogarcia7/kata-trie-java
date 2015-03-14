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
	private List<String> chars = new ArrayList<>();
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
			this.chars.add(value);
		}
		return this;
	}

	private boolean hasSuffixAlreadyPresent (final String value) {
		return value.length() > 1 && this.chars.contains(String.valueOf(value.charAt(0)));
	}

	public boolean contains (final String value) {
		levelCounter.oneMore(); // check prefix
		if (hasSuffixAlreadyPresent(value)) {
			levelCounter.oneMore(); // check  suffix
			final String suffix = suffixes.get(value.charAt(0));
			return suffix.equals(value);
		}
		for (String current : chars) {
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
