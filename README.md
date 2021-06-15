<p align="center"><img width=64px src=".github/markdown/karel.png"></p>
<h1 align="center">Karel The Robot - Java Frontend</h1>

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/04850fbc4c284ca58ad1587bb02de9e0)](https://www.codacy.com/gh/hendrikboeck/karel_the_robot_java_frontend/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=hendrikboeck/karel_the_robot_java_frontend&amp;utm_campaign=Badge_Grade) ![Java](https://img.shields.io/badge/java-11+-blue.svg) [![License](https://img.shields.io/badge/license-GPL_v3.0-blue.svg)](https://opensource.org/licenses/GPL-3.0) [![GitHub release](https://img.shields.io/github/release/hendrikboeck/karel_the_robot_java_frontend.svg)](https://github.com/hendrikboeck/karel_the_robot_java_frontend/releases/) [![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/hendrikboeck/karel_the_robot_java_frontend/graphs/commit-activity)

- [1. General](#1-general)
  - [1.1. Abstract](#11-abstract)
  - [1.2. How it works](#12-how-it-works)
- [2. Example Program](#3-example-program)
- [3. Acknowledgements](#4-acknowledgements)

# 1. General

## 1.1. Abstract

Karel The Robot was invented in th 1970s by Richard E. Pattis at Standford Univeristy. Karel The Robot is a program, that should make the intruduction to coding for newcomers and beginners more simple. Its aim is to teach basic principles such as top-down programming and establish them from the beginning. Futhermore is learning programming with Karel The Robot a way more visual and rewarding experience then just printing out some strings and numbers onto the command-line.

Also see [hendrikboeck/karel_the_robot_python3_backend](https://github.com/hendrikboeck/karel_the_robot_python3_backend).

## 1.2. How it works

The frontend connects to the PBE-pipe via a TCP-socket (`tcp/14480`). As a JSON-library the [json-simple](https://code.google.com/archive/p/json-simple/) library is used. Currently StarterProjects for Gradle projects are supported. StarterProjects can be downloaded from the [Releases](https://github.com/hendrikboeck/karel_the_robot_java_frontend/releases) section.

# 2. Example Program

The library as a .jar-file, can be found at the [Releases](https://github.com/hendrikboeck/karel_the_robot_java_frontend/releases) section.

```java
import com.github.hendrikboeck.karel.Karel;

public class TestRoom extends Karel {

  public TestRoom() {
    loadWorld("TestRoom");

    move();
    turnLeft();

    while (frontIsClear()) move();

    ...
  }

  public void turnRight() {
    turnLeft();
    turnLeft();
    turnLeft();
  }

}
```

# 3. Acknowledgements

- Karel The Robot by Richard E. Pattis at Stanford University
- [KarelLearnsC](https://github.com/OTHRegensburgMedieninformatik/KarelLearnsC) by [OTHRegensburgMedieninformatik](https://github.com/OTHRegensburgMedieninformatik)
