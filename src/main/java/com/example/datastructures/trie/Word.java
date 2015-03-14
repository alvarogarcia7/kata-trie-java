package com.example.datastructures.trie;

import java.util.Optional;

/**
* Created by alvaro on 14/03/15.
*/
class Word {

	private final Character prefix;
	private final Optional<String> suffix;

	private Word (final char prefix, final String suffix) {
		this(prefix, Optional.of(suffix));
	}

	private Word (final char prefix) {
		this(prefix, Optional.empty());
	}

	private Word (final char prefix, Optional<String> suffix) {
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
	public Character prefix () {
		return prefix;
	}

	public Optional<String> suffix () {
		return suffix;
	}
}
