package com.example.fang.autotestfastmap;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.fail;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapBase
{

    protected  static void setClassUp() throws Exception
    {

        Init();

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        packageName = getPackageName();

        clearCollect();

        ReStartApp();

        loginProcess();

    //        waitDownLoadMetal();
    //
    //        waitDownLoadMap();

    }

    protected  void setAfter()
    {
        switch (eCurrLayer)
        {
            case Layer_MyData:
                ExitMyData();
                break;
            case Layer_IndoorTools:
                ExitIndoorTools();
                break;
            case Layer_GridManager:
                //ExitGridManager();
                break;
            default:
                break;
        }
    }

    protected static String getPackageName() throws Exception
    {
        String rslt = mDevice.executeShellCommand("pm list packages");
        String[] array  = rslt.split("\n");

        for (int i=0; i<array.length; i++)
        {
            if (array[i].contains("package:com.fastmap.hd"))
            {
                String name = array[i].substring("package:".length());
                return name;
            }
        }

        throw new Exception("fastmap not install!");
    }

    protected static void clearCollect() throws IOException
    {
        String rslt = mDevice.executeShellCommand("ls /sdcard/");
        String[] array  = rslt.split("\n");

        String dirName = "";
        for (int i=0; i<array.length; i++)
        {
            if (array[i].contains("FastMap"))
            {
                dirName = array[i];
            }
        }

        if (dirName.isEmpty())
        {
            return;
        }

        dirName = "/sdcard/" + dirName +"/Data/Collect/3655/";

        mDevice.executeShellCommand("rm -rf " + dirName + "coremap.sqlite");
        mDevice.executeShellCommand("rm -rf " + dirName + "oremap.shm");
        mDevice.executeShellCommand("rm -rf " + dirName + "coremap.wal");
    }

    public static void  ReStartApp() throws InterruptedException, IOException
    {
        mDevice.executeShellCommand("am force-stop " + packageName);

        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "login_btn")), 10*1000);
        if (object == null)
        {
            fail("fast map not start!");
        }
    }

    public static void loginProcess()
    {
        //登录
        PutinEditor("login_account_et", "zhanglingling03655");
        PutinEditor("login_pswd_et", "036550");

        Click("login_btn");

        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "head_icon")), 20*1000);
        if (object == null)
        {
            fail("user login failed!");
        }
    }

    protected static void waitDownLoadMetal() throws Exception {
        //元数据下载
        int waitCount = 0;
        while (true)
        {
            if (waitCount == 30)
            {
                break;
            }

            if (mDevice.findObject(By.res(packageName, "update_image")) != null)
            {
                Click(GetCenter());
            }

            if (metaDataDownSuccess())
            {
                break;
            }

            Thread.sleep(1000);
            waitCount++;
            continue;
        }
    }

    protected static void waitDownLoadMap() throws Exception
    {
        Click("head_icon");
        Click("fmcard_tv_user_bg_map",2000);

        Click("rb_manager");

        UiObject2 check = mDevice.findObject(By.res(packageName, "download_title"));
        if (check != null && check.getText().equals("下载完成"))
        {
            Click("btn_back");
            Click("fmcard_ibtn_back");

            return;
        }

        Click("rb_city_list");
        Click(beijingMap);

        int waitCount = 0;

        while (true)
        {
            if (waitCount == 180)
            {
                throw new Exception("下载离线地图超时");
            }

            UiObject2 downSucess = mDevice.findObject(By.res(packageName, "download_title"));
            if (downSucess != null && downSucess.getText().equals("下载完成"))
            {
                break;
            }

            Thread.sleep(1000);
            waitCount++;
        }

        Click("btn_back");
        Click("fmcard_ibtn_back");
    }

    protected void GotoMyData(String strType)
    {
        Click("head_icon");
        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click(strType);
        Click("tv_condition_confirm_hd");
        eCurrLayer = EnumLayer.Layer_MyData;
    }

    protected  void ExitMyData()
    {
        Click("iv_my_data_back");
        Click("fmcard_ibtn_back");
        eCurrLayer = EnumLayer.Layer_Main;
    }

    protected void GotoIndoorTools()
    {
        Click("head_icon");
        Click("fmcard_tv_sync_photos");
        Click("tv_my_data");
        eCurrLayer = EnumLayer.Layer_IndoorTools;
    }

    protected  void ExitIndoorTools()
    {
        Click("iv_my_data_back");
        Click("sync_photos_back");
        Click("fmcard_ibtn_back");
        eCurrLayer = EnumLayer.Layer_Main;
    }

    protected void GotoGridManager()
    {
        Click("head_icon");
        Click("fmcard_tv_grid_manager");

        eCurrLayer = EnumLayer.Layer_GridManager;
    }

    protected void ExitGridManager()
    {
        Click("back");
        Click("fmcard_ibtn_back");
        eCurrLayer = EnumLayer.Layer_Main;
    }


    protected  static void Click(String strViewId)
    {
        Click(strViewId, 1000);

    }

    protected  static void Click(String strViewId, int time)
    {
        try
        {
            int waitCount =0;
            UiObject2 btnBack2 =  mDevice.findObject(By.res(packageName, strViewId));
            while (btnBack2 == null)
            {
                btnBack2 = mDevice.findObject(By.res(packageName, strViewId));
                if (waitCount == 30)
                {
                    break;
                }

                waitCount++;
                Thread.sleep(1000);
            }

            if (btnBack2 == null)
            {
                fail("can not find ctrl:" + strViewId);
            }

            btnBack2.click();
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    protected  static void Click(Point point)
    {
        Click(point, 1000);

    }

    protected  static void Click(Point point, int time)
    {
        mDevice.click(point.x, point.y);

        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    protected static Point GetCenter()
    {
        return  new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2);
    }

    protected static void PutinEditor(String editorCtrl, String inPut)
    {
        UiObject2 editName = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);

        editName.setText(inPut);
    }

    protected void assertEditorEqual(String editorCtrl, String textExcept)
    {
        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);

        assertEquals(textExcept, txtAddCount.getText());
    }

    protected void assertEditorEqual(String editorCtrl, List<String> textExceptList)
    {
        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);

        String str="";
        String strReal = txtAddCount.getText();

        if (strReal == null)
        {
            return;
        }

        for (String textExcept : textExceptList)
        {
            if (textExcept == null)
            {
                return;
            }

            if (strReal.equals(textExcept))
            {
                return;
            }

            str += textExcept+" or ";
        }


        fail(editorCtrl + "expect:" + str + "but real:" + strReal);
    }

    protected void CheckAllData() throws InterruptedException, UiObjectNotFoundException
    {
        GotoIndoorTools();

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));

        try
        {
            while (true)
            {
                UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "否");
                Object.click();
            }

        }
        catch (UiObjectNotFoundException e)
        {

        }

        ExitIndoorTools();
    }

    protected static boolean metaDataDownSuccess() throws InterruptedException
    {
        UiObject2 object = mDevice.findObject(By.res(packageName, "tv_title"));
        if (object != null && object.getText().equals("元数据更新"))
        {
            Click("btn_fm_confirm", 2000);

            int count = 0;
            while (true)
            {
                try
                {
                    UiCollection videos = new UiCollection(new UiSelector().className("android.widget.FrameLayout"));

                    UiObject confirmObj = videos.getChild(new UiSelector().className("android.widget.Button"));
                    if (confirmObj.isEnabled())
                    {
                        confirmObj.click();
                        return true;
                    }
                }
                catch (android.support.test.uiautomator.UiObjectNotFoundException e)
                {
                    continue;
                }
                finally
                {
                    if (count == 180)
                    {
                        fail("download metal data timeout");
                        break;
                    }

                    Thread.sleep(1000);
                    count++;
                }
            }
        }

        return false;
    }

    protected void CheckSyncResult() throws UiObjectNotFoundException, InterruptedException
    {

        int count = 0;
        while (true)
        {
            try
            {
                UiCollection videos = new UiCollection(new UiSelector().className("android.widget.FrameLayout"));

                UiObject confirmObj = videos.getChild(new UiSelector().className("android.widget.Button"));
                if (confirmObj.isEnabled())
                {
                    Thread.sleep(5000);
                    break;
                }
            }
            catch (android.support.test.uiautomator.UiObjectNotFoundException e)
            {
                continue;
            }
            finally
            {
                if (count == 150)
                {
                    break;
                }

                Thread.sleep(1000);
                count++;
            }
        }


        UiCollection videos = new UiCollection(new UiSelector().className("android.widget.ScrollView"));

        int i=0;
        while (true)
        {
            UiObject txtResult = videos.getChild(new UiSelector().className("android.widget.TextView").instance(i));
            switch (i)
            {
                case 1:
                    if (poiNum == 0) {
                        Assert.assertEquals("没有需要上传的数据", txtResult.getText());
                    } else {
                        Assert.assertEquals("Poi上传成功(成功" + Integer.toString(poiNum) + "条,失败0条)", txtResult.getText());
                    }
                    break;

                case 4:
                    Assert.assertEquals("Poi数据安装成功", txtResult.getText());
                    break;

                case 7:
                    if (tipsNum == 0)
                    {
                        Assert.assertEquals("没有需要上传的数据", txtResult.getText());
                    }
                    else {
                        Assert.assertEquals("Tips上传成功(成功" + Integer.toString(tipsNum) + "条,失败0条)", txtResult.getText());
                    }
                    break;

                case 10:
                    Assert.assertEquals( "tips实景数据安装成功", txtResult.getText());
                    break;

                case 13:
                    if (infoPOINum == 0)
                    {
                        Assert.assertEquals("没有需要上传的数据", txtResult.getText());
                    } else
                    {
                        Assert.assertEquals("情报上传成功(成功" + Integer.toString(infoPOINum+infoRoadNum) + "条,失败0条)", txtResult.getText());
                    }
                    break;

                case 16:
                    Assert.assertEquals("info数据安装成功", txtResult.getText());
                    return;

                default:
                    break;
            }

            i++;

        }

    }

    protected void CheckSyncInfoResult() throws UiObjectNotFoundException
    {
        UiObject2 btnObject = mDevice.wait(Until.findObject(By.clazz("android.widget.Button").enabled(true)), 120*1000);

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
        UiObject Object = objscoll.getChildByInstance(new UiSelector().className("android.widget.TextView"), 1);

        if (infoPOINum+infoRoadNum == 0)
        {
            Assert.assertEquals("没有需要上传的数据", Object.getText());
        } else
        {
            Assert.assertEquals("情报上传成功(成功" + Integer.toString(infoPOINum+infoRoadNum) + "条,失败0条)", Object.getText());
        }

        btnObject.click();
    }

        protected enum EnumLayer
    {
        Layer_Main,
        Layer_MyData,
        Layer_IndoorTools,
        Layer_GridManager,
    }

    private static void Init()
    {
        eCurrLayer = EnumLayer.Layer_Main;
        tipsNum = 0;
        poiNum = 0;
        infoPOINum = 0;
        infoRoadNum = 0;
        infoGateType = 0;
    }

    protected void AssertIndoorCheck(String type, String level, String rule, String error, String severity) throws UiObjectNotFoundException
    {
        GotoIndoorTools();
        Click("btn_check");
        Click("progress_btn_positive");

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        Assert.assertNotNull(objscoll);

        objscoll.setMaxSearchSwipes(3);

        objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), rule);
        
        for (int i=0; i<objscoll.getChildCount(); i++)
        {
            UiObject subOject =objscoll.getChild(new UiSelector().index(i));
            String strr = subOject.getClassName();
            if (!subOject.getClassName().equals("android.widget.LinearLayout"))
            {
                continue;
            }

            UiObject txtObj = subOject.getChild(new UiSelector().className("android.widget.TextView").instance(3));
            if (txtObj.getText().equals(rule))
            {
                txtObj = subOject.getChild(new UiSelector().className("android.widget.TextView").instance(1));
                Assert.assertEquals(type, txtObj.getText());
                txtObj = subOject.getChild(new UiSelector().className("android.widget.TextView").instance(2));
                Assert.assertEquals(level, txtObj.getText());
                txtObj = subOject.getChild(new UiSelector().className("android.widget.TextView").instance(3));
                Assert.assertEquals(rule, txtObj.getText());
                txtObj = subOject.getChild(new UiSelector().className("android.widget.TextView").instance(4));
                Assert.assertEquals(error, txtObj.getText());

                txtObj = subOject.getChild(new UiSelector().className("android.widget.TextView").instance(5));
                Assert.assertEquals(severity, txtObj.getText());
                break;
            }

        }
    }

    protected static UiDevice mDevice;
    protected static String packageName = "com.fastmap.hd";

    protected static Point MultPoint1 = new Point(100, 1120);
    protected static Point MultPoint2 = new Point(100, 1260);
    protected static Point beijingMap = new Point(636,460);
    protected static Point MultPoint3 = new Point(720,1430);

    protected static EnumLayer eCurrLayer = EnumLayer.Layer_Main;

    protected static int tipsNum = 0;
    protected static int poiNum = 0;
    protected static int infoPOINum = 0;
    protected static int infoRoadNum = 0;
    protected static int infoGateType = 0;

    protected static Point newPOIPoint = new Point((152-36)/2+36, (834-718)/2+718);
    protected static Point newTrafficLight = new Point(370, 1440);
    protected static Point newDrawRoardReal = new Point(220, 1000);
    protected static Point newDrawTrackLimit = new Point(340, 990);
    protected static Point newPas = new Point(235,1240);
    protected static Point newElecEye = new Point(720,1150);
    protected static Point newRoadNameSign = new Point(366, 1240);
    protected static Point newDirectBoard = new Point(220, 850);
    protected static SqliteTools m_Sqlit = new SqliteTools();
}
