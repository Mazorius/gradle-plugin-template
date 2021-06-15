package com.example.gradle.plugin.template.model

import org.gradle.api.provider.Property

/**
 * A named domain container interface, that can be used to create N configurations.
 */
interface TemplateContainer {

  val name : Property<String>
}
