package listener;

import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.mustache.Value;
import util.browserUtil;

public class allureReportListener implements IHookable {

    @Override
    public void run(IHookCallBack var1, ITestResult var2){
       //去执行@Test 注解对应得测试方法
        var1.runTestMethod(var2);
        //var2 test result 如果有问题进行截图
        if (var2.getThrowable()!=null){
                testResultListener testResultListener = new testResultListener();
                testResultListener.getScreenShot();
        }
    };

   /* @Attachment(Value="methodName:{0}",type = "image/png")
    public byte[] saveScreen(String methodName){
        return browserUtil.takeScreenShot(methodName);
    }
    */

}
