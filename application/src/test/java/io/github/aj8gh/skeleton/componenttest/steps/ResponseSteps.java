package io.github.aj8gh.skeleton.componenttest.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java8.En;
import io.github.aj8gh.skeleton.componenttest.context.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseSteps implements En {

  @Autowired
  private ScenarioContext scenarioContext;

  public ResponseSteps() {
    Then("the response status code is {int}", (Integer statusCode) ->
        assertThat(scenarioContext.getResponseStatusCode().value())
            .isEqualTo(statusCode));
  }
}
