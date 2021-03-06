package com.demo.sentence.out;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.demo.sentence.model.Sentence;


/**
 * Writes Sentences to output stream.
 */
public class XMLSentenceWriter implements SentenceWriterInterface {

	BufferedWriter writer;
	
	public XMLSentenceWriter(OutputStream os) {
		writer = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	public void writeSentence(Sentence sentence) throws IOException {
		
		writer.write("\t<sentence>\n");
		sentence.getWords().forEach(w -> {
			try {
				writer.write("\t\t<word>" + w + "</word>\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		writer.write("\t</sentence>\n");
	}



	@Override
	public void writeHeader() throws IOException {
		writer.write("<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>\n");
		writer.write("<text>\n");

	}


	@Override
	public void writeFooterAndClose() throws IOException {
		writer.write("</text>\n");
		writer.close();

	}

}
