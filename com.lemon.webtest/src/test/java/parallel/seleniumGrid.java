package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class seleniumGrid {


    //selenium grid 无法同时执行，分布测试，想要同时，需要通过多线程启动TestNG 实现），
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // 期望能力对象
        DesiredCapabilities capabilities = new DesiredCapabilities();
//配置测试的浏览器
        capabilities.setBrowserName(BrowserType.FIREFOX);
// hub节点
        String url = "http://192.168.1.222:8888/wd/hub";
//和hub建立通讯，把相应配置传给hub，hub会根据配置选择注册的node节点，打开相应的浏览器进行测试
        WebDriver driver = new RemoteWebDriver(new URL(url), capabilities);
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("柠檬班软件测试");
        Thread.sleep(2000);

    }
}
