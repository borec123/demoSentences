package com.demo.sentence.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class SentenceTest {

	@Test
	void testEqual1() {
		Sentence sentence1 = new Sentence(Collections.emptyList());
		Sentence sentence2 = new Sentence(new ArrayList<>());
		
		assertTrue(sentence1.equals(sentence2));
		
		assertTrue(sentence2.equals(sentence1));
		
	}

	@Test
	void testEqual2() {
		Sentence sentence1 = new Sentence(Collections.emptyList());
		Sentence sentence2 = new Sentence(null);
		
		assertTrue(sentence1.equals(sentence2));
		
		assertTrue(sentence2.equals(sentence1));
		
	}

}
