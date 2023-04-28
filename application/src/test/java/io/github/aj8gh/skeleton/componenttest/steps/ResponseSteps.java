package io.github.aj8gh.skeleton.componenttest.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.github.aj8gh.skeleton.componenttest.context.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponseSteps {

  @Autowired
  private ScenarioContext scenarioContext;

  @Then("the response status code is {int}")
  public void responseStatusCodeIs(int statusCode) {
    assertThat(scenarioContext.getResponseStatusCode().value())
        .isEqualTo(statusCode);
  }
}
