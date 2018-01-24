package com.fastmap.ui;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import com.example.fang.autotestfastmap.Point;
import java.lang.reflect.Field;

/**
 * Created by fang on 18/1/19.
 */

public class FastMapPage
{
    public FastMapPage()
    {
        try
        {
            Field[] fields = this.getClass().getDeclaredFields();

            for (Field field : fields)
            {
                if (!field.isAnnotationPresent(FindResource.class))
                {
                    continue;
                }

                field.set(null, field.getName());
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    public void Click(Point point) throws InterruptedException
    {
        mDevice.click(point.x, point.y);
        Thread.sleep(1000);
    }

    public void Click(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {

        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, annotation.Id())), 500);
            obj.click();
        }
        Thread.sleep(1000);
    }

    public void SetValue(String findRes, String value) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, annotation.Id())), 500);
            obj.setText(value);
        }
    }

    public String GetValue(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, annotation.Id())), 500);
            return obj.getText();
        } else {
            return "";
        }
    }

    public static void InitDevice(UiDevice device, String name)
    {
        mDevice = device;
        packageName = name;
    }

    protected static UiDevice mDevice;
    protected static String  packageName;
}