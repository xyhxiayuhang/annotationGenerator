package annotation.Random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import random.randomID;
import random.randomName;

public class annotateCreator {

	// 输入为带ID注释的文件，输出为带生产者标注的文件
	public void annotate_Creator(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// 从输入文件中读取一行存入aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();
			randomName rName = new randomName();
			String name, creator;
			String id = null, idMeta = null;// 获得的ID的完整形式和描述三元组的ID
			int count = 1;// 用来控制注释的比例
			while ((aLine = bfReader.readLine()) != null) {
				if (count % 50 == 1 || count % 50 == 2 || count % 50 == 3 || count % 50 == 4 || count % 50 == 5
						|| count % 50 == 6 || count % 50 == 7 || count % 50 == 8 || count % 50 == 9) {
					name = rName.getRandomEnglishName();
					id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
					creator = " <http://yago-knowledge.org/resource/creator> ";
					idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + "> .\n";// 组合成随机ID
					bufferedWriter.write(id + creator + "\"" + name + "\" " + idMeta);
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
