package annotation;

//�������ID
public class randomID {

	// ���������
	public static long randomDataGenerater(long min, long max) {
		long temp;
		temp = (long) (Math.random() * (max - min)) + min;
		return temp;
	}

	// ��������id_92662_53478_5221�����ID
	public String random_ID() {
		return "id_" + randomDataGenerater(10000, 99999) + "_" + randomDataGenerater(10000, 99999) + "_"
				+ randomDataGenerater(1000, 9999);
	}
}
