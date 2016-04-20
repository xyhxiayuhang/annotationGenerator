package annotation.Gaussian;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import random.randomGaussianLatAndLon;
import random.randomID;

public class annotateGaussianGeo {

	// ����Ϊ��IDע�͵��ļ������Ϊ�������ע���ļ���������Ϣ���Ӹ�˹�ֲ�
	public void annotate_GaussianGeo(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile.getAbsolutePath()));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();
			HashMap<String, String> geoMap = new HashMap<String, String>();
			HashMap<Integer, String> latMap = new HashMap<Integer, String>();
			HashMap<Integer, String> lonMap = new HashMap<Integer, String>();
			int geocount = 1;
			geoMap = randomGaussianLatAndLon.gaussianLatAndLon("data/gaussianGeo.txt");
			while (!geoMap.isEmpty()) {
				Set<Entry<String, String>> setEntry = geoMap.entrySet();
				for (Entry<String, String> entry : setEntry) {
					latMap.put(geocount, entry.getKey());
					lonMap.put(geocount, entry.getValue());
					geocount++;
				}
			}
			String LON, LAT, latString, lonString, lon, lat;
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
					latID = "<http://yago-knowledge.org/resource/" + rId.random_ID() + "> .\n";
					lonID = "<http://yago-knowledge.org/resource/" + rId.random_ID() + "> .\n";
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
