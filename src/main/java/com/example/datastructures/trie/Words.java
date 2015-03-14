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
		if (noMatchingPrefixFor(word)){
			return false;
		}
		return checkSuffixIfPresentFor(word);
	}

	private boolean checkSuffixIfPresentFor (final Word word) {
		if(!word.suffix().isPresent()){
			return true;
		}
		levelCounter.oneMore();
		return suffixes.get(word.prefix()).contains(word.suffix());
	}

	private boolean noMatchingPrefixFor (final Word word) {
		levelCounter.oneMore();
		if(!prefixes.contains(word.prefix())){
			return true;
		}
		return false;
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		this.levelCounter = levelCounter;
	}
}
