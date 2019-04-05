package io.battlesnake.starter.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelBase {

  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

  static {
    JSON_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
  }

  protected ObjectMapper mapper() {
    return JSON_MAPPER;
  }
}
