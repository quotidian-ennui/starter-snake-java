package io.battlesnake.starter.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.set.ListOrderedSet;
import io.battlesnake.starter.model.Arena;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

// Stores the current game state, very simple, static methods to create/destroy.
// ExpiringMap cache of board ids to store all the boardy bits.
public class CurrentGame {

  private static ExpiringMap<String, CurrentGame> ALL_GAMES = 
      ExpiringMap.builder().maxSize(1024)
          .expirationPolicy(ExpirationPolicy.ACCESSED).expiration(1, TimeUnit.HOURS).build();
  
  public static synchronized CurrentGame getInstance(Arena arena) {
    String gameId = id(arena);
    CurrentGame state = new CurrentGame(gameId).addArena(arena);
    if (ALL_GAMES.containsKey(gameId)) {
      state = ALL_GAMES.get(gameId).addArena(arena);
    } else {
      ALL_GAMES.put(gameId, state);
    }
    return state;
  }
  
  private static String id(Arena arena) {
    return String.format("%s-%s", arena.game.id, arena.you.id);
  }

  public static synchronized void finish(Arena arena) {
    ALL_GAMES.remove(id(arena));
  }

  private ListOrderedSet<Arena> moveHistory =
      ListOrderedSet.listOrderedSet(new HashSet<Arena>());
  private String id;

  private CurrentGame(String id) {
    this.id = id;
  }

  public CurrentGame addArena(Arena arena) {
    // the first move with the "move" is actually the same board as what's
    // called with start, but that shouldn't matter, since we're a set.
    moveHistory.add(arena);
    return this;
  }

  public List<Arena> history() {
    return new ArrayList<>(moveHistory);
  }

  public String id() {
    return id;
  }

  public static String randomize(String[] strings) {
    return strings[ThreadLocalRandom.current().nextInt(0, strings.length)];
  }

}
