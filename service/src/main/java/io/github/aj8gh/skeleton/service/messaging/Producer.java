package io.github.aj8gh.skeleton.service.messaging;

import io.github.aj8gh.skeleton.messaging.SkeletonProducer;
import io.github.aj8gh.skeleton.service.mapper.SkeletonMapper;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

  private final SkeletonMapper mapper;
  private final SkeletonProducer skeletonProducer;

  public void send(Skeleton model) {
    skeletonProducer.send(mapper.toEvent(model));
  }
}
