package com.intellias.challenge

import org.scalameter.KeyValue
import org.scalameter.api.{Bench, Context, Gen}
import org.scalameter.api.*

import scala.util.Random

trait SequentialScanBenchmark
  extends Bench.OfflineReport
  with BaseBenchConfig
  with BenchExecutor
  with TestData {
  
  performance of "SequentialScan" config baseBenchContext in {
    measure method "scan" in {
      using(sizes) in { (in, out) =>
        SequentialScan.scan(in, out)
      }
    }
  }
}
