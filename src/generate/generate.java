package generate;

import java.util.Date;

import annotation.annotateCreator;
import annotation.annotateGaussianConfidence;
import annotation.annotateGeo;
import annotation.annotateGuassianDate;
import annotation.annotateID;
import annotation.annotateOrigin;
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
		// annotateDate aDate = new annotateDate();
		// aDate.annotate_Date(inputFile, outputFile);
		// System.out.println(new Date());
		// ���ɷ��ϸ�˹�ֲ���ʱ��ע��
		annotateGuassianDate aGuassianDate = new annotateGuassianDate();
		aGuassianDate.annotate_Date(inputFile, outputFile);
		System.out.println(new Date());
		// ����������
		annotateCreator aCreator = new annotateCreator();
		aCreator.annotate_Creator(inputFile, outputFile);
		System.out.println(new Date());
		// ���ɾ�γ��
		annotateGeo aGeo = new annotateGeo();
		aGeo.annotate_Creator(inputFile, outputFile);
		System.out.println(new Date());
		// ������Դ��Ϣ
		annotateOrigin aOrigin = new annotateOrigin();
		aOrigin.annotate_Origin(inputFile, outputFile);
		System.out.println(new Date());
		// ����������Ŷ�
		// annotateConfidence aConfidence = new annotateConfidence();
		// aConfidence.annotate_Confidence(inputFile, outputFile);
		// System.out.println(new Date());
		// ���ɷ��ϸ�˹�ֲ������Ŷ�
		annotateGaussianConfidence aGaussianConfidence = new annotateGaussianConfidence();
		aGaussianConfidence.annotate_Confidence(inputFile, outputFile);
		System.out.println(new Date());
		// merge
		mergeQuads.merge(inputFile, outputFile);
		System.out.println(new Date());

		// create triples
		System.out.println(new Date());
		nQuadsToTriples.nqToNt(outputFile, path + "annotateTriples.nt");
		System.out.println(new Date());
		// // ����Ԫ��ת������Ԫ��
		// nQuadsToTriples nToTriples = new nQuadsToTriples();

		// nToTriples.nqToNt(outputFilePath+"annotateID.nq",
		// outputFilePath+"annotateID.nt");
		// System.out.println(new Date());
		//
		// nToTriples.nqToNt(outputFilePath+"annotateDate.nq",
		// outputFilePath+"annotateDate.nt");
		// System.out.println(new Date());
		//
		// nToTriples.nqToNt(outputFilePath+"annotateCreator.nq",
		// outputFilePath+"annotateCreator.nt");
		// System.out.println(new Date());
		//
		// nToTriples.nqToNt(outputFilePath+"annotateGeo.nq",
		// outputFilePath+"annotateGeo.nt");
		// System.out.println(new Date());
		//
		// nToTriples.nqToNt(outputFilePath+"annotateOrigin.nq",
		// outputFilePath+"annotateOrigin.nt");
		// System.out.println(new Date());
		//
		// nToTriples.nqToNt(outputFilePath+"annotateConfidence.nq",
		// outputFilePath+"annotateConfidence.nt");
		// System.out.println(new Date());

	}
}
