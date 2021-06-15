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

    project.logger.debug("Apply Template plugin on '${project.path}'")
    project.registerTask(project.registerExtension())

    project.logger.quiet("Here should be your code and this log should be deleted")
  }

  private fun Project.registerExtension(): TemplateExtension {
    logger.debug("Create Template extension on '$path'")
    return extensions.create(TemplateExtension.NAME, TemplateExtension::class)
  }

  private fun Project.registerTask(extension: TemplateExtension) {
    logger.debug("Create Template task on '$path'")
    tasks.register(TemplateTask.NAME, TemplateTask::class) {
      sourceFiles.from(extension.sub.fileCollection)
      outputDirectory.set(extension.sub.directory)
    }
  }
}
