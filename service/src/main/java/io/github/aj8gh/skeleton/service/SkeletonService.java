package io.github.aj8gh.skeleton.service;

import io.github.aj8gh.skeleton.service.model.Skeleton;
import io.github.aj8gh.skeleton.service.repository.SkeletonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkeletonService {

  private final SkeletonRepository repository;

  public Skeleton create(Skeleton skeleton) {
    return repository.save(skeleton);
  }
}
