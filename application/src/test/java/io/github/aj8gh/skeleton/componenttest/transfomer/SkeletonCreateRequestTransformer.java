package io.github.aj8gh.skeleton.componenttest.transfomer;

import static io.github.aj8gh.skeleton.componenttest.util.Constants.BONES;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.NAME;

import io.cucumber.java.DataTableType;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import java.util.Map;

public class SkeletonCreateRequestTransformer {

  @DataTableType
  public SkeletonCreateRequest transform(Map<String, String> data) {
    return SkeletonCreateRequest.builder()
        .name(data.get(NAME))
        .bones(Integer.parseInt(data.get(BONES)))
        .build();
  }
}
