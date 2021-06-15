package com.example.gradle.plugin.template.extension

import com.example.gradle.plugin.template.model.TemplateContainer
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.Nested
import org.gradle.kotlin.dsl.domainObjectContainer

/**
 * A extension for configuration of the behavior of the template plugin.
 *
 * This extension provides a second extension which configures the ...
 * @see TemplateSubExtension .
 */
open class TemplateExtension(
  private val objects: ObjectFactory,
  private val project: Project
) {

  /**
   * sub extension of type
   * @see TemplateSubExtension
   */
  @get:Nested
  val sub = TemplateSubExtension(objects, project)

  /**
   * a domain container to set zero or more configurations
   * @see TemplateContainer
   */
  val container = objects.domainObjectContainer(TemplateContainer::class)

  /**
   * Make it possible to configure
   * @see TemplateSubExtension
   * via closure call:
   *
   * <code>
   * sub {
   *  ...
   * }
   * </code>
   */
  fun sub(configure: Action<TemplateSubExtension>) = configure.execute(sub)

  companion object {

    /**
     * Name of the extension
     */
    const val NAME = "exampleTemplate"
  }
}
