package io.github.aj8gh.skeleton.service.messaging;

import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildEvent;
import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildModel;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.aj8gh.skeleton.messaging.SkeletonProducer;
import io.github.aj8gh.skeleton.service.mapper.SkeletonMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProducerTest {

  @Mock
  private SkeletonProducer skeletonProducer;

  @Mock
  private SkeletonMapper mapper;

  @InjectMocks
  private Producer producer;

  @Test
  void send() {
    // Given
    var model = buildModel();
    var event = buildEvent();
    when(mapper.toEvent(model)).thenReturn(event);

    // When
    producer.send(model);

    // Then
    verify(skeletonProducer).send(event);
  }
}
