package io.github.aj8gh.skeleton.service.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import io.github.aj8gh.skeleton.persistence.repository.JpaSkeletonRepository;
import io.github.aj8gh.skeleton.service.mapper.SkeletonMapper;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SkeletonRepositoryTest {

  private static final UUID ID = UUID.randomUUID();
  private static final Skeleton MODEL = Skeleton.builder().build();
  private static final SkeletonEntity ENTITY = SkeletonEntity.builder().build();
  private static final SkeletonEntity CREATED_ENTITY = ENTITY.toBuilder().id(ID).build();
  private static final Skeleton CREATED_MODEL = MODEL.toBuilder().id(ID).build();

  @Mock
  private JpaSkeletonRepository jpaRepository;

  @Mock
  private SkeletonMapper mapper;

  @InjectMocks
  private SkeletonRepository repository;

  @Test
  void save() {
    // Given
    when(mapper.toEntity(MODEL)).thenReturn(ENTITY);
    when(jpaRepository.save(ENTITY)).thenReturn(CREATED_ENTITY);
    when(mapper.fromEntity(CREATED_ENTITY)).thenReturn(CREATED_MODEL);

    // When
    var actual = repository.save(MODEL);

    // Then
    assertThat(actual).isEqualTo(CREATED_MODEL);
  }
}
