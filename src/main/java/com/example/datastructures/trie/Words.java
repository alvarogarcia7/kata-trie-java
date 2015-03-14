package com.example.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by alvaro on 14/03/15.
 */
public class Words {
	private LevelCounter levelCounter;
	private List<Character> prefixes = new ArrayList<>();
	private Map<Character, List<Optional<String>>> suffixes = new HashMap<>();

	public Words (final LevelCounter levelCounter) {
		this.levelCounter = levelCounter;
	}

	public void add (final Word word) {
		if(!prefixes.contains(word.prefix())){
			prefixes.add(word.prefix());
		}
		if(!suffixes.containsKey(word.prefix())){
			suffixes.put(word.prefix(),new ArrayList<>());
		}
		suffixes.get(word.prefix()).add(word.suffix());
	}

	public boolean contain (final Word word) {
		return matchingPrefixFor(word) && checkSuffixFor(word);
	}

	private boolean checkSuffixFor (final Word word) {
		levelCounter.oneMore();
		final List<Optional<String>> suffixes = this.suffixes.get(word.prefix());
		return null != suffixes && suffixes.contains(word.suffix());
	}

	private boolean matchingPrefixFor (final Word word) {
		levelCounter.oneMore();
		return prefixes.contains(word.prefix());
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		this.levelCounter = levelCounter;
	}

	public boolean isEmpty () {
		return prefixes.isEmpty();
	}
}
