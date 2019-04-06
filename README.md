starter-snake-java
===

[![Build Status](https://travis-ci.org/quotidian-ennui/starter-snake-java.svg?branch=develop)](https://travis-ci.org/quotidian-ennui/starter-snake-java)

A simple [Battlesnake AI](http://battlesnake.io) written in Java. I've been using it as a _fun project_ (no really) for my daughter and her friends. I did the work to model the JSON, translated the original maven build to gradle (mainly because I hate maven), add a minimal `Action` interface for the various snake activities. It's all the supporting work so they can concentrate on the logic. 

All the logic and stuff in 'Move' is theirs; code style is probably all mine.

Visit [https://docs.battlesnake.io](https://docs.battlesnake.io)
for API documentation and instructions for running your AI.

This snake is built using a lightweight http server Spark framework - [http://sparkjava.com/documentation](http://sparkjava.com/documentation). It could have easily have been re-built from the original using [Undertow](http://undertow.io/), or [Quarkus](https://quarkus.io), or in fact anything.

### Requirements

- Install JDK 8

### Running the snake

If you don't switch the console to plain, then it looks kinda wrong in the console window.

```bash
./gradlew -Dorg.gradle.console=plain snake
```

Snake will start up on port 8080. It's a system property so you could do `./gradlew -DPORT=8081 ...`. Eventual heroku / docker action because we can.
