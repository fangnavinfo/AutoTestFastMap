package com.fastmap.ui;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import java.lang.reflect.Field;

/**
 * Created by fang on 18/1/19.
 */
public class Page_POI_Camera extends FastMapPage
{
    @FindResource(Id="take_pic_imgbtn")
    public static String TAKE_PIC;

    @FindResource(Id="task_pic_back_img")
    public static String BACK;

    @FindResource(Id="mingcheng_btn")
    public static String NAME_TYPE;

    @FindResource(Id="shuipai_btn")
    public static String SHUIPAI_TYPE;

    @FindResource(Id="chanpinquanmao_btn")
    public static String CHANPINQUANMAO_TYPE;

    @FindResource(Id="radio_revolution1")
    public static String RADIO_LOW; //低分辨率

    @FindResource(Id="radio_revolution2")
    public static String RADIO_MID; //中分辨率

    @FindResource(Id="radio_revolution3")
    public static String RADIO_HIG; //高分辨率

    public boolean GetBool(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, annotation.Id())), 500);
            //return obj.getText();
            if (obj.isChecked())
            {
               return true;
            }
        }
        return false;
    }

    public static Page_POI_Camera Inst;
    static
    {
        Inst = new Page_POI_Camera();
    }
}
