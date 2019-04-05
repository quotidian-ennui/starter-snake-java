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
  
  public static synchronized CurrentGame getInstance(String gameId, Arena arena) {
    CurrentGame state = new CurrentGame().addArena(arena);
    if (ALL_GAMES.containsKey(gameId)) {
      state = ALL_GAMES.get(gameId).addArena(arena);
    } else {
      ALL_GAMES.put(gameId, state);
    }
    return state;
  }
  
  public static synchronized void finish(String gameId) {
    ALL_GAMES.remove(gameId);
  }

  private ListOrderedSet<Arena> moveHistory =
      ListOrderedSet.listOrderedSet(new HashSet<Arena>());

  private CurrentGame() {

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

  public static String randomize(String[] strings) {
    return strings[ThreadLocalRandom.current().nextInt(0, strings.length)];
  }

}
