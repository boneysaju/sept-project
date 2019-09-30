package test.packages.cucumber.Runner

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
features = Array("src/test/resources/feature"),
glue = Array("test.packages.cucumber.stepdefs"),
format = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json"),
tags = Array("~@wip")
)
class Runner {
}
