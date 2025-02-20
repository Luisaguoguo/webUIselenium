package webtest.logontestcase;


import io.qameta.allure.Feature;
import javafx.scene.layout.Priority;
import listener.testNGRetry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.basePage;
import pageObject.homePage;
import pageObject.logonPage;
import testDatas.datas;
import util.browserUtil;
import util.constantsUtil;
import workFlow.loginFlow;

public class logon extends basePage {

    private String browserName;
    //参数通过paramter 传入，在testNG file中配置.

//Parameter 'browserName' is required by BeforeTest on method
// setuptest but has not been marked @Optional or defined
//in
// setuptest but has not been marked @Optional or defined

    @BeforeMethod
    @Parameters("browserName")
    public void setuptest(String browserName) throws InterruptedException {
        //browserUtil.driver.openBrowser(browserName, constantsUtil.URL);
        browserUtil.openBrowser(browserName, constantsUtil.URL);


        //工具不需要实例化
        Thread.sleep(3000);
        logonPage logonPage = new logonPage();
        logonPage.clickLogonButton();
    }


    @Test(priority = 1, dataProviderClass = datas.class, dataProvider = "pwdSuccessData")
    public void logontestcase(String mobilePhone, String pwd, String expectedResult) throws InterruptedException {
        //driver 是全局变量
       /* driver.findElement(By.xpath("//*[text()='登录']")).click();
        Thread.sleep(2000);
        //请输入手机号/用户名
        driver.findElement(By.xpath("//*[@placeholder=\"请输入手机号/用户名\"]")).sendKeys("18629486979");
        driver.findElement(By.xpath("//*[@placeholder=\"请输入密码\"]")).sendKeys("Annika123!");

        driver.findElement(By.className("login-button")).click();

        //对哪个页面进行操作，则创建对应页面得对象，对对象进行操作实例化
        logonPage logonPage=new logonPage();
        logonPage.inputMobilePhone(mobilePhone);
        logonPage.inputPassWord(pwd);
        logonPage.clickLogonWindowButton();
        Thread.sleep(2000);

        */
        loginFlow loginFlow = new loginFlow();
        loginFlow.logonFlow(mobilePhone, pwd);
        // go to home page, 做断言

        //browserUtil.driver.getCurrentUrl(); //工具类名.类名，进行实例化操作

        //WebElement expectedResult=driver.findElement(By.className("link-name"));
        // WebDriverWait webDriverWait=new WebDriverWait(browserUtil.driver,5);
        // WebElement webElement=webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'18629486979')]")));


        homePage homePage = new homePage();
        Assert.assertEquals(homePage.getUserNameInfo(), expectedResult);
        // System.out.println(webElement.getText());
//browserUtil.takeScreenShot("C:\\Users\\Administrator\\Desktop\\testImage\\happy.png");
    }


    @Test(dataProviderClass = datas.class, dataProvider = "failureData",retryAnalyzer = testNGRetry.class)
    //使用datas 这个类，指定数据类的位置

    public void failedUsernameTest(String mobile, String password, String expectedResult) throws InterruptedException {
        loginFlow loginFlow01 = new loginFlow();
        loginFlow01.logonFlow(mobile, password);

        logonPage logonPage = new logonPage();
        Assert.assertEquals(logonPage.getUseNameErrorMsg(), expectedResult);
        Thread.sleep(2000);
       // browserUtil.takeScreenShot("C:\\Users\\Administrator\\Desktop\\testImage\\failedUsernameTest.png");
    }

    @Test(dataProviderClass = datas.class, dataProvider = "pwdErrorData")
    public void failedPasswordTest(String mobile, String password, String expectedResult) throws InterruptedException {
        loginFlow loginFlow02 = new loginFlow();
        loginFlow02.logonFlow(mobile, password);

        logonPage logonPage = new logonPage();
        /* 对logon流程进行封装

        logonPage.inputMobilePhone(mobile);
        logonPage.inputPassWord(password);
        logonPage.clickLogonWindowButton();
         */

        Assert.assertEquals(logonPage.getErrorUserNamePwdMsg(), expectedResult);
      //  browserUtil.takeScreenShot("C:\\Users\\Administrator\\Desktop\\testImage\\failedPasswordTest.png");
    }
    //

    //关闭浏览器，资源销毁
    @AfterMethod
    public void teardowntest() {
        browserUtil.driver.quit();

    }


}
