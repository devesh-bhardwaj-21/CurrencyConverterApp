// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Config.BuildPlugins.androidGradle)
        classpath(Config.BuildPlugins.kotlinGradlePlugin)
        classpath(Config.BuildPlugins.navigationBuildPlugin)
        classpath(Config.BuildPlugins.hiltBuildPlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

/*plugins {
    id("io.gitlab.arturbosch.detekt") version 1.15.0-RC1
}*/

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
