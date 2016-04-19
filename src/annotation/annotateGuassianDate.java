package annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import random.randomGaussianDate;
import random.randomID;

public class annotateGuassianDate {

	// ����Ϊ��IDע�͵��ļ������Ϊ���Ӹ�˹�ֲ��Ĵ�����ע�͵��ļ�
	public void annotate_Date(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// �������ļ��ж�ȡһ�д���aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			Date dateStart = null, dateEnd = null;
			randomID rId = new randomID();
			String dateStartToString, dateEndToString;// ������ת��Ϊ�ַ�����ʽ
			String id = null, idMeta = null, occurs, interval, commonID;// ��õ�ID��������ʽ��������Ԫ���ID
			String start, startPoint, end, endPoint, time, startTime, endTime;
			while ((aLine = bfReader.readLine()) != null) {
				id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
				commonID = id.substring(id.lastIndexOf("/") + 1, id.lastIndexOf(">"));// ���湲ͬʹ�õ���ID
				occurs = " <http://yago-knowledge.org/resource/occurs> ";
				interval = "<http://yago-knowledge.org/resource/" + commonID + "interval> ";
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				bufferedWriter.write(id + occurs + interval + idMeta);// д��id
																		// occurs
																		// interval
																		// id2
				startPoint = "<http://franz.com/ns/allegrograph/3.0/temporal/startpoint> ";
				endPoint = "<http://franz.com/ns/allegrograph/3.0/temporal/endpoint> ";
				start = "<http://yago-knowledge.org/resource/" + commonID + "Start> ";
				end = "<http://yago-knowledge.org/resource/" + commonID + "End> ";

				dateStart = randomGaussianDate.RandomGaussianDate(1000, 100000000);
				dateStartToString = String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", dateStart);// ������תΪ�ַ�����ʽ��ȡ�̸�ʽ����ʼʱ��

				dateEnd = randomGaussianDate.RandomGaussianDate(100000000, 1000000000);
				dateEndToString = String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", dateEnd);// ����ʱ��

				// �õ��淶��datetime��ʽ
				startTime = "\"" + dateStartToString + "\"" + "^^<http://www.w3.org/2001/XMLSchema#dateTime>";
				endTime = "\"" + dateEndToString + "\"" + "^^<http://www.w3.org/2001/XMLSchema#dateTime>";
				time = " <http://franz.com/ns/allegrograph/3.0/temporal/time> ";
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				bufferedWriter.write(interval + startPoint + start + idMeta);
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				bufferedWriter.write(start + time + startTime + " " + idMeta);
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				bufferedWriter.write(interval + endPoint + end + idMeta);
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				bufferedWriter.write(end + time + endTime + " " + idMeta);
			}
			bfReader.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
