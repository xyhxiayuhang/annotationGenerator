package generate;

import java.util.Date;

import annotation.Gaussian.annotateGaussianConfidence;
import annotation.Gaussian.annotateGaussianGeo;
import annotation.Gaussian.annotateGuassianDate;
import annotation.Random.annotateConfidence;
import annotation.Random.annotateCreator;
import annotation.Random.annotateDate;
import annotation.Random.annotateGeo;
import annotation.Random.annotateID;
import annotation.Random.annotateOrigin;
import formatConvert.nQuadsToTriples;
import merge.mergeQuads;

public class generate {

	public static void main(String[] args) {
		System.out.println(new Date());
		String inputFile = "/home/hadoop/xyh/workspace/annotationGenerator/Data1m/annotateID.nq";
		String outputFile = "/home/hadoop/xyh/workspace/annotationGenerator/Data1m/annotateQuads.nq";
		String path = "/home/hadoop/xyh/workspace/annotationGenerator/Data1m/";
		// ����ע��ID
		annotateID annoID = new annotateID();
		annoID.annotate_ID(path + "dataset_1m.nt", inputFile);
		System.out.println(new Date());

		// �������ʱ��ע��
		annotateDate aDate = new annotateDate();
		aDate.annotate_Date(inputFile, outputFile);
		System.out.println(new Date());

		// ���ɷ��ϸ�˹�ֲ���ʱ��ע��
		annotateGuassianDate aGuassianDate = new annotateGuassianDate();
		aGuassianDate.annotate_Date(inputFile, outputFile);
		System.out.println(new Date());

		// ����������
		annotateCreator aCreator = new annotateCreator();
		aCreator.annotate_Creator("data/annotateID.nq", "data/annotateCreator.nq");
		System.out.println(new Date());

		// ���ɾ�γ�ȷ�������ֲ�
		annotateGeo aGeo = new annotateGeo();
		aGeo.annotate_Geo(inputFile, outputFile);
		System.out.println(new Date());

		// ���ɷ��ϸ�˹�ֲ��ĵ���ע��
		annotateGaussianGeo aGaussianGeo = new annotateGaussianGeo();
		aGaussianGeo.annotate_GaussianGeo(inputFile, outputFile);

		// ������Դ��Ϣ
		annotateOrigin aOrigin = new annotateOrigin();
		aOrigin.annotate_Origin(inputFile, outputFile);
		System.out.println(new Date());

		// ����������Ŷ�
		annotateConfidence aConfidence = new annotateConfidence();
		aConfidence.annotate_Confidence(inputFile, outputFile);
		System.out.println(new Date());

		// ���ɷ��ϸ�˹�ֲ������Ŷ�
		annotateGaussianConfidence aGaussianConfidence = new annotateGaussianConfidence();
		aGaussianConfidence.annotate_Confidence(inputFile, outputFile);
		System.out.println(new Date());

		// merge
		mergeQuads.merge(inputFile, outputFile);
		System.out.println(new Date());

		// create triples
		System.out.println(new Date());
		nQuadsToTriples.nqToNt("data/annotateCreator.nq", "data/annotateCreator.nt");
		System.out.println(new Date());

		// annotateGeoFromYago aYago = new annotateGeoFromYago();
		// aYago.annotate_Creator("data/annotateID.nq",
		// "data/annotateGeoFromYago.nq");
		// System.out.println(new Date());
	}
}
