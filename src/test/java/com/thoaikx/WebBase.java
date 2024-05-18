package com.thoaikx;

import static com.thoaikx.config.ConfigurationManager.configuration;

import com.thoaikx.driver.DriverManager;
import com.thoaikx.driver.TargetFactory;
import com.thoaikx.report.AllureManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public  abstract class WebBase {
  @BeforeSuite
  public void beforeSuite() {
    AllureManager.setAllureEnvironmentInformation();
  }

  @BeforeMethod(alwaysRun = true)
  @Parameters("browser")
  public void preCondition(@Optional("chrome") String browser) {
    WebDriver driver = new TargetFactory().createInstance(browser);
    DriverManager.setDriver(driver);

    DriverManager.getDriver().get(configuration().url());
  }

  @AfterMethod(alwaysRun = true)
  public void postCondition() {
    DriverManager.quit();
  }
}
