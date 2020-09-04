package com.demo.sentence.out;

import java.io.IOException;

import com.demo.sentence.model.Sentence;

public interface SentenceWriterInterface {
	

	void writeSentence(Sentence sentence) throws IOException;

	void writeHeader() throws IOException ;
	void writeFooterAndClose() throws IOException ;

	
}
