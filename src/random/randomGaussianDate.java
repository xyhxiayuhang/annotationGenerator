package random;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class randomGaussianDate {

	// 生成服从高斯分布的随机时间
	public static Date RandomGaussianDate(int start, int end) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String strOldDate = "1970-01-01 00:00:00";
			Date oldDate;
			oldDate = sdf.parse(strOldDate);
			Random random = new Random();
			long plus = random(start, end);
			double gaussian = random.nextGaussian();
			while (gaussian <= 0)
				gaussian = random.nextGaussian();
			int daysAdd = (int) (plus * gaussian);
			Date newDate = getDateByAddingSeconds(oldDate, daysAdd);
			return newDate;
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

	public static Date getDateByAddingSeconds(Date oldDate, int daysAdd) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(oldDate);
		cd.add(Calendar.SECOND, daysAdd);
		Date newDate = cd.getTime();
		return newDate;
	}
}
