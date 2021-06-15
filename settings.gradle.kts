rootProject.name = "template"
gradle.allprojects {
  group = "com.example.gradle.plugin"
  version = "1.0.0"
}

// TODO EVERYTHING BELOW CAN BE EXTRACTED
dependencyResolutionManagement {
  repositories {
    mavenCentral()
  }
}
