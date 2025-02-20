package workFlow;


import pageObject.logonPage;

public class loginFlow {
   // private String mobilePhone;
   // private String password;


    /*public void logonFlow(String mobilePhone, String password) {
        this.mobilePhone = mobilePhone;
        this.password = password;

    }

     */


    public void logonFlow(String mobilePhone, String password) {
        logonPage logonPage=new logonPage();
        logonPage.inputMobilePhone(mobilePhone);
        logonPage.inputPassWord(password);
        logonPage.clickLogonWindowButton();
    }
}
