package annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class annotateOrigin {

	// 输入为带ID注释的文件，输出为带来源标注的文件
	public void annotate_Origin(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// 从输入文件中读取一行存入aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			randomID rId = new randomID();
			String origin = " <http://yago-knowledge.org/resource/origin> ";
			String id = null, idMeta = null, originExample;// 获得的ID的完整形式和描述三元组的ID
			while ((aLine = bfReader.readLine()) != null) {
				id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
				originExample = "<http://yago-knowledge.org/origin/example_" + rId.random_ID() + "> ";
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";// 组合成随机ID
				bufferedWriter.write(id + origin + originExample + idMeta);
			}
			bfReader.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
