package io.github.aj8gh.skeleton.api.controller;

import io.github.aj8gh.skeleton.api.mapper.SkeletonRestMapper;
import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import io.github.aj8gh.skeleton.service.SkeletonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SkeletonController implements SkeletonApi {

  private static final int RESOURCE_CREATED = 201;

  private final SkeletonService service;
  private final SkeletonRestMapper mapper;

  @Override
  public ResponseEntity<SkeletonDto> create(SkeletonCreateRequest request) {
    var model = service.create(mapper.fromCreateRequest(request));
    var dto = mapper.toDto(model);
    return new ResponseEntity<>(dto, HttpStatusCode.valueOf(RESOURCE_CREATED));
  }
}
