// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent

    repositories {
        google()
        mavenCentral()
    }

    /**
     * Source https://github.com/JLLeitschuh/ktlint-gradle/blob/master/plugin/src/main/kotlin/org/jlleitschuh/gradle/ktlint/KtlintExtension.kt
     * Optional configure Ktlint
     * */
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true) // Debug mode
        android.set(true) // Android mode
        outputToConsole.set(true) // Set if report should output in console
        outputColorName.set("RED") // Report color in console
        baseline.set(file("${project.rootDir}/reports/ktlint/baseline.xml")) // Set baseline file
        filter {
            exclude("**/generated/**") // Excluding generated folder
            include("**/*.kt") // Including all files
            exclude("**/*Test.kt") // Excluding test file
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

/**
 * Set placement for report file
 * */
tasks.withType<org.jlleitschuh.gradle.ktlint.tasks.GenerateReportsTask> {
    reportsOutputDirectory.set(
        project.layout.buildDirectory.dir("${project.rootDir}/reports/ktlint/$name")
    )
}
