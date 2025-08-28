package com.Stven5490.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        plugin = {
                "pretty",
                // HTML con capturas
                "html:build/reports/cucumber/cucumber.html",
                // JSON por si luego quieres un reporte extra
                "json:build/reports/cucumber/cucumber.json"
        },
        monochrome = true
)
public class testRunner {

}
