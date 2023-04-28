package io.github.aj8gh.skeleton.componenttest.config;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import io.github.aj8gh.skeleton.componenttest.client.SkeletonClient;
import io.github.aj8gh.skeleton.componenttest.context.ScenarioContext;
import io.github.aj8gh.skeleton.componenttest.kafka.Consumer;
import io.github.aj8gh.skeleton.componenttest.kafka.TestProducer;
import io.github.aj8gh.skeleton.messaging.event.SkeletonCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@TestConfiguration
public class CucumberConfig {

  @Value("${api.root-uri}")
  private String rootUri;

  @Value("${api.port}")
  private String port;

  @Value("${api.path.create}")
  private String createPath;

  @Value("${spring.security.user.name}")
  private String username;

  @Value("${spring.security.user.password}")
  private String password;

  @Value("${kafka.topics.skeleton-created-v1.name}")
  private String topicName;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder()
        .rootUri(getRootUriWithPort())
        .defaultHeader(CONTENT_TYPE, APPLICATION_JSON.toString())
        .basicAuthentication(username, password)
        .build();
  }

  @Bean
  public SkeletonClient skeletonClient() {
    return new SkeletonClient(restTemplate(), createPath);
  }

  @Bean
  public ScenarioContext scenarioContext() {
    return new ScenarioContext();
  }

  @Bean
  public Consumer consumer() {
    return new Consumer();
  }

  @Bean
  public TestProducer testProducer(KafkaTemplate<String, SkeletonCreatedEvent> kafkaTemplate) {
    return new TestProducer(topicName, kafkaTemplate);
  }

  private String getRootUriWithPort() {
    return new DefaultUriBuilderFactory()
        .uriString(rootUri)
        .port(port)
        .build()
        .toString();
  }
}
