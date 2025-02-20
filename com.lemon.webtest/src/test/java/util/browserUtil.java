package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class browserUtil {
        //driver 需要定义为全局静态变量，需要在全局中对他使用
    public static WebDriver driver;

    //ThreadLocal是为解决多线程的并发问题提供的工具类：
    private static  ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    //当定义方法使用void修饰的时候，也就是什么也不返回，
    public static void openBrowser(String browserName, String url) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriver chromeDriver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
            //向threadlocal 储存driver 对象
           // threadLocal.set(chromeDriver);
            setDriver(chromeDriver);
          // driver=chromeDriver;
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            WebDriver firefoxDriver = new FirefoxDriver();
            firefoxDriver.get(url);
            firefoxDriver.manage().window().fullscreen();
            //多态，父类对象接受子类对象

           // driver=firefoxDriver;
            setDriver(firefoxDriver);


        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
            WebDriver edgeDriver = new EdgeDriver();
            edgeDriver.get(url);
           // driver=edgeDriver;
            setDriver(edgeDriver);
        }

    }

    //从threadlocal 区域里面取到driver 对象
     public static WebDriver getDriver() {
        return threadLocal.get();
     }
    //从threadlocal 区域里面存储driver 对象
     public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
     }

        public static byte[] takeScreenShot(String targetFileName)  {
            //类型强制转换
            TakesScreenshot ts = (TakesScreenshot)driver;
            //OutputType.FILE  返回类型为File（图片）
            File srcFile=ts.getScreenshotAs(OutputType.FILE);
            //给一个目标地址得File 对象
            File descFile=new File(targetFileName);
            //原始得file 对象拷贝到目标地址 第三方依赖commons-io
            try {
                FileUtils.copyFile(srcFile, descFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            return null;
        }



}
