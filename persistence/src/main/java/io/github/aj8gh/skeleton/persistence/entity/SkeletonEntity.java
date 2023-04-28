package io.github.aj8gh.skeleton.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "skeleton")
@Getter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SkeletonEntity {

  @Id
  @UuidGenerator
  @GeneratedValue
  @EqualsAndHashCode.Include
  private UUID id;

  private String name;
  private int bones;

  @CreationTimestamp
  @GeneratedValue
  private Instant createdAt;

  @UpdateTimestamp
  @GeneratedValue
  private Instant updatedAt;
}
