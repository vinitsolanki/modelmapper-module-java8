package org.modelmapper.module.jsr310;

import org.modelmapper.ModelMapper;
import org.modelmapper.Module;

/**
 * Supports the JSR310 {@code java.time} objects with  ModelMapper
 *
 * @author Chun Han Hsiao
 */
public class Jsr310Module implements Module {
  private Jsr310ModuleConfig config;

  public Jsr310Module() {
    this(Jsr310ModuleConfig.builder().build());
  }

  public Jsr310Module(Jsr310ModuleConfig config) {
    this.config = config;
  }

  @Override
  public void setupModule(ModelMapper modelMapper) {
    modelMapper.getConfiguration().getConverters().add(0, new FromTemporalConverter(config));
    modelMapper.getConfiguration().getConverters().add(0, new ToTemporalConverter(config));
    modelMapper.getConfiguration().getConverters().add(0, new TemporalToTemporalConverter());
  }
}
