package io.github.aj8gh.skeleton.componenttest.steps;

import io.cucumber.spring.CucumberContextConfiguration;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@Suite
@SpringBootTest
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberContextConfiguration
@AutoConfigureEmbeddedDatabase
public class TestRunnerCucumber {
}
