package io.github.aj8gh.skeleton;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExampleRepository extends JpaRepository<ExampleEntity, UUID> {
}
