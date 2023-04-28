package io.github.aj8gh.skeleton.service.util;

import static lombok.AccessLevel.PRIVATE;

import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import java.time.Instant;
import java.util.UUID;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class ModelCreator {

  private static final String NAME = "name";
  private static final int BONES = 206;
  private static final Instant NOW = Instant.now();
  private static final UUID ID = UUID.randomUUID();

  public static Skeleton buildModel() {
    return Skeleton.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();
  }

  public static SkeletonEntity buildEntity() {
    return SkeletonEntity.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();
  }

  public static SkeletonCreatedEvent buildEvent() {
    return SkeletonCreatedEvent.newBuilder()
        .setId(ID)
        .setName(NAME)
        .setBones(BONES)
        .setCreatedAt(NOW)
        .build();
  }
}
