package languageProcessing.messageRecognition.training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import exceptions.BlackMoonException;
import languageProcessing.messageRecognition.enums.MessageCategoryStatusEnum;
import languageProcessing.messageRecognition.search.MessageValue;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class MessageTrainer {

	private void learnMessage(String message, MessageCategoryStatusEnum messageCategory) throws BlackMoonException {
		try {
			String line = "";
			if (messageCategory.equals(MessageCategoryStatusEnum.ERROR)) {
				line = line + "0";
			} else {
				line = line + "1";
			}
			line = line + "	";
			line = line + message;

			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.txt", true)));
			out.println(line);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<String> getLinesFile() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("message.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			while ((str = in.readLine()) != null) {
				lines.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void main(String[] args) {
		MessageTrainer messageTrainer = new MessageTrainer();
		messageTrainer.testMessageTrainer();
	}

	public void testMessageTrainer() {
		try {

		List<MessageValue> listMessageValue = new ArrayList<MessageValue>();
		listMessageValue.add(new MessageValue("usuário não cadastrado", MessageCategoryStatusEnum.ERROR));
		listMessageValue.add(new MessageValue("usuário cadastrado com sucesso", MessageCategoryStatusEnum.SUCCESS));
		
		generateModel(listMessageValue);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void convertListToModel(List<MessageValue> listMessageValue) {

		for (MessageValue messageValue : listMessageValue) {
			try {
				learnMessage(messageValue.getMessage(), messageValue.getMessageStatus());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Generate moedle
	}
	
	private void cleanFile() {
		try {
			new PrintWriter("test.txt").close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createModel(List<MessageValue> listMessageValue){
		try {
			cleanFile();
			for(MessageValue messageValue : listMessageValue){
				learnMessage(messageValue.getMessage(),messageValue.getMessageStatus());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DoccatModel getModelFromFile() {
		DoccatModel out = null;

		InputStream dataIn = null;
		try {
			dataIn = new FileInputStream("test.txt");
			ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
			ObjectStream sampleStream = new DocumentSampleStream(lineStream);
			int cutoff = 3;
			int trainingIterations = 100;
			out = DocumentCategorizerME.train("pt", sampleStream);
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
		 return out;
	}
	
	public DoccatModel generateModel(List<MessageValue> messageValues){
		cleanFile();
		convertListToModel(messageValues);
		return getModelFromFile();
	}
}