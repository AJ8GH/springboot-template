package io.github.aj8gh.template;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTest {

  @Test
  void main() {
    assertThatNoException().isThrownBy(() ->
        Application.main(new String[] {}));
  }
}
