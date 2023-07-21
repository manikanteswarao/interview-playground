import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id(Plugins.kotlinJvm) version "1.8.10" apply false
}

allprojects {
  repositories {
    mavenCentral()
    jcenter()
  }
}

subprojects {
  group = "in.porter.fury"

  apply(plugin = Plugins.kotlinJvm)

  dependencies {
    "implementation"(Libs.Kotlin.kotlinStdlibJdk8)


    "testImplementation"(Libs.Test.spekDslJvm)
    "testImplementation"(Libs.Test.kluent)
    "testImplementation"(Libs.Test.spekRunnerJunit5)

    if(name != "commons") {
      "implementation"(project(Modules.commons))
    }
  }

  tasks.withType<Test> {
    @Suppress("UnstableApiUsage")
    useJUnitPlatform()
  }

  tasks.named<KotlinCompile>("compileKotlin") {
    kotlinOptions.jvmTarget = "1.8"
  }

  tasks.named<KotlinCompile>("compileTestKotlin") {
    kotlinOptions.jvmTarget = "1.8"
  }
}
