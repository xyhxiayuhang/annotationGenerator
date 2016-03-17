package annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class annotateGeo {

	// ����Ϊ��IDע�͵��ļ������Ϊ�������ע���ļ�
	public void annotate_Creator(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
			FileWriter fileWriter = new FileWriter(outputfile.getName(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();
			randomName rName = new randomName();
			String LON, LAT, latString, lonString;
			DecimalFormat df = new DecimalFormat("######0.0000");
			String id, idMeta, latID, lonID;// ��õ�ID��������ʽ��������Ԫ���ID
			randomLatitudeAndLongitude rLongitude = new randomLatitudeAndLongitude();
			while ((aLine = bfReader.readLine()) != null) {
				id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
				LON = "\"" + rLongitude.randomLongitude() + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";// ����������
				LAT = "\"" + rLongitude.randomLatitude() + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";// ������ά��
				latString = " <http://www.w3.org/2003/01/geo/wgs84_pos#lat> ";// γ��
				lonString = " <http://www.w3.org/2003/01/geo/wgs84_pos#long> ";// ����
				latID = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				lonID = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				bufferedWriter.write(id + lonString + LON + lonID);
				bufferedWriter.write(id + latString + LAT + latID);
			}
			bfReader.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
