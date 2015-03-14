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
	private Map<Character, List<Optional<String>>> suffixes = new HashMap<>();

	public boolean isEmpty () {
		return prefixes.isEmpty();
	}

	public MyTrie add (final String value) {
		Word word = Word.from(value);
		if(!prefixes.contains(word.prefix)){
			prefixes.add(word.prefix);
		}
		if(!suffixes.containsKey(word.prefix)){
			suffixes.put(word.prefix,new ArrayList<>());
		}
		suffixes.get(word.prefix).add(word.suffix);
		return this;
	}

	public boolean contains (final String value) {
		Word word = Word.from(value);
		return words_contain(word);
	}

	//TODO AGB this method has this name because I'm forecasting I'm going to extract a repository for Word
	private boolean words_contain (final Word word) {
		if (noMatchingPrefixFor(word)){
			return false;
		}
		return checkSuffixIfPresentFor(word);
	}

	private boolean checkSuffixIfPresentFor (final Word word) {
		if(!word.suffix.isPresent()){
			return true;
		}
		levelCounter.oneMore();
		return suffixes.get(word.prefix).contains(word.suffix);
	}

	private boolean noMatchingPrefixFor (final Word word) {
		levelCounter.oneMore();
		if(!prefixes.contains(word.prefix)){
			return true;
		}
		return false;
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		this.levelCounter = levelCounter;
	}

	private static class Word {
		private final Character prefix;
		private final Optional<String> suffix;

		public Word (final char prefix, final String suffix) {
			this(prefix, Optional.of(suffix));
		}

		public Word (final char prefix) {
			this(prefix, Optional.empty());
		}

		public Word (final char prefix, Optional<String> suffix) {
			this.prefix = prefix;
			this.suffix = suffix;
		}

		@Override
		public String toString () {
			return "{" +
					"prefix=" + prefix +
					", suffix=" + suffix +
					'}';
		}

		public static Word from (final String value) {
			if(value.length() > 1){
				return new Word(value.charAt(0), value.substring(1));
			} else {
				return new Word(value.charAt(0));
			}
		}
	}
}
