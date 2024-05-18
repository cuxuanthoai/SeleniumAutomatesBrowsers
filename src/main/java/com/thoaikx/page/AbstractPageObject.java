package com.thoaikx.page;

import static com.thoaikx.config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

import com.thoaikx.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class AbstractPageObject  {

 protected WebDriver driver;
  protected AbstractPageObject() {
    driver = DriverManager.getDriver();
  }

}
