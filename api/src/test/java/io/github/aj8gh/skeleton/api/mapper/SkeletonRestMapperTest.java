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
  void fromCreateRequest_HappyPath() {
    // Given
    var request = buildCreateRequest();
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
  void toDto_HappyPath() {
    // Given
    var model = buildModel();
    var expected = buildDto();

    // When
    var actual = mapper.toDto(model);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  private SkeletonCreateRequest buildCreateRequest() {
    return SkeletonCreateRequest.builder()
        .name(NAME)
        .bones(BONES)
        .build();
  }

  private SkeletonDto buildDto() {
    return SkeletonDto.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();
  }

  private Skeleton buildModel() {
    return Skeleton.builder()
        .id(ID)
        .name(NAME)
        .bones(BONES)
        .createdAt(NOW)
        .updatedAt(NOW)
        .build();
  }
}
