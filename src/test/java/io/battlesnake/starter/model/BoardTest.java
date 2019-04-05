package io.battlesnake.starter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BoardTest extends ModelBase {

  private static final String BOARD_JSON =
      "  { \"height\": 11, \"width\": 12, \"food\": [{\"x\": 1, \"y\": 3 }, {\"x\": 5, \"y\": 6}],\n" + 
      "    \"snakes\": [\n" + 
      "      { \"id\": \"snake1\", \"name\": \"Snakey\", \"health\": 100, \"body\": [{ \"x\": 1, \"y\": 3 }]},\n" + 
      "      { \"id\": \"snake2\", \"name\": \"Sneaky\", \"health\": 100, \"body\": [{ \"x\": 4, \"y\": 5 }]}\n" + 
      "    ]\n" + 
      "  }";


  @Test
  public void testToObject() throws Exception {
    Board board = mapper().readValue(BOARD_JSON, Board.class);
    assertEquals(11, board.height);
    assertEquals(12, board.width);
    System.err.println(mapper().writeValueAsString(board));
    assertEquals(2, board.food.length);
    assertEquals(2, board.snakes.length);
    assertEquals("Snakey", board.snakes[0].name);
    assertEquals("Sneaky", board.snakes[1].name);
  }
}
