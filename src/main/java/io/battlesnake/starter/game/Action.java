package io.battlesnake.starter.game;

import java.util.Map;
import io.battlesnake.starter.model.Arena;

@FunctionalInterface
public interface Action {

  Map<String, String> handle(Arena arena);

}
