package io.battlesnake.starter;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.Collections;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.battlesnake.starter.game.End;
import io.battlesnake.starter.game.Move;
import io.battlesnake.starter.game.Start;
import io.battlesnake.starter.model.Arena;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * Snake server that deals with requests from the snake engine. Just boiler plate code. See the
 * readme to get started. It follows the spec here:
 * https://github.com/battlesnakeio/docs/tree/master/apis/snake
 */
public class Snake {
  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
  private static final Handler HANDLER = new Handler();
  private static final Logger LOG = LoggerFactory.getLogger(Snake.class);

  /**
   * Main entry point.
   *
   * @param args are ignored.
   */
  public static void main(String[] args) throws Exception {
    String port = System.getProperty("PORT");
    if (port != null) {
      LOG.info("Found system provided port: {}", port);
    } else {
      port = "8080";
      LOG.info("Using default port: {}", port);
    }
    Runtime.getRuntime().addShutdownHook(new ShutdownHandler());
    port(Integer.parseInt(port));
    get("/", (req, res) -> "Battlesnake documentation can be found at "
        + "<a href=\"https://docs.battlesnake.io\">https://docs.battlesnake.io</a>.");
    post("/start", HANDLER::process, JSON_MAPPER::writeValueAsString);
    post("/ping", HANDLER::process, JSON_MAPPER::writeValueAsString);
    post("/move", HANDLER::process, JSON_MAPPER::writeValueAsString);
    post("/end", HANDLER::process, JSON_MAPPER::writeValueAsString);
  }

  private static class ShutdownHandler extends Thread {
    @Override
    public void run() {
      Spark.stop();
      Spark.awaitStop();
    }
  }

  /**
   * Handler class for dealing with the routes set up in the main method.
   */
  public static class Handler {

    /**
     * Generic processor that prints out the request and response from the methods.
     *
     * @param req
     * @param res
     * @return
     */
    public Map<String, String> process(Request req, Response res) {
      try {
        Arena board = JSON_MAPPER.readValue(req.body(), Arena.class);
        String uri = req.uri();
        Map<String, String> snakeResponse;
        LOG.info("Received : {}", req.body());
        if (uri.equals("/start")) {
          snakeResponse = new Start().handle(board);
        } else if (uri.equals("/ping")) {
          snakeResponse = Collections.EMPTY_MAP;
        } else if (uri.equals("/move")) {
          snakeResponse = new Move().handle(board);
        } else if (uri.equals("/end")) {
          snakeResponse = new End().handle(board);
        } else {
          throw new IllegalArgumentException("Strange call made to the snake: " + uri);
        }
        LOG.info("Responding with: {}", JSON_MAPPER.writeValueAsString(snakeResponse));
        return snakeResponse;
      } catch (Exception e) {
        LOG.warn("Something went wrong!", e);
        return null;
      }
    }
  }

}
