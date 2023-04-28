package io.github.aj8gh.skeleton.messaging;

import static org.mockito.Mockito.verify;

import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

@ExtendWith(MockitoExtension.class)
class SkeletonProducerTest {

  private static final String TOPIC_NAME = "topicName";
  private static final String NAME = "name";
  private static final int BONES = 206;

  @Mock
  private KafkaTemplate<String, SkeletonCreatedEvent> kafkaTemplate;

  private SkeletonProducer skeletonProducer;

  @BeforeEach
  void setUp() {
    skeletonProducer = new SkeletonProducer(TOPIC_NAME, kafkaTemplate);
  }

  @Test
  void send() {
    // Given
    var event = buildEvent();

    // When
    skeletonProducer.send(event);

    // Then
    verify(kafkaTemplate).send(TOPIC_NAME, event.getId().toString(), event);
  }

  private SkeletonCreatedEvent buildEvent() {
    return SkeletonCreatedEvent.newBuilder()
        .setId(UUID.randomUUID())
        .setCreatedAt(Instant.now())
        .setName(NAME)
        .setBones(BONES)
        .build();
  }
}
