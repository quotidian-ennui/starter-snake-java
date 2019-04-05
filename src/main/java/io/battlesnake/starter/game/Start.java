package io.battlesnake.starter.game;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.battlesnake.starter.model.Arena;

public class Start implements Action {

  public static final String[] SNAKE_HEADS = {
      "regular", "beluga", "bendr", "dead", "evil", "fang", "pixel", "safe", "sand-worm", "shades",
      "silly", "smile", "tongue"
  };

  public static final String[] SNAKE_TAILS = {
      "regular", "block-bum", "bolt", "curled", "fat-rattle", "freckled", "hook", "pixel",
      "round-bum", "sharp", "skinny", "small-rattle"
  };

  private Logger log = LoggerFactory.getLogger(this.getClass());

  private static final String COLOR = "color";
  private static final String HEAD_TYPE = "headType";
  private static final String TAIL_TYPE = "tailType";


  @Override
  public Map<String, String> handle(Arena arena) {
    CurrentGame state = CurrentGame.getInstance(arena.game.id, arena);
    log.info("Created new game [{}]", arena.game.id);
    Map<String,String> map = new HashMap<>();
    map.put(HEAD_TYPE, CurrentGame.randomize(SNAKE_HEADS));
    map.put(TAIL_TYPE, CurrentGame.randomize(SNAKE_TAILS));
    map.put(COLOR, randomColour());
    return map;
  }

  private String randomColour() {
    return String.format("%s%02x%02x%02x", "#", randomRGB(), randomRGB(), randomRGB());
  }

  private int randomRGB() {
    return ThreadLocalRandom.current().nextInt(0, 256);
  }
}
