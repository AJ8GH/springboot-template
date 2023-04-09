package io.github.aj8gh.skeleton.componenttest.transfomer;

import io.cucumber.java.DataTableType;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import java.util.Map;

public class SkeletonDtoTransformer {

  private static final String NAME = "name";
  private static final String BONES = "bones";

  @DataTableType
  public SkeletonDto transform(Map<String, String> data) {
    return new SkeletonDto()
        .name(data.get(NAME))
        .bones(Integer.parseInt(data.get(BONES)));
  }
}
