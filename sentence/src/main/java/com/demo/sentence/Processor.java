package com.demo.sentence;

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
		
	     
		/*
		 * Scanner s = new Scanner(System.in).useDelimiter("\\s*[\\.!\\?]\\s*");
		 * while(s.hasNext()) { String line = s.next(); System.out.println("\"" + line +
		 * "\""); Scanner innerScanner = new Scanner(line);
		 * 
		 * List<String> words = new ArrayList<>();
		 * innerScanner.tokens().forEach(words::add); innerScanner.close();
		 * 
		 * Collections.sort(words);
		 * 
		 * Sentence sentence = new Sentence(words);
		 * 
		 * words.forEach(w -> System.out.println("<word>" + w + "</word>")); }
		 * s.close();
		 */

	}

	private void process() {
		SentenceScanner sentenceScanner = new SentenceScanner(System.in);
		XMLSentenceWriter sentenceWriter = new XMLSentenceWriter(System.out);
		
		while(sentenceScanner.hasMoreElements()) {
			sentenceWriter.writeSentence(sentenceScanner.nextElement());
		}
		
		sentenceWriter.writeFooterAndClose();
	}

}
