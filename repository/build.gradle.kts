import de.mannodermaus.gradle.plugins.junit5.junitPlatform

plugins {
    id(Plugin.androidLibrary)
    id(Plugin.kotlinAndroid)
    id(Plugin.androidJunit5)
    id(Plugin.kotlinKapt)
    id(Plugin.kotlinExtensions)
}

android {

    compileSdkVersion(AppConfig.Sdk.targetVersion)

    defaultConfig {
        minSdkVersion(AppConfig.Sdk.minVersion)
        targetSdkVersion(AppConfig.Sdk.targetVersion)
        versionCode = AppConfig.Version.code
        versionName = AppConfig.Version.name
        testInstrumentationRunner = AppConfig.testRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dataBinding.isEnabled = true
    testOptions {
        junitPlatform.filters.includeEngines("spek2")
    }

    androidExtensions { isExperimental = true }

}

dependencies {
    implementation(project(":util"))
    implementation(project(":entity"))

    implementation(Dependency.Kotlin.stblib)
    implementation(Dependency.Coroutine.core)
    implementation(Dependency.Room.runtime)
    implementation(Dependency.Room.coroutines)
    implementation(Dependency.Result.result)
    implementation(Dependency.Result.resultCoroutine)
    implementation(Dependency.Koin.core)
    implementation(Dependency.Koin.coreExt)
    implementation(Dependency.Koin.androidxExt)

    kapt(Dependency.Room.compiler)

    androidTestImplementation(Dependency.AndroidTest.runner)
    androidTestImplementation(Dependency.AndroidTest.espressoCore)
    androidTestImplementation(Dependency.AndroidTest.testExt)
    androidTestImplementation(Dependency.Room.test)
    androidTestImplementation(Dependency.Koin.test)
    androidTestImplementation(Dependency.Junit.hamkrest)
    androidTestImplementation(Dependency.Kotlin.reflect)

}
