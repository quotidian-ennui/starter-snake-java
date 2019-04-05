package io.battlesnake.starter.game;

import java.util.Collections;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.battlesnake.starter.model.Arena;

public class End implements Action {
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public Map<String, String> handle(Arena arena) {
    log.debug("Finishing game [{}]", arena.game.id);
    CurrentGame.finish(arena.game.id);
    return Collections.EMPTY_MAP;
  }
}
