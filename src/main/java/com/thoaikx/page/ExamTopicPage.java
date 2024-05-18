package com.thoaikx.page;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v122.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.print.PrintOptions;


@Slf4j
public class ExamTopicPage  extends  AbstractPageObject{

  public final String googleSearchTextEdit = "//textarea[@id='APjFqb']" ;
  public final String firstResult = "//h3[contains( text() ,'Exam 1z0-900 topic ')]";
  //"//h4/a[contains(text(),'SAP M')]"
  public  final String showbutton = "//a[@class = 'btn btn-primary reveal-solution']";

  WebElement first ;
  Boolean firstCheck ;
  //



/*  This doesn't answert the question directly but I would have thought using SendKeys in the WebElement class would have been better,
 since you already have the WebElement object in memory, why do you need to create an Actions object?
  I have always used the WebElement.SendKeys() method and I have not found any uses to switch over to using the Actions class for
  sending over a regular string.
  I would use the Actions class when I require more complex scenarios e.g. Need to hold down a button or drag something.*/
  public  void  getDump() throws InterruptedException, IOException {

    for (int i = 1; i < 142; i++) {
      WebElement google = driver.findElement(By.xpath(googleSearchTextEdit));
      wait.until(a -> google.isDisplayed());
      Thread.sleep(500);
      String testText = "exam 1z0-900 topic 1 question " +i;
      google.sendKeys(testText);
      google.sendKeys(Keys.ENTER);
      Thread.sleep(500);
      firstCheck = driver.findElement(By.xpath(firstResult)).isDisplayed();
      first = driver.findElement(By.xpath(firstResult));

      Thread.sleep(500);
        if(!firstCheck) {
          continue;
        }
        wait.until(a -> first.isDisplayed());
        first.click();
        }
      WebElement showButton = driver.findElement(By.xpath(showbutton));
    log.error(showbutton);
      wait.until(s -> showButton.isDisplayed());
      showButton.click();
      Pdf pdf = ((PrintsPage) driver).print(new PrintOptions());
      Files.write(Paths.get(nameFile()), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
      Thread.sleep(2000);
      driver.get("https://www.google.com/");
    }

  private  static String nameFile(){
    Random rand = new Random();
    int rand_int1 = rand.nextInt(1000);
    String nameFile =  "C:\\Users\\ad\\Downloads\\pdf\\test"+System.currentTimeMillis() +".pdf" ;
    return  nameFile;
  }
}
