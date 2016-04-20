package random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class randomLatAndLonFromYago {

	public static HashMap<Integer, String> latAndLonFromYago(String inputFile) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		File file = new File(inputFile);
		try {
			BufferedReader Reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			int Count = 1;
			String line;
			while ((line = Reader.readLine()) != null) {
				map.put(Count, line);
				Count++;
			}
			Reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
