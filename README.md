# TODO

## Table of Contents

<!-- TOC -->
* [About the Project](#about-the-project)
* [Features](#features)
* [Prerequisites](#prerequisites)
* [Installation](#installation)
* [Usage](#usage)
* [Development](#development)
<!-- TOC -->

## About the Project

This project is an exercise in bringing functionality from Rust's std::todo macro into the Java ecosystem.
Inspired by Rust's straightforward and efficient approach, this project implements a similar behavior in Java making use
of static factory methods and aspect-oriented programming. The central feature of the project consists of a static
factory method that aids in the development process by signaling parts of the code that are yet to be implemented.
Simultaneously, this project taps into the power of AspectJ to leverage aspect-oriented programming to also provide an
annotation-driven approach to implementing something similar to Rust's std::todo macro.

## Features

- TODO annotation.
- TODO helper method.

## Prerequisites

- Install Java 17 on your computer [here](https://adoptium.net/de/temurin/releases/?version=17).

## Installation

TODO provides two ways of marking code as yet to be implemented, either by using a factory method or by annotation. If
you don't care about the annotation add a dependency on TODO using Maven:

```xml

<dependency>
    <groupId>io.github.maikbasel</groupId>
    <artifactId>todo</artifactId>
    <version>0.1.0</version>
</dependency>
```

To add a dependency using Gradle:

```gradle
dependencies {
  // Pick one:

  // 1. Use TODO in your implementation only:
  implementation("io.github.maikbasel:todo:0.1.0")

  // 2. Use TODO types in your public API:
  api("io.github.maikbasel:todo:0.1.0")
}
```

If you also want to leverage the `@Todo` annotation you also need to set
up [AspectJ](https://github.com/eclipse-aspectj/aspectj) in your project. To use TODO with you can, for example, use
the [io.freefair.aspectj.post-compile-weaving](https://docs.freefair.io/gradle-plugins/8.4/reference/#_post_compile_weaving)
gradle plugin by adding the following dependencies to your build.gradle.kts:

```kotlin
plugins {
    id("java")
    id("io.freefair.aspectj.post-compile-weaving") version ("6.3.0")
}

dependencies {
    aspect("io.github.maikbasel:todo:0.1.0")
    implementation("org.aspectj:aspectjrt:1.9.21")
}
```

For more information on when to use `api` and when to use `implementation`,
consult the
[Gradle documentation on API and implementation separation](https://docs.gradle.org/current/userguide/java_library_plugin.html#sec:java_library_separation).

## Usage

Either use the `todo()` factory method:

```java
package io.github.maikbasel.todo.example;

import io.github.maikbasel.todo.Dev;

public class Service {

    public void process() {
        Dev.todo();
    }
}
```

or if you configured AspectJ you can use the `@Todo` annotation:

```java
package io.github.maikbasel.todo.example;

import io.github.maikbasel.todo.Todo;

public class Service {

    @Todo
    public void process() {
    }
}
```

Both will result in
a [NotImplementedException](lib%2Fsrc%2Fmain%2Fjava%2Fio%2Fgithub%2Fmaikbasel%2Ftodo%2FNotImplementedException.java) to
be thrown when the method you marked as TODO is called.

## Development

Build the project locally using gradle

```bash
./gradlew build
```