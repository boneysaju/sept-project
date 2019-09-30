package pages


import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest.Matchers
import org.scalatest.selenium.WebBrowser
import utils.driver

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


}
