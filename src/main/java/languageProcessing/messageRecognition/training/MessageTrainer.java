package languageProcessing.messageRecognition.training;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class MessageTrainer {

	public static void main(String[] args) {

		DoccatModel model = null;
		
		InputStream dataIn = null;
		try {
			dataIn = new FileInputStream("messageTraining.txt");
			ObjectStream<String> lineStream = new PlainTextByLineStream(dataIn, "UTF-8");

			ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);
			model = DocumentCategorizerME.train("pt", sampleStream);
			
			OutputStream modelOut = null;
			try {
				modelOut = new BufferedOutputStream(new FileOutputStream("en-sentiment_out.train"));
				model.serialize(modelOut);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (modelOut != null) {
					try {
						modelOut.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dataIn != null) {
				try {
					dataIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
