package io.battlesnake.starter.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;

// Just limits the number of changes that we need to make in the event of naming changes...
public class BattlesnakeNaming extends PropertyNamingStrategyBase {

  @Override
  public String translate(String input) {
    return input.toLowerCase();
  }
}
