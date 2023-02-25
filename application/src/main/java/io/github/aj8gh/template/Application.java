package io.github.aj8gh.template;

import io.github.aj8gh.template.hello.HelloWorld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

  private static final String HELLO_WORLD = new HelloWorld().helloWorld();

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    log.info(HELLO_WORLD);
    log.warn(HELLO_WORLD);
    log.error(HELLO_WORLD);
  }
}
