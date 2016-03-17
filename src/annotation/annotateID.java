package annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class annotateID {

	public void annotate_ID(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
			FileWriter fileWriter = new FileWriter(outputfile.getName(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();// ��ȡ���ID����
			String id = null;// ID��������ʽ
			while ((aLine = bfReader.readLine()) != null) {
				id = "<http://yago-knowledge.org/resource/" + rId.random_ID();
				aLine = aLine.substring(0, aLine.length() - 1);// ɾ��ÿ��ĩβ�ĵ��.
				bufferedWriter.write(aLine + id + ">.\n");
			}
			bfReader.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
