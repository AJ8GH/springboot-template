package io.github.aj8gh.api.controller;

import io.github.aj8gh.skeleton.api.controller.SkeletonApi;
import io.github.aj8gh.skeleton.api.model.Skeleton;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkeletonController implements SkeletonApi {

  @Override
  public ResponseEntity<Skeleton> create(SkeletonCreateRequest skeletonCreateRequest) {
    return null;
  }
}
