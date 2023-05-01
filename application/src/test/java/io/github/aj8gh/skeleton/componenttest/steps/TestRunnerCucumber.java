package io.github.aj8gh.skeleton.componenttest.steps;

import static io.github.aj8gh.skeleton.componenttest.util.Constants.CUCUMBER;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.FEATURES;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.LISTENERS;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.PARTITIONS;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.PORT;
import static io.github.aj8gh.skeleton.componenttest.util.Constants.TEST;
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
@IncludeEngines(CUCUMBER)
@SelectClasspathResource(FEATURES)
@CucumberContextConfiguration
@AutoConfigureEmbeddedDatabase
@ActiveProfiles(TEST)
@EmbeddedKafka(brokerProperties = {LISTENERS}, ports = {PORT}, partitions = PARTITIONS)
@SpringBootTest(classes = {Application.class, CucumberConfig.class}, webEnvironment = DEFINED_PORT)
public class TestRunnerCucumber {
}
