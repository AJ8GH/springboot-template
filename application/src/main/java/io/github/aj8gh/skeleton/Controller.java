package io.github.aj8gh.skeleton;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

  private final ExampleRepository exampleRepository;

  @PostMapping("/create")
  public ExampleEntity create() {
    var ent = ExampleEntity.builder().name("ent1").id(UUID.randomUUID()).build();
    exampleRepository.saveAndFlush(ent);
    log.info("successfully created ent {}", ent);
    return ent;
  }

  @GetMapping("/findAll")
  public List<ExampleEntity> get() {
    log.info("Finding all ents...");
    return exampleRepository.findAll();
  }
}
