package listener;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryLisener implements IAnnotationTransformer {


    @Override
   public void transform(ITestAnnotation var1, Class var2, Constructor var3, Method var4){
        //注解对象var1
           //获取RetryAnalyzer得属性
       IRetryAnalyzer iRetryAnalyzer= var1.getRetryAnalyzer();//RetryAnalyzer 用于重试机制
        //如果iRetryAnalyzer 属性没有设置得话，为null
        if(iRetryAnalyzer==null){
            //设置重试机制
            var1.setRetryAnalyzer(testNGRetry.class);
        }
    }


}
