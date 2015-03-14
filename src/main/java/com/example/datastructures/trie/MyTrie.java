package com.example.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by alvaro on 14/03/15.
 */
public class MyTrie {
	private List<Character> prefixes = new ArrayList<>();
	private LevelCounter levelCounter = new LevelCounter();
	private Map<Character, String> suffixes = new HashMap<>();

	public boolean isEmpty () {
		return prefixes.isEmpty();
	}

	public MyTrie add (final String value) {
		if (hasPrefixAlreadyPresent(value)) {
			this.suffixes.put(value.charAt(0), value.substring(0));
		} else {
			this.prefixes.add(value.charAt(0));
		}
		return this;
	}

	private PrefixSuffix splitIntoPrefixSuffix (final String value) {
		if(value.length() > 1){
			return new PrefixSuffix(value.charAt(0), value.substring(0));
		} else {
			return new PrefixSuffix(value.charAt(0));
		}
	}

	private boolean hasPrefixAlreadyPresent (final String value) {
		PrefixSuffix prefixSuffix = splitIntoPrefixSuffix(value);
		if(prefixSuffix.suffix.isPresent() && this.prefixes.contains(prefixSuffix.prefix)){
			return true;
		}return false;
	}

	public boolean contains (final String value) {

		levelCounter.oneMore(); // check prefix
		if (hasPrefixAlreadyPresent(value)) {
			levelCounter.oneMore(); // check  suffix
			final String suffix = suffixes.get(value.charAt(0));
			return suffix.equals(value);
		}
		for (Character current : prefixes) {
			if (current.equals(value.charAt(0))) {
				return true;
			}
		}
		return false;
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		this.levelCounter = levelCounter;
	}

	private class PrefixSuffix {
		private final Character prefix;
		private final Optional<String> suffix;

		public PrefixSuffix (final char prefix, final String suffix) {
			this(prefix, Optional.of(suffix));
		}

		public PrefixSuffix (final char c) {
			this(c, Optional.empty());
		}

		public PrefixSuffix(final char prefix, Optional<String> suffix) {
			this.prefix = prefix;
			this.suffix = suffix;
		}
	}
}
