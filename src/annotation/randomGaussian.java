package annotation;

import java.util.Random;

//���ɷ��ϸ�˹�ֲ������Ŷ�
public class randomGaussian {

	public static String Gaussian() {
		Random random = new Random();
		double result, x;
		String Gaussian;
		// result = (Math.sqrt(b) * random.nextGaussian() + a);
		// while (result < 0.8 || result >= 1.0)
		// result = Math.sqrt(b) * random.nextGaussian() + a;
		// x = randomGaussian.randomDataGenerater(-0.1, 0.1);
		// result = ((1 / (Math.sqrt(2 * Math.PI))) * Math.exp(Math.pow(x, 2) *
		// (-1) / 2)) * 0.2 + 0.8;
		result = random.nextGaussian() / 30.0 + 0.9;
		while (result > 1)
			result = random.nextGaussian() / 30.0 + 0.9;// ��֤���ŶȲ������1����Ȼ����1�ĸ���΢����΢
		Gaussian = String.format("%.3f", result);
		return "\"" + Gaussian + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";
	}

	public static double randomDataGenerater(double min, double max) {
		double temp;
		temp = (double) (Math.random() * (max - min)) + min;
		return temp;
	}
}
