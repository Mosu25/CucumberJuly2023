package org.mosu.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features/addToCart.feature",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        glue = {"org.mosu.stepdefs", "org.mosu.hooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@prod or @test"
//        plugin = {"html:cucumber/Report.html"}

)
public class AddToCartTestRunner extends AbstractTestNGCucumberTests {

}
