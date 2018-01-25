package com.fastmap.ui;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

/**
 * Created by fang on 18/1/22.
 */
public class Page_QCProblem extends FastMapPage
{

    @FindResource(Id="btn_save_data_check")
    public static String SAVE;

    public void SelectError(String error)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.text(error)), 500);
        obj.click();
    }

    public static Page_QCProblem Inst;
    static
    {
        Inst = new Page_QCProblem();
    }
}
