package io.github.aj8gh.skeleton.service.model;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Skeleton {

  UUID id;
  String name;
  long bones;
  Instant createdAt;
  Instant updatedAt;
}
