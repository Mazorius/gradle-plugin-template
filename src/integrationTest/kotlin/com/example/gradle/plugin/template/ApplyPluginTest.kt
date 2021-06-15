package com.example.gradle.plugin.template

import com.example.gradle.plugin.template.PreparationListener
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.string.shouldContain
import org.gradle.testkit.runner.GradleRunner
import java.io.File

class ApplyPluginTest : BehaviorSpec(
  {
    val buildGradleKts = "build.gradle.kts"
    File(PreparationListener.tempDir, buildGradleKts).writeText(
      ClassLoader.getSystemResource(buildGradleKts).readText()
    )

    val settingsGradleKts = "settings.gradle.kts"
    File(PreparationListener.tempDir, settingsGradleKts).writeText(
      ClassLoader.getSystemResource(settingsGradleKts).readText()
    )

    Given("Common Gradle Project") {

      When("Run build task") {
        val taskName = "buildEnvironment"
        val buildResult = GradleRunner.create()
          .withProjectDir(PreparationListener.tempDir)
          .withArguments(taskName, "--debug", "--stacktrace")
          .withPluginClasspath()
          .build()

        Then("Build env should contain plugin") {
          buildResult.output.shouldContain(
            "Apply Template plugin on ':'"
          )
        }
      }
    }
  }
)
