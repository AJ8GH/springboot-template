package io.github.aj8gh.skeleton.componenttest.config;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import io.github.aj8gh.skeleton.componenttest.client.SkeletonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@TestConfiguration
public class ClientConfig {

  @Value("${api.root-uri}")
  private String rootUri;

  @Value("${api.path.create}")
  private String createPath;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplateBuilder()
        .rootUri(rootUri)
        .defaultHeader(CONTENT_TYPE, APPLICATION_JSON.toString())
        .build();
  }

  @Bean
  public SkeletonClient skeletonClient() {
    return new SkeletonClient(restTemplate(), createPath);
  }
}
