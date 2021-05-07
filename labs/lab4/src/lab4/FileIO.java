package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {

	public static ArrayList<String> readFile(String inputFileName) {

		ArrayList<String> expr = new ArrayList<>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFileName));
			String line = reader.readLine();
			while (line != null) {
				if (line.equals("")) {
				} else {
					expr.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		return expr;
	}

}
