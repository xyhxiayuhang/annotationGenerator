package annotation.Yago;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import random.randomID;
import random.randomLatAndLonFromYago;

public class annotateGeoFromYago {

	// 输入为带ID注释的文件，输出为带地理标注的文件，地理信息为从YAGO中抽取的
	public void annotate_Creator(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile.getAbsolutePath()));
			String aLine = null;// 从输入文件中读取一行存入aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();
			HashMap<Integer, String> latMap = new HashMap<Integer, String>();
			HashMap<Integer, String> lonMap = new HashMap<Integer, String>();
			latMap = randomLatAndLonFromYago
					.latAndLonFromYago("E:/workspace/ExtractInformationFromYago/geoLatInput.txt");
			lonMap = randomLatAndLonFromYago
					.latAndLonFromYago("E:/workspace/ExtractInformationFromYago/geoLonInput.txt");
			String LON, LAT, latString, lonString, lon, lat, temp;
			String id, latID, lonID;// 获得的ID的完整形式和描述三元组的ID
			Random random = new Random();
			int i;// 随机整数，用来取经纬度
			int count = 1;// 控制地理注释的比例
			while ((aLine = bfReader.readLine()) != null) {
				if (count % 25 == 1 || count % 25 == 2) {
					id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
					i = random.nextInt(latMap.size());
					lat = latMap.get(i);
					lon = lonMap.get(i);
					LON = "\"" + lon + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";// 获得随机经度
					LAT = "\"" + lat + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";// 获得随机维度
					latString = " <http://www.w3.org/2003/01/geo/wgs84_pos#lat> ";// 纬度
					lonString = " <http://www.w3.org/2003/01/geo/wgs84_pos#long> ";// 经度
					latID = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
					lonID = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
					bufferedWriter.write(id + lonString + LON + lonID);
					bufferedWriter.write(id + latString + LAT + latID);
					count++;
				} else {
					continue;
				}
			}
			bfReader.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
