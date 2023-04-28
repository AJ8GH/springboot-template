package io.github.aj8gh.skeleton.componenttest.steps;

import io.cucumber.java.Before;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public class HookSteps {

  private final List<JpaRepository<?, ?>> repositories;

  @Before
  public void before() {
    repositories.forEach(JpaRepository::deleteAll);
  }
}
