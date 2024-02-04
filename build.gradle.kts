plugins {
    `java-library`
    `maven-publish`
    signing
    id("io.freefair.aspectj") version ("6.3.0")
}

group = "io.github.maikbasel"
version = "0.1.0-SNAPSHOT"

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
    withJavadocJar()
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    val extension = extensions
        .getByName("publishing") as PublishingExtension
    sign(extension.publications)
}

val isReleaseVersion by extra { version.toString().endsWith("SNAPSHOT").not() }

object Meta {
    const val DESC = "A Java adaptation of Rust's std::todo macro features using static factory methods, AspectJ's AOP, and annotations to mark unimplemented code sections."
    const val LICENSE = "MIT"
    const val GITHUB_REPO = "maikbasel/todo"
    const val RELEASE_REPO = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
    const val SNAPSHOT_REPO = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])

            pom {
                name.set(project.name)
                description.set(Meta.DESC)
                url.set("https://github.com/${Meta.GITHUB_REPO}")
                licenses {
                    license {
                        name.set(Meta.LICENSE)
                        url.set("https://opensource.org/license/mit")
                    }
                }
                developers {
                    developer {
                        id.set("maikbasel")
                        name.set("Maik Basel")
                    }
                }
                scm {
                    url.set(
                        "https://github.com/${Meta.GITHUB_REPO}.git"
                    )
                    connection.set(
                        "scm:git:git://github.com/${Meta.GITHUB_REPO}.git"
                    )
                    developerConnection.set(
                        "scm:git:git://github.com/${Meta.GITHUB_REPO}.git"
                    )
                }
                issueManagement {
                    url.set("https://github.com/${Meta.GITHUB_REPO}/issues")
                }
            }

            repositories {
                maven {
                    url = if (isReleaseVersion) uri(Meta.RELEASE_REPO) else uri(Meta.SNAPSHOT_REPO)

                    credentials {
                        val ossrhUsername: String? by project
                        val ossrhPassword: String? by project

                        username = ossrhUsername
                        password = ossrhPassword
                    }
                }
            }
        }
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