package io.battlesnake.starter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ArenaTest extends ModelBase {

  private static final String GAME_STATE_JSON =
      "{\n" + 
      "  \"game\": {\"id\": \"game-id-string\" },\n" + 
      "  \"turn\": 1,\n" + 
      "  \"board\": \n" + 
      "  { \"height\": 11, \"width\": 11, \"food\": [{\"x\": 1, \"y\": 3 }, {\"x\": 5, \"y\": 6}],\n" + 
      "    \"snakes\": [\n" + 
      "      { \"id\": \"snake1\", \"name\": \"Snakey\", \"health\": 100, \"body\": [{ \"x\": 1, \"y\": 3 }]},\n" + 
      "      { \"id\": \"snake2\", \"name\": \"Sneaky\", \"health\": 100, \"body\": [{ \"x\": 4, \"y\": 5 }]}\n" + 
      "    ]\n" + 
      "  },\n" + 
      "  \"you\": { \"id\": \"your-snake\", \"name\": \"You\", \"health\": 100, \"body\": [{ \"x\": 1, \"y\": 3 }, { \"x\": 1, \"y\": 4 }, { \"x\": 1, \"y\": 5 }]}\n" + 
      "}";


  @Test
  public void testToObject() throws Exception {
    Arena gameState = mapper().readValue(GAME_STATE_JSON, Arena.class);
    System.err.println(mapper().writeValueAsString(gameState));
    assertEquals("game-id-string", gameState.game.id);
    assertEquals(2, gameState.board.snakes.length);
    assertEquals("Snakey", gameState.board.snakes[0].name);
    assertEquals("Sneaky", gameState.board.snakes[1].name);
    assertEquals("your-snake", gameState.you.id);
  }
}
