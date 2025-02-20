package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

public class testNGRetry implements IRetryAnalyzer {
 //TODO
  //规定重试次数最多跑多少次，
    private Logger log = Logger.getLogger(this.getClass());
    private int currentRetrycount = 0;
    private int maxRetryCount = 3;

    @Override
    public  boolean retry(ITestResult var1){
       // return var1.getStatus() == ITestResult.FAILURE;
        //default 机制是重复执行failed case，直到pass
        //需要认为加入条件逻辑判断控制 达到fail次数跳出
        if (currentRetrycount < maxRetryCount) {
            currentRetrycount++;
            log.info("当前重试次数"+currentRetrycount);
            return true;
        } else {

            return false;

        }

    }
}
