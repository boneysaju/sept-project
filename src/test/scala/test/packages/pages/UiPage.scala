package test.packages.pages

import org.openqa.selenium.{By, Keys}

object UiPage extends BasePage {

  val politicianDatabaseUrl = "http://ec2-34-250-139-60.eu-west-1.compute.amazonaws.com/"

  def navigateToNewEntityPage: Unit = {
    go to politicianDatabaseUrl
  }

  def enterFullName(name: String) = {
    textField("fullName", name)
    TestData.addToStore("fullName", name)
  }


  def enterCountry(country: String) = textField("country", country)


  def enterPosition(position: String) = {
    click on "position"
    driver.findElement(By.id("position")).sendKeys(position)
  }

  def enterSourceInfoUrl(url: String) = textField("url", url)


  def selectRiskLevel(riskLevel: String) = {
    click on "risk"
    riskLevel.toLowerCase() match{
      case "low" => driver.findElement(By.cssSelector("#risk > option:nth-child(1)")).click()
      case "medium" => driver.findElement(By.cssSelector("#risk > option:nth-child(2)")).click()
      case "high" => driver.findElement(By.cssSelector("#risk > option:nth-child(3)")).click()
      case "huge" => driver.findElement(By.cssSelector("#risk > option:nth-child(4)")).click()
      case _ => throw new IllegalArgumentException(s"You have specified an unknown risk level")

    }}


  def selectDoB(day: String, month: String, year: String) = {
    val dobTextField = driver.findElement(By.name("yob")).sendKeys(day + month + year)
    driver.findElement(By.name("yob")).sendKeys(Keys.ENTER)


  }

  def clickOnSave() = click on cssSelector("#root > div > div > form > button")

  def getPopUpMessage = driver.findElement(By.cssSelector("body > div:nth-child(6) > div > div.modal.fade.show > div > div > div.modal-body")).getText


}
