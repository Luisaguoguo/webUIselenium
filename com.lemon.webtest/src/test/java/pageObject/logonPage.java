package pageObject;


import org.openqa.selenium.By;

public class logonPage extends basePage{
    //创建一个By 对象，对页面元素进行定位
    //page 页面只有元素的属性和行为

    private By logonButtonBy=By.xpath("//*[text()='登录']");

    private By mobilePhoneBy=By.xpath("//*[@placeholder=\"请输入手机号/用户名\"]");

    private By passWordBy=By.xpath("//*[@placeholder=\"请输入密码\"]");


    private By getErrorLogonMsg=By.xpath("(//div[@class='error'])[1]");


    private By logonWindowButtonBy=By.xpath("//a[@class='login-button']");

    private By errorUserNamePwd=By.className("el-message__content");

    //输入手机号码


    public void inputMobilePhone(String mobilePhone){
        //需要对driver 进行操作，输入，在原先文件中需要将driver 定义成静态，然后对其进行操作
       // logon.driver.findElement(mobilePhoneBy).sendKeys(mobilePhone); driver 重新放到util中进行调用
      //  browserUtil.driver.findElement(mobilePhoneBy).sendKeys(mobilePhone);
        //对代码进行二次优化,不需要强制等待，只需要显示等待
       sendText(mobilePhoneBy,mobilePhone);
       //继续优化

    }

    public void inputPassWord(String passWord){
       // logon.driver.findElement(passWordBy).sendKeys(passWord);
       // browserUtil.driver.findElement(passWordBy).sendKeys(passWord);
       // basePage.visibleWaitElement(passWordBy).sendKeys(passWord);
      sendText(passWordBy,passWord);
    }

    public void clickLogonButton(){
        //logon.driver.findElement(logonButtonBy).click();
       // browserUtil.driver.findElement(logonButtonBy).click();
        //basePage.waitElementClick(logonButtonBy);
       clickElement(logonButtonBy);

    }

    public void clickLogonWindowButton(){
        clickElement(logonWindowButtonBy);
    }



    public String getUseNameErrorMsg(){
        String usernameErrorMsg=logonPage.visibleWaitElement(getErrorLogonMsg).getText();
        return usernameErrorMsg;
    }



    public String getErrorUserNamePwdMsg(){
       String actualResult=basePage.getMsg(errorUserNamePwd);
        return actualResult;
    }
}
