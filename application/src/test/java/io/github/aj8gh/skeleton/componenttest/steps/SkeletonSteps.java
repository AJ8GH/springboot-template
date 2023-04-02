package io.github.aj8gh.skeleton.componenttest.steps;

import static java.util.Comparator.comparing;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import io.github.aj8gh.skeleton.persistence.repository.JpaSkeletonRepository;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

public class SkeletonSteps implements En {

  private static final String ID = "id";
  private static final String CREATED_AT = "createdAt";
  private static final String UPDATED_AT = "updatedAt";

  @Autowired
  private JpaSkeletonRepository jpaSkeletonRepository;

  public SkeletonSteps() {
    When("the following create skeleton request is made", (DataTable data) -> {

    });

    Then("the following entities exist in the skeleton table", (DataTable data) ->
        await().untilAsserted(() -> {
          var expected = sortedById(data.asList(SkeletonEntity.class));
          var actual = sortedById(jpaSkeletonRepository.findAll());
          var softly = new SoftAssertions();
          softly.assertThat(actual).hasSize(expected.size());
          softly.assertThat(actual)
              .zipSatisfy(expected, (actualEntity, expectedEntity) ->
                  softly.assertThat(actualEntity)
                      .usingRecursiveAssertion()
                      .ignoringFields(ID, CREATED_AT, UPDATED_AT)
                      .isEqualTo(expectedEntity));
          softly.assertAll();
        }));
  }

  private List<SkeletonEntity> sortedById(List<SkeletonEntity> entities) {
    return entities.stream()
        .sorted(comparing(SkeletonEntity::getId))
        .toList();
  }
}
