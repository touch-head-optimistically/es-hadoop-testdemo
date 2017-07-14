package main

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.elasticsearch.spark.sql._

import org.elasticsearch.spark._

/**
  * Created by MA on 2016/12/19.
  */
object testzz {

  val sc = new SparkContext(new SparkConf().setAppName("Demo4").set("es.nodes","127.0.0.1").set("es.port","17100"))

  //创建sqlContext
  val sqlContext = new SQLContext(sc)

  val people = sqlContext.esDF("zz/zz")
  println(people.schema.treeString)

  val wangs = sqlContext.esDF("zz/zz","?q=*")
  wangs.show()

}
