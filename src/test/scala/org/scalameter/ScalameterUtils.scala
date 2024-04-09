package org.scalameter

import org.scalameter.api.*

object ScalameterUtils {
  // We need to have access to dyn object in [[org.scalameter]] package to define our custom executor.
  // This object is package private and in order to make it available in our code we define ScalameterUtils
  // in our package with the same name [[org.scalameter]]
  def scopedDyn = dyn
}
