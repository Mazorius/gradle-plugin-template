package com.example.gradle.plugin.template.extension

import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.kotlin.dsl.listProperty
import org.gradle.kotlin.dsl.mapProperty
import org.gradle.kotlin.dsl.property
import org.gradle.kotlin.dsl.setProperty
import javax.inject.Inject

/**
 * Plugin extension to configure sub.
 *
 * Is only usable as sub extension of
 * @see TemplateExtension
 * and can not be used without it.
 */
open class TemplateSubExtension(objects: ObjectFactory, project: Project) {

  /**
   * Boolean property example
   */
  val boolean = objects.property<Boolean>().convention(false)

  /**
   * String property example
   */
  val string = objects.property<String>().convention("")

  /**
   * Set property example
   */
  val setProperty = objects.setProperty<String>().convention(mutableSetOf())

  /**
   * List property example
   */
  val listProperty = objects.listProperty<String>().convention(mutableListOf())

  /**
   * Map property example
   */
  val mapProperty =
    objects.mapProperty<String, String>().convention(mutableMapOf())

  /**
   * Directory property example
   */
  val directory = objects.directoryProperty().convention(
    project.layout.projectDirectory.dir(".")
  )

  /**
   * File property example
   */
  val fileProperty = objects.fileProperty().convention(
    project.layout.projectDirectory.file("file.txt")
  )

  /**
   * File collection example
   */
  val fileCollection = objects.fileCollection()

  /**
   * File tree example
   */
  val fileTree = objects.fileTree().setDir(
    project.layout.projectDirectory.dir("dir")
  )
}
