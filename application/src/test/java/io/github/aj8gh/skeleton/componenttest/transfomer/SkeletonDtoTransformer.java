package io.github.aj8gh.skeleton.componenttest.transfomer;

import static io.github.aj8gh.skeleton.componenttest.util.Constants.BONES;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.NAME;

import io.cucumber.java.DataTableType;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import java.util.Map;

public class SkeletonDtoTransformer {

  @DataTableType
  public SkeletonDto transform(Map<String, String> data) {
    return SkeletonDto.builder()
        .name(data.get(NAME))
        .bones(Integer.parseInt(data.get(BONES)))
        .build();
  }
}
