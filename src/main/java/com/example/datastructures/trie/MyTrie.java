package com.example.datastructures.trie;

/**
 * Created by alvaro on 14/03/15.
 */
public class MyTrie {
	private LevelCounter levelCounter = new LevelCounter();
	private Words words = new Words(levelCounter);

	public boolean isEmpty () {
		return words.isEmpty();
	}

	public MyTrie add (final String value) {
		Word word = Word.from(value);
		words.add(word);
		return this;
	}

	public boolean contains (final String value) {
		Word word = Word.from(value);
		return words.contain(word);
	}

	public void injectLevelCounter (final LevelCounter levelCounter) {
		words.injectLevelCounter(levelCounter);
	}

}
