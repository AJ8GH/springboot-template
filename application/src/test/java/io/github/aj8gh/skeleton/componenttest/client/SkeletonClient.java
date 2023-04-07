package io.github.aj8gh.skeleton.componenttest.client;

import io.github.aj8gh.skeleton.api.model.Skeleton;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class SkeletonClient {

  private final RestTemplate restTemplate;
  private final String createPath;

  public ResponseEntity<Skeleton> create(SkeletonCreateRequest request) {
    return restTemplate.postForEntity(createPath, request, Skeleton.class);
  }
}
