package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.By;
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
public class testFastMapFS extends testFastMapBase
{

    @BeforeClass
    public static void setClassUp() throws Exception
    {

//        String dbPath =Environment.getExternalStorageDirectory().getPath() + "/FastMap18Summer/Data/Collect/3655/coremap.sqlite";
//
//        SQLiteDatabase db=SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY, null);
//        Cursor cursor = db.rawQuery("select * from edit_tips", null);
//
//        while (cursor.moveToNext())
//        {
//            String str2 = cursor.getString(0);
//        }
//
//        db.close();

//        testFastMapBase.setClassUp();
    }

    @AfterClass
    public static void setClassDown() throws InterruptedException, IOException
    {
    }

    @Before
    public void setUp() throws Exception
    {
        super.setClassUp("collect", "123456");
    }

    @After
    public  void setAfter() throws IOException, InterruptedException
    {

    }

    @Test
    public void test00101_poi_add() throws InterruptedException, UiObjectNotFoundException
    {
        Click(newPOIPoint, 6000);

        Click("take_pic_imgbtn");
        Click("task_pic_back_img");

        PutinEditor("fm_et_name", "测试ＰＯＩ");

        Click("tv_assort_type");

        UiObject object1=new UiObject(new UiSelector().text("中餐馆"));
        object1.click();

        Click("save_button");
        poiNum++;

        GotoMyData("rb_condition_poi");

        assertEditorEqual("tv_my_data_count_2", Integer.toString(poiNum));
        assertNotNull(Until.findObject(By.desc("测试ＰＯＩ")));

        ExitMyData();

        String strUid;
        //m_Sqlit.CheckTipsIcons(strUid, "");
        //m_Sqlit.GetTipsDisplayText(rowkey);
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
    public void test00301_tips_line_DrawRoad_add() throws Exception
    {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
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

        UiObject2 obj = mDevice.wait(Until.findObject(By.textContains("测线")),500);
        assertNotNull(obj);

        obj.click();

        String rowkey = mDevice.wait(Until.findObject(By.res(packageName, "et_title")), 500).getText();
        rowkey = rowkey.substring("rowkey：".length());

        Click("cancel_button");

        ExitMyData();

        //m_Sqlit.RefreshData();
        //assertEquals(m_Sqlit.GetTipsDisplayText(rowkey), " 1 车道 | K1");
    }

    @Test
    public void test00401_tips_releation_TrackLimit_add()
    {
        Click(MultPoint2);
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

        Click(MultPoint0);
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
        Click("infor_report_type_poi");
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
        Click("infor_report_type_poi");
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
    public  void test01201_tips_Eyes_SpeedType_Add_Modify_Del() throws InterruptedException, UiObjectNotFoundException
    {
        String SpeedEyes[] = {"electronic_eye_overspeed",
                "electronic_eye_ultra_low_speed",
                "electronic_eye_move_velocity_measurement",
                "electronic_eye_variable_velocity_measurement",
                "electronic_eye_sub_lane_speed_measurement",
                "electronic_eye_vehicle_metering_speed",
                "electronic_eye_interval_start",
                "electronic_eye_interval_end"};

        for (String type : SpeedEyes)
        {
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            Click(MultPoint4);
            Click(newElecEye);
            Click(GetCenter());

            Click("tv_electronic_eye_type_more");

            Click(type);

            UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));

            UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "40");
            Object.click();

            Click("save_button");
            tipsNum++;

            GotoMyData("rb_condition_tips");

            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object = mDevice.wait(Until.findObject(By.text("电子眼")), 3000);
            assertNotNull(object);

            object.click();
            Click("delete_button");
            Click("btn_fm_confirm");

            tipsNum--;
            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object2 = mDevice.wait(Until.findObject(By.desc("电子眼")), 3000);
            Assert.assertEquals(object2, null);

            ExitMyData();
        }
    }

    @Test
    public void test01202_tips_Eyes_TimeType_Add_Modify_Del() throws InterruptedException, UiObjectNotFoundException
    {

        String TimeEyes[]  = {"electronic_eye_bus_lane",
                "electronic_eye_one_way_street"};

        for (String type : TimeEyes)
        {
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            Click(MultPoint4);
            Click(newElecEye);
            Click(GetCenter());

            Click("tv_electronic_eye_type_more");

            Click(type);

            UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));

            UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "增加时间");
            Object.click();

            Click("btn_fm_confirm");

            Click("save_button");
            tipsNum++;

            GotoMyData("rb_condition_tips");

            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object = mDevice.wait(Until.findObject(By.text("电子眼")), 3000);
            assertNotNull(object);

            object.click();
            Click("delete_button");
            Click("btn_fm_confirm");

            tipsNum--;
            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object2 = mDevice.wait(Until.findObject(By.desc("电子眼")), 3000);
            Assert.assertEquals(object2, null);

            ExitMyData();
        }
    }

    @Test
    public void test01203_tips_Eyes_CarType_Add_Modify_Del() throws InterruptedException, UiObjectNotFoundException
    {

        String CarTypeEyes[] = {"electronic_eye_traffic_controls",
                "electronic_eye_environmental_protection_limit"};

        for (String type : CarTypeEyes)
        {
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            Click(MultPoint4);
            Click(newElecEye);
            Click(GetCenter());

            Click("tv_electronic_eye_type_more");

            Click(type);

            UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));

            UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "增加时间");
            Object.click();

            Click("btn_fm_confirm");

            Object = objscoll.getChildByText(new UiSelector().className("android.widget.CheckBox"), "卡车");
            Object.click();

            Click("save_button");
            tipsNum++;

            GotoMyData("rb_condition_tips");

            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object = mDevice.wait(Until.findObject(By.text("电子眼")), 3000);
            assertNotNull(object);

            object.click();
            Click("delete_button");
            Click("btn_fm_confirm");

            tipsNum--;
            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object2 = mDevice.wait(Until.findObject(By.desc("电子眼")), 3000);
            Assert.assertEquals(object2, null);

            ExitMyData();
        }
    }

    @Test
    public void test01204_tips_Eyes_CommonType_Add_Modify_Del()throws InterruptedException, UiObjectNotFoundException
    {
        String CommonEyes[] = {"electronic_eye_not_vehicle_lane",
                "electronic_eye_no_turning_around",
                "electronic_eye_illegal_parking",
                "electronic_eye_emergency_lane",
                "electronic_eye_traffic_lights",
                "electronic_eye_traffic_marking",
                "electronic_eye_exit_entrance",
                "electronic_eye_courtesy_pedestrian",
                "electronic_eye_no_audible_warning",
                "electronic_eye_no_turn_off",
                "electronic_eye_violating_lane",
                "electronic_eye_lllegal_corssing",
                "electronic_eye_violation_prohibition_sign",
                "electronic_eye_lllegal_light",
                "electronic_eye_no_seat_belt",
                "electronic_eye_drive_cell_phone",
                "electronic_eye_road_condition_monitoring",
                "electronic_eye_non_annual_inspection",
                "electronic_eye_tail_gas_exceeding_standard",};

        for(String type : CommonEyes)
        {
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            Click(MultPoint4);
            Click(newElecEye);
            Click(GetCenter());

            Click("tv_electronic_eye_type_more");

            Click(type);

            Click("save_button");
            tipsNum++;

            GotoMyData("rb_condition_tips");

            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object =mDevice.wait(Until.findObject(By.text("电子眼")), 3000);
            assertNotNull(object);

            object.click();
            Click("delete_button");
            Click("btn_fm_confirm");

            tipsNum--;
            assertEditorEqual("tv_my_data_count_2", Integer.toString(tipsNum));
            UiObject2 object2 =mDevice.wait(Until.findObject(By.desc("电子眼")), 3000);
            Assert.assertEquals(object2, null);

            ExitMyData();
        }
    }

    @Test
    public void test01301_data_check() throws UiObjectNotFoundException, InterruptedException
    {
        //左侧车道必须大于或等于右侧车道的限速值域（数组从小到大顺序）
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);
        //创建限速车道从左到右分别为90,110，110
        Click(new Point(969, 1447), 1000);
        Click(new Point(mDevice.getDisplayWidth()/2-250, mDevice.getDisplayHeight()/2-250));
        Click("card_speed_limit_type_driveway",100);//选择车道限速
        mDevice.drag(77, 632, 225, 643, 10);
        mDevice.drag(77, 632, 225, 643, 10);
        Click(new Point(79,552),1000);
        Click("speed_limit_number_90", 1000);
        Click("speed_limit_number_110", 1000);
        Click("speed_limit_number_110", 1000);
        Click(new Point(75,475),1000);//点限速必选一个
        Click("save_button", 1000);
        Thread.sleep(3000);
        tipsNum++;

        //室内整理工具检查，车道限速
        AssertIndoorCheck("车道限速","中","FM-1113-2-2","左侧车道限速小于右侧车道限速","");
    }

    @Test
    public void test01301_IndoorCheck_FM_1401_7_1() throws UiObjectNotFoundException
    {
        //方向看板Tips，必须至少添加一张照片
        mDevice.drag(700, 823, 1024, 823, 10);

        Click(MultPoint1);
        Click(newDirectBoard);
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
    public void test01302_IndoorCheck_FM_1401_6_1() throws UiObjectNotFoundException
    {
        //方向看板关联在前道路级别为K1、K2、K8~K13

        String[] lineTypeArray = {"card_nine_rd", "card_pedestrian_rd", "card_people_crossing", "card_ferry"};

        for (String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);

            Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
            DrawRoad(arrayPoint, type);

            Click(MultPoint1);
            Click(newDirectBoard);
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
    public void test01305_IndoorCheck_FM_1401_6_1() throws UiObjectNotFoundException
    {
        //方向看板关联在前道路级别为K3、4、6
        String[] lineTypeArray = {"card_national_rd", "card_provincial_rd", "card_county_rd"};

        for (String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);

            Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
            DrawRoad(arrayPoint, type);

            Click(MultPoint1);
            Click(newDirectBoard);
            Click(new Point(1000, 500));
            Click("save_button");
            tipsNum++;

            AssertIndoorCheckNull("FM-1401-6-1");

            DeleteTipInMyData("方向看板", "测线");
        }
    }


    @Test
    public void test01306_IndoorCheck_FM_2001_6_1() throws UiObjectNotFoundException
    {
        //新增测线（t_sync=0）本身的车道数<>0时，测线上有车道数Tips时，报log
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
        DrawRoad(arrayPoint);

        Click(MultPoint5);
        Click(newLandNum);
        Click(new Point(1000, 500));
        Click("lane_num_1");

        tipsNum++;

        AssertIndoorCheck("测线", "中", "FM-2001-6-1", "测线车道数记录在属性中，请删除关联测线的车道数Tips", "");

        DeleteTipInMyData("车道数", "测线");

        AssertIndoorCheckNull("FM-2001-6-1");
    }

    @Test
    public void test01307_IndoorCheck_FM_1504_5_1() throws UiObjectNotFoundException
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
    public void test01308_IndoorCheck_FM_1505_5_1() throws UiObjectNotFoundException
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
    public void test01309_IndoorCheck_FM_1509_6_1() throws UiObjectNotFoundException
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
    public void test01310_IndoorCheck_FM_1509_6_1() throws UiObjectNotFoundException
    {
        //跨线立交桥与桥互斥
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "cross_line_overpass_bt");
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "bridge_bt");

        AssertIndoorCheck("中", "跨线立交桥", "FM-1509-6-1", "跨线立交桥与桥、匝道、隧道属性不能共存", "不能忽略");

        DeleteTipInMyData("固定桥", "跨线立交桥", "测线");

        mDevice.drag(700, 823, 1024, 823, 10);
        Point[] arrayPoint2 = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], "cross_line_overpass_bt");
        SetStartEndPoint(new Point(arrayPoint2[1].x-100, arrayPoint2[1].y), arrayPoint2[2], "bridge_bt");

        AssertIndoorCheckNull("FM-1509-6-1");

        DeleteTipInMyData("固定桥", "跨线立交桥", "测线");
    }

    @Test
    public void test01311_IndoorCheck_FM_1509_6_1() throws UiObjectNotFoundException
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
    public void test01314_IndoorCheck_FM_1109_6_7() throws UiObjectNotFoundException
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
    public void test01315_IndoorCheck_FM_1109_6_7() throws UiObjectNotFoundException
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
    public void test01316_IndoorCheck_FM_1109_6_7() throws UiObjectNotFoundException
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

        CheckSyncResult();

        Click("grid_sync_btn_positive");

        ExitGridManager();
    }

}