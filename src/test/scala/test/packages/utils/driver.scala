package test.packages.utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

trait driver {

  implicit val driver: WebDriver = new ChromeDriver()


}
