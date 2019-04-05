package io.battlesnake.starter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(BattlesnakeNaming.class)
@JsonInclude(Include.NON_NULL)
public class Board extends Model {

  public int height;
  public int width;
  public Location[] food;
  public Snake[] snakes;

}
