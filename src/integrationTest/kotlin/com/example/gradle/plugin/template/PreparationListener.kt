package com.example.gradle.plugin.template

import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.AutoScan
import io.kotest.core.spec.Spec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import java.io.File
import kotlin.reflect.KClass

@AutoScan
object PreparationListener : TestListener {

  internal lateinit var tempDir: File

  override suspend fun prepareSpec(kclass: KClass<out Spec>) {
    super.prepareSpec(kclass)

    tempDir = createTempDir()
  }

  override suspend fun finalizeSpec(
    kclass: KClass<out Spec>,
    results: Map<TestCase, TestResult>
  ) {
    super.finalizeSpec(kclass, results)

    tempDir.deleteRecursively()
  }
}
