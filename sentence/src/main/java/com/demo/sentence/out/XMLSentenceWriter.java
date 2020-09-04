package com.demo.sentence.out;

import java.io.OutputStream;

public class XMLSentenceWriter extends AbstractSentenceWriter {

	public XMLSentenceWriter(OutputStream os) {
		super(os);

	}


	@Override
	protected String getLine(String word) {
		
		return "\t\t<word>" + word + "</word>";
	}


	@Override
	protected String writeHeader() {
		printStream.println("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>");
		printStream.println("<text>");
		return null;
	}


	@Override
	public String writeFooterAndClose() {
		printStream.println("</text>");
		close();
		return null;
	}

}
