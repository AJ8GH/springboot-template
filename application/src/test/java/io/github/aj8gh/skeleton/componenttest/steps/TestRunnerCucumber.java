package io.github.aj8gh.skeleton.componenttest.steps;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import io.cucumber.spring.CucumberContextConfiguration;
import io.github.aj8gh.skeleton.Application;
import io.github.aj8gh.skeleton.componenttest.config.ClientConfig;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@Suite
@SpringBootTest(webEnvironment = DEFINED_PORT, classes = {Application.class, ClientConfig.class})
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberContextConfiguration
@AutoConfigureEmbeddedDatabase
public class TestRunnerCucumber {
}
