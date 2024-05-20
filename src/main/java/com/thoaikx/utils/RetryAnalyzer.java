package com.thoaikx.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer  implements IRetryAnalyzer {

  private  final  int MAX_RETRIRS = 3;
  private   int retryCount = 0 ;
  @Override
  public boolean retry(ITestResult result) {
    if (retryCount <= MAX_RETRIRS){
      retryCount ++ ;
      return  true;
    }
    return  false;
  }

//  example using

  @Test(retryAnalyzer = RetryAnalyzer.class)
  private  void  testRetry (){
  }
}
