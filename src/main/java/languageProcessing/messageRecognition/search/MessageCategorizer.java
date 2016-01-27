package languageProcessing.messageRecognition.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class MessageCategorizer {
	DoccatModel model;

	//
	public void trainModel() {
		InputStream dataIn = null;
		try {
			dataIn = new FileInputStream("messageTraining.txt");
			ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
			ObjectStream sampleStream = new DocumentSampleStream(lineStream);
			int cutoff = 3;
			int trainingIterations = 100;
			model = DocumentCategorizerME.train("pt", sampleStream);
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
	
	public MessageCategoryEnum categorizeMessage(String message) {
		trainModel();
		DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);
		double[] outcomes = myCategorizer.categorize(message);
		String category = myCategorizer.getBestCategory(outcomes);
		
		if (category.equalsIgnoreCase("1")) {
			return MessageCategoryEnum.SUCCESS;
		} else {
			return MessageCategoryEnum.ERROR;
		}
	}
}