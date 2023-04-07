package io.github.aj8gh.skeleton.componenttest.transfomer;

import io.cucumber.java.DataTableType;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import java.util.Map;

public class SkeletonCreateRequestTransformer {
  private static final String NAME = "name";
  private static final String BONES = "bones";

  @DataTableType
  public SkeletonCreateRequest transform(Map<String, String> data) {
    return new SkeletonCreateRequest()
        .name(data.get(NAME))
        .name(data.get(BONES));
  }
}
