package io.github.aj8gh.skeleton.componenttest.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java8.En;

public class ApplicationSteps implements En {

  public ApplicationSteps() {
    Given("cucumber works", () -> assertThat(1 + 1).isEqualTo(2));
  }
}
