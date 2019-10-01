package test.packages.pages

import cucumber.api.Scenario
import org.junit.{After, Before}
import org.openqa.selenium.{By, OutputType, TakesScreenshot, WebDriverException}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest.Matchers
import org.scalatest.selenium.WebBrowser
import test.packages.utils.driver

trait BasePage extends driver with Matchers with WebBrowser {


  def navigateTo(url: String): Unit = driver.navigate().to(url)

  def textField(id: String, value: String): Unit = {
    val elem = find(id)
    if (elem.isDefined) {
      val e = new TextField(elem.get.underlying)
      if (e.isDisplayed) e.value = value
    }
  }

  def waitForPopUpBox() = {
    val driverWait: WebDriverWait = new WebDriverWait(driver, 90)
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")))
  }

  @Before
  def beforeEachScenario(): Unit = {
    driver.manage().deleteAllCookies()
    driver.manage().window().maximize()
  }

  @After
  def tearDown(result: Scenario) {
    if (result.isFailed) driver match {
      case screenshot1: TakesScreenshot =>
        try {
          val screenshot = screenshot1.getScreenshotAs(OutputType.BYTES)
          result.embed(screenshot, "image/png")
        } catch {
          case somePlatformsDontSupportScreenshots: WebDriverException =>
            System.err.println(somePlatformsDontSupportScreenshots.getMessage)
        }
      case _ =>
    }
  }

}

