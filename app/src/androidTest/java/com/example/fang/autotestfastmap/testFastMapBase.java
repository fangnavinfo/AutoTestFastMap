package com.example.fang.autotestfastmap;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import com.fastmap.ui.*;

import com.fastmap.ui.FastMapUI;

import junit.framework.Assert;

import org.junit.FixMethodOrder;
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

    protected  static void setClassUp(String userName, String passWord, boolean... isHmWorking) throws Exception
    {

        testFastMapBase.userName = userName;
        testFastMapBase.passWord = passWord;

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        packageName = getPackageName();
        if(isHmWorking.length > 0 && isHmWorking[0] == true)
        {
            userPath = GetUserPathHM();
        }else
        {
            userPath = GetUserPath();
        }

        Init();

        ReStartApp();

        clearCollect();

        if(isHmWorking.length > 0 && isHmWorking[0] == true)
        {
            loginHmProcess();
        }else
        {
            loginProcess();
        }

        SqliteTools.initialize(userPath);

        FastMapUI.initialize(mDevice, packageName);
        FastMapPage.InitDevice(mDevice, packageName);


    //        waitDownLoadMetal();
    //
    //        waitDownLoadMap();

    }

//    protected  void setAfter() throws IOException, InterruptedException {
//        try {
//            switch (eCurrLayer) {
//                case Layer_MyData:
//                    ExitMyData();
//                    break;
//                case Layer_IndoorTools:
//                    ExitIndoorTools();
//                    break;
//                case Layer_GridManager:
//                    //ExitGridManager();
//                    break;
//                default:
//                    break;
//            }
//        } catch (RuntimeException e) {
//            ReStartApp();
//            loginProcess();
//        }
//    }
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
        mDevice.executeShellCommand("rm -rf " + userPath + "coremap.sqlite");
        mDevice.executeShellCommand("rm -rf " + userPath + "oremap.shm");
        mDevice.executeShellCommand("rm -rf " + userPath + "coremap.wal");
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

    // 选择非港澳服务
    public static void chooseServer() throws InterruptedException {
        UiObject2 hm = mDevice.findObject(By.res(packageName, "chk_work_area_type"));
        if(hm.isChecked()) {
            hm.click();
            Thread.sleep(1000);
        }
        Click("login_tv_service_address");
        UiObject2 Object = mDevice.wait(Until.findObject(By.text("开发->http://fs-road.navinfo.com/dev/trunk")), 500);
        Object.click();

        Click("btn_fm_confirm");
    }
    // 选择港澳服务
    public static void chooseHmServer() throws InterruptedException {
        UiObject2 hm = mDevice.findObject(By.res(packageName, "chk_work_area_type"));
        if(!hm.isChecked()) {
            hm.click();
            Thread.sleep(1000);
        }
        Click("login_tv_service_address");
        UiObject2 Object = mDevice.wait(Until.findObject(By.text("港澳->http://192.168.4.130:9700")), 500);
        Object.click();

        Click("btn_fm_confirm");
    }

    //非港澳作业登录
    public static void loginProcess() throws InterruptedException {
        chooseServer();

        //登录
        PutinEditor("login_account_et", userName);
        PutinEditor("login_pswd_et", passWord);

        Click("login_btn");

        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "head_icon")), 30*1000);
        if (object == null)
        {
            fail("user login failed!");
        }
    }

    //港澳作业登录
    public static void loginHmProcess() throws InterruptedException {
        chooseHmServer();

        //登录
        PutinEditor("login_account_et", userName);
        PutinEditor("login_pswd_et", passWord);

        Click("login_btn");

        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "head_icon")), 30*1000);
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
            while (btnBack2 == null || !btnBack2.isEnabled())
            {
                btnBack2 = mDevice.findObject(By.res(packageName, strViewId));
                if (waitCount == 5)
                {
                    break;
                }

                waitCount++;
                Thread.sleep(1000);
            }

            if (btnBack2 == null)
            {
                throw new RuntimeException("can not find ctrl:" + strViewId);
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

        UiObject object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), rule);

        Assert.assertEquals(object.getText(), rule);

//        List<UiObject2> resultList = mDevice.wait(Until.findObject(By.clazz("android.widget.ListView")), 500).getChildren();
//        int i = resultList.size();
//        for (UiObject2 obj : resultList)
//        {
//            if (!obj.getClassName().equals("android.widget.LinearLayout"))
//            {
//                continue;
//            }
//
//            if (obj.findObject(By.text(rule)) == null)
//            {
//                continue;
//            }
//
//            UiObject2 objType = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_type"));
//            Assert.assertEquals(type, objType.getText());
//
//            UiObject2 objlevel = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_error_level"));
//            Assert.assertEquals(level, objlevel.getText());
//
//            UiObject2 objError = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_error_info"));
//            Assert.assertEquals(error, objError.getText());
//
//
////            UiObject2 ObjSerious = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_serious"));
////            if (severity.isEmpty() && ObjSerious.getText() == null)
////            {
////            }
////            else
////            {
////                Assert.assertEquals(severity, ObjSerious.getText());
////            }
//        }

        Click("iv_indoor_check_back");
        ExitIndoorTools();
    }

    protected void AssertIndoorCheckNull(String rule)
    {
        GotoIndoorTools();
        Click("btn_check");

        try
        {
            Click("progress_btn_positive");
        }
        catch (RuntimeException e)
        {
            ExitIndoorTools();
            return;
        }

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        Assert.assertNotNull(objscoll);

        objscoll.setMaxSearchSwipes(3);

        try
        {
            UiObject subOject = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), rule);
            if (subOject != null)
            {
                Click("iv_indoor_check_back");

                Assert.fail(rule + " exit!");
            }
        }
        catch (UiObjectNotFoundException e)
        {
            UiObject2 btnObject = mDevice.wait(Until.findObject(By.res(packageName, "iv_indoor_check_back")), 500);
            if (btnObject != null)
            {
                Click("iv_indoor_check_back");
            }
        }


        ExitIndoorTools();

    }

    //按照坐标绘制测线
    protected void DrawRoad(Point[] pointArray) throws Exception
    {
        DrawRoad(pointArray, "card_high_speed");
    }

    //按照坐标绘制测线
    protected void DrawRoad(Point[] pointArray, String type) throws Exception
    {
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        for(Point p : pointArray)
        {
            Click(p);
        }

        Click(type);

        if (!type.equals("card_nine_rd") && !type.equals("card_pedestrian_rd") && !type.equals("card_people_crossing") && !type.equals("card_ferry"))
        {
            Click("lane_num_1");
        }

        Click("save_button");
        tipsNum++;
    }

    //设置起终点类型
    protected void SetStartEndPoint(Point start, Point end, String type) throws Exception
    {
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.StartEndPoint);
        Click(start);
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.StartEndPoint);
        Click(end);
        Click(type);
        Click("save_button");
        tipsNum++;
    }

    //在我的数据中删除对应名字的tip
    protected void DeleteTipInMyData(String... names)
    {
        GotoMyData("rb_condition_tips");

        for (String name : names)
        {
            UiObject2 object = mDevice.wait(Until.findObject(By.text(name)), 3000);
            object.click();

            Click("delete_button");
            Click("btn_fm_confirm");
            tipsNum--;
        }

        ExitMyData();
    }

    //获取10个点位的真实距离。
    protected double GetDistance100Pixel()
    {
        Click("btn_distance_measure");
        Click(new Point(1000, 1000));
        Click(new Point(1000, 1000+100));

        UiObject2 editName = mDevice.wait(Until.findObject(By.res(packageName, "tv_distance_measure_value")), 500);
        String value = editName.getText();
        double ivalue = Double.parseDouble(value);
        mDevice.pressBack();

        return ivalue;
    }

    //增加电子眼
    protected void AddElecEye(Point point) throws UiObjectNotFoundException
    {
        Click(MultPoint4);
        Click(newElecEye);
        Click(point);

        Click("tv_electronic_eye_type_more");

        Click("electronic_eye_overspeed");

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));

        UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "40");
        Object.click();

        Click("save_button");
        tipsNum++;
    }

    //增加区域属性
    protected void AddRegional(Point point, String type)
    {
        Click(MultPoint6);
        Click(newRegional);
        Click(point);
        Click(type);
        Click("save_button");

        tipsNum++;
    }

    private static  String GetUserPathHM() throws IOException
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
            return "";
        }

        if(userName.equals("collector"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/21_HM/";
        }
        if(userName.equals("collector1"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/23_HM/";
        }
        if(userName.equals("collector2"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/24_HM/";
        }
        if(userName.equals("zhanglingling03655"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/3655_HM/";
        }
        return "";
    }

    private static  String GetUserPath() throws IOException
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
            return "";
        }

        if(userName.equals("collector"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/21/";
        }
        if(userName.equals("collector1"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/23/";
        }
        if(userName.equals("collector2"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/24/";
        }
        if(userName.equals("zhanglingling03655"))
        {
            return "/sdcard/" + dirName + "/Data/Collect/3655/";
        }
        return "";
    }

    void CheckMyData(String type, String name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);

        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);

        Page_MyData.Inst.CheckVaild(type, name);
        Page_MyData.Inst.Click(Page_MyData.BACK);

        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    protected static UiDevice mDevice;
    protected static String packageName = "com.fastmap.hd";

    protected static Point MultPoint0 = new Point(100, 1010);
    protected static Point MultPoint1 = new Point(100, 1120);
    protected static Point MultPoint2 = new Point(100, 1260);
    protected static Point beijingMap = new Point(636, 460);
    protected static Point MultPoint4 = new Point(720, 1430);
    protected static Point MultPoint5 = new Point(840, 1430);
    protected static Point MultPoint6 = new Point(1300, 1430);

    protected static EnumLayer eCurrLayer = EnumLayer.Layer_Main;

    protected static int tipsNum = 0;
    protected static int poiNum = 0;
    protected static int infoPOINum = 0;
    protected static int infoRoadNum = 0;
    protected static int infoGateType = 0;

    protected static Point newPOIPoint = new Point((152-36)/2+36, (834-718)/2+718);
    protected static Point newTrafficLight = new Point(370, 1440);
    protected static Point newDrawRoardReal = new Point(230, 990);
    protected static Point newDrawTrackLimit = new Point(356, 976);
    protected static Point newPas = new Point(353,1038);
    protected static Point newElecEye = new Point(720,1150);
    protected static Point newRoadNameSign = new Point(366, 1240);
    protected static Point newDirectBoard = new Point(220, 730);
    protected static Point newLandNum = new Point(840, 1030);
    protected static Point newStartEnd = new Point(1670, 1450);
    protected static Point newRamp = new Point(1450, 1140);
    protected static Point newTollStation = new Point(584, 1130);
    protected static Point newRegional = new Point(1200, 1140);

    protected static String userPath = "";
    protected static SqliteTools m_Sqlit = null;

    private static String userName = "";
    private static String passWord = "";
}
