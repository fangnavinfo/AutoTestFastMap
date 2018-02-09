package com.fastmap.ui;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import com.example.fang.autotestfastmap.Point;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, annotation.Id())), 10000);
            obj.click();
            return;
        }

        if (!annotation.Text().isEmpty())
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.text(annotation.Text())), 10000);
            obj.click();
            return;
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

    public void ScrollClick(String findRes) throws NoSuchFieldException, UiObjectNotFoundException
    {
        Field field = this.getClass().getDeclaredField("SCROLL");

        FindResource annotation = field.getAnnotation(FindResource.class);

        UiScrollable objscoll = new UiScrollable(new UiSelector().className(annotation.clazz()));

        field = this.getClass().getDeclaredField(findRes);
        annotation = field.getAnnotation(FindResource.class);

        //UiObject Object = objscoll.getChild(new UiSelector().text(annotation.Text()));
        UiObject Object = objscoll.getChildByText(new UiSelector().className(annotation.clazz()), annotation.Text());
        Object.click();
    }

    public static void InitDevice(UiDevice device, String name)
    {
        mDevice = device;
        packageName = name;
    }

    public void ClickByText(String value)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.text(value)), 500);
        obj.click();
    }

    protected void CheckResource(UiObject2 object, ArrayList<UiObject2> listResult)
    {
        List<UiObject2> lst = object.getChildren();
        for (UiObject2 obj : lst)
        {
            if (obj.getClassName().equals("android.widget.TextView"))
            {
                listResult.add(obj);
            }

            CheckResource(obj, listResult);
        }

    }
    protected static UiDevice mDevice;
    protected static String  packageName;
}