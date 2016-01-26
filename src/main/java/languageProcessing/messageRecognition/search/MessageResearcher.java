package languageProcessing.messageRecognition.search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageResearcher {
	static String bigString = "";
	static int quantityFiles = 0;

	public void walk(String path) {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				quantityFiles++;
				bigString = bigString + readFile(f.getAbsoluteFile().toString());
			}
		}
	}
	
	public String readFile(String filename) {
		String content = null;
		File file = new File(filename);
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}
	
	public static void main(String[] args) {
		MessageResearcher fw = new MessageResearcher();
		
		fw.walk("C:\\beans\\");
		// setMensagemDeAviso , setMensagemSucesso , setMensagemErro
		Pattern pattern = Pattern.compile("setMensagemDeAviso.*?\\);");
		
		Matcher matcher = pattern.matcher(fw.bigString);
		
		while (matcher.find()) {
			String phrase = matcher.group();

			Pattern internalPattern = Pattern.compile("\".*?\"");
			Matcher internalMatcher = internalPattern.matcher(matcher.group());
			
			while (internalMatcher.find()) {
				String message = internalMatcher.group();
				if (message.trim().isEmpty()) {
				} else if (!message.trim().contains(" ")) {
				} else if (message.length() < 10) {
				} else if (message.contains("+")) {
				} else {
					MessageResearcher messageResearcher = new MessageResearcher();
					System.out.println(internalMatcher.group());
				}
			}
		}
	}
	// 
	public void writefile(String conteudo) {
		try {
			String content = conteudo;
			
			File file = new File("messages.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
 	}
}