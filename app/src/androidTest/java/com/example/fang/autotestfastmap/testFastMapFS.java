package com.example.fang.autotestfastmap;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
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
import android.util.Log;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
    public void setUp()
    {
    }

    @After
    public  void setAfter() throws IOException, InterruptedException
    {

        super.setAfter();
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

        m_Sqlit.RefreshData();
        assertEquals(m_Sqlit.GetTipsDisplayText(rowkey), " 1 车道 | K1");
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

        Click(MultPoint2);
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

            Click(MultPoint3);
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

            Click(MultPoint3);
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

            Click(MultPoint3);
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

            Click(MultPoint3);
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

        String[] lineTypeArray = {"card_high_speed", "card_city_high_speed",
                                  "card_other_rd", "card_nine_rd", "card_pedestrian_rd", "card_people_crossing", "card_ferry"};

        for (String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);


            Click(MultPoint2);
            Click(newDrawRoardReal);

            Click(new Point(1000, 1000));

            Click(new Point(1000, 500));

            Click(new Point(500, 1000));

            Click(type);
            Click("lane_num_1");
            Click("save_button");
            tipsNum++;

            Click(MultPoint1);
            Click(newDirectBoard);
            Click(new Point(1000, 500));
            Click("save_button");
            tipsNum++;

            AssertIndoorCheck("方向看板", "中", "FM-1401-6-1", "采集方向看板应该采集在7级上下分离或6级及以上的普通道路（3,4,6）上", "");

            GotoMyData("rb_condition_tips");

            UiObject2 object =mDevice.wait(Until.findObject(By.text("方向看板")), 3000);
            object.click();

            Click("delete_button");
            Click("btn_fm_confirm");
            tipsNum--;

            ExitMyData();

            AssertIndoorCheckNull("FM-1401-6-1");
        }
    }

    @Test
    public void test01303_IndoorCheck_FM_1401_6_1() throws UiObjectNotFoundException
    {
        //方向看板关联在前道路级别为K7上下分离
        mDevice.drag(700, 823, 1024, 823, 10);

        Click(MultPoint2);
        Click(newDrawRoardReal);

        Click(new Point(1000, 1000));

        Click(new Point(1000, 500));

        Click(new Point(500, 1000));

        Click("card_township_village_rd");
        Click("lane_num_1");
        Click("save_button");
        tipsNum++;

        Click(newStartEnd);
        Click(new Point(1000, 500));
        Click(newStartEnd);
        Click(new Point(500, 1000));
        Click("up_low_separation_bt");
        Click("save_button");
        tipsNum++;

        Click(MultPoint1);
        Click(newDirectBoard);
        Click(new Point(1000, 500));
        Click("save_button");
        tipsNum++;

        AssertIndoorCheck("方向看板", "中", "FM-1401-6-1", "采集方向看板应该采集在7级上下分离或6级及以上的普通道路（3,4,6）上", "");

        GotoMyData("rb_condition_tips");

        UiObject2 object =mDevice.wait(Until.findObject(By.text("方向看板")), 3000);
        object.click();

        Click("delete_button");
        Click("btn_fm_confirm");
        tipsNum--;

        ExitMyData();

        AssertIndoorCheckNull("FM-1401-6-1");
    }

    @Test
    public void test01304_IndoorCheck_FM_1401_6_1() throws UiObjectNotFoundException
    {
        //方向看板关联在前道路级别为K7没有上下分离
        mDevice.drag(700, 823, 1024, 823, 10);

        Click(MultPoint2);
        Click(newDrawRoardReal);

        Click(new Point(1000, 1000));

        Click(new Point(1000, 500));

        Click(new Point(500, 1000));

        Click("card_township_village_rd");
        Click("lane_num_1");
        Click("save_button");
        tipsNum++;

        Click(MultPoint1);
        Click(newDirectBoard);
        Click(new Point(1000, 500));
        Click("save_button");
        tipsNum++;

        AssertIndoorCheckNull("FM-1401-6-1");

        GotoMyData("rb_condition_tips");

        UiObject2 object =mDevice.wait(Until.findObject(By.text("方向看板")), 3000);
        object.click();

        Click("delete_button");
        Click("btn_fm_confirm");
        tipsNum--;

        ExitMyData();
    }

    @Test
    public void test01305_IndoorCheck_FM_1401_6_1() throws UiObjectNotFoundException
    {
        //方向看板关联在前道路级别为K3、4、6
        String[] lineTypeArray = {"card_national_rd", "card_provincial_rd", "card_county_rd"};

        for (String type : lineTypeArray)
        {
            mDevice.drag(700, 823, 1024, 823, 10);

            Click(MultPoint2);
            Click(newDrawRoardReal);

            Click(new Point(1000, 1000));

            Click(new Point(1000, 500));

            Click(new Point(500, 1000));

            Click(type);
            Click("lane_num_1");
            Click("save_button");
            tipsNum++;

            Click(MultPoint1);
            Click(newDirectBoard);
            Click(new Point(1000, 500));
            Click("save_button");
            tipsNum++;

            AssertIndoorCheckNull("FM-1401-6-1");

            GotoMyData("rb_condition_tips");

            UiObject2 object = mDevice.wait(Until.findObject(By.text("方向看板")), 3000);
            object.click();

            Click("delete_button");
            Click("btn_fm_confirm");
            tipsNum--;

            ExitMyData();
        }
    }


    @Test
    public void test01306_IndoorCheck_FM_2001_6_1() throws UiObjectNotFoundException
    {
        //新增测线（t_sync=0）本身的车道数<>0时，测线上有车道数Tips时，报log
        mDevice.drag(700, 823, 1024, 823, 10);

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
        DrawRoad(arrayPoint);

        Click(MultPoint4);
        Click(newLandNum);
        Click(new Point(1000, 500));
        Click("lane_num_1");

        tipsNum++;

        AssertIndoorCheck("测线", "中", "FM-2001-6-1", "测线车道数记录在属性中，请删除关联测线的车道数Tips", "不能忽略");

        GotoMyData("rb_condition_tips");

        UiObject2 object =mDevice.wait(Until.findObject(By.text("车道数")), 3000);
        object.click();

        Click("delete_button");
        Click("btn_fm_confirm");
        tipsNum--;

        ExitMyData();

        AssertIndoorCheckNull("FM-2001-6-1");
    }

//    @Test
//    public void test01307_IndoorCheck_FM_1054_5_1() throws UiObjectNotFoundException
//    {
//        //跨越桥的几何长度要小于800m时，报log
//        mDevice.drag(700, 823, 1024, 823, 10);
//
//        int MAX_LEN = 790;
//
//        int Distance = GetDistance10Pixel();
//
//        Point[] arrayPoint = {new Point(1000, 1000),
//                              new Point(1000, 1000-(MAX_LEN/Distance)*10/2),
//                              new Point(1000-(MAX_LEN/Distance)*10/2, 1000)};
//        DrawRoad(arrayPoint);
//
//        SetStartEndPoint(arrayPoint[0], arrayPoint[2], "overpass_bt");
//
//        AssertIndoorCheck("OverPass", "道路形状及相关检查", "FM-2001-6-1", "跨越桥长度小于800米，不需要采集！", "可以忽略");
//
//        DeleteTipInMyData("Underpass");
//
//        //跨越桥的几何长度大于800m时，不报log
//        mDevice.drag(700, 823, 1024, 823, 10);
//
//        MAX_LEN = 810;
//
//        Point[] arrayPoint2 = {new Point(1000, 1000),
//                new Point(1000, 1000-(MAX_LEN/Distance)*10/2),
//                new Point(1000-(MAX_LEN/Distance)*10/2, 1000)};
//        DrawRoad(arrayPoint2);
//
//        SetStartEndPoint(arrayPoint2[0], arrayPoint2[2], "overpass_bt");
//
//        AssertIndoorCheckNull("FM-2001-6-1");
//    }

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