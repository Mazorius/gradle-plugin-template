package com.example.gradle.plugin.template.model

import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.kotlin.dsl.property

/**
 * A named domain container object, that can be used to create N configurations.
 */
open class TemplateContainer(val name: String) {
}
