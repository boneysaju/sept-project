package test.packages.utils

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver


object SingletonDriver {

  private val systemProperties = System.getProperties
  private var instanceOption: Option[WebDriver] = None
  private var baseWindowHandleOption: Option[String] = None

  def getInstance(): WebDriver = instanceOption getOrElse initialiseBrowser()


  private def initialiseBrowser(): WebDriver = {
    val instance = newWebDriver()
    baseWindowHandleOption = Some(instance.getWindowHandle)
    instanceOption = Some(instance)
    instance.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
    instance
  }

  def newWebDriver(): WebDriver = {
    val selectedDriver = Option(systemProperties.getProperty("browser", "chrome")).map(_.toLowerCase) match {
      case Some("firefox") ⇒ createFirefoxDriver()
      case Some("chrome") ⇒ createChromeDriver(false)
      case Some(other) ⇒ throw new IllegalArgumentException(s"Unrecognised browser: $other")
      case None ⇒ throw new IllegalArgumentException("No browser set")
    }
    selectedDriver
  }

  private def createFirefoxDriver(): WebDriver = {
    new FirefoxDriver()
  }


  private def createChromeDriver(headless: Boolean): WebDriver = {
    new ChromeDriver()
  }

}
