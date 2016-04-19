package generate;

import annotation.annotateConfidence;
import annotation.annotateGaussianConfidence;

public class generate {

	public static void main(String[] args) {
		// 生成注释ID
		// annotateID annoID = new annotateID();
		// annoID.annotate_ID("dataset.nt", "D:/data/annotateID.nq");

		// 生成符合随机分布的时间注释
		// annotateDate aDate = new annotateDate();
		// aDate.annotate_Date("D:/data/annotateID.nq",
		// "D:/data/annotateDate.nq");

		// 生成制造商
		// annotateCreator aCreator = new annotateCreator();
		// aCreator.annotate_Creator("D:/data/annotateID.nq",
		// "D:/data/annotateCreator.nq");

		// 生成经纬度
		// annotateGeo aGeo = new annotateGeo();
		// aGeo.annotate_Creator("D:/data/annotateID.nq",
		// "D:/data/annotateGeo.nq");

		// 生成来源信息
		// annotateOrigin aOrigin = new annotateOrigin();
		// aOrigin.annotate_Origin("D:/data/annotateID.nq",
		// "D:/data/annotateOrigin.nq");

		// 生成符合随机分布的置信度
		annotateConfidence aConfidence = new annotateConfidence();
		aConfidence.annotate_Confidence("data/annotateID.nq", "data/annotateConfidence.nq");

		// 生成符合高斯分布的置信度
		annotateGaussianConfidence aGConfidence = new annotateGaussianConfidence();
		aGConfidence.annotate_Confidence("data/annotateID.nq", "data/annotateGaussianConfidence.nq");

		// 将四元组转换成三元组
		// nQuadsToTriples nToTriples = new nQuadsToTriples();
		// nToTriples.nqToNt("annotateConfidence.nq", "annotateConfidence.nt");

		// 生成符合高斯分布的时间注释
		// annotateGuassianDate aDate = new annotateGuassianDate();
		// aDate.annotate_Date("data/annotateID.nq",
		// "data/annotateGaussianDate.nq");

		// System.out.println(new Date());
		// nQuadsToTriples.nqToNt("D:/annotateQuad.nq",
		// "D:/annotateTriples.nt");
		// System.out.println(new Date());
	}
}
