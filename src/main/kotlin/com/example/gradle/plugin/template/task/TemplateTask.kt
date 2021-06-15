package com.example.gradle.plugin.template.task

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileCollection
import org.gradle.api.file.FileTree
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

/**
 * A task of the template plugin.
 */
abstract class TemplateTask : DefaultTask() {

  init {
    group = GROUP
    description = DESCRIPTION
  }

  @get:InputFiles
  abstract val sourceFiles: ConfigurableFileCollection

  @get:OutputDirectory
  abstract val outputDirectory: DirectoryProperty

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
