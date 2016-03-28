package generate;

import java.util.Date;

import formatConvert.nQuadsToTriples;

public class generate {

	public static void main(String[] args) {
		// 生成注释ID
		// annotateID annoID = new annotateID();
		// annoID.annotate_ID("dataset.nt", "D:/data/annotateID.nq");

		// 生成时间注释
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

		// 生成置信度
		// annotateConfidence aConfidence = new annotateConfidence();
		// aConfidence.annotate_Confidence("D:/data/annotateID.nq",
		// "D:/data/annotateConfidence.nq");

		// 将四元组转换成三元组
		// nQuadsToTriples nToTriples = new nQuadsToTriples();
		// nToTriples.nqToNt("annotateConfidence.nq", "annotateConfidence.nt");
		System.out.println(new Date());
		nQuadsToTriples.nqToNt("D:/annotateQuad.nq", "D:/annotateTriples.nt");
		System.out.println(new Date());
	}
}
