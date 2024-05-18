package com.thoaikx.page;

import static com.thoaikx.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

import com.thoaikx.driver.DriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPageObject  {

 protected WebDriver driver;
protected Wait<WebDriver> wait ;
  protected AbstractPageObject() {
    driver = DriverManager.getDriver();
    wait = new WebDriverWait(driver,Duration.ofSeconds(configuration().timeout()));
  }

}
