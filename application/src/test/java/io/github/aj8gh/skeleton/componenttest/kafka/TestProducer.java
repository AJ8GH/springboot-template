package io.github.aj8gh.skeleton.componenttest.kafka;

import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@RequiredArgsConstructor
public class TestProducer {

  private final String topicName;
  private final KafkaTemplate<String, SkeletonCreatedEvent> kafkaTemplate;

  public void sendMessage(SkeletonCreatedEvent event) {
    kafkaTemplate.send(topicName, event.getId().toString(), event);
  }
}
