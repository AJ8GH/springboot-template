package io.github.aj8gh.skeleton.api.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SkeletonRestMapperTest {

  private static final String NAME = "name";
  private static final int BONES = 206;
  private static final Instant NOW = Instant.now();
  private static final UUID ID = UUID.randomUUID();

  private SkeletonRestMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = Mappers.getMapper(SkeletonRestMapper.class);
  }

  @Test
  void fromCreateRequest() {
    // Given
    var request = new SkeletonCreateRequest()
        .name(NAME)
        .bones(BONES);

    var expected = Skeleton.builder()
        .name(NAME)
        .bones(BONES)
        .build();

    // When
    var actual = mapper.fromCreateRequest(request);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void toDto() {
    // Given
    var model = Skeleton.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();

    var expected = new SkeletonDto()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW);

    // When
    var actual = mapper.toDto(model);

    // Then
    assertThat(actual).isEqualTo(expected);
  }
}
