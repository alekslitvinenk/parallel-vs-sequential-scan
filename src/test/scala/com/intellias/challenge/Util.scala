package com.intellias.challenge

import org.scalatest.matchers.should.Matchers._

import scala.util.Random

object Util {
  def arrayOfRandomElements(size: Int): Array[Int] = (0 until size).view.map(_ => Random.nextInt()).toArray
  def arrayOfPosRandomElements(size: Int): Array[Int] = (0 until size).view.map(_ => Math.abs(Random.nextInt(100))).toArray
  def assertOutputOrdered(out: Array[Int]): Any = {
    val z = out.zip(out.slice(1, out.length))
    z.forall(p => p._1 <= p._2) should be(true)
  }
}
