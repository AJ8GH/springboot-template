package io.github.aj8gh.skeleton.service.repository;

import io.github.aj8gh.skeleton.persistence.repository.JpaSkeletonRepository;
import io.github.aj8gh.skeleton.service.mapper.SkeletonMapper;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SkeletonRepository {

  private final JpaSkeletonRepository repository;
  private final SkeletonMapper mapper;

  public Skeleton save(Skeleton skeleton) {
    var entity = mapper.toEntity(skeleton);
    var saved = repository.save(entity);
    return mapper.fromEntity(saved);
  }
}
