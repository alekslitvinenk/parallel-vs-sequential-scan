package com.intellias.challenge

import org.scalameter.{Key, KeyValue, KeyWithDefaultValue}
import org.scalameter.api.*
import org.scalameter.picklers.Implicits.*

object ParallelVsSequentialPerformanceBenchmark extends Bench.Group {
  
  performance of "parallelScanSmallThresholds" config(
    KeyValue(reports.resultDir -> "benchmarks/parallel-small-thr")
  ) in {
    include(
      new ParallelScanSmallThresholdsBenchmark(){}
    )
  }
  
  performance of "parallelScanBigThresholds" config(
    KeyValue(reports.resultDir -> "benchmarks/parallel-big-thr")
    ) in {
    include(
      new ParallelScanBigThresholdsBenchmark(){}
    )
  }
  
  performance of "sequentialScan" config(
    KeyValue(reports.resultDir -> "benchmarks/sequential")
  ) in {
    include(
      new SequentialScanBenchmark(){}
    )
  }
}
