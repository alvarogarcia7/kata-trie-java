package com.example.datastructures.trie;

import java.util.Optional;

/**
 * Created by alvaro on 14/03/15.
 */
public class MyTrie {
	private boolean empty = true;
	private Optional<String> value = Optional.empty();

	public boolean isEmpty () {
		return empty;
	}

	public MyTrie add (final String value) {
		empty = false;
		this.value = Optional.of(value);
		return this;
	}

	public boolean contains (final String value) {
		if(this.value.isPresent()){
			return this.value.get().equals(value);
		}
		return false;
	}
}
