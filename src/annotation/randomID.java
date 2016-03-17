package annotation;

//生成随机ID
public class randomID {

	// 生成随机数
	public static long randomDataGenerater(long min, long max) {
		long temp;
		temp = (long) (Math.random() * (max - min)) + min;
		return temp;
	}

	// 生成形如id_92662_53478_5221的随机ID
	public String random_ID() {
		return "id_" + randomDataGenerater(10000, 99999) + "_" + randomDataGenerater(10000, 99999) + "_"
				+ randomDataGenerater(1000, 9999);
	}
}
