package com.demo.sentence.in;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.demo.sentence.model.Sentence;

class SentenceScannerTest {

	@Test
	void testEmptyString() {
		test("");
	}

	@Test
	void testNull() {
		test(null);
	}

	@Test
	void testSentence1() {
		List<Sentence> list = test("  Mary   had a little  lamb  . " + "\n" + "\n"
				+ "				  Peter   called for the wolf   ,  ((and Aesop came .\r\n"
				+ "				 Cinderella  likes shoes..");
		
		assertEquals(3, list.size());
		assertEquals("a,had,lamb,little,Mary,", list.get(0).toString());
		assertEquals("Aesop,and,called,came,for,Peter,the,wolf,", list.get(1).toString());
		assertEquals("Cinderella,likes,shoes,", list.get(2).toString());
	}
	
	@Test
	void testSentence2() {
		List<Sentence> list = test(" Mary had a little lamb. Peter called for the wolf, and Aesop came.\r\n" + 
				"Cinderella likes shoes.");
		
		assertEquals(3, list.size());
		assertEquals("a,had,lamb,little,Mary,", list.get(0).toString());
		assertEquals("Aesop,and,called,came,for,Peter,the,wolf,", list.get(1).toString());
		assertEquals("Cinderella,likes,shoes,", list.get(2).toString());
	}

	List<Sentence> test(String string) {
		SentenceScanner sentenceScanner = new SentenceScanner(string);
		List<Sentence> list = new ArrayList<>();
		while (sentenceScanner.hasMoreElements()) {
			Sentence sentence = sentenceScanner.nextElement();
			list.add(sentence);
			System.out.println(sentence);
		}
		return list;
	}

}
