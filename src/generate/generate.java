package generate;

import formatConvert.nQuadsToTriples;

public class generate {

	public static void main(String[] args) {
		// 生成注释ID
		// annotateID annoID = new annotateID();
		// annoID.annotate_ID("dataset.nt", "annotateID.nq");

		// 将四元组转换成三元组
		nQuadsToTriples nToTriples = new nQuadsToTriples();
		nToTriples.nqToNt("annotateGeo.nq", "annotateGeo.nt");

		// 生成时间注释
		// annotateDate aDate = new annotateDate();
		// aDate.annotate_Date("annotateID.nq", "annotateDate.nq");

		// 生成制造商
		// annotateCreator aCreator = new annotateCreator();
		// aCreator.annotate_Creator("annotateID.nq", "annotateCreator.nq");

		// 生成经纬度
		// annotateGeo aGeo = new annotateGeo();
		// aGeo.annotate_Creator("annotateID.nq", "annotateGeo.nq");

	}
}
