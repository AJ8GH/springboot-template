package io.github.aj8gh.skeleton.api.controller;

import io.github.aj8gh.skeleton.api.model.Skeleton;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SkeletonController implements SkeletonApi {

  @Override
  public ResponseEntity<Skeleton> create(SkeletonCreateRequest request) {
    log.info("*** Create: ***\n{}", request);
    return null;
  }
}
