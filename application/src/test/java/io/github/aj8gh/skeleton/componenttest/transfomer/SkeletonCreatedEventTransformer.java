package io.github.aj8gh.skeleton.componenttest.transfomer;

import static io.github.aj8gh.skeleton.componenttest.util.Constants.BONES;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.NAME;

import io.cucumber.java.DataTableType;
import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class SkeletonCreatedEventTransformer {

  @DataTableType
  public SkeletonCreatedEvent transform(Map<String, String> data) {
    return SkeletonCreatedEvent.newBuilder()
        .setId(UUID.randomUUID())
        .setName(data.get(NAME))
        .setBones(Integer.parseInt(data.get(BONES)))
        .setCreatedAt(Instant.now())
        .build();
  }
}
