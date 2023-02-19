package io.github.aj8gh.template;

import io.github.aj8gh.template.hello.HelloWorld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

  private static final HelloWorld HELLO_WORLD = new HelloWorld();

  public static void main(String[] args) {
    log.info(HELLO_WORLD.helloWorld());
    SpringApplication.run(Application.class);
  }
}
