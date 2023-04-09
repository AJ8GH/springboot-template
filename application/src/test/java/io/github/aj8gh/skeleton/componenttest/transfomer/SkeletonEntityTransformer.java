package io.github.aj8gh.skeleton.componenttest.transfomer;

import io.cucumber.java.DataTableType;
import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import java.util.Map;

public class SkeletonEntityTransformer {

  private static final String NAME = "name";
  private static final String BONES = "bones";

  @DataTableType
  public SkeletonEntity transform(Map<String, String> data) {
    return SkeletonEntity.builder()
        .name(data.get(NAME))
        .bones(Integer.parseInt(data.get(BONES)))
        .build();
  }
}
