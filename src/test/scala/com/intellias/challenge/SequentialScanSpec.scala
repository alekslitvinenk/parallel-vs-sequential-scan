package com.intellias.challenge

import com.intellias.challenge.Util.assertOutputOrdered
import org.scalatest.wordspec.AnyWordSpec

class SequentialScanSpec extends AnyWordSpec {
  "SequentialScan" should {
    "give correct results for array" in {
      val in = Util.arrayOfRandomElements(10000000)
      val out = in.clone()
      
      SequentialScan.scan(in, out)
  
      assertOutputOrdered(out)
    }
  }
}
