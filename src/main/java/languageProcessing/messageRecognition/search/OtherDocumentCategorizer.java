package languageProcessing.messageRecognition.search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class OtherDocumentCategorizer {
	DoccatModel model;

	public static void main(String[] args) {
		OtherDocumentCategorizer twitterCategorizer  = new OtherDocumentCategorizer();
		// twitterCategorizer.trainModel();
		twitterCategorizer.classifyNewTweet("Erro ao cadastrar recurso");
	}
	
	public void trainModel() {
		InputStream dataIn = null;
		try {
			dataIn = new FileInputStream("MessageTrain.txt");
			ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
			ObjectStream sampleStream = new DocumentSampleStream(lineStream);
			int cutoff = 2;
			int trainingIterations = 50;
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
	
	public void classifyNewTweet(String tweet) {
		DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);
		double[] outcomes = myCategorizer.categorize(tweet);
		String category = myCategorizer.getBestCategory(outcomes);

		if (category.equalsIgnoreCase("1")) {
			System.out.println("Mensagem de sucesso");
		} else {
			System.out.println("Mensagem de erro");
		}
	}
}