package languageProcessing.messageRecognition.training;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import languageProcessing.messageRecognition.enums.MessageCategoryStatusEnum;
import languageProcessing.messageRecognition.enums.MessageErrorCategoriesEnum;
import languageProcessing.messageRecognition.search.MessageValue;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class MessageTrainer {

	private String generateLine(String message, int messageCode) {
		String line = "";
		line = line + messageCode;
		line = line + "	";
		line = line + message;
		return line;
	}

	public void updateFile(String line, String file) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			out.println(line);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void learnStatusCategory(String message, MessageErrorCategoriesEnum statusCategoryEnum) {
		String line = generateLine(message, statusCategoryEnum.getCategoryCode());
		updateFile(line, "statusMessage.txt");
	}

	private void learnErrorCategory(String message, MessageCategoryStatusEnum errorCategoryEnum) {
		String line = generateLine(message, errorCategoryEnum.getCategoryCode());
		updateFile(line, "errorMessage.txt");
	}

	public static void main(String[] args) {
		MessageTrainer messageTrainer = new MessageTrainer();
		messageTrainer.testMessageTrainer();
	}
	
	public void testMessageTrainer() {
		try {
			List<MessageValue> listMessageValue = new ArrayList<MessageValue>();
			listMessageValue.add(new MessageValue("usuário não cadastrado", MessageCategoryStatusEnum.ERROR, MessageErrorCategoriesEnum.EMPTY_FIELD));
			listMessageValue.add(new MessageValue("usuário cadastrado com sucesso", MessageCategoryStatusEnum.SUCCESS));
	
			generateModel(listMessageValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void convertListToErrorModel(List<MessageValue> listMessageValue) {
		for (MessageValue messageValue : listMessageValue) {
			try {
				learnErrorCategory(messageValue.getMessage(), messageValue.getMessageStatus());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void convertListToCategoryModel(List<MessageValue> listMessageValue) {
		for (MessageValue messageValue : listMessageValue) {
			try {
				learnStatusCategory(messageValue.getMessage(), messageValue.getMessageErrorCategory());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void cleanFile() {
		try {
			new PrintWriter("test.txt").close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createCategoryModel(List<MessageValue> listMessageValue) {
		try {
			cleanFile();
			for (MessageValue messageValue : listMessageValue) {
				learnStatusCategory(messageValue.getMessage(), messageValue.getMessageErrorCategory());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createErrorModel(List<MessageValue> listMessageValue) {
		try {
			cleanFile();
			for (MessageValue messageValue : listMessageValue) {
				learnStatusCategory(messageValue.getMessage(), messageValue.getMessageErrorCategory());
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

	public DoccatModel generateModel(List<MessageValue> messageValues) {
		cleanFile();
		convertListToErrorModel(messageValues);
		convertListToCategoryModel(messageValues);
		return getModelFromFile();
	}
}