package test.packages.pages

import org.openqa.selenium.By

object UiPage extends BasePage {

  val politicianDatabaseUrl = "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/"

  def navigateToNewEntityPage: Unit = {
    go to politicianDatabaseUrl
  }

  def enterFullName(name: String) = textField("fullName", name)


  def enterCountry(country: String) = textField("country", country)


  def enterPosition(position: String) = textField("position", position)


  def enterSourceInfoUrl(url: String) = textField("url", url)


  def selectRiskLevel(riskLevel: String) = {
    click on "risk"
    driver.findElement(By.linkText(riskLevel))
  }


  def selectDoB(day: String, month: String, year: String) = {
    click on name("yob")
    val dobTextField = driver.findElement(By.name("yob")).click()

  }

  def clickOnSave() = click on cssSelector("#root > div > div > form > button")

  def getPopUpMessage = driver.findElement(By.cssSelector("body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body")).getText



}
