package io.battlesnake.starter.game;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.battlesnake.starter.model.Arena;

public class Move implements Action {
  private Logger log = LoggerFactory.getLogger(this.getClass());

  private static final String MOVE = "move";
  private static final String UP = "up";
  private static final String DOWN = "down";
  private static final String LEFT = "left";
  private static final String RIGHT = "right";

  private static final String[] DIRECTIONS = {UP, DOWN, LEFT, RIGHT};

  @Override
  public Map<String, String> handle(Arena arena) {
    CurrentGame state = CurrentGame.getInstance(arena);
    log.info("Retrieved game [{}]", state.id());
    return buildMove(CurrentGame.randomize(DIRECTIONS));
  }

  private Map<String, String> buildMove(String move) {
    Map<String, String> map = new HashMap<>();
    map.put(MOVE, move);
    return map;
  }

}
