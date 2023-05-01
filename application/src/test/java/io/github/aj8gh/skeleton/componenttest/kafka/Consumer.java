package io.github.aj8gh.skeleton.componenttest.kafka;

import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Getter
public class Consumer {

  private final List<ConsumerRecord<String, SkeletonCreatedEvent>> records =
      new CopyOnWriteArrayList<>();

  @KafkaListener(topics = "${spring.kafka.topics.skeleton-created-v1.name}")
  public void listen(ConsumerRecord<String, SkeletonCreatedEvent> record) {
    log.info("Received Message: {} => {}", record.key(), record.value());
    records.add(record);
  }
}
