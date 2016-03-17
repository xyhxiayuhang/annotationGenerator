package annotation;

import java.text.DecimalFormat;

public class randomLatitudeAndLongitude {

	// �������������
	public double randomFloatDataGenerater(double min, double max) {
		double temp;
		temp = (double) (Math.random() * (max - min)) + min;
		return temp;
	}

	// �����������
	public String randomLongitude() {
		double lon;
		String LON;
		DecimalFormat df = new DecimalFormat("######0.0000");
		lon = this.randomFloatDataGenerater(-180.0, 180.0);
		LON = df.format(lon);
		return LON;
	}

	// �������γ��
	public String randomLatitude() {
		double lat;
		String LAT;
		DecimalFormat df = new DecimalFormat("######0.0000");
		lat = this.randomFloatDataGenerater(-180.0, 180.0);
		LAT = df.format(lat);
		return LAT;
	}
}