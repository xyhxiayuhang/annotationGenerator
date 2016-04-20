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

	// ����Ϊ��IDע�͵��ļ������Ϊ�������ע���ļ���������ϢΪ��YAGO�г�ȡ��
	public void annotate_Creator(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile.getAbsolutePath()));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
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
			String id, latID, lonID;// ��õ�ID��������ʽ��������Ԫ���ID
			Random random = new Random();
			int i;// �������������ȡ��γ��
			int count = 1;// ���Ƶ���ע�͵ı���
			while ((aLine = bfReader.readLine()) != null) {
				if (count % 25 == 1 || count % 25 == 2) {
					id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
					i = random.nextInt(latMap.size());
					lat = latMap.get(i);
					lon = lonMap.get(i);
					LON = "\"" + lon + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";// ����������
					LAT = "\"" + lat + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";// ������ά��
					latString = " <http://www.w3.org/2003/01/geo/wgs84_pos#lat> ";// γ��
					lonString = " <http://www.w3.org/2003/01/geo/wgs84_pos#long> ";// ����
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
