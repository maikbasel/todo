plugins {
    id("java")
    id("io.freefair.aspectj.post-compile-weaving") version("6.3.0")
}

group = "io.github.maikbasel"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    aspect(project(":lib"))
    implementation(libs.aspectjrt)

    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}