package com.thoaikx.test;

import com.thoaikx.WebBase;
import com.thoaikx.page.ExamTopicPage;
import java.io.IOException;
import org.testng.annotations.Test;

public class GetDumpTest extends WebBase {

  @Test()
  public  void getDumps() throws InterruptedException, IOException {
    var examTopicPage = new ExamTopicPage();
    examTopicPage.getDump();
  }
}
