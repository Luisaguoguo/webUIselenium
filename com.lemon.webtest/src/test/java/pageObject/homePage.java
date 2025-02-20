package pageObject;

import org.openqa.selenium.By;

public class homePage extends basePage {

    private By logonUserInfo = By.xpath("//a[@class='link-name']");

    public String getUserNameInfo(){
       String userLogonInfo= basePage.getMsg(logonUserInfo);
        return userLogonInfo;
    }

}
