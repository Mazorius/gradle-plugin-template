package com.example.gradle.plugin.template

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.booleans.shouldBeTrue
import org.gradle.testfixtures.ProjectBuilder

class ApplyPluginTest : BehaviorSpec(
  {

    Given("Gradle project") {
      val rootProject = ProjectBuilder.builder().withName("root").build()

      When("Apply plugin") {
        rootProject.pluginManager.apply(TemplatePlugin::class.java)

        Then("Is present in root project plugin list") {
          rootProject
            .plugins
            .hasPlugin(TemplatePlugin::class.java)
            .shouldBeTrue()
        }
      }
    }
  }
)
