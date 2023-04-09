package io.github.aj8gh.skeleton.service.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import io.github.aj8gh.skeleton.service.model.Skeleton;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface SkeletonMapper {

  SkeletonEntity toEntity(Skeleton model);

  Skeleton fromEntity(SkeletonEntity entity);
}
