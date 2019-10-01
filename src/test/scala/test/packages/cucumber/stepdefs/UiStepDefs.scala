package test.packages.cucumber.stepdefs

import cucumber.api.scala.{EN, ScalaDsl}
import test.packages.pages.{BasePage, TestData, UiPage}

class UiStepDefs extends ScalaDsl with EN with BasePage {

  Given("""^I navigate to the test website$""") {
    //    navigateTo("http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/")
    //    go to "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/"
    driver.navigate.to("http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/")
  }


  Then("""^I enter the (.*) '(.*)'$""") { (field: String, input: String) =>
    field.toLowerCase() match {
      case "politician name" => UiPage.enterFullName(input)
      case "country" => UiPage.enterCountry(input)
      case "position" => UiPage.enterPosition(input)
      case "source info url" => UiPage.enterSourceInfoUrl(input)
      case _ => throw new IllegalArgumentException(s"You have specified an unknown field")
    }
  }

  And("""^I enter the date of birth of (.*)-(.*)-(.*)$""") { (day: String, month: String, year: String) =>
    UiPage.selectDoB(day, month, year)
  }

  And("""^I select the Risk level to be '(.*)'$""") { level: String =>
    UiPage.selectRiskLevel(level)
  }

  And("""^I click on the save button$""") {
    UiPage.clickOnSave()
  }

  Then("""^a pop up will appear and the name will be correct$""") {
    waitForPopUpBox()
    if (UiPage.getPopUpMessage contains (TestData.store("fullName"))) {
      println(s"${(TestData.store("fullName"))} has been added to the database")
    }
    else {
      print(s"***********!!WARNING!!: ${(TestData.store("fullName"))} has not been added to the database*************")
    }
  }
}
