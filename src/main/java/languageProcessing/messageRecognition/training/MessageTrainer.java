package languageProcessing.messageRecognition.training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import exceptions.BlackMoonException;
import languageProcessing.messageRecognition.search.MessageCategoryEnum;

public class MessageTrainer {

	public void learnMessage(String message, MessageCategoryEnum messageCategory) throws BlackMoonException {
		try {
			String line = "";
			if (messageCategory.equals(MessageCategoryEnum.ERROR)) {
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
			in = new BufferedReader(new FileReader("test.txt"));
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
		try {
			messageTrainer.learnMessage("usuário não cadastrado", MessageCategoryEnum.ERROR);
			messageTrainer.learnMessage("usuário cadastrado com sucesso", MessageCategoryEnum.SUCCESS);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		// try {
		// messageTrainer.learnMessage("Usuário não pode ser salvo",
		// MessageCategoryEnum.ERROR);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		System.out.println(messageTrainer.getLinesFile().size());
	}

}