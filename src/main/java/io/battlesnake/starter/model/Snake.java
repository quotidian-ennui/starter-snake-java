package io.battlesnake.starter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(BattlesnakeNaming.class)
@JsonInclude(Include.NON_NULL)
public class Snake extends Model {

  public String id;
  public String name;
  public int health;
  public Location[] body;

}
