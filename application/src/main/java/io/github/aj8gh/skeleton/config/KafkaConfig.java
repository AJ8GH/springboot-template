package io.github.aj8gh.skeleton.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfig {

  @Value("${kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Bean
  public KafkaAdmin admin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    return new KafkaAdmin(configs);
  }

  @Bean
  public KafkaAdmin.NewTopics topics() {
    return new KafkaAdmin.NewTopics(
        TopicBuilder.name("test-1")
            .replicas(1)
            .partitions(1)
            .build(),
        TopicBuilder.name("test-2")
            .replicas(1)
            .partitions(1)
            .build());
  }
}
