package generate;

import annotation.annotateConfidence;
import formatConvert.nQuadsToTriples;

public class generate {

	public static void main(String[] args) {
		// ����ע��ID
		// annotateID annoID = new annotateID();
		// annoID.annotate_ID("dataset.nt", "annotateID.nq");

		// ����ʱ��ע��
		// annotateDate aDate = new annotateDate();
		// aDate.annotate_Date("annotateID.nq", "annotateDate.nq");

		// ����������
		// annotateCreator aCreator = new annotateCreator();
		// aCreator.annotate_Creator("annotateID.nq", "annotateCreator.nq");

		// ���ɾ�γ��
		// annotateGeo aGeo = new annotateGeo();
		// aGeo.annotate_Creator("annotateID.nq", "annotateGeo.nq");

		// ������Դ��Ϣ
		// annotateOrigin aOrigin = new annotateOrigin();
		// aOrigin.annotate_Origin("annotateID.nq", "annotateOrigin.nq");

		// �������Ŷ�
		annotateConfidence aConfidence = new annotateConfidence();
		aConfidence.annotate_Confidence("annotateID.nq", "annotateConfidence.nq");

		// ����Ԫ��ת������Ԫ��
		nQuadsToTriples nToTriples = new nQuadsToTriples();
		nToTriples.nqToNt("annotateConfidence.nq", "annotateConfidence.nt");

	}
}
