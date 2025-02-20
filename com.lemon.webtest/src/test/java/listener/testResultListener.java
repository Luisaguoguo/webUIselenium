package listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import util.browserUtil;

public class testResultListener extends TestListenerAdapter{

    @Override
    public void onTestFailure(ITestResult var1) {
        //super 调用父类得方法，进行相关操作
        super.onTestFailure(var1);

        //user.dir 工程目录
         String filePath=System.getProperty("user.dir")+"\\target\\screeshot\\";
        //System.currentTimeMillis();
        String fileName=System.currentTimeMillis()+".png";
        browserUtil.takeScreenShot(filePath+fileName);
       // addAllureAttachment(fileName,filePath);

    }


   public String getScreenShot(){
        return System.getProperty("user.dir")+"\\target\\screenshot\\";
    }




      /*  @Attachment
        public void addAllureAttachment(String filePath, String fileName)  {
            // ...
            Allure.attachment(fileName, filePath);

            }
            */

    }




