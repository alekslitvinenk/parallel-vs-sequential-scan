package com.intellias.challenge

import org.scalameter.api.Bench

trait ParallelScanBigThresholdsBenchmark
  extends Bench.OfflineReport
  with BaseBenchConfig
  with BenchExecutor
  with TestData {
    
    private val inputData = for {
      io <- sizes
      t <- thresholdsBig
    } yield (io._1, io._2, t)
    
    performance of "ParallelScan" config baseBenchContext in {
      measure method "scan" in {
        using(inputData) in { (in, out, t) =>
          ParallelScan.scan(in, out, t)
        }
      }
    }
  
}
