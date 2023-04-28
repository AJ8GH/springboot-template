package io.github.aj8gh.skeleton.service.mapper;

import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildEntity;
import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildEvent;
import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildModel;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SkeletonMapperTest {

  private SkeletonMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = Mappers.getMapper(SkeletonMapper.class);
  }

  @Test
  void toEntity() {
    // Given
    var model = buildModel();
    var expected = buildEntity();

    // When
    var actual = mapper.toEntity(model);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void fromEntity() {
    // Given
    var entity = buildEntity();
    var expected = buildModel();

    // When
    var actual = mapper.fromEntity(entity);

    // Then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void toEvent() {
    // Given
    var model = buildModel();
    var expected = buildEvent();

    // When
    var actual = mapper.toEvent(model);

    // Then
    assertThat(actual).isEqualTo(expected);
  }
}
