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
		// 生成注释ID
		annotateID annoID = new annotateID();
		annoID.annotate_ID(path + "dataset_1m.nt", inputFile);
		System.out.println(new Date());

		// 生成随机时间注释
		annotateDate aDate = new annotateDate();
		aDate.annotate_Date(inputFile, outputFile);
		System.out.println(new Date());

		// 生成符合高斯分布的时间注释
		annotateGuassianDate aGuassianDate = new annotateGuassianDate();
		aGuassianDate.annotate_Date(inputFile, outputFile);
		System.out.println(new Date());

		// 生成制造商
		annotateCreator aCreator = new annotateCreator();
		aCreator.annotate_Creator("data/annotateID.nq", "data/annotateCreator.nq");
		System.out.println(new Date());

		// 生成经纬度符合随机分布
		annotateGeo aGeo = new annotateGeo();
		aGeo.annotate_Geo(inputFile, outputFile);
		System.out.println(new Date());

		// 生成符合高斯分布的地理注释
		annotateGaussianGeo aGaussianGeo = new annotateGaussianGeo();
		aGaussianGeo.annotate_GaussianGeo(inputFile, outputFile);

		// 生成来源信息
		annotateOrigin aOrigin = new annotateOrigin();
		aOrigin.annotate_Origin(inputFile, outputFile);
		System.out.println(new Date());

		// 生成随机置信度
		annotateConfidence aConfidence = new annotateConfidence();
		aConfidence.annotate_Confidence(inputFile, outputFile);
		System.out.println(new Date());

		// 生成符合高斯分布的置信度
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
