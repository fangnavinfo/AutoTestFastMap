package com.example.fang.autotestfastmap;

import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
public class testFastMap
{
    @BeforeClass
    public static void setClassUp() throws Exception
    {

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        packageName = getPackageName();

        clearCollect();

        waitAppStart();

        loginProcess();

        waitDownLoadMetal();

        waitDownLoadMap();

    }

    @AfterClass
    public static void setClassDown() throws InterruptedException, IOException
    {

    }

    @Before
    public void setUp()
    {
        // Initialize UiDevice instance
        //mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        //mDevice.pressHome();
    }

    @After
    public  void setAfter()
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

    @Test
    public void test00101_poi_add() throws InterruptedException
    {
        Click(newPOIPoint, 6000);

        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_img");

        PutinEditor("fm_et_name", "测试ＰＯＩ");

        Click("tv_assort_type", 3000);
        Thread.sleep(3000);

        List<UiObject2> objList = mDevice.wait(Until.findObjects(By.res(packageName, "top_name_txtinfo")), 500);

        if (objList == null)
        {
            fail("can not find ctrl: top_name_txtinfo");
        }

        UiObject2 objectRest = null;
        for (UiObject2 object : objList)
        {
            if(object.getText().equals("中餐馆"))
            {
                objectRest = object;
            }
        }

        if (objectRest == null)
        {
            fail("can not find ctrl: 中餐馆");
        }

        objectRest.click();


        Click("save_button");
        poiNum++;

        GotoMyData("rb_condition_poi");

        assertEditorEqual("tv_my_data_count_2", Integer.toString(poiNum));
        assertNotNull(Until.findObject(By.desc("测试ＰＯＩ")));

        ExitMyData();
    }

    @Test
    public void test00201_tips_point_TrafficLight_add() throws InterruptedException
    {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(newTrafficLight);
        Click(GetCenter());
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("红绿灯")));

        ExitMyData();
    }

    @Test
    public void test00301_tips_line_DrawRoad_add() throws InterruptedException
    {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(newDrawRoard);
        Click(newDrawRoardReal);

        Click(new Point(1000, 1000));

        Click(new Point(1000, 500));

        Click(new Point(500, 1000));

        Click("card_high_speed");
        Click("lane_num_1");
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("测线")));

        ExitMyData();
    }

    @Test
    public void test00401_tips_releation_TrackLimit_add()
    {
        Click(newDrawRoard);
        Click(newDrawTrackLimit);

        Click(new Point(1000, 1000));

        Click("traffic_forbidden_icon_c2");
        Click("save_button");

        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("卡车交限")));

        ExitMyData();

    }

    @Test
    public void test00501_QCTask_add() throws InterruptedException
    {
        GotoIndoorTools();

        Click("btn_indoor_data_check_open");

        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(newTrafficLight);
        Click(GetCenter());
        tipsNum++;

        Click("ck_data_check_list_item");
        Click("btn_save_data_check");

        assertNotNull(Until.findObject(By.res(packageName, "img_indoor_my_data_snap_list_item_qc")));

        ExitIndoorTools();

    }

    @Test
    public void test00601_Precise_Pas_add() throws InterruptedException
    {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(newDrawRoard);
        Click(newPas);

        PutinEditor("fm_et_name_pas", "测试ＰＡＳ");
        PutinEditor("fm_et_address_pas", "101");
        Click("ck_odd");
        Click("ck_road");
        Click("save_button");

        GotoMyData("rb_condition_pas");

        assertEditorEqual("tv_my_data_count_2", "1");
        assertNotNull(Until.findObject(By.desc("测试ＰＡＳ１０１")));

        ExitMyData();
    }

    @Test
    public void test00701_info_Point_add() throws InterruptedException
    {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("btn_infor_report");
        Click("info_pop_add_point");

        PutinEditor("edt_infor_report_name", "测试点ＩＮＦＯ");

        Click("tv_poiReport_time");
        Click("btn_fm_confirm");

        Click("camera_button", 3000);
        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_imgbtn");

        Click(GetCenter());

        Click("save_button");

        infoPOINum++;

        GotoMyData("rb_condition_live_information");

        assertEditorEqual("tv_my_data_count_1", Integer.toString(infoPOINum));
        assertNotNull(Until.findObject(By.desc("自采集情报(POI)(点)")));

        ExitMyData();
    }

    @Test
    public void test00801_info_Line_add() throws InterruptedException
    {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("btn_infor_report");
        Click("info_pop_add_line");

        Click(new Point(1000, 1000));
        Click(new Point(1000, 500));
        Click(new Point(500, 1000));

        Click("draw_line_over");

        PutinEditor("edt_infor_report_name", "测试线ＩＮＦＯ");

        Click("tv_poiReport_time");
        Click("btn_fm_confirm");

        Click("camera_button", 3000);
        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_imgbtn");

        Click("save_button");

        infoPOINum++;

        GotoMyData("rb_condition_live_information");

        assertEditorEqual("tv_my_data_count_1", Integer.toString(infoPOINum));
        assertNotNull(Until.findObject(By.desc("自采集情报(POI)(线)")));

        ExitMyData();
    }

    @Test
    public void test00901_info_Frame_add() throws InterruptedException
    {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("btn_infor_report");
        Click("info_pop_add_frame");

        Click(new Point(1000, 1000));
        Click(new Point(1000, 500));
        Click(new Point(500, 1000));

        Click("draw_line_over");

        PutinEditor("edt_infor_report_name", "测试面ＩＮＦＯ");

        Click("infor_report_type_road");
        Click("tv_poiReport_time");
        Click("btn_fm_confirm");

        Click("camera_button", 3000);
        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_imgbtn");

        Click("save_button");

        infoRoadNum++;

        GotoMyData("rb_condition_live_information");

        assertEditorEqual("tv_my_data_count_2", Integer.toString(infoRoadNum));
        assertNotNull(Until.findObject(By.desc("自采集情报(道路)(面)")));

        ExitMyData();
    }

    @Test
    public void test1000_SyncData() throws InterruptedException, UiObjectNotFoundException
    {
        CheckAllData();

        GotoGridManager();

        Click("grid_project_button");
        Click(GetCenter());
        Click("synchronous_button");
        Click("btn_fm_confirm");

        assertEditorEqual("sync_count_dialog_select_tips", "Tips："+Integer.toString(tipsNum));
        assertEditorEqual("sync_count_dialog_select_poi",  "POI："+Integer.toString(poiNum));
        assertEditorEqual("sync_count_dialog_select_info",  "情报："+Integer.toString(infoPOINum+infoRoadNum));

        Click("btn_fm_confirm", 5000);

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

        CheckSyncResult();

        Click("grid_sync_btn_positive");
        Click("btn_fm_confirm");

        ExitGridManager();
    }

    private static String getPackageName() throws Exception
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

    private static void clearCollect() throws IOException
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

    private static void  waitAppStart() throws InterruptedException {

        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "login_btn")), 10*1000);
        if (object == null)
        {
            fail("fast map not start!");
        }
    }

    private static void loginProcess()
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

    private static void waitDownLoadMetal() throws Exception {
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

    private static void waitDownLoadMap() throws Exception
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

    private void GotoMyData(String strType)
    {
        Click("head_icon");
        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click(strType);
        Click("tv_condition_confirm_hd");
        eCurrLayer = EnumLayer.Layer_MyData;
    }

    private  void ExitMyData()
    {
        Click("iv_my_data_back");
        Click("fmcard_ibtn_back");
        eCurrLayer = EnumLayer.Layer_Main;
    }

    private void GotoIndoorTools()
    {
        Click("head_icon");
        Click("fmcard_tv_sync_photos");
        Click("tv_my_data");
        eCurrLayer = EnumLayer.Layer_IndoorTools;
    }

    private  void ExitIndoorTools()
    {
        Click("iv_my_data_back");
        Click("sync_photos_back");
        Click("fmcard_ibtn_back");
        eCurrLayer = EnumLayer.Layer_Main;
    }

    private void GotoGridManager()
    {
        Click("head_icon");
        Click("fmcard_tv_grid_manager");

        eCurrLayer = EnumLayer.Layer_GridManager;
    }

    private void ExitGridManager()
    {
        Click("back");
        Click("fmcard_ibtn_back");
        eCurrLayer = EnumLayer.Layer_Main;
    }


    private  static void Click(String strViewId)
    {
        Click(strViewId, 1000);

    }

    private  static void Click(String strViewId, int time)
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

    private  static void Click(Point point)
    {
        Click(point, 1000);

    }

    private  static void Click(Point point, int time)
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

    private static Point GetCenter()
    {
        return  new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2);
    }

    private static void PutinEditor(String editorCtrl, String inPut)
    {
        UiObject2 editName = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);

        editName.setText(inPut);
    }

    private void assertEditorEqual(String editorCtrl, String textExcept)
    {
        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);

        assertEquals(textExcept, txtAddCount.getText());
    }

    private void assertEditorEqual(String editorCtrl, List<String> textExceptList)
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

    private void CheckAllData() throws InterruptedException {
        GotoIndoorTools();

        Thread.sleep(5000);


        UiObject2 noRec = null;
        do
        {
            List<UiObject2> objList = mDevice.wait(Until.findObjects(By.res(packageName, "tv_indoor_my_data_snap_list_item_index")), 1000);

            if (objList != null)
            {
                for (UiObject2 object : objList)
                {
                    object.click();

                }
            }

            ExitIndoorTools();

            GotoIndoorTools();

            noRec = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);

        }while (!noRec.getText().equals("0"));


        ExitIndoorTools();
    }

    private void CheckSyncResult() throws UiObjectNotFoundException {

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

    private static boolean metaDataDownSuccess() throws InterruptedException
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

    enum EnumLayer
    {
        Layer_Main,
        Layer_MyData,
        Layer_IndoorTools,
        Layer_GridManager,
    }

    private static UiDevice mDevice;
    private static String packageName = "com.fastmap.hd";

    private static Point newPOIPoint = new Point((152-36)/2+36, (834-718)/2+718);
    private static Point newTrafficLight = new Point(370, 1440);
    private static Point newDrawRoard = new Point(100, 1260);
    private static Point newDrawRoardReal = new Point(220, 1000);
    private static Point newDrawTrackLimit = new Point(340, 990);
    private static Point newPas = new Point(235,1240);
    private static Point beijingMap = new Point(636,460);

    private static EnumLayer eCurrLayer = EnumLayer.Layer_Main;

    private static int tipsNum = 0;
    private static int poiNum = 0;
    private static int infoPOINum = 0;
    private static int infoRoadNum = 0;
}
