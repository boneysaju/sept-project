package stepDefs

import cucumber.api.scala.{EN, ScalaDsl}
import pages.{BasePage, UiPage}

class UiStepDefs extends ScalaDsl with EN with BasePage {

  Given("""^I navigate to the test website$""") {
    UiPage.navigateToNewEntityPage
  }


  Then("""^I enter the (.*) '(.*)'$""") { (field: String, input: String) =>
    field.toLowerCase() match {
      case "politician name" => UiPage.enterFullName(input)
      case "country" => UiPage.enterCountry(input)
      case "position" => UiPage.enterPosition(input)
      case "source info url" => UiPage.enterSourceInfoUrl(input)

    }
  }

  And("""^I enter the date of birth of (.*)-(.*)-(.*)$""") { (day: String, month: String, year: String) =>
    UiPage.selectDoB(day, month, year)
  }

  And("""^I select the Risk level to be '(.*)'$""") { level =>
    UiPage.selectRiskLevel(level)
  }

  And("""^I click on the save button$""") {
    UiPage.clickOnSave()
  }

  Then("""^a pop up will appear$""") {
    waitForPopUpBox()
    if (UiPage.getPopUpMessage contains "Terry Lawrence") {
      println("Terry Lawrence has been added to the database")
    }
    else {
      print("Terry Lawrence has not been added to the database")
    }
  }

}
