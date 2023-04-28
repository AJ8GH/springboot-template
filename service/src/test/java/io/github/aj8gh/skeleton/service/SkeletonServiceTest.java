package io.github.aj8gh.skeleton.service;

import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.aj8gh.skeleton.service.messaging.Producer;
import io.github.aj8gh.skeleton.service.repository.SkeletonRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SkeletonServiceTest {

  @Mock
  private SkeletonRepository repository;

  @Mock
  private Producer producer;

  @InjectMocks
  private SkeletonService service;

  @Test
  void create() {
    // Given
    var model = buildModel();
    var expected = model.toBuilder().id(UUID.randomUUID()).build();
    when(repository.save(model)).thenReturn(expected);

    // When
    var actual = service.create(model);

    // Then
    assertThat(actual).isEqualTo(expected);
    verify(repository).save(model);
    verify(producer).send(expected);
  }
}
