package io.github.aj8gh.skeleton.componenttest.steps;

import static io.github.aj8gh.skeleton.componenttest.util.Constants.CREATED_AT;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.ID;
import static io.github.aj8gh.skeleton.componenttest.util.Methods.eventsSortedById;
import static io.github.aj8gh.skeleton.componenttest.util.Methods.recordsSortedById;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.github.aj8gh.skeleton.componenttest.kafka.Consumer;
import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

public class SkeletonKafkaSteps {

  @Autowired
  private Consumer consumer;

  @Then("the following message is published to skeleton-v1 topic")
  public void publishedToSkeletonV1Topic(DataTable data) {
    var expectedEvents = eventsSortedById(data.asList(SkeletonCreatedEvent.class));
    await()
        .untilAsserted(() -> assertThat(consumer.getRecords())
        .hasSize(expectedEvents.size()));

    var actualEvents = recordsSortedById(consumer.getRecords());
    var softly = new SoftAssertions();
    softly.assertThat(actualEvents)
        .zipSatisfy(expectedEvents, (actual, expected) ->
            softly.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields(ID, CREATED_AT)
                .isEqualTo(expected));

    softly.assertAll();
  }
}
