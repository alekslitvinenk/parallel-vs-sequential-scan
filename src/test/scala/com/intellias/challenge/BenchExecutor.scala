package com.intellias.challenge

import org.scalameter.Bench.{OfflineReport, OnlineRegressionReport}
import org.scalameter.ScalameterUtils.scopedDyn
import org.scalameter.{CurveData, Key, KeyValue, Setup, currentContext, dyn, log, utils}
import org.scalameter.api.*
import org.scalameter.execution.SeparateJvmsExecutor
import org.scalameter.picklers.Implicits.*
import org.scalameter.utils.Tree

import scala.collection.Seq

trait BenchExecutor { self: OfflineReport =>
  
  // Due to a bug in Scalameter implementation we need to provide our own implementation of Executor to allow
  // scoped context propagation into global currentContext
  override def executor: Executor[Double] = new SeparateJvmsExecutor(
    warmer, aggregator, measurer
  ) {
    override def run[T](setuptree: utils.Tree[Setup[T]], reporter: Reporter[Double], persistor: Persistor): utils.Tree[CurveData[Double]] = {
      val time = System.currentTimeMillis()
      var result: Tree[CurveData[Double]] = null
      var count = 0
      for (setup <- setuptree) {
        count += 1
      }
      
      val newContext = currentContext ++ Seq(
        exec.setupCount := count,
        exec.setupIndex := 0,
        exec.overallBegin := time
      )
      for (_ <- scopedDyn.currentContext.using(newContext)) {
        result = for (setup <- setuptree) yield {
          log.clear()
          log.overallBegin(time)
          log.overallScope(setup.context.scope + " \ud83e\udc7a " + setup.context(Key.dsl.curve))
          val cd: CurveData[Double] = runSetup(setup)
          scopedDyn.currentContext.withValue(setup.context) {
            reporter.report(Tree[CurveData[Double]](currentContext, Seq(cd), Seq()), persistor)
          }
          cd
        }
      }
      log.clear()
      Tree[CurveData[Double]](currentContext, Seq(), Seq())
    }
  }
}
