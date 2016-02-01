package fileManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {
	
	public ArrayList<String> getLinesFile(String file) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
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

}