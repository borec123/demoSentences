package com.demo.sentence.model;

import java.util.List;

/**
 * domain model class Sentence.java
 */
public class Sentence {

	private final List<String> words;

	public List<String> getWords() {
		return words;
	}

	public Sentence(List<String> words) {
		super();
		this.words = words;
	}

	private String value() {
		if(words == null || words.size() == 0) {
			return "";
		}
		final StringBuilder string = new StringBuilder();
		words.forEach(s -> string.append(s + ","));
		return string.toString();
	}
	
	@Override
	public int hashCode() {
		return value().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Sentence)) {
			return false;
		}
		return value().equals(((Sentence)obj).value());
	}

	@Override
	public String toString() {
		return value();
	}
	
	
	
}
