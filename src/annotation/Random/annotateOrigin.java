package annotation.Random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import random.randomID;

public class annotateOrigin {

	// ����Ϊ��IDע�͵��ļ������Ϊ����Դ��ע���ļ�
	public void annotate_Origin(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();
			String origin = " <http://yago-knowledge.org/resource/origin> ";
			String id = null, idMeta = null, originExample;// ��õ�ID��������ʽ��������Ԫ���ID
			int count = 1;// ��������ע����ռ����
			while ((aLine = bfReader.readLine()) != null) {
				if (count % 50 == 1 || count % 50 == 2 || count % 50 == 3 || count % 50 == 4 || count % 50 == 5
						|| count % 50 == 6 || count % 50 == 7 || count % 50 == 8 || count % 50 == 9) {
					id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
					originExample = "<http://yago-knowledge.org/origin/example_" + rId.random_ID() + "> ";
					idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";// ��ϳ����ID
					bufferedWriter.write(id + origin + originExample + idMeta);
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
