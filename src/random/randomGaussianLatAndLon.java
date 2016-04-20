package random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class randomGaussianLatAndLon {

	public static HashMap<String, String> gaussianLatAndLon(String inputFile) {
		HashMap<String, String> map = new HashMap<String, String>();
		File file = new File(inputFile);
		try {
			BufferedReader Reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String line;
			while ((line = Reader.readLine()) != null) {
				map.put(line.substring(0, line.indexOf(",")), line.substring(line.indexOf(",") + 2, line.length()));
			}
			Reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
