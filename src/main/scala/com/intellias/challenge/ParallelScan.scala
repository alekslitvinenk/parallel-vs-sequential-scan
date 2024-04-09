package com.intellias.challenge

import common.*

import scala.annotation.tailrec

object ParallelScan extends ScanInterface {
  
  override def sequentialUpsweep(input: Array[Int], from: Int, until: Int): Int = {
    var prevMax = input(from)
    ((from + 1) until until).foreach { i =>
      prevMax = prevMax max input(i)
    }
    prevMax
  }
  
  override def upsweep(input: Array[Int], from: Int, until: Int, threshold: Int): Tree = {
    val len = until - from
    if (len > threshold) {
      val halfIndex: Int = len / 2 + from
      val (left, right) = parallel(
        upsweep(input, from, halfIndex, threshold),
        upsweep(input, halfIndex, until, threshold)
      )
      Tree.Node(left, right)
    } else {
      Tree.Leaf(from, until, sequentialUpsweep(input, from, until))
    }
  }

  override def sequentialDownsweep(input: Array[Int], output: Array[Int], startingValue: Int, from: Int, until: Int): Unit = {
    output(from) = input(from).max(startingValue)
    (from + 1 until until).foreach { i =>
      output(i) = input(i).max(output(i - 1))
    }
  }
  
  override def downsweep(input: Array[Int], output: Array[Int], startingValue: Int, tree: Tree): Unit =
    tree match
      case Tree.Node(left: Tree, right: Tree) =>
        parallel(
          downsweep(input, output, startingValue, left),
          downsweep(input, output, startingValue.max(left.maxPrevious), right)
        )
      case Tree.Leaf(from, until, _) =>
        sequentialDownsweep(input, output, startingValue, from, until)

  override def scan(input: Array[Int], output: Array[Int], threshold: Int): Unit = {
    val tree = upsweep(input, 0, input.length, threshold)
    downsweep(input, output, input(0), tree)
  }
}
