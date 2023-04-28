package io.github.aj8gh.skeleton.componenttest.util;

import static java.util.Comparator.comparing;
import static lombok.AccessLevel.PRIVATE;

import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@NoArgsConstructor(access = PRIVATE)
public final class Methods {

  public static List<SkeletonEntity> entitiesSortedById(List<SkeletonEntity> entities) {
    return sortedByUuid(entities, SkeletonEntity::getId);
  }

  public static List<SkeletonCreatedEvent> eventsSortedById(List<SkeletonCreatedEvent> events) {
    return sortedByUuid(events, SkeletonCreatedEvent::getId);
  }

  public static List<SkeletonCreatedEvent> recordsSortedById(
      List<ConsumerRecord<String, SkeletonCreatedEvent>> records) {
    return eventsSortedById(records.stream().map(ConsumerRecord::value).toList());
  }

  private static <T> List<T> sortedByUuid(List<T> list, Function<T, UUID> function) {
    return list.stream()
        .sorted(comparing(function))
        .toList();
  }
}
