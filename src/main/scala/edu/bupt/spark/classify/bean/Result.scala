package edu.bupt.spark.classify.bean

class Result {
  private var category = 0L //text category


  private var predict = 0L //predict category


  def isCorrect: Boolean = category == predict



  def this(category: Long, predict: Long) {
    this()
    this.category = category
    this.predict = predict
  }

  def getCategory: Long = category

  def setCategory(category: Long): Unit = {
    this.category = category
  }

  def getPredict: Long = predict

  def setPredict(predict: Long): Unit = {
    this.predict = predict
  }
}
