plugins {
  `java-gradle-plugin`
  `kotlin-dsl`
  `idea`
  `eclipse`
  `jacoco`
}

gradlePlugin.plugins.create("example") {
  id = "com.example.${rootProject.name}"
  displayName = "Template Plugin"
  description = """
    The Template Project Plugin sets something in our projects.
  """.trimIndent()
  implementationClass = "${project.group}.template.TemplatePlugin"
}

dependencies {
  implementation(enforcedPlatform("org.jetbrains.kotlin:kotlin-bom:1.4.31"))

  val koTestVersion = "4.6.0"
  testImplementation("io.kotest:kotest-assertions-core:$koTestVersion")
  testImplementation("io.kotest:kotest-property:$koTestVersion")
  testImplementation("io.kotest:kotest-runner-junit5:$koTestVersion")
}

// TODO EVERYTHING BELOW CAN BE EXTRACTED
java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of("11"))
  }
}

val sourceSetName = "integrationTest"
sourceSets {
  // TODO is not recognized as test source set in IntelliJ
  register(sourceSetName) {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
    allSource.srcDir(layout.projectDirectory.dir("src/$sourceSetName"))
  }
}

val integrationTest by tasks.registering(Test::class) {
  group = LifecycleBasePlugin.VERIFICATION_GROUP
  description = "Runs the integration tests."

  val sourceSet = sourceSets.named(sourceSetName).get()
  testClassesDirs = sourceSet.output.classesDirs
  classpath = sourceSet.runtimeClasspath
}

tasks.check.get().dependsOn(integrationTest)
tasks.named("jacocoTestReport").get().dependsOn(integrationTest)

configurations {
  val testImplementation by configurations
  val integrationTestImplementation by configurations
  integrationTestImplementation.extendsFrom(testImplementation)
  val testRuntimeOnly by configurations
  val integrationTestRuntimeOnly by configurations
  integrationTestRuntimeOnly.extendsFrom(testRuntimeOnly)
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging.events("passed", "skipped", "failed")
}
