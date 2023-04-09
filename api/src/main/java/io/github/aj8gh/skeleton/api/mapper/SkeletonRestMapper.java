package io.github.aj8gh.skeleton.api.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import io.github.aj8gh.skeleton.api.model.SkeletonCreateRequest;
import io.github.aj8gh.skeleton.api.model.SkeletonDto;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface SkeletonRestMapper {

  Skeleton fromCreateRequest(SkeletonCreateRequest request);

  SkeletonDto toDto(Skeleton model);
}
