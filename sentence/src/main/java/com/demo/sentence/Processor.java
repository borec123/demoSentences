package com.demo.sentence;

import java.io.IOException;

import com.demo.sentence.in.SentenceScanner;
import com.demo.sentence.out.XMLSentenceWriter;

public class Processor {

	public static void main(String[] args) {
		
		//TODO Process command line arguments (XML or CSV ...) .
		
		try {
			new Processor().process();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	private void process() throws IOException {
		SentenceScanner sentenceScanner = new SentenceScanner(System.in);
		XMLSentenceWriter sentenceWriter = new XMLSentenceWriter(System.out);
		
		sentenceWriter.writeHeader();
		
		while(sentenceScanner.hasMoreElements()) {
			sentenceWriter.writeSentence(sentenceScanner.nextElement());
		}
		
		sentenceWriter.writeFooterAndClose();
	}

}
