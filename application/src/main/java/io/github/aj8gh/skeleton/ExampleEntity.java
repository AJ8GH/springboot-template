package io.github.aj8gh.skeleton;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExampleEntity {

  @Id
  UUID id;
  String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    ExampleEntity exampleEntity = (ExampleEntity) o;
    return id != null && Objects.equals(id, exampleEntity.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
