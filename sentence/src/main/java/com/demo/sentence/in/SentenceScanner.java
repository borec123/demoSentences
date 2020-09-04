package com.demo.sentence.in;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.demo.sentence.model.Sentence;

public class SentenceScanner implements Enumeration<Sentence> {

	private InputStream inputStream;
	private Scanner mainScanner;
	private static final String sentence_scanner_pattern = "\\s*!+|\\?+|\\.+\\s*";
	private static final String word_scanner_pattern = "[\\p{javaWhitespace},()]+";

	public SentenceScanner(String input) {
		super();
		mainScanner = new Scanner(input == null ? "" : input).useDelimiter(sentence_scanner_pattern );
	}

	public SentenceScanner(InputStream is) {
		super();
		this.inputStream = is;
		mainScanner = new Scanner(inputStream).useDelimiter(sentence_scanner_pattern);
	}

	@Override
	public boolean hasMoreElements() {
		if (!mainScanner.hasNext()) {
			mainScanner.close();
			return false;
		}

		return true;
	}

	@Override
	public Sentence nextElement() {
		String line = mainScanner.next();
		Scanner innerScanner = new Scanner(line).useDelimiter(word_scanner_pattern);
		
		List<String> words = new ArrayList<>();
		innerScanner.tokens().forEach(words::add);
		innerScanner.close();

		words.sort((String s1, String s2) -> s1.compareToIgnoreCase(s2));

		Sentence sentence = new Sentence(words);
		return sentence;
	}

}
