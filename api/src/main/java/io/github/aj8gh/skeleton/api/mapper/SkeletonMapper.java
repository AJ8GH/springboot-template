package io.github.aj8gh.skeleton.api.mapper;

import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import org.mapstruct.Mapper;

@Mapper
public interface SkeletonMapper {

  Skeleton fromCreateRequest(SkeletonCreateRequest request);

  SkeletonDto toDto(Skeleton model);
}
