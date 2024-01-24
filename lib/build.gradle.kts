plugins {
    `java-library`
    id("io.freefair.aspectj") version("6.3.0")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.aspectjrt)

    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj.core)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register("javadocAspectj", Javadoc::class) {
    description = "Generates JavaDoc documentation for the aspectj sources set."
    group = "documentation"
    source = sourceSets["aspectj"].allJava
}