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
	private List<Character> prefixes = new ArrayList<>();
	private Map<Character, List<Optional<String>>> suffixes = new HashMap<>();
	public void add (final Word word) {
		if(!prefixes.contains(word.prefix())){
			prefixes.add(word.prefix());
		}
		if(!suffixes.containsKey(word.prefix())){
			suffixes.put(word.prefix(),new ArrayList<>());
		}
		suffixes.get(word.prefix()).add(word.suffix());
	}
}
