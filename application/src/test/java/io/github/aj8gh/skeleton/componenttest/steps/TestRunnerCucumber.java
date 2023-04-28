package io.github.aj8gh.skeleton.componenttest.steps;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import io.cucumber.spring.CucumberContextConfiguration;
import io.github.aj8gh.skeleton.Application;
import io.github.aj8gh.skeleton.componenttest.config.CucumberConfig;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberContextConfiguration
@AutoConfigureEmbeddedDatabase
@ActiveProfiles("test")
@EmbeddedKafka(
    brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" },
    partitions = 1)
@SpringBootTest(
    classes = {Application.class, CucumberConfig.class},
    webEnvironment = DEFINED_PORT)
public class TestRunnerCucumber {
}
