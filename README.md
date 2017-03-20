# annotationGenerator
对三元组生成注释信息
1、本系统使用的原始三元组是使用BSBM工具生成的，具体生成方式可参考
http://wifo5-03.informatik.uni-mannheim.de/bizer/berlinsparqlbenchmark/spec/BenchmarkRules/index.html#datagenerator
2、本系统共对三元组添加了时间注释、地理注释、生产者注释、置信度注释。
3、本系统共生成了随机分布、高斯分布、以及服从YAGO中真实数据分布的数据。
4、在src目录下，random为随机、高斯、YAGO等各种数据生成函数；annotation为加各种注释，formatConvert为将四元组转换为三元组；generate.java为生成
注释信息主方法，inputFile为加了注释ID之后的文件路径，outputFile自己定义，path也是自己定义，原始三元组文件放在path目录下，如示例中的dataset_1m.nt；
根目录中的数据为以dataset_1m.nt为基础生成的各种注释文件。
5、流程：<s,p,o> -> <s,p,o,id> -> <id, hasS, s>, <id, hasP,p>,<id, hasO,o>
如有不妥，欢迎交流！
