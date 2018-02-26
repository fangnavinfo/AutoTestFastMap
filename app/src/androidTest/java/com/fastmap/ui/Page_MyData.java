package com.fastmap.ui;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

    @FindResource(Id="rb_condition_pas")
    public static String PAS_TYPE;

    @FindResource(Id="rb_condition_live_information")
    public static String INFO_TYPE;

    @FindResource(Id="rb_condition_live_information")
    public static String LIVE_INFORMATION_TYPE;

    @FindResource(Id="tv_condition_confirm_hd")
    public static String SELECT_CONFIRM;

    @FindResource(Id="iv_my_data_back")
    public static String BACK;

    @FindResource(Id="et_title")
    public static String TITLE;

    @FindResource(Id="ll_my_data_snap_list")
    public static String DATALIST; //我的数据列表

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

    public void CheckNotExist(String type, String name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Click(SELECT_DATA_TYPE);
        Click(type);
        Click(SELECT_CONFIRM);

        assertNull(mDevice.wait(Until.findObject(By.text(name)), 500));
    }

    public void SelectData(String name)
    {
        ClickByText(name);
    }

    public String GetGlobalID() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        String strTemp = GetValue(TITLE);
        String temp = strTemp.substring(strTemp.length()-32,strTemp.length());
        return temp;
    }
}