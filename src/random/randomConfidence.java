package random;

public class randomConfidence {

	// ���ɷ�������ֲ������Ŷ�
	public static String Confidence() {
		double result;
		String confidence;

		result = randomConfidence.randomDataGenerater(0.8, 1.0);
		confidence = String.format("%.3f", result);
		return confidence;
	}

	public static double randomDataGenerater(double min, double max) {
		double temp;
		temp = (double) (Math.random() * (max - min)) + min;
		return temp;
	}
}
