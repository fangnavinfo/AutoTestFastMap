package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import com.fastmap.ui.*;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static junit.framework.Assert.fail;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import com.fastmap.ui.FastMapUI;
import com.fastmap.ui.FastMapUI.*;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapFS extends testFastMapBase
{

    @BeforeClass
    public static void setClassUp() throws Exception
    {

    }

    @AfterClass
    public static void setClassDown() throws Exception
    {

    }

    @Before
    public void setUp() throws Exception
    {
        this.setClassUp("collector", "123456");
    }

    @After
    public  void setAfter() throws IOException, InterruptedException
    {

        super.setAfter();
    }

    @Test
    public void test00101_poi_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.CheckVaild(Page_MyData.POI_TYPE, "测试ＰＯＩ");
    }

    @Test
    public void test00201_tips_point_TrafficLight_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.Click(GetCenter());

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.CheckVaild(Page_MyData.TIPS_TYPE, "红绿灯");
    }

    @Test
    public void test00301_tips_line_DrawRoad_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.CheckVaild(Page_MyData.TIPS_TYPE, "测线");

//        String strType = "rb_condition_tips";
//        GotoMyData(strType);
//
//        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
//        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
//
//        UiObject2 obj = mDevice.wait(Until.findObject(By.textContains("测线")),500);
//        assertNotNull(obj);
//
//        obj.click();
//
//        String rowkey = mDevice.wait(Until.findObject(By.res(packageName, "et_title")), 500).getText();
//        rowkey = rowkey.substring("rowkey：".length());
//
//        Click("cancel_button");
//
//        ExitMyData();

//        m_Sqlit.RefreshData();
//        assertEquals(m_Sqlit.GetTipsDisplayText(rowkey), " 1 车道 | K1");
    }

    @Test
    public void test00401_tips_releation_TrackLimit_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000, 1000));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.FORB_LEFT);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "卡车交限");
    }


    @Test
    public void test00501_QCTask_add() throws Exception
    {
        GotoIndoorTools();

        Page_MainBoard.Inst.Click(Page_MainBoard.QC_TASK);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.Click(GetCenter());

        Page_QCProblem.Inst.SelectError("不受灯控LINK选择错误");
        Page_QCProblem.Inst.Click(Page_QCProblem.SAVE);

        Page_IndoorMyData.Inst.CheckQcDataExist("红绿灯");

        ExitIndoorTools();

    }

    @Test
    public void test00601_Precise_Pas_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        CheckMyData(Page_MyData.PAS_TYPE, "测试ＰＡＳ１０１");
    }

    @Test
    public void test00701_info_Point_add() throws Exception
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO);

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试点ＩＮＦＯ");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);

        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);

        Thread.sleep(1000);

        Page_MainBoard.Inst.Click(GetCenter());

        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);

        CheckMyData(Page_MyData.INFO_TYPE, "自采集情报(POI)(点)");
    }

    @Test
    public void test00801_info_Line_add() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {

        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO);

        Thread.sleep(1000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试线ＩＮＦＯ");
        Page_InfoLine.Inst.Click(Page_InfoLine.POI_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);

        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);

        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        CheckMyData(Page_MyData.INFO_TYPE, "自采集情报(POI)(线)");
    }



    @Test
    public void test00901_info_Frame_add() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO);

        Thread.sleep(1000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);

        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.SetValue(Page_InfoFrame.NAME, "测试面ＩＮＦＯ");
        Page_InfoFrame.Inst.Click(Page_InfoFrame.ROAD_TYPE);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME_CONFIRM);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.CAMERA);

        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);

        Page_InfoFrame.Inst.Click(Page_InfoFrame.SAVE);

        CheckMyData(Page_MyData.INFO_TYPE, "自采集情报(道路)(面)");
    }

    @Test
    public  void test01201_tips_Eyes_SpeedType_Add_Modify_Del() throws Exception
    {
        String SpeedEyes[] = {
                Page_ElecEye.EYE_INTERVAL_END,
                Page_ElecEye.EYE_OVERSPEED,
                Page_ElecEye.EYE_LOWSPEED,
                Page_ElecEye.EYE_MOVE,
                Page_ElecEye.EYE_VAR,
                Page_ElecEye.EYE_LANE_SPEED,
                Page_ElecEye.EYE_VEHICLE
        };


        for (String type : SpeedEyes)
        {
            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.Click(GetCenter());

            Page_ElecEye.Inst.SetSpeed("40");
            Page_ElecEye.Inst.Click(Page_ElecEye.TYPE_MORE);
            Page_ElecEye.Inst.Click(type);
            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

            Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);

            Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);

            Page_MyData.Inst.CheckVaild(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.SelectData("电子眼");

            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.Click(Page_MyData.BACK);

            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test
    public void test01202_tips_Eyes_TimeType_Add_Modify_Del() throws Exception
    {
        String TimeEyes[]  = {
                Page_ElecEye.EYE_BUS_LANE,
                Page_ElecEye.EYE_ONE_WAY,
        };

        for (String type : TimeEyes)
        {
            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.Click(GetCenter());

            Page_ElecEye.Inst.Click(type);
            Page_ElecEye.Inst.Click(Page_ElecEye.TIME);
            Page_ElecEye.Inst.Click(Page_ElecEye.TIME_CONFIRM);

            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

            Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);

            Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);

            Page_MyData.Inst.CheckVaild(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.SelectData("电子眼");

            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.Click(Page_MyData.BACK);

            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test
    public void test01203_tips_Eyes_CarType_Add_Modify_Del() throws Exception
    {

        String CarTypeEyes[] = {
                Page_ElecEye.EYE_NUM_CTRL,
                Page_ElecEye.EYE_ENV_PROT};

        for (String type : CarTypeEyes)
        {
            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.Click(GetCenter());

            Page_ElecEye.Inst.Click(Page_ElecEye.TYPE_MORE);
            Page_ElecEye.Inst.Click(type);
            Page_ElecEye.Inst.ScrollClick(Page_ElecEye.TIME);
            Page_ElecEye.Inst.Click(Page_ElecEye.TIME_CONFIRM);
            Page_ElecEye.Inst.ScrollClick(Page_ElecEye.TRUCK);
            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

            Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);

            Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);

            Page_MyData.Inst.CheckVaild(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.SelectData("电子眼");

            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.Click(Page_MyData.BACK);

            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test
    public void test01204_tips_Eyes_CommonType_Add_Modify_Del() throws Exception
    {
        String CommonEyes[] = {
                Page_ElecEye.EYE_NO_VECHICLE,
                Page_ElecEye.EYE_NO_TURN,
                Page_ElecEye.EYE_ILLEGAL_PARKING,
                Page_ElecEye.EYE_EMERG_LANE,
                Page_ElecEye.EYE_TRAFFIC_LIGHT,
                Page_ElecEye.EYE_TRAFFIC_MARK,
                Page_ElecEye.EYE_EXIT_ENTER,
                Page_ElecEye.EYE_PEDESTRIAN,
                Page_ElecEye.EYE_AUD_WAIN,
                Page_ElecEye.EYE_NO_TURNOFF,
                Page_ElecEye.EYE_VIOLAT_LANE,
                Page_ElecEye.EYE_ILLEGAL_CROSS,
                Page_ElecEye.EYE_VIOLAT_SIGN,
                Page_ElecEye.EYE_ILLEGAL_LIGHT,
                Page_ElecEye.EYE_NO_BELT,
                Page_ElecEye.EYE_DRIVE_PHONE,
                Page_ElecEye.EYE_ROAD_MONITOR,
                Page_ElecEye.EYE_NO_INSPECTION,
                Page_ElecEye.EYE_TAIL_GAS,
        };

        for(String type : CommonEyes)
        {
            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.Click(GetCenter());

            Page_ElecEye.Inst.Click(Page_ElecEye.TYPE_MORE);
            Page_ElecEye.Inst.Click(type);
            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);


            Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);

            Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);

            Page_MyData.Inst.CheckVaild(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.SelectData("电子眼");

            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.Click(Page_MyData.BACK);

            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test
    public void test01301_IndoorCheck_FM_1401_7_1() throws Exception
    {
        //方向看板Tips，必须至少添加一张照片
        mDevice.drag(700, 823, 1024, 823, 10);

        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.DIRECTION_BOARD);

        Click(new Point(1000, 500));
        Click("save_button");
        tipsNum++;

        AssertIndoorCheck("方向看板", "高", "FM-1401-7-1", "方向看板，必须添加现场照片", "");

        GotoMyData("rb_condition_tips");

        UiObject2 object =mDevice.wait(Until.findObject(By.text("方向看板")), 3000);
        object.click();
        Click("camera_button");
        Click("take_pic_imgbtn");
        mDevice.pressBack();
        Click("save_button");

        ExitMyData();

        AssertIndoorCheckNull("FM-1401-7-1");

        GotoMyData("rb_condition_tips");

        object =mDevice.wait(Until.findObject(By.text("方向看板")), 3000);
        object.click();
        Click("delete_button");
        Click("btn_fm_confirm");
        tipsNum--;

        ExitMyData();

        AssertIndoorCheckNull("FM-1401-7-1");
    }



    @Test
    public void test01302_IndoorCheck_FM_1401_6_1() throws Exception
    {
        //方向看板关联在前道路级别为K1、K2、K8~K13

        String[] lineTypeArray = {"card_nine_rd", "card_pedestrian_rd", "card_people_crossing", "card_ferry"};

        for (String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);

            Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
            DrawRoad(arrayPoint, type);

            FastMapUI.pressBtnMainBoard(TipsDeepDictionary.DIRECTION_BOARD);

            Click(new Point(1000, 500));
            Click("save_button");
            tipsNum++;

            AssertIndoorCheck("方向看板", "中", "FM-1401-6-1", "采集方向看板应该采集在7级上下分离或6级及以上的普通道路（3、4、6）上", "");

            GotoMyData("rb_condition_tips");

            UiObject2 object =mDevice.wait(Until.findObject(By.text("方向看板")), 3000);
            object.click();

            Click("delete_button");
            Click("btn_fm_confirm");
            tipsNum--;

            ExitMyData();

            AssertIndoorCheckNull("FM-1401-6-1");

            DeleteTipInMyData("测线");
        }
    }

    @Test
    public void test01305_IndoorCheck_FM_1401_6_1() throws Exception
    {
        //方向看板关联在前道路级别为K3、4、6
        String[] lineTypeArray = {"card_national_rd", "card_provincial_rd", "card_county_rd"};

        for (String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);

            Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
            DrawRoad(arrayPoint, type);

            FastMapUI.pressBtnMainBoard(TipsDeepDictionary.DIRECTION_BOARD);

            Click(new Point(1000, 500));
            Click("save_button");
            tipsNum++;

            AssertIndoorCheckNull("FM-1401-6-1");

            DeleteTipInMyData("方向看板", "测线");
        }
    }


    @Test
    public void test01306_IndoorCheck_FM_2001_6_1() throws Exception
    {
        //新增测线（t_sync=0）本身的车道数<>0时，测线上有车道数Tips时，报log
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
        DrawRoad(arrayPoint);

        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.LANE_NUMBER);

        Click(new Point(1000, 500));
        Click("lane_num_1");

        tipsNum++;

        AssertIndoorCheck("测线", "中", "FM-2001-6-1", "测线车道数记录在属性中，请删除关联测线的车道数Tips", "");

        DeleteTipInMyData("车道数", "测线");

        AssertIndoorCheckNull("FM-2001-6-1");
    }

    @Test
    public void test01307_IndoorCheck_FM_1504_5_1() throws Exception
    {
        //跨越桥的几何长度要小于800m时，报log
        mDevice.drag(700, 823, 1024, 823, 10);

        int MAX_LEN = 790;

        double Distance = GetDistance100Pixel();

        Point[] arrayPoint = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2))};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[2], "overpass_bt");

        AssertIndoorCheck("OverPass", "低", "FM-1504-5-1", "跨越桥长度小于800米，不需要采集！", "可以忽略");

        DeleteTipInMyData("Overpass");

        //跨越桥的几何长度大于800m时，不报log
        mDevice.drag(700, 823, 1024, 823, 10);

        MAX_LEN = 810;

        Point[] arrayPoint2 = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2))};
        DrawRoad(arrayPoint2);

        SetStartEndPoint(arrayPoint2[0], arrayPoint2[2], "overpass_bt");

        AssertIndoorCheckNull("FM-1504-5-1");

        DeleteTipInMyData("Overpass", "测线");
    }

    @Test
    public void test01308_IndoorCheck_FM_1505_5_1() throws Exception
    {
        //穿越地道的几何长度要小于800m时, 报log
        mDevice.drag(700, 823, 1024, 823, 10);

        int MAX_LEN = 790;

        double Distance = GetDistance100Pixel();

        Point[] arrayPoint = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2))};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[2], "under_pass_bt");

        AssertIndoorCheck("Underpass", "低", "FM-1505-5-1", "穿越地道长度小于800米，不需要采集！", "可以忽略");

        DeleteTipInMyData("Underpass");

        //跨越桥的几何长度大于800m时，不报log
        mDevice.drag(700, 823, 1024, 823, 10);

        MAX_LEN = 810;

        Point[] arrayPoint2 = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2))};
        DrawRoad(arrayPoint2);

        SetStartEndPoint(arrayPoint2[0], arrayPoint2[2], "under_pass_bt");

        AssertIndoorCheckNull("FM-1505-5-1");

        DeleteTipInMyData("Underpass", "测线", "测线");
    }

    @Test
    public void test01309_IndoorCheck_FM_1509_6_1() throws Exception
    {
        //跨线立交桥与匝道互斥
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[2], "cross_line_overpass_bt");

        Click(MultPoint6);
        Click(newRamp);
        Click(arrayPoint[1]);
        Click("btn_ramp");
        Click("save_button");

        AssertIndoorCheck("中", "跨线立交桥", "FM-1509-6-1", "跨线立交桥与桥、匝道、隧道属性不能共存", "不能忽略");

        DeleteTipInMyData("匝道");

        AssertIndoorCheckNull("FM-1059-6-1");

        DeleteTipInMyData("跨线立交桥", "测线");
    }

    @Test
    public void test01310_IndoorCheck_FM_1509_6_1() throws Exception
    {
        //跨线立交桥与桥互斥
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "cross_line_overpass_bt");
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "bridge_bt");

        AssertIndoorCheck("中", "跨线立交桥", "FM-1509-6-1", "跨线立交桥与桥、匝道、隧道属性不能共存", "不能忽略");

        DeleteTipInMyData("桥", "跨线立交桥", "测线");

        mDevice.drag(700, 823, 1024, 823, 10);
        Point[] arrayPoint2 = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "cross_line_overpass_bt");
        SetStartEndPoint(new Point(arrayPoint2[1].x-100, arrayPoint2[1].y), arrayPoint2[2], "bridge_bt");

        AssertIndoorCheckNull("FM-1509-6-1");

        DeleteTipInMyData("固定桥", "跨线立交桥", "测线");
    }

    @Test
    public void test01311_IndoorCheck_FM_1509_6_1() throws Exception
    {
        //跨线立交桥与隧道互斥
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "cross_line_overpass_bt");
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "tunnel_bt");

        AssertIndoorCheck("中", "跨线立交桥", "FM-1509-6-1", "跨线立交桥与桥、匝道、隧道属性不能共存", "不能忽略");

        DeleteTipInMyData("隧道", "跨线立交桥", "测线");

        mDevice.drag(700, 823, 1024, 823, 10);
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "cross_line_overpass_bt");
        SetStartEndPoint(new Point(arrayPoint[1].x-100, arrayPoint[1].y), arrayPoint[2], "tunnel_bt");

        AssertIndoorCheckNull("FM-1509-6-1");

        DeleteTipInMyData("隧道", "跨线立交桥", "测线");
    }


    @Test
    public void test01314_IndoorCheck_FM_1109_6_7() throws Exception
    {
        //10级、11级、13级测线采集摄像头
        mDevice.drag(700, 823, 1024, 823, 10);

        String[] lineTypeArray = {"card_pedestrian_rd", "card_people_crossing", "card_ferry"};

        for(String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);

            Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
            DrawRoad(arrayPoint, type);

            AddElecEye(arrayPoint[0]);

            AssertIndoorCheck("中", "电子眼", "FM-1109-6-7", "10级、人渡、轮渡、具有区域内道路属性的8级路不采集摄像头", "不能忽略");

            DeleteTipInMyData("电子眼", "测线");

            AssertIndoorCheckNull("FM-1109-6-7");
        }

    }

    @Test
    public void test01315_IndoorCheck_FM_1109_6_7() throws Exception
    {
        //8级区域内测线采集摄像头
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};

        DrawRoad(arrayPoint, "card_other_rd");

        AddRegional(arrayPoint[0], "card_intra_regional_road");
        AddElecEye(arrayPoint[0]);

        AssertIndoorCheck("中", "电子眼", "FM-1109-6-7", "10级、人渡、轮渡、具有区域内道路属性的8级路不采集摄像头", "不能忽略");

        DeleteTipInMyData("电子眼");

        AssertIndoorCheckNull("FM-1109-6-7");
    }

    @Test
    public void test01316_IndoorCheck_FM_1109_6_7() throws Exception
    {
        //其他正常情况采集摄像头
        mDevice.drag(700, 823, 1024, 823, 10);

        String[] lineTypeArray = {"card_high_speed", "card_city_high_speed", "card_national_rd", "card_provincial_rd",
                "card_county_rd", "card_other_rd", "card_township_village_rd",};

        for(String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);

            Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
            DrawRoad(arrayPoint, type);

            AddElecEye(arrayPoint[0]);

            AssertIndoorCheckNull("FM-1109-6-7");

            DeleteTipInMyData("电子眼", "测线");
        }
    }

    @Test
    public void test1000_SyncData() throws InterruptedException, UiObjectNotFoundException, NoSuchFieldException, ClassNotFoundException
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

        CheckSyncResult();

        Click("grid_sync_btn_positive");

        ExitGridManager();
    }
}