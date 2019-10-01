package test.packages.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import test.packages.pages.{ApiSteps, BasePage}

class ApiStepDefs extends ScalaDsl with EN with BasePage {
  Given("""^I have added a politician to the database via the API$""") {
    ApiSteps.insertNewData
  }


//  Then("""^I can retrieve the latest 5 politicians$""") {
//    ApiSteps.getLatestFivePoliticians
//  }

  Then("""^I grab the latest Politician from the list$""") {
    ApiSteps.getPolitician
  }

}
