package com.fastmap.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import junit.framework.Assert;

import java.util.List;

/**
 * Created by fang on 18/1/22.
 */
public class Page_IndoorMyData extends FastMapPage
{
    @FindResource(Id="iv_my_data_back")
    public static String BACK;

    @FindResource(Id="img_indoor_my_data_snap_list_item_qc")
    public static String QC_LIST_ITEM_ICON;

    @FindResource(Id="v_indoor_my_data_snap_list_item_type")
    public static String QC_LIST_ITEM_TYPE;

    public static Page_IndoorMyData Inst;
    static
    {
        Inst = new Page_IndoorMyData();
    }

    public void CheckQcDataExist(String name) throws UiObjectNotFoundException
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, "img_indoor_my_data_snap_list_item_qc")), 500);

        obj = obj.getParent().getParent().findObject(By.text(name));
        Assert.assertEquals(name, obj.getText());
    }
}
