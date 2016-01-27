package languageProcessing.messageRecognition.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import languageProcessing.messageRecognition.enums.MessageCategoryStatusEnum;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class MessageCategorizer {
	DoccatModel model;
	
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

	public MessageCategoryStatusEnum categorizeMessage(String message) {
		trainModel();
		DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);
		double[] outcomes = myCategorizer.categorize(message);
		String category = myCategorizer.getBestCategory(outcomes);

		if (category.equalsIgnoreCase("1")) {
			return MessageCategoryStatusEnum.SUCCESS;
		} else {
			return MessageCategoryStatusEnum.ERROR;
		}
	}

	private void cleanFile() {
		try {
			new PrintWriter("test.txt").close();
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {

			MessageCategorizer messageCategorizer = new MessageCategorizer();
			messageCategorizer.cleanFile();
			System.out.println("foi");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}