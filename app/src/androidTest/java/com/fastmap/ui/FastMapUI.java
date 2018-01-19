package com.fastmap.ui;
import android.content.res.Resources;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import com.example.fang.autotestfastmap.Point;
import com.example.fang.autotestfastmap.SqliteTools;
import com.example.fang.autotestfastmap.TipsDeepDictionary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by fang on 18/1/9.
 */
public class FastMapUI
{
    public static void initialize(UiDevice mDevice, String packageName) throws Exception
    {
        FastMapUI.mDevice = mDevice;
        FastMapUI.packageName = packageName;
        FastMapUI.arrayLocation = new ArrayList<>();
        FastMapUI.arrayLocationQc = new ArrayList<>();

        ArrayList<HashMap<int[], String>> arrayMap = new ArrayList<>();

        arrayMap.add(SqliteTools.GetKeyboardLeft());
        arrayMap.add(SqliteTools.GetKeyboardRight());
        arrayMap.add(SqliteTools.GetKeyboardBottom());

        InitialLocation(arrayMap, arrayLocation);

        arrayMap.clear();
        arrayMap.add(SqliteTools.GetKeyboardLeftWithQC());
        arrayMap.add(SqliteTools.GetKeyboardRightWithQC());
        arrayMap.add(SqliteTools.GetKeyboardBottomWithQC());

        InitialLocation(arrayMap, arrayLocationQc);

    }

    public static void pressBtnMainBoard(String type) throws Exception
    {
        int[] keyboardInfo = GetObjectIndex(type);

        UiObject2 obj2 = mDevice.wait(Until.findObject(By.res(packageName, "free_drag_view")), 500);
        List<UiObject2> lst = obj2.findObjects(By.clazz("android.widget.FrameLayout").clickable(true));

        lst.get(keyboardInfo[0]).click();

        if (keyboardInfo[1] == -1)
        {
            Thread.sleep(1000);
            return;
        }

        UiObject2 gridobj = mDevice.wait(Until.findObject(By.clazz("android.widget.GridLayout").clickable(true)), 500);

        //CheckTool(gridobj);

        lst = gridobj.findObjects(By.clazz("android.widget.ImageView"));
        lst.get(keyboardInfo[1]).click();

        Thread.sleep(1000);
    }

    protected static void CheckTool(UiObject2 textObj)
    {
        String className = textObj.getClassName();
        String text = textObj.getText();
        List<UiObject2> objList = textObj.getChildren();
        for (UiObject2 obj : objList)
        {
            CheckTool(obj);
        }
    }

    private static int[] GetObjectIndex(String type)
    {
        if (type.equals(TipsDeepDictionary.StartEndPoint))
        {
            UiObject2 obj2 = mDevice.wait(Until.findObject(By.res(packageName, "free_drag_view")), 500);
            List<UiObject2> lst = obj2.findObjects(By.clazz("android.widget.FrameLayout").clickable(true));

            return new int[]{lst.size()-1, -1};
        }

        ArrayList<ArrayList<String>> currLocation = arrayLocation;
        if (mDevice.wait(Until.findObject(By.res(packageName, "btn_indoor_data_check_open")), 500) != null)
        {
            currLocation = arrayLocationQc;
        }

        for (int i=0; i<currLocation.size(); i++)
        {
            ArrayList<String> arrayString = currLocation.get(i);
            for (int j=0; j<arrayString.size(); j++)
            {
                if (arrayString.get(j).equals(type))
                {
                    if (arrayString.size() > 1)
                    {
                        return new int[]{i, j};
                    }
                    else
                    {
                        return new int[]{i, -1};
                    }
                }
            }
        }

        throw new Resources.NotFoundException();
    }

    private static void InitialLocation(ArrayList<HashMap<int[], String>> arrayMap, ArrayList<ArrayList<String>> arrayLocation)
    {
        for (HashMap<int[], String> map : arrayMap)
        {
            ArrayList<int[]> arrayKey = new ArrayList<>(map.keySet());
            Collections.sort(arrayKey, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] > o2[0])
                    {
                        return 1;
                    }
                    else if (o1[0] < o2[0])
                    {
                        return -1;
                    }
                    else
                    {
                        if (o1[1] > o2[1])
                        {
                            return 1;
                        }
                        else if (o1[1] < o2[1])
                        {
                            return -1;
                        }
                        else
                        {
                            return 0;
                        }
                    }
                }
            });

            for (int i=0; i<arrayKey.size(); i++) {
                if (i != 0) {
                    int[] perKey = arrayKey.get(i - 1);
                    if (perKey[0] == arrayKey.get(i)[0]) {
                        arrayLocation.get(arrayLocation.size() - 1).add(map.get(arrayKey.get(i)));
                        continue;
                    }
                }

                ArrayList<String> arrString = new ArrayList<>();
                arrString.add(map.get(arrayKey.get(i)));
                arrayLocation.add(arrString);

            }
        }

    }

    private static UiDevice mDevice;
    private static String packageName;
    private static ArrayList<ArrayList<String>> arrayLocation;
    private static ArrayList<ArrayList<String>> arrayLocationQc;
}
