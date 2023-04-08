package io.github.aj8gh.skeleton.componenttest.context;

import io.cucumber.spring.ScenarioScope;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@ScenarioScope
public class ScenarioContext {

  private HttpStatusCode responseStatusCode;
  private SkeletonDto createSkeletonResponseBody;
}
