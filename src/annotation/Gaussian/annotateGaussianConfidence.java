package annotation.Gaussian;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import random.randomGaussianConfidence;
import random.randomID;

public class annotateGaussianConfidence {

	// ����Ϊ��IDע�͵��ļ������Ϊ�����Ŷȱ�ע���ļ�
	public void annotate_Confidence(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();// ��ȡ���ID����
			String id = null;// ID��������ʽ
			String confidenceString, confidenceID, confidence;
			int count = 1;// ��������ע����ռ����
			while ((aLine = bfReader.readLine()) != null) {
				if (count % 50 == 1 || count % 50 == 2 || count % 50 == 3 || count % 50 == 4 || count % 50 == 5
						|| count % 50 == 6 || count % 50 == 7 || count % 50 == 8 || count % 50 == 9) {
					id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
					confidenceString = " <http://yago-knowledge.org/resource/confidence> ";
					confidenceID = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
					confidence = "\"" + randomGaussianConfidence.Gaussian() + "\""
							+ "^^<http://www.w3.org/2001/XMLSchema#float> ";
					bufferedWriter.write(id + confidenceString + confidence + confidenceID);
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
