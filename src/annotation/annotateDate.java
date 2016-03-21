package annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class annotateDate {

	// 输入为带ID注释的文件，输出为带日期注释的文件
	public void annotate_Date(String input, String output) {
		File inputfile = new File(input);
		File outputfile = new File(output);
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(inputfile));
			String aLine = null;// 从输入文件中读取一行存入aLine
			FileWriter fileWriter = new FileWriter(outputfile.getAbsolutePath(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			Date dateStart = null, dateEnd = null;
			randomID rId = new randomID();
			String dateStartToString, dateEndToString;// 将日期转换为字符串格式
			// String dateComplete = null;// Date的完整形式
			String id = null, idMeta = null, occurs, interval, commonID;// 获得的ID的完整形式和描述三元组的ID
			String start, startPoint, end, endPoint, time, startTime, endTime;
			while ((aLine = bfReader.readLine()) != null) {
				// date = randomDate.RandomDate("2012-06-01", "2015-12-12");
				// dateToString = String.format("%tF", date);// 将日期转为字符串格式，取短格式
				// dateComplete = "\"" + dateToString + "\"" +
				// "^^<http://www.w3.org/2001/XMLSchema#date> ";
				//
				// id = aLine.substring(aLine.lastIndexOf("<"),
				// aLine.lastIndexOf(">") + 1);
				// idMeta = "<http://yago-knowledge.org/resource/" +
				// rId.random_ID() + ">.\n";// 组合成随机ID
				// occurSince = "
				// <http://yago-knowledge.org/resource/occursSince> ";
				// bufferedWriter.write(id + occurSince + dateComplete +
				// idMeta);

				id = aLine.substring(aLine.lastIndexOf("<"), aLine.lastIndexOf(">") + 1);
				commonID = id.substring(id.lastIndexOf("/") + 1, id.lastIndexOf(">"));// 后面共同使用到的ID
				occurs = " <http://yago-knowledge.org/resource/occurs> ";
				interval = "<http://yago-knowledge.org/resource/" + commonID + "interval> ";
				idMeta = "<http://yago-knowledge.org/resource/" + rId.random_ID() + ">.\n";
				bufferedWriter.write(id + occurs + interval + idMeta);// 写入id
																		// occurs
																		// interval
																		// id2
				startPoint = "<http://franz.com/ns/allegrograph/3.0/temporal/startpoint> ";
				endPoint = "<http://franz.com/ns/allegrograph/3.0/temporal/endpoint> ";
				start = "<http://yago-knowledge.org/resource/" + commonID + "Start> ";
				end = "<http://yago-knowledge.org/resource/" + commonID + "End> ";
				dateStart = randomDate.RandomDate("2012-06-01T00:00:00.235-0700", "2015-12-30T00:00:00.235-0700");// 生成时间格式为2014-06-12T00:12:00
				dateStartToString = String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", dateStart);// 将日期转为字符串格式，取短格式。开始时间
				dateEndToString = dateStartToString + ".235-0700";
				dateEnd = randomDate.RandomDate(dateEndToString, "2015-12-31T00:00:00.235-0700");
				dateEndToString = String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", dateEnd);// 结束时间
				// 得到规范的datetime格式
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
