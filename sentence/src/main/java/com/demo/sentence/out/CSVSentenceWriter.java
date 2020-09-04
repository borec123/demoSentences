package com.demo.sentence.out;

import java.io.OutputStream;

public class CSVSentenceWriter extends AbstractSentenceWriter {



	public CSVSentenceWriter(OutputStream os) {
		super(os);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getLine(String word) {
		throw new RuntimeException("To be implemented...");
	}

	@Override
	protected String writeHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String writeFooterAndClose() {
		// TODO Auto-generated method stub
		return null;
	}

}
