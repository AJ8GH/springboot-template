package io.github.aj8gh.template.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloWorldTest {

  @Test
  void helloWorld() {
    assertEquals("Hello, World!", new HelloWorld().helloWorld());
  }
}
