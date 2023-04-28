package io.github.aj8gh.skeleton.componenttest.steps;

import static io.github.aj8gh.skeleton.componenttest.util.Constants.CREATED_AT;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.ID;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.UPDATED_AT;
import static io.github.aj8gh.skeleton.componenttest.util.Methods.entitiesSortedById;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import io.github.aj8gh.skeleton.componenttest.client.SkeletonClient;
import io.github.aj8gh.skeleton.componenttest.context.ScenarioContext;
import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import io.github.aj8gh.skeleton.persistence.repository.JpaSkeletonRepository;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

public class SkeletonSteps {

  @Autowired
  private JpaSkeletonRepository jpaSkeletonRepository;

  @Autowired
  private SkeletonClient skeletonClient;

  @Autowired
  private ScenarioContext scenarioContext;

  @Given("the following create skeleton request is made")
  public void createSkeletonRequestIsMade(DataTable data) {
    SkeletonCreateRequest request = data.convert(SkeletonCreateRequest.class, false);
    var response = skeletonClient.create(request);

    scenarioContext.setResponseStatusCode(response.getStatusCode());
    scenarioContext.setCreateSkeletonResponseBody(response.getBody());
  }

  @Then("the following entities exist in the skeleton table")
  public void entitiesExistInSkeletonTable(DataTable data) {
    var expected = entitiesSortedById(data.asList(SkeletonEntity.class));

    await().untilAsserted(() -> {
      var actual = entitiesSortedById(jpaSkeletonRepository.findAll());
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
  }

  @Then("the skeleton create response has the following body")
  public void skeletonCreateResponseHasBody(DataTable data) {
    SkeletonDto expectedResponseBody = data.convert(SkeletonDto.class, false);
    var actualResponseBody = scenarioContext.getCreateSkeletonResponseBody();

    assertThat(actualResponseBody)
        .usingRecursiveComparison()
        .ignoringFields(ID, CREATED_AT, UPDATED_AT)
        .isEqualTo(expectedResponseBody);

    assertThat(actualResponseBody.getId()).isNotNull();
    assertThat(actualResponseBody.getCreatedAt()).isNotNull();
    assertThat(actualResponseBody.getUpdatedAt()).isNotNull();
  }
}
