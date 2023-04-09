package io.github.aj8gh.skeleton.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.aj8gh.skeleton.service.model.Skeleton;
import io.github.aj8gh.skeleton.service.repository.SkeletonRepository;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SkeletonServiceTest {

  private static final String NAME = "name";
  private static final int BONES = 206;
  private static final Instant NOW = Instant.now();
  private static final UUID ID = UUID.randomUUID();

  @Mock
  private SkeletonRepository repository;
  @InjectMocks
  private SkeletonService service;

  @Test
  void create() {
    // Given
    var model = Skeleton.builder()
        .name(NAME)
        .bones(BONES)
        .build();

    var expected = model.toBuilder()
        .id(ID)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();

    when(repository.save(model)).thenReturn(expected);

    // When
    var actual = service.create(model);

    // Then
    assertThat(actual).isEqualTo(expected);
    verify(repository).save(model);
  }
}
