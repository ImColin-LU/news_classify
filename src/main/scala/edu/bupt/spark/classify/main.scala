package edu.bupt.spark.classify

import edu.bupt.spark.classify.utils.HbaseUtil

/**
 * @Description:
 * @Author: LSL_2017213464
 * @Date: 2020/11/28 20:17
 */
object main {
  def main(args: Array[String]): Unit = {
    val hbaseUtil = new HbaseUtil
    //hbaseUtil.createTable("news","classify","f",96)
    hbaseUtil.createTable("news","classify_test","f",96)
    println(hbaseUtil.getRowData("news:classify_test", "11709", "f", NaiveBayesTest.col))
  }
}
