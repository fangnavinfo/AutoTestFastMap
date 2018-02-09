package com.fastmap.ui;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by h on 2018/2/1.
 */

public class Page_Indoor_Data_List extends FastMapPage {
    @FindResource(Id = "ll_my_data_snap_list")
    public static String LIST;

    @FindResource(Id = "iv_my_data_back")
    public static String BACK;
    public static Page_Indoor_Data_List Inst;
    static{
        Inst = new Page_Indoor_Data_List();
    }
    public  void scrollClickObject(String targetName) throws UiObjectNotFoundException {
        UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
        if(listScrollable.exists()) {
            listScrollable.scrollDescriptionIntoView(targetName);
            mDevice.findObject(By.text(targetName)).click();
        } else {
            mDevice.findObject(By.text(targetName)).click();
        }

    }
    public void ClickObject(String tarObject)
    {
        mDevice.findObject(By.text(tarObject)).click();
    }
}
