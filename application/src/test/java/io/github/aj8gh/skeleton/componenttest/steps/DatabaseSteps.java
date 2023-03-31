package io.github.aj8gh.skeleton.componenttest.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java8.En;
import io.github.aj8gh.skeleton.ExampleEntity;
import io.github.aj8gh.skeleton.ExampleRepository;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j
public class DatabaseSteps implements En {

  @Autowired
  private List<JpaRepository<?, ?>> repositories;

  @Autowired
  private ExampleRepository exampleRepository;

  public DatabaseSteps() {
    Given("entities are created and saved", () -> {
      var entity = ExampleEntity.builder()
          .id(UUID.randomUUID())
          .name("name")
          .build();
      exampleRepository.save(entity);
    });

    Then("the entities exist in the database", () -> {
      var all = exampleRepository.findAll();
      assertThat(all).hasSize(1);
    });

    Then("the database is empty", () -> repositories.forEach(repository -> {
      var all = repository.findAll();
      assertThat(all).isEmpty();
    }));
  }
}
