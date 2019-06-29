buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Dependency.gradle)
        classpath(Dependency.Kotlin.gradlePlugin)
        classpath(Dependency.Junit.junit5)
        classpath(Dependency.Navigation.safeArgs)
    }
}

allprojects {

    repositories {
        google()
        jcenter()
        maven { setUrl("https://dl.bintray.com/soywiz/soywiz") }
        maven { setUrl("https://dl.bintray.com/kittinunf/maven") }
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}
