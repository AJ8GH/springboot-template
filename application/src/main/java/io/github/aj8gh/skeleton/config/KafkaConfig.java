package io.github.aj8gh.skeleton.config;

import io.github.aj8gh.skeleton.messaging.SkeletonProducer;
import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConfig {

  @Value("${kafka.topics.skeleton-created-v1.name}")
  private String skeletonCreatedTopic;

  @Value("${kafka.topics.skeleton-created-v1.partitions}")
  private int skeletonCreatedPartitions;

  @Value("${kafka.topics.skeleton-created-v1.replicas}")
  private int skeletonCreatedReplicas;

  @Bean
  public KafkaAdmin.NewTopics topics() {
    return new KafkaAdmin.NewTopics(
        TopicBuilder.name(skeletonCreatedTopic)
            .partitions(skeletonCreatedPartitions)
            .replicas(skeletonCreatedReplicas)
            .build());
  }

  @Bean
  SkeletonProducer skeletonProducer(KafkaTemplate<String, SkeletonCreatedEvent> template) {
    return new SkeletonProducer(skeletonCreatedTopic, template);
  }
}
