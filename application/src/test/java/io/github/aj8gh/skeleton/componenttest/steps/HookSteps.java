package io.github.aj8gh.skeleton.componenttest.steps;

import io.cucumber.java8.En;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class HookSteps implements En {

  @Autowired
  private List<JpaRepository<?, ?>> repositories;

  public HookSteps() {
    Before(() -> repositories.forEach(JpaRepository::deleteAll));
  }
}
