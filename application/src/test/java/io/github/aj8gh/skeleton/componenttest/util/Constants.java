package io.github.aj8gh.skeleton.componenttest.util;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class Constants {

  /**
   * Profiles
   */
  public static final String TEST = "test";

  /**
   * Cucumber
   */
  public static final String CUCUMBER = "cucumber";
  public static final String FEATURES = "features";

  /**
   * Embedded Kafka
   */
  public static final String LISTENERS = "listeners=PLAINTEXT://${spring.kafka.bootstrap-servers}";
  public static final int PARTITIONS = 1;

  /**
   * Model
   */
  public static final String NAME = "name";
  public static final String BONES = "bones";
  public static final String ID = "id";
  public static final String CREATED_AT = "createdAt";
  public static final String UPDATED_AT = "updatedAt";

}
