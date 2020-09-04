package com.demo.sentence.out;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.PrintStream;

import com.demo.sentence.model.Sentence;

public abstract class AbstractSentenceWriter {
	
	protected PrintStream printStream;
	
	public AbstractSentenceWriter(OutputStream os) {
		printStream = new PrintStream(os);
		writeHeader();
	}
	
	public void writeSentence(Sentence sentence) {
		
		//BufferedWriter BufferedWriter = new BufferedWriter(os);
		printStream.println("\t<sentence>");
		sentence.getWords().forEach(w -> printStream.println(getLine(w)));
		printStream.println("\t</sentence>");
	}


	protected abstract String getLine(String word);
	protected abstract String writeHeader();
	protected abstract String writeFooterAndClose();

	protected void close() {
		printStream.close();
	}
		
}
