package formatConvert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//����Ԫ��ת���ɺ���hasS��hasP��hasO����Ԫ����ʽ
public class nQuadsToTriples {

	public static void nqToNt(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);// ��þ���·��
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String spo, s, p, o, g, po, hasS, hasP, hasO;
			while ((aLine = bfReader.readLine()) != null) {
				g = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);// ȡ��g
				spo = aLine.substring(0, aLine.lastIndexOf("<") - 1);// ȡ��spo
				s = spo.substring(0, spo.indexOf(">") + 1);// ���s
				po = spo.substring(spo.indexOf(">") + 2, spo.length());
				p = po.substring(0, po.indexOf(">") + 1);// �õ�p
				o = po.substring(po.indexOf(">") + 2, po.length());// �õ�o

				// ��ϳ�hasS��hasP��hasO�ĸ�ʽ
				hasS = g + " <http://yago-knowledge.org/resource/hasS> " + s + ".\n";
				hasP = g + " <http://yago-knowledge.org/resource/hasP> " + p + ".\n";
				hasO = g + " <http://yago-knowledge.org/resource/hasO> " + o + ".\n";

				bufferedWriter.write(hasS + hasP + hasO);
			}
			bfReader.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
