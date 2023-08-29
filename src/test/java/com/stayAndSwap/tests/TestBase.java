package com.stayAndSwap.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestBase {

   // protected static AppLicationManager app = new AppLicationManager(System.getProperty
           // ("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    // @BeforeMethod
    @BeforeSuite
    public void setUp (){
        init();

    }


    //@AfterMethod(enabled = false)
    @AfterSuite (enabled = false)
    public void tearDown(){
        stop();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p){
        logger.info("Start test" + m.getName() + "with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result){
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED : " + result.getMethod().getMethodName() + " Screenshot: "
                    + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("==================================================");
    }

}
