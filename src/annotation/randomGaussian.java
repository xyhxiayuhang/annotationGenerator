package annotation;

import java.util.Random;

//生成符合高斯分布的置信度
public class randomGaussian {

	public static String Gaussian(Double a, Double b) {
		Random random = new Random();
		double result;
		String Gaussian;
		result = Math.sqrt(b) * random.nextGaussian() + a;
		while (result < 0.8 || result >= 1.0)
			result = Math.sqrt(b) * random.nextGaussian() + a;
		Gaussian = String.format("%.3f", result);
		return "\"" + Gaussian + "\"" + "^^<http://www.w3.org/2001/XMLSchema#float> ";

	}
}
