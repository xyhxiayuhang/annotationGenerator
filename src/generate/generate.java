package generate;

import formatConvert.nQuadsToTriples;

public class generate {

	public static void main(String[] args) {
		// ����ע��ID
		// annotateID annoID = new annotateID();
		// annoID.annotate_ID("dataset.nt", "annotateID.nq");

		// ����Ԫ��ת������Ԫ��
		nQuadsToTriples nToTriples = new nQuadsToTriples();
		nToTriples.nqToNt("annotateDate.nq", "annotateDate.nt");

		// ����ʱ��ע��
		// annotateDate aDate = new annotateDate();
		// aDate.annotate_Date("annotateID.nq", "annotateDate.nq");

		// ����������
		// annotateCreator aCreator = new annotateCreator();
		// aCreator.annotate_Creator("annotateID.nq", "annotateCreator.nq");
	}
}