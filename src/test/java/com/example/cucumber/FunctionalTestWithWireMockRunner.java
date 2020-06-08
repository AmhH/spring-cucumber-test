package com.example.cucumber;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json",
                "junit:target/cucumber/cucumber.xml"},
        features = "src/test/java/com/example/cucumber/feature",
        glue = "stepdefinition",
        strict = true
)
public class FunctionalTestWithWireMockRunner {

    private static WireMockServer mockServer;

    @BeforeClass
    public static void setUp(){
        WireMockConfiguration configuration = new WireMockConfiguration();
        configuration.port(2131);
        configuration.usingFilesUnderClasspath("src/test/resources/mock");
        mockServer = new WireMockServer(configuration);
        mockServer.start();
    }

    @AfterClass
    public static void tearDown() {
        mockServer.stop();
    }
}
