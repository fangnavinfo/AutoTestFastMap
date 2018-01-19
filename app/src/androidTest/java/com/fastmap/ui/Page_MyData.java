package com.fastmap.ui;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertNotNull;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MyData extends FastMapPage
{
    @FindResource(Id="tv_my_data_condition_1")
    public static String SELECT_DATA_TYPE;

    @FindResource(Id="rb_condition_poi")
    public static String POI_TYPE;

    @FindResource(Id="rb_condition_tips")
    public static String TIPS_TYPE;

    @FindResource(Id="tv_condition_confirm_hd")
    public static String SELECT_CONFIRM;

    @FindResource(Id="iv_my_data_back")
    public static String BACK;

    public static Page_MyData Inst;
    static
    {
        Inst = new Page_MyData();
    }

    public void CheckVaild(String type, String name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Click(SELECT_DATA_TYPE);
        Click(type);
        Click(SELECT_CONFIRM);

        assertNotNull(mDevice.wait(Until.findObject(By.text(name)), 500));
    }
}
