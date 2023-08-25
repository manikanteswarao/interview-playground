object Libs {
  object Kotlin {

    private const val group = "org.jetbrains.kotlin"
    const val kotlinStdlibJdk8 = "$group:kotlin-stdlib-jdk8"
    const val kotlinReflect = "$group:kotlin-reflect"
  }

  object KotlinX {

    private const val group = "org.jetbrains.kotlinx"
    private const val version = "1.3.5"
    const val kotlinxCoroutinesCore = "$group:kotlinx-coroutines-core:$version"
    const val kotlinxCoroutinesJdk8 = "$group:kotlinx-coroutines-jdk8:$version"
    const val kotlinxCoroutinesTest = "$group:kotlinx-coroutines-test:$version"
  }


  object Test {

    const val mockk = "io.mockk:mockk:1.9.3"
    const val kluent = "org.amshove.kluent:kluent:1.60"

    private const val spek2Group = "org.spekframework.spek2"
    private const val spek2Version = "2.0.5"
    const val spekDslJvm = "$spek2Group:spek-dsl-jvm:$spek2Version"
    const val spekRunnerJunit5 = "$spek2Group:spek-runner-junit5:$spek2Version"
  }

  object Dagger {
    private const val group = "com.google.dagger"
    private const val version = "2.27"

    const val dagger = "$group:dagger:$version"
    const val compiler = "$group:dagger-compiler:$version"
  }


}
