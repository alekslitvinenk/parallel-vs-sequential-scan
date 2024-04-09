package com.intellias.challenge

import org.scalameter.Bench.OfflineReport
import org.scalameter.ScalameterUtils.scopedDyn
import org.scalameter.{CurveData, Key, KeyValue, Setup, currentContext, dyn, log, utils}
import org.scalameter.api.*
import org.scalameter.execution.SeparateJvmsExecutor
import org.scalameter.picklers.Implicits.*
import org.scalameter.utils.Tree

import scala.collection.Seq

trait BaseBenchConfig {
  
  val baseBenchContext: Context = Context(
    KeyValue(exec.jvmflags -> List(
      "-Xms512M",
      "-Xmx4g",
      "-Xss256M",
    )),
  )
}
