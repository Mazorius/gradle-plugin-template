package com.example.gradle.plugin.template

import com.example.gradle.plugin.template.extension.TemplateExtension
import com.example.gradle.plugin.template.task.TemplateTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register

/**
 * The main class of the template plugin.
 *
 * The main purpose of this plugin ... .
 */
class TemplatePlugin : Plugin<Project> {

  override fun apply(project: Project) {
    /*
    Logging inside a Gradle Plugin can be done by:
     - project.logger.info()
     - project.logger.debug()
     - project.logger.warn()
     - project.logger.error() — does not interrupt the plugin
        > use throw Exception or error("")

    There are also:
     - project.logger.quiet() — do not use this please except for local tests
     - project.logger.lifecycle() - do not use this!
     - project.logger.trace() — will never be printed in Gradle!
     */

    // The following functions show how a plugin can be applied to projects.
    project.applyOnProject()
    //project.applyOnlyOnRootProject()
    //project.applyOnAllProjectsViaRootProject()
    //project.applyOnlyOnSubProjectsViaRootProject()
  }

  private fun Project.applyOnProject() {
    logger.debug("Apply Template plugin on '$path'")
    registerTask(registerExtension())
    logger.quiet("Here should be your code and this log should be deleted")
  }

  private fun Project.applyOnlyOnRootProject() {
    ifRootProject {
      applyOnProject()
    }
  }

  private fun Project.applyOnAllProjectsViaRootProject() {
    ifRootProject {
      allprojects {
        applyOnProject()
      }
    }
  }

  private fun Project.applyOnlyOnSubProjectsViaRootProject() {
    ifRootProject {
      subprojects {
        applyOnProject()
      }
    }
  }

  private fun Project.ifRootProject(action: () -> Unit) {
    if (this.equals(rootProject)) {
      action()
    } else {
      throw UnsupportedOperationException(
        "The Template plugin should only be applied on the root project."
      )
    }
  }

  private fun Project.registerExtension(): TemplateExtension {
    logger.debug("Create Template extension on '$path'")
    return extensions.create(
      TemplateExtension.NAME,
      TemplateExtension::class,
      project
    )
  }

  private fun Project.registerTask(extension: TemplateExtension) {
    logger.debug("Create Template task on '$path'")
    tasks.register(
      TemplateTask.NAME,
      TemplateTask::class,
      extension
    )
  }
}
