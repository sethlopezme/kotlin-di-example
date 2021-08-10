import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("kapt") version "1.5.0"
}

group = "me.sethlopez"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // testing
    testImplementation(kotlin("test-junit"))
    testImplementation("io.mockk:mockk:1.10.6")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}