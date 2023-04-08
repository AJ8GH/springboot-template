package io.github.aj8gh.skeleton.componenttest.client;

import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class SkeletonClient {

  private final RestTemplate restTemplate;
  private final String createPath;

  public ResponseEntity<SkeletonDto> create(SkeletonCreateRequest request) {
    return restTemplate.postForEntity(createPath, request, SkeletonDto.class);
  }
}
