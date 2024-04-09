package com.intellias.challenge

import com.intellias.challenge.Util.*
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.wordspec.*
import org.scalatest.matchers.should.Matchers.*

import java.time.Instant

class ParallelScanSpec extends AnyWordSpec {
  "ParallelScan.scan" should {
    "give correct results for array 1" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val out = in.clone()
      val expected = Array(0, 0, 1, 5, 5, 5, 6)
      
      ParallelScan.scan(in, out, 2)
  
      assertOutputOrdered(out)
      out.toList should contain theSameElementsInOrderAs (expected.toList)
    }
  
    "give correct results for array 2" in {
      val in = Array(2, 4, 1, 6, 3, 8, 5, 7)
      val out = in.clone()
      val expected = Array(2, 4, 4, 6, 6, 8, 8, 8)
    
      ParallelScan.scan(in, out, 4)
  
      assertOutputOrdered(out)
      out.toList should contain theSameElementsInOrderAs (expected.toList)
    }
  
    "give correct results for array 3" in {
      val in = Array(76,91,39,87,72,60,64,8,25,66)
      val out = in.clone()
    
      ParallelScan.scan(in, out, 2)
  
      assertOutputOrdered(out)
    }
  
    "give correct results for array 4" in {
      val in = Util.arrayOfPosRandomElements(1000)
      val out = in.clone()
    
      ParallelScan.scan(in, out, 2)
  
      assertOutputOrdered(out)
    }
  
    "give correct results for array 5" in {
      // TODO: better record generated random values to file and read them in tests
      val in = Util.arrayOfRandomElements(100000)
      val out = in.clone()
    
      ParallelScan.scan(in, out, 1000)
    
      assertOutputOrdered(out)
    }
  
    "give correct results for array 6" in {
      // TODO: better record generated random values to file and read them in tests
      val in = Util.arrayOfRandomElements(1000000)
      val out = in.clone()
    
      ParallelScan.scan(in, out, 2000)
    
      assertOutputOrdered(out)
    }
  
    "give correct results for array 7" in {
      // TODO: better record generated random values to file and read them in tests
      val in = Util.arrayOfRandomElements(10000000)
      val out = in.clone()
    
      ParallelScan.scan(in, out, 100000)
      
      assertOutputOrdered(out)
    }
  }
  
  "ParallelScan.sequentialUpsweep" should {
    "calculate correctly maximum value for slice 1" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val expected = 6
      
      val out = ParallelScan.sequentialUpsweep(in, 0, in.length)
      
      out should equal(expected)
    }
  
    "calculate correctly maximum value for slice 2" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val expected = 5
    
      val out = ParallelScan.sequentialUpsweep(in, 2, 5)
    
      out should equal(expected)
    }
  }
  
  "ParallelScan.upsweep" should {
    "produce binary tree for slice 1" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val expected = Tree.Node(
        Tree.Leaf(0, 3, 1),
        Tree.Leaf(3, 7, 6)
      )
  
      val out = ParallelScan.upsweep(in, 0, in.length, 4)
  
      out should be(expected)
    }
  
    "produce binary tree for slice 2" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val expected = Tree.Node(
        Tree.Leaf(0, 2, 0),
        Tree.Leaf(2, 4, 5)
      )
    
      val out = ParallelScan.upsweep(in, 0, 4, 2)
    
      out should be(expected)
    }
  }
  
  "ParallelScan.sequentialDownsweep" should {
    "write correct output for slice 1" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val out = in.clone()
      val expected = Array(0, 0, 1, 5, 5, 5, 6)
  
      ParallelScan.sequentialDownsweep(in, out, in(0), 0, in.length)
  
      out.toList should contain theSameElementsInOrderAs (expected.toList)
    }
  
    "write correct output for slice 2" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val out = in.clone()
      val expected = Array(0, 0, 1, 5, 5, 3, 6)
    
      ParallelScan.sequentialDownsweep(in, out, in(0), 2, 5)
    
      out.toList should contain theSameElementsInOrderAs (expected.toList)
    }
  }
  
  "ParallelScan.downsweep" should {
    "write correct output for slice 1" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val out = in.clone()
      val tree = Tree.Node(
        Tree.Leaf(0, 3, 1),
        Tree.Leaf(3, 7, 6)
      )
      val expected = Array(0, 0, 1, 5, 5, 5, 6)
      
      ParallelScan.downsweep(in, out, in(0), tree)
      
      out.toList should contain theSameElementsInOrderAs (expected.toList)
    }
    
    "write correct output for slice 2" in {
      val in = Array(0, 0, 1, 5, 2, 3, 6)
      val out = in.clone()
      val tree = Tree.Node(
        Tree.Leaf(0, 2, 0),
        Tree.Leaf(2, 5, 5)
      )
      val expected = Array(0, 0, 1, 5, 5, 3, 6)
  
      ParallelScan.downsweep(in, out, in(0), tree)
      
      out.toList should contain theSameElementsInOrderAs (expected.toList)
    }
  }
}
