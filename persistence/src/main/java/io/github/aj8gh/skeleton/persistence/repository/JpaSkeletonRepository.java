package io.github.aj8gh.skeleton.persistence.repository;

import io.github.aj8gh.skeleton.persistence.entity.SkeletonEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSkeletonRepository extends JpaRepository<SkeletonEntity, UUID> {
}
