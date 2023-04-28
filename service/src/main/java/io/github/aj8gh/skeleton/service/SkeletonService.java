package io.github.aj8gh.skeleton.service;

import io.github.aj8gh.skeleton.service.messaging.Producer;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import io.github.aj8gh.skeleton.service.repository.SkeletonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkeletonService {

  private final SkeletonRepository repository;
  private final Producer producer;

  public Skeleton create(Skeleton skeleton) {
    var model = repository.save(skeleton);
    producer.send(model);
    return model;
  }
}
