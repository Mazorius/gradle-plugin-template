package com.example.gradle.plugin.template.task

import com.example.gradle.plugin.template.extension.TemplateExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

/**
 * A task of the template plugin.
 */
open class TemplateTask(extension: TemplateExtension) : DefaultTask() {

  init {
    group = GROUP
    description = DESCRIPTION
  }

  @InputFiles
  val sourceFiles = extension.sub.fileCollection

  @OutputDirectory
  val outputDirectory = extension.sub.directory

  @TaskAction
  fun execute() {
    TODO("Define what has to be done!")
  }

  companion object {

    /**
     * Name of the task
     */
    const val NAME = "templater"

    /**
     * Group of the task
     */
    const val GROUP = "Template Group"

    /**
     * Description of the task
     */
    const val DESCRIPTION = "Template description"
  }
}
