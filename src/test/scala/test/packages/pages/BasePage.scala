package test.packages.pages

import org.junit.{After, Before}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.Matchers
import org.scalatest.selenium.WebBrowser
import test.packages.utils.SingletonDriver

trait BasePage extends Matchers with WebBrowser {

  implicit val driver: WebDriver = SingletonDriver.getInstance()

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
    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")))
  }

  @Before
  def beforeEachScenario(): Unit = {
    driver.manage().deleteAllCookies()
    driver.manage().window().maximize()
  }

  @After
  def tearDown() = {
    sys.addShutdownHook(driver.quit())
  }


}

