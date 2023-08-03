package org.mosu.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features/addToCart.feature",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        glue = {"org.mosu.stepdefs", "org.mosu.hooks"},
        plugin = {"html:cucumber/Report.html"}

)
public class Runner extends AbstractTestNGCucumberTests {


}
