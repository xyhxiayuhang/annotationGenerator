package generate;

import java.util.Date;

import formatConvert.nQuadsToTriples;

public class generate {

	public static void main(String[] args) {
		// ����ע��ID
		// annotateID annoID = new annotateID();
		// annoID.annotate_ID("dataset.nt", "D:/data/annotateID.nq");

		// ����ʱ��ע��
		// annotateDate aDate = new annotateDate();
		// aDate.annotate_Date("D:/data/annotateID.nq",
		// "D:/data/annotateDate.nq");

		// ����������
		// annotateCreator aCreator = new annotateCreator();
		// aCreator.annotate_Creator("D:/data/annotateID.nq",
		// "D:/data/annotateCreator.nq");

		// ���ɾ�γ��
		// annotateGeo aGeo = new annotateGeo();
		// aGeo.annotate_Creator("D:/data/annotateID.nq",
		// "D:/data/annotateGeo.nq");

		// ������Դ��Ϣ
		// annotateOrigin aOrigin = new annotateOrigin();
		// aOrigin.annotate_Origin("D:/data/annotateID.nq",
		// "D:/data/annotateOrigin.nq");

		// �������Ŷ�
		// annotateConfidence aConfidence = new annotateConfidence();
		// aConfidence.annotate_Confidence("D:/data/annotateID.nq",
		// "D:/data/annotateConfidence.nq");

		// ����Ԫ��ת������Ԫ��
		// nQuadsToTriples nToTriples = new nQuadsToTriples();
		// nToTriples.nqToNt("annotateConfidence.nq", "annotateConfidence.nt");
		System.out.println(new Date());
		nQuadsToTriples.nqToNt("D:/annotateQuad.nq", "D:/annotateTriples.nt");
		System.out.println(new Date());
	}
}
