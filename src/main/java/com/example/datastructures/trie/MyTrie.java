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
	private Words words = new Words(levelCounter);
	private Map<Character, List<Optional<String>>> suffixes = new HashMap<>();

	public boolean isEmpty () {
		return prefixes.isEmpty();
	}

	public MyTrie add (final String value) {
		Word word = Word.from(value);
		words.add(word);

		// PARALLEL CHANGE
		if(!prefixes.contains(word.prefix())){
			prefixes.add(word.prefix());
		}
		if(!suffixes.containsKey(word.prefix())){
			suffixes.put(word.prefix(),new ArrayList<>());
		}
		suffixes.get(word.prefix()).add(word.suffix());
		// END PARALLEL CHANGE


		return this;
	}

	public boolean contains (final String value) {
		Word word = Word.from(value);
		return words_contain(word);
	}

	//TODO AGB this method has this name because I'm forecasting I'm going to extract a repository for Word
	private boolean words_contain (final Word word) {
		return words.contain(word);
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		words.injectLevelCounter(levelCounter);
	}

}
