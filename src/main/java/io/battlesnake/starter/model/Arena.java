package io.battlesnake.starter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(BattlesnakeNaming.class)
@JsonInclude(Include.NON_NULL)
public class Arena extends Model {

  public Game game;
  public int turn;
  public Board board;
  public Snake you;


}
