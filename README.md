starter-snake-java
===

[![Build Status](https://travis-ci.org/quotidian-ennui/starter-snake-java.svg?branch=develop)](https://travis-ci.org/quotidian-ennui/starter-snake-java)

A simple [Battlesnake AI](http://battlesnake.io) written in Java. I've been using it as a _fun project_ (no really) for my daughter and her friends. I've did the work to model the JSON, and to translate maven to gradle (mainly because I hate maven), so they can concentrate on the logic.

All the logic and stuff in 'Move' is theirs; code style is probably all mine.

Visit [https://docs.battlesnake.io](https://docs.battlesnake.io)
for API documentation and instructions for running your AI.

This snake is built using a lightweight http server Spark framework - [http://sparkjava.com/documentation](http://sparkjava.com/documentation)

Requirements

---

- Install JDK 8

Running the snake
---

If you don't switch the console to plain, then it looks kinda wrong in the console window.

```bash
./gradlew -Dorg.gradle.console=plain snake
```

Snake will start up on port 8080

