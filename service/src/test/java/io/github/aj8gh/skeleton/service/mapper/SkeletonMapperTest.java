package io.github.aj8gh.skeleton.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SkeletonMapperTest {

  private static final String NAME = "name";
  private static final int BONES = 206;
  private static final Instant NOW = Instant.now();
  private static final UUID ID = UUID.randomUUID();

  private SkeletonMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = Mappers.getMapper(SkeletonMapper.class);
  }

  @Test
  void toEntity() {
    // Given
    var model = Skeleton.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();

    var expected = SkeletonEntity.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();

    // When
    var actual = mapper.toEntity(model);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void fromEntity() {
    // Given
    var entity = SkeletonEntity.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();

    var expected = Skeleton.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();

    // When
    var actual = mapper.fromEntity(entity);

    // Then
    assertThat(actual).isEqualTo(expected);
  }
}
