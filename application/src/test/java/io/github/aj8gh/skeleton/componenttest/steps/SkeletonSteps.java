package io.github.aj8gh.skeleton.componenttest.steps;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import io.github.aj8gh.skeleton.componenttest.client.SkeletonClient;
import io.github.aj8gh.skeleton.componenttest.context.ScenarioContext;
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

  @Autowired
  private SkeletonClient skeletonClient;

  @Autowired
  private ScenarioContext scenarioContext;

  public SkeletonSteps() {
    When("the following create skeleton request is made", (DataTable data) -> {
      SkeletonCreateRequest request = data.convert(SkeletonCreateRequest.class, false);
      var response = skeletonClient.create(request);

      scenarioContext.setResponseStatusCode(response.getStatusCode());
      scenarioContext.setCreateSkeletonResponseBody(response.getBody());
    });

    Then("the following entities exist in the skeleton table", (DataTable data) -> {
      var expected = sortedById(data.asList(SkeletonEntity.class));

      await().untilAsserted(() -> {
        var actual = sortedById(jpaSkeletonRepository.findAll());
        var softly = new SoftAssertions();

        softly.assertThat(actual).hasSize(expected.size());
        softly.assertThat(actual)
            .zipSatisfy(expected, (actualEntity, expectedEntity) ->
                softly.assertThat(actualEntity)
                    .usingRecursiveComparison()
                    .ignoringFields(ID, CREATED_AT, UPDATED_AT)
                    .isEqualTo(expectedEntity));

        softly.assertAll();
      });
    });

    Then("the skeleton create response has the following body", (DataTable data) -> {
      SkeletonDto expectedResponseBody = data.convert(SkeletonDto.class, false);
      var actualResponseBody = scenarioContext.getCreateSkeletonResponseBody();

      assertThat(actualResponseBody)
          .usingRecursiveComparison()
          .ignoringFields(ID, CREATED_AT, UPDATED_AT)
          .isEqualTo(expectedResponseBody);

      assertThat(actualResponseBody.getId()).isNotNull();
      assertThat(actualResponseBody.getCreatedAt()).isNotNull();
      assertThat(actualResponseBody.getUpdatedAt()).isNotNull();
    });
  }

  private List<SkeletonEntity> sortedById(List<SkeletonEntity> entities) {
    return entities.stream()
        .sorted(comparing(SkeletonEntity::getId))
        .toList();
  }
}
