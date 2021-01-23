package edu.bupt.spark.classify.utils

import java.util
import java.util.{ArrayList, List}

import org.ansj.domain.{Result, Term}
import org.ansj.splitWord.analysis.NlpAnalysis

/**
 * @Description:
 * @Author: LSL_2017213464
 * @Date: 2020/11/29 15:43
 * @des：这里设计了使用ansj类对文本进行分词的功能。主要的函数是NlpANalysis.parse();
 * @利用NLP进行分词，能够进行1,语法实体名抽取，未登录词整理，但是速度比较慢，稳定性比较差。
 *
 *
 */
object AnsjUtil {
  def participle(text: String): util.List[String] = {
    val wordList = new util.ArrayList[String]
    //引入java util.arraylist[] string 数组，数组可以动态的添加删除修改
    // 为了接收分类结果，写了一个result
    val result: Result = NlpAnalysis.parse(text)
    // list 的list
    val terms: util.List[Term] = result.getTerms
    //java的有序数组序列，可以对列表的每个元素的位置进行控制
    import scala.collection.JavaConversions._

    for (term <- terms) {
      val name: String = term.getName
      wordList.add(name)
    }
    wordList
  }
  //下面定义了对数据进行拼接的函数
  def participleText(text: String): String = {
    val wordText = new StringBuffer
    val result: Result = NlpAnalysis.parse(text)
    val terms: util.List[Term] = result.getTerms
    for (i <- 0 until terms.size) {
      val term: Term = terms.get(i)
      val word: String = term.getName
      if (i != 0) wordText.append(" ")
      wordText.append(word)
    }
    wordText.toString
  }

}
