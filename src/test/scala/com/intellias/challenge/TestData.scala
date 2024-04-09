package com.intellias.challenge

import org.scalameter.api.Gen

trait TestData {
  private val sizesGen = Gen.range("size")(1000000, 10000000, 1000000)
  
  val sizes: Gen[(Array[Int], Array[Int])] = for {
    size <- sizesGen
  } yield {
    val arr = Util.arrayOfRandomElements(size)
    (arr, arr.clone())
  }
  
  val thresholdsSmall: Gen[Int] = Gen.range("threshold")(500, 100000, 500)
  val thresholdsBig: Gen[Int] = Gen.range("threshold")(10000, 1000000, 10000)
}
