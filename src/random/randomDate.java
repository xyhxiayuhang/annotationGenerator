package random;

import java.text.SimpleDateFormat;
import java.util.Date;

public class randomDate {

	// 生成随机时间
	public static Date RandomDate(String beginDate, String endDate) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date start = format.parse(beginDate);// 开始日期
			Date end = format.parse(endDate);// 结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end) {
		long rtnn = begin + (long) (Math.random() * (end - begin));
		if (rtnn == begin || rtnn == end) {
			return random(begin, end);
		}
		return rtnn;
	}
}
