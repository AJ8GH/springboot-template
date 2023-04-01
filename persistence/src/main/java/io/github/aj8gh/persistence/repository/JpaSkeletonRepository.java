package io.github.aj8gh.persistence.repository;

import io.github.aj8gh.persistence.entity.SkeletonEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSkeletonRepository extends JpaRepository<UUID, SkeletonEntity> {
}
