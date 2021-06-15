package com.example.gradle.plugin.template

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.SpecExecutionOrder
import io.kotest.core.test.TestCaseOrder

object ProjectConfig : AbstractProjectConfig() {

  override val testCaseOrder = TestCaseOrder.Random
  override val specExecutionOrder = SpecExecutionOrder.Random
}
