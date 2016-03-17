package annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class annotateCreator {

	// ����Ϊ��IDע�͵��ļ������Ϊ�������߱�ע���ļ�
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
			String name, creator;
			String id = null, idMeta = null;// ��õ�ID��������ʽ��������Ԫ���ID
			while ((aLine = bfReader.readLine()) != null) {
				name = rName.getRandomEnglishName();
				id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
				creator = " <http://yago-knowledge.org/resource/creator> ";
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";// ��ϳ����ID
				bufferedWriter.write(id + creator + "\"" + name + "\" " + idMeta);
			}
			bfReader.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
