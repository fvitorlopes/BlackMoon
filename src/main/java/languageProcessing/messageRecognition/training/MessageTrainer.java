package languageProcessing.messageRecognition.training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.safety.Cleaner;

import exceptions.BlackMoonException;
import languageProcessing.messageRecognition.search.MessageCategoryStatusEnum;
import languageProcessing.messageRecognition.search.MessageValue;

public class MessageTrainer {

	public void learnMessage(String message, MessageCategoryStatusEnum messageCategory) throws BlackMoonException {
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

	public ArrayList<String> getLinesFile() {
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
			cleanFile();
			learnMessage("usuário não cadastrado", MessageCategoryStatusEnum.ERROR);
			learnMessage("usuário cadastrado com sucesso", MessageCategoryStatusEnum.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Create new file only for this
	public void convertListToModel(List<MessageValue> listMessageValue) {
		// Clean value

		for (MessageValue messageValue : listMessageValue) {
			try {
				learnMessage(messageValue.getMessage(), messageValue.getMessageStatus());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Generate moedle
	}

	public void cleanFile() {
		try {
			new PrintWriter("test.txt").close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}