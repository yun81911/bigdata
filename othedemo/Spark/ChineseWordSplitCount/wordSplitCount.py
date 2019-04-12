#-*-coding:utf-8-*-

from pyspark import SparkConf, SparkContext

import jieba

def split(line):
    word_list = jieba.cut(line.strip().split("\t")[1])  #�������ķִ�
    ls =[]
    for word in word_list:
        if len(word)>1:      #���˵������ڴ�
            ls.append(word)
    return ls

def combine(line):
    result = ""
    result +=line[0]+"\t"+str(line[1])   #��������ǰ������ͳ��
    return result

def main(sc):
    text = sc.textFile("/file/douban_movie_data/movie_summary.txt")
    word_list = text.map(split).collect() #����Ϊ�б�

    count = sc.parallelize(word_list[0]) #�����б��еĵ�һ��Ԫ��
    results = count.map(lambda w:(w,1)).reduceByKey(lambda x,y:x+y).map(combine).sortByKey().saveAsTextFile("/file/douban_movie_data/result")
    print "succeed"

if __name__=="__main__":
    conf = SparkConf().setAppName("wordSplit")
    conf.setMaster("local")
    sc= SparkContext(conf = conf)
    main(sc)