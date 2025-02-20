package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.browserUtil;

public class basePage {

    //页面的父类

    //封装得显示等待
    public static WebElement visibleWaitElement(By locator) {
        WebDriverWait webDriverWait=new WebDriverWait(browserUtil.driver,5);
        WebElement webElement=webDriverWait.until(ExpectedConditions.
                visibilityOfElementLocated(locator));
        return webElement;
    }

    public static WebElement waitElementClick(By locator) {
        WebDriverWait webDriverWait=new WebDriverWait(browserUtil.driver,5);
        WebElement webElement=webDriverWait.until(ExpectedConditions.
                elementToBeClickable(locator));
        return webElement;
    }

    public static void clickElement(By locator) {
        waitElementClick(locator).click();
    }

    public static void sendText(By locator, String text) {
        visibleWaitElement(locator).sendKeys(text);
    }

    public static String getMsg(By locator) {
        String actualErrorMsg=basePage.waitElementClick(locator).getText();
        return actualErrorMsg;
    }
}
