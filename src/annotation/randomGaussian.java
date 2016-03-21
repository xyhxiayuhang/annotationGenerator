package annotation;

import java.util.Random;

//生成符合高斯分布的置信度
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
			result = random.nextGaussian() / 30.0 + 0.9;// 保证置信度不会大于1，虽然大于1的概率微乎其微
		Gaussian = String.format("%.3f", result);
		return "\"" + Gaussian + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";
	}

	public static double randomDataGenerater(double min, double max) {
		double temp;
		temp = (double) (Math.random() * (max - min)) + min;
		return temp;
	}
}
