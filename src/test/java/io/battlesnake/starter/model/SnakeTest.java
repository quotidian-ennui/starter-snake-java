package io.battlesnake.starter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SnakeTest extends ModelBase {

  private static final String SNAKE_JSON =
      " { \"id\": \"your-snake\", \"name\": \"You\", \"health\": 100, \"body\": [{ \"x\": 1, \"y\": 3 }, { \"x\": 1, \"y\": 4 }, { \"x\": 1, \"y\": 5 }]}";


  @Test
  public void testToObject() throws Exception {
    Snake snake = mapper().readValue(SNAKE_JSON, Snake.class);
    assertEquals("You", snake.name);
    assertEquals("your-snake", snake.id);
    System.err.println(mapper().writeValueAsString(snake));
    assertEquals(3, snake.body.length);
  }
}
