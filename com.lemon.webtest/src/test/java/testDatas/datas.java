package testDatas;

import org.testng.annotations.DataProvider;

public class datas {


    @DataProvider
    public Object[][] failureData() {
        Object[][] data={{"123","112332","账号为4~16位字母、数字或下划线"},{"186","22343411","账号或密码不正确"}};
        return data;
    }

    @DataProvider
    public Object[][] pwdErrorData() {
        Object[][] data={{"3422","11233","账号或密码不正确"}};
        return data;
    }

    @DataProvider
    public Object[][] pwdSuccessData() {
        Object[][] data={{"18629486979","Annika123!","18629486979"}};
        return data;
    }


}
