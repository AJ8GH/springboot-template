package io.github.aj8gh.skeleton.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class SkeletonEntity {

  @Id
  @UuidGenerator
  @GeneratedValue
  private UUID id;

  private String name;
  private int bones;

  @CreationTimestamp
  @GeneratedValue
  private Instant createdAt;

  @UpdateTimestamp
  @GeneratedValue
  private Instant updatedAt;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SkeletonEntity that = (SkeletonEntity) o;
    return bones == that.bones
        && Objects.equals(id, that.id)
        && Objects.equals(createdAt, that.createdAt)
        && Objects.equals(updatedAt, that.updatedAt)
        && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdAt, updatedAt, name, bones);
  }
}
