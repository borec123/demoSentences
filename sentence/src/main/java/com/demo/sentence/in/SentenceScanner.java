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
	private static final String pattern = "\\s*!+|\\?+|\\.+\\s*";

	public SentenceScanner(String input) {
		super();
		mainScanner = new Scanner(input).useDelimiter(pattern );
	}

	public SentenceScanner(InputStream is) {
		super();
		this.inputStream = is;

		mainScanner = new Scanner(inputStream).useDelimiter(pattern);
		
		/*
		 * while(mainScanner.hasNext()) { String line = mainScanner.next();
		 * System.out.println("\"" + line + "\""); Scanner innerScanner = new
		 * Scanner(line);
		 * 
		 * List<String> words = new ArrayList<>();
		 * innerScanner.tokens().forEach(words::add); innerScanner.close();
		 * 
		 * Collections.sort(words);
		 * 
		 * Sentence sentence = new Sentence(words); }
		 */ }

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
		System.out.println("\"" + line + "\"");
		Scanner innerScanner = new Scanner(line).useDelimiter("\\s*,|\\(+|\\)+\\s*");

		List<String> words = new ArrayList<>();
		innerScanner.tokens().forEach(words::add);
		innerScanner.close();

		words.sort((String s1, String s2) -> s1.compareToIgnoreCase(s2));

		Sentence sentence = new Sentence(words);
		return sentence;
	}

}
