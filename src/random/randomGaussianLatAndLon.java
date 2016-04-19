package random;

import java.text.DecimalFormat;

public class randomGaussianLatAndLon {

	// 生成随机浮点数
	public double randomFloatDataGenerater(double min, double max) {
		double temp;
		temp = (double) (Math.random() * (max - min)) + min;
		return temp;
	}

	// 生成随机经度
	public String randomLongitude() {
		double lon;
		String LON;
		DecimalFormat df = new DecimalFormat("######0.0000");
		lon = this.randomFloatDataGenerater(20.0, 120.0);
		LON = df.format(lon);
		return LON;
	}

	// 生成随机纬度
	public String randomLatitude() {
		double lat;
		String LAT;
		DecimalFormat df = new DecimalFormat("######0.0000");
		lat = this.randomFloatDataGenerater(23.5, 66.3);
		LAT = df.format(lat);
		return LAT;
	}
}
