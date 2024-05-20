package com.thoaikx;

import static com.thoaikx.config.ConfigurationManager.configuration;

import com.thoaikx.driver.DriverManager;
import com.thoaikx.driver.TargetFactory;
import com.thoaikx.report.AllureManager;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteResult;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public  abstract class WebBase {
  WebDriver driver ;
  @BeforeSuite
  public void beforeSuite() {
    AllureManager.setAllureEnvironmentInformation();
  }

  @BeforeMethod(alwaysRun = true)
  @Parameters("browser")
  public void preCondition(@Optional("chrome") String browser) {
    driver = new TargetFactory().createInstance(browser);
    DriverManager.setDriver(driver);
    DriverManager.getDriver().get(configuration().url());
  }

  @AfterMethod(alwaysRun = true)
  public void postCondition() {
    DriverManager.quit();
  }

  public  void teardown (ITestResult result){
    if(result.getStatus() == ITestResult.FAILURE){

    }
  }

}
