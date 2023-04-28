package io.github.aj8gh.skeleton.service.repository;

import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildEntity;
import static io.github.aj8gh.skeleton.service.util.ModelCreator.buildModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import io.github.aj8gh.skeleton.persistence.repository.JpaSkeletonRepository;
import io.github.aj8gh.skeleton.service.mapper.SkeletonMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SkeletonRepositoryTest {

  @Mock
  private JpaSkeletonRepository jpaRepository;

  @Mock
  private SkeletonMapper mapper;

  @InjectMocks
  private SkeletonRepository repository;

  @Test
  void save() {
    // Given
    var model = buildModel();
    var entity = buildEntity();
    when(mapper.toEntity(model)).thenReturn(entity);
    when(jpaRepository.save(entity)).thenReturn(entity);
    when(mapper.fromEntity(entity)).thenReturn(model);

    // When
    var actual = repository.save(model);

    // Then
    assertThat(actual).isEqualTo(model);
  }
}
