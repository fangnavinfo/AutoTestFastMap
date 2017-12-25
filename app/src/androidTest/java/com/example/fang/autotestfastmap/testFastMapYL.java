package com.example.fang.autotestfastmap;

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
public class testFastMapYL extends testFastMapBase
{
    @BeforeClass
    public static void setClassUp() throws Exception
    {
        testFastMapBase.setClassUp();
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
    public  void setAfter()
    {
        super.setAfter();
    }

    @Test
    public void test00702_info_Point_testPath() throws InterruptedException, UiObjectNotFoundException {


        Click("btn_infor_report");
        Click("info_pop_add_point");

        Click(GetCenter());
        PutinEditor("edt_infor_report_name", "测试点ＩＮＦＯ");

        Click("infor_report_type_road");
        Click("tv_poiReport_time");
        Click("btn_fm_confirm");

        Click("camera_button", 3000);
        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_imgbtn");

        Click("save_button");
        infoRoadNum++;

        Click("head_icon");
        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click("rb_condition_live_information");
        Click("tv_condition_confirm_hd");

        UiObject2 test = mDevice.findObject(By.text("自采集情报(道路)(点)"));
        test.click();
        UiObject2 Object = mDevice.findObject(By.res(packageName, "et_title"));
        String strTemp = Object.getText();
        String temp = strTemp.substring(strTemp.length()-32,strTemp.length());
        Click("save_button");

        Click("iv_my_data_back");
        Click("fmcard_ibtn_back");
        SyncInfo();
        infoRoadNum = 0;

        Click("img_search");//Click(new Point(2004,124));//

        Click(new Point(1200,420));//Click("tv_tab_text");
        PutinEditor("edt_search_info_input",temp);
        Click("tv_search_info_btn");

        Click("tv_my_data_snap_list_item_name");

        Click("other_button");//部分采纳
        Click("info_pop_add_point");
        Click("cancel_button");

        infoRoadNum++;

    }

    @Test
    public void test00802_info_Line_testPath() throws InterruptedException, UiObjectNotFoundException {
        Click("btn_infor_report");
        Click("info_pop_add_line");

        Click(new Point(1000, 1000));
        Click(new Point(1000, 500));
        Click(new Point(500, 1000));

        Click("draw_line_over");
        PutinEditor("edt_infor_report_name", "测试线ＩＮＦＯ");

        Click("infor_report_type_road");
        Click("tv_poiReport_time");
        Click("btn_fm_confirm");

        Click("camera_button", 3000);
        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_imgbtn");

        Click("save_button");
        infoRoadNum++;

        Click("head_icon");
        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click("rb_condition_live_information");
        Click("tv_condition_confirm_hd");

        UiObject2 test = mDevice.findObject(By.text("自采集情报(道路)(线)"));
        test.click();
        UiObject2 Object = mDevice.findObject(By.res(packageName, "et_title"));
        String strTemp = Object.getText();
        String temp = strTemp.substring(strTemp.length()-32,strTemp.length());
        Click("save_button");

        Click("iv_my_data_back");
        Click("fmcard_ibtn_back");
        SyncInfo();
        infoRoadNum = 0;

        Click("img_search");//Click(new Point(2004,124));//

        Click(new Point(1200,420));//Click("tv_tab_text");
        PutinEditor("edt_search_info_input",temp);
        Click("tv_search_info_btn");

        Click("tv_my_data_snap_list_item_name");

        Click("other_button");//部分采纳
        Click("info_pop_add_line");
        Click("cancel_button");

        infoRoadNum++;
    }

    @Test
    public void test00902_info_Frame_testPath() throws InterruptedException, UiObjectNotFoundException {
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
        infoRoadNum++;

        Click("camera_button", 3000);
        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_imgbtn");

        Click("save_button");

        Click("head_icon");
        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click("rb_condition_live_information");
        Click("tv_condition_confirm_hd");

        UiObject2 test = mDevice.findObject(By.text("自采集情报(道路)(面)"));
        test.click();
        UiObject2 Object = mDevice.findObject(By.res(packageName, "et_title"));
        String strTemp = Object.getText();
        String temp = strTemp.substring(strTemp.length()-32,strTemp.length());
        Click("save_button");

        Click("iv_my_data_back");
        Click("fmcard_ibtn_back");
        SyncInfo();
        infoRoadNum = 0;

        Click("img_search");//Click(new Point(2004,124));//

        Click(new Point(1200,420));//Click("tv_tab_text");
        PutinEditor("edt_search_info_input",temp);
        Click("tv_search_info_btn");

        Click("tv_my_data_snap_list_item_name");

        Click("other_button");//部分采纳
        Click("info_pop_add_frame");
        Click("cancel_button");
        infoRoadNum++;
    }


    @Test
    public void test01001_tips_roadnamesign_add() throws InterruptedException
    {
        //新增道路名标牌 3个字
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
        Click(newRoadNameSign);

        Click(GetCenter());
        PutinEditor("card_road_name_sign_name_edit","123");
        Click("save_button");//保存按键ID

        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("道路名标牌")));
        ExitMyData();
    }

    @Test
    public void test01002_info_roadnamesign_add() throws InterruptedException
    {
        //在室内整理工具中查看我的数据中道路名称标牌信息  进入属性编辑页 保存 tipNum不增加

        Click("head_icon");
        Click("fmcard_tv_sync_photos");
        Click("tv_my_data");

        Thread.sleep(2000);

        List<UiObject2> objList = mDevice.wait(Until.findObjects(By.res(packageName, "tv_indoor_my_data_snap_list_item_type")), 500);

        if (objList == null)
        {
            fail("can not find ctrl: tv_indoor_my_data_snap_list_item_type");
        }

        UiObject2 object = null;
        for (UiObject2 testObject : objList)
        {
            if(testObject.getText().equals("道路名标牌"))
            {
                object = testObject;
            }
        }

        if (object == null)
        {
            fail("can not find ctrl: 道路名标牌");
        }

        object.click();
        Thread.sleep(3000);
        object.click();

        Click("save_button");//保存按键ID
        Click("iv_my_data_back");
        Click("sync_photos_back");

        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click("rb_condition_tips");
        Click("tv_condition_confirm_hd");

        ExitMyData();
    }

    @Test
    public void test01003_info_roadnamesign_add() throws InterruptedException
    {
        //室内整理工具 我的数据  道路名称标牌  进入属性编辑页 编辑显示点位 保存 tipNum不增加

        Click("head_icon");
        Click("fmcard_tv_sync_photos");
        Click("tv_my_data");

        //GotoIndoorTools();
        List<UiObject2> objList = mDevice.wait(Until.findObjects(By.res(packageName, "tv_indoor_my_data_snap_list_item_type")), 500);

        if (objList == null)
        {
            fail("can not find ctrl: tv_indoor_my_data_snap_list_item_type");
        }

        UiObject2 object = null;
        for (UiObject2 testObject : objList)
        {
            if(testObject.getText().equals("道路名标牌"))
            {
                object = testObject;
            }
        }

        if (object == null)
        {
            fail("can not find ctrl: 道路名标牌");
        }

        object.click();
        Thread.sleep(3000);
        object.click();

        Click("ck_move_point");//移动点位checkbox的ID
        mDevice.drag(700, 823, 1024, 823, 10);
        Click("ck_move_point");
        Thread.sleep(1000);
        Click("save_button");//保存按键ID

        Click("iv_my_data_back");
        Click("sync_photos_back");

        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click("rb_condition_tips");
        Click("tv_condition_confirm_hd");

        ExitMyData();
    }

    @Test
    public void test01004_info_roadnamesign_add() throws InterruptedException
    {
        //室内整理工具 我的数据  道路名称标牌  进入属性编辑页 编辑端点标牌 保存 tipNum不增加

        Click("head_icon");
        Click("fmcard_tv_sync_photos");
        Click("tv_my_data");

        List<UiObject2> objList = mDevice.wait(Until.findObjects(By.res(packageName, "tv_indoor_my_data_snap_list_item_type")), 500);

        if (objList == null)
        {
            fail("can not find ctrl: tv_indoor_my_data_snap_list_item_type");
        }

        UiObject2 object = null;
        for (UiObject2 testObject : objList)
        {
            if(testObject.getText().equals("道路名标牌"))
            {
                object = testObject;
            }
        }

        if (object == null)
        {
            fail("can not find ctrl: 道路名标牌");
        }

        object.click();
        Thread.sleep(3000);
        object.click();

        Click("card_road_name_sign_radio_yes");//是的checkboxID

        Click("save_button");//保存按键ID

        Click("iv_my_data_back");
        Click("sync_photos_back");

        Click("fmcard_tv_user_data");
        Click("tv_my_data_condition_1");
        Click("rb_condition_tips");
        Click("tv_condition_confirm_hd");

        ExitMyData();
    }

    @Test
    public void test01005_info_roadnamesign_delete() throws InterruptedException
    {
        //新增道路名标牌 删除
        Click("head_icon");
        Click("fmcard_tv_user_data");

        List<UiObject2> objList = mDevice.wait(Until.findObjects(By.res(packageName, "tv_my_data_snap_list_item_name")), 500);

        if (objList == null)
        {
            fail("can not find ctrl: tv_indoor_my_data_snap_list_item_type");
        }

        UiObject2 object = null;
        for (UiObject2 testObject : objList)
        {
            if(testObject.getText().equals("道路名标牌"))
            {
                object = testObject;
            }
        }

        if (object == null)
        {
            fail("can not find ctrl: 道路名标牌");
        }

        object.click();
        Click("delete_button");
        Click("btn_fm_confirm");

        tipsNum--;

        assertEditorEqual("tv_my_data_count_1", Integer.toString(tipsNum));
        assertNotNull(Until.findObject(By.desc("道路名标牌")));

        ExitMyData();
    }

    @Test
    public void test01006_tips_roadnamesign_add() throws InterruptedException
    {
        //新增道路名标牌 6个字
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
        Click(newRoadNameSign);

        Click(GetCenter());
        PutinEditor("card_road_name_sign_name_edit","新道路标牌名");//标牌名称编辑框ID
        Click("save_button");//保存按键ID

        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("道路名标牌")));
        ExitMyData();
    }

    @Test
    public void test01007_info_roadnamesign_add() throws InterruptedException
    {
        //操作复制功能 保存 tipNum不增加

        Click("head_icon");
        Click("fmcard_tv_user_data");

        List<UiObject2> objList = mDevice.wait(Until.findObjects(By.res(packageName, "tv_my_data_snap_list_item_name")), 500);

        if (objList == null)
        {
            fail("can not find ctrl: tv_indoor_my_data_snap_list_item_type");
        }

        UiObject2 object = null;
        for (UiObject2 testObject : objList)
        {
            if(testObject.getText().equals("道路名标牌"))
            {
                object = testObject;
            }
        }

        if (object == null)
        {
            fail("can not find ctrl: 道路名标牌");
        }

        object.click();

        Click("cancel_button");
        Click("iv_my_data_back");
        Click("fmcard_ibtn_back");

        Click(new Point(605,1445));//复制TipID

        //Click(new Point(mDevice.getDisplayWidth()/2-20, mDevice.getDisplayHeight()/2-20));
        Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2));
        Click(new Point(1400,900));
        PutinEditor("card_road_name_sign_name_edit","新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名");
        Click("save_button");//保存按键ID
        tipsNum++;

    }

    @Test
    public void test01008_tips_roadnamesign_add() throws InterruptedException
    {
        //新增道路名标牌 多个字
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
        Click(newRoadNameSign);

        Click(GetCenter());
        PutinEditor("card_road_name_sign_name_edit","新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名");
        Click("save_button");//保存按键ID

        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("道路名标牌")));
        ExitMyData();
    }

    @Test
    public void test01009_tips_roadnamesign_add() throws InterruptedException
    {
        //新增道路名标牌 端点标牌选是
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
        Click(newRoadNameSign);

        Click(GetCenter());
        PutinEditor("card_road_name_sign_name_edit","qwe");//标牌名称编辑框ID
        Click("card_road_name_sign_radio_yes");//端点标牌是的ID
        Click("save_button");//保存按键ID

        tipsNum++;

        GotoMyData("rb_condition_tips");

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("道路名标牌")));

        ExitMyData();
    }

    @Test
    public void test01010_tips_roadnamesign_add() throws InterruptedException
    {
        //新增道路名标牌 新增名称为空 拍照
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
        Click(newRoadNameSign);

        Click(GetCenter());

        PutinEditor("card_road_name_sign_radio_yes","");//标牌名称编辑框ID

        Click("camera_button");//拍照ID
        Click("take_pic_imgbtn", 3000);//拍摄按键ID
        Click("task_pic_back_img");//返回键ID

        Click("save_button");//保存按键ID

        tipsNum++;

        GotoMyData("rb_condition_tips");

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("道路名标牌")));

        ExitMyData();
    }
    @Test
    public void test01011_tips_roadnamesign_add() throws InterruptedException
    {
        //新增道路名标牌 新增名称不为空 拍照
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
        Click(newRoadNameSign);

        Click(GetCenter());

        PutinEditor("card_road_name_sign_radio_yes","wer");//标牌名称编辑框ID

        Click("camera_button");//拍照ID
        Click("take_pic_imgbtn", 3000);//拍摄按键ID
        Click("task_pic_back_img");//返回键ID

        Click("save_button");//保存按键ID
        tipsNum++;

        GotoMyData("rb_condition_tips");

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("道路名标牌")));

        ExitMyData();
    }

    @Test
    public void test01012_tips_roadnamesign_add() throws InterruptedException
    {
        //新增道路名标牌 取消
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(MultPoint2);
        Click(newRoadNameSign);

        Click(GetCenter());
        PutinEditor("card_road_name_sign_radio_yes","qwe");
        Click("card_road_name_sign_radio_yes");//端点标牌是的ID
        Click("cancel_button");

    }

    @Test
    public void test01101_tips_CarInfo_add() throws InterruptedException
    {
        //点击更多,收起，显示隐藏全部单箭头选项
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("rb_select_one_a");//单车道任一控件ID
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_r");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01102_tips_CarInfo_add() throws InterruptedException
    {
        //我的数据，Tips下点击车信，进入编辑模式，删除
        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("rb_select_one_a");//单车道任一控件ID
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_r");

        Click("save_button");

        Click("head_icon");
        Click("fmcard_tv_user_data");

        UiObject2 test = mDevice.findObject(By.text("车信"));
        test.click();
        Click("delete_button");
        Click("btn_fm_confirm");

        ExitMyData();
    }
    //
    @Test
    public void test01103_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 r 斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_r");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }


    @Test
    public void test01104_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 s 斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_s");//斜右单车道控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01105_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 t 直斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_t");//直斜左控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01106_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 x 直斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_x");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01107_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 u 左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_u");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01108_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 z 右斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_z");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01109_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 w 调斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_w");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01110_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 0 调斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_0");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01111_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 y 左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_y");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01112_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 v 右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_v");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01113_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 2 直左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_2");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01114_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 5 直右斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_5");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01115_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 3 直左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_3");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01116_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 4 直右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_4");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01117_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 1 斜左斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_1");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01118_tips_CarInfo_add() throws InterruptedException {
        //增加单车道箭头
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);


        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("rb_select_one_a");//单车道任一控件ID
        Click("ll_bg_select_more");//“更多”控件ID
        Click("iv_dri");
        Click("rb_select_six_r");//斜左
        Click("rb_select_six_s");//斜右控件ID
        Click("rb_select_six_t");
        Click("rb_select_six_x");//直斜左控件ID
        Click("rb_select_seven_u");//直斜右控件ID
        Click("rb_select_seven_z");//左斜左控件ID
        Click("rb_select_seven_w");//右斜右控件ID
        Click("rb_select_seven_0");//调斜左控件ID
        Click("rb_select_eight_y");//调斜右控件ID
        Click("rb_select_eight_v");//左斜右控件ID
        Click("rb_select_eight_2");//右斜左控件ID
        Click("rb_select_eight_5");//直左斜左控件ID
        Click("rb_select_eight_3");//直右斜右控件ID
        Click("rb_select_eight_4");//直左斜右控件ID
        Click("rb_select_eight_1");//直右斜左控件ID


        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    /*
    //
    @Test
    public void test01119_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 s 斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//单车道任一控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("ll_bg_select_more");//“更多”控件ID
        Click("");//斜右单车道控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01120_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 t 直斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");//直斜左控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01121_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 x 直斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01122_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 u 左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01123_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 z 右斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01124_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 w 调斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01125_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 0 调斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01126_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 y 左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01127_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 v 右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01128_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 2 直左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01129_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 5 直右斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01130_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 3 直左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01131_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 4 直右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//单车道任一控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//更多
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01132_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 1 斜左斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//单车道任一控件ID
        Click("");//“更多”控件ID
        Click("");

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    //
    @Test
    public void test01133_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 1 斜左
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01134_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 s 斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//单车道任一控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");//斜右单车道控件ID
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01135_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 t 直斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");//直斜左控件ID
        Click("");//单车道任一控件ID
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01136_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 x 直斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01137_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 u 左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01138_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 z 右斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01139_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 w 调斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01140_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 0 调斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01141_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 y 左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01142_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 v 右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01143_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 2 直左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01144_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 5 直右斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01145_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 3 直左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01146_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 4 直右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//单车道任一控件ID
        Click(GetCenter());

        Click("");//更多
        Click("");
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01147_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 1 斜左斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click("");//车信控件ID
        Click(GetCenter());
        Click("");//“更多”控件ID
        Click("");
        Click("");//单车道任一控件ID

        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    */

    @Test
    public void test01148_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 1 斜左
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_r");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01149_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 s 斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_s");//斜右单车道控件ID
        Click("iv_delete");
        Click("cancel_button");


        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01150_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 t 直斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_t");//直斜左控件ID
        Click("iv_delete");
        Click("cancel_button");


        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01151_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 x 直斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_x");
        Click("iv_delete");
        Click("cancel_button");


        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01152_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 u 左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_u");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01153_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 z 右斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_z");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01154_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 w 调斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_w");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01155_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 0 调斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_0");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01156_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 y 左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_y");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01157_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 v 右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_v");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01158_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 2 直左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_2");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01159_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 5 直右斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_5");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01160_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 3 直左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_3");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01161_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 4 直右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//更多
        Click("rb_select_eight_4");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01162_tips_CarInfo_close() throws InterruptedException {
        //新增单箭头 1 斜左斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_1");
        Click("iv_delete");
        Click("cancel_button");

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }


    //注意每个ID切换成下一个ID 比如63这个用例

    @Test

    public void test01163_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 1 斜左
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_r");

        Click("iv_dri");//附加上方控件IDiv_dri
        Click("rb_select_six_s");//斜左斜右控件ID
        Click("save_button");//保存控件ID

        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01164_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 s 斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_s");//斜右单车道控件ID
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_six_t");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01165_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 t 直斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_t");//直斜左控件ID
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_six_x");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01166_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 x 直斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_x");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_seven_u");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01167_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 u 左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_u");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_seven_z");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01168_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 z 右斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_z");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_seven_w");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01169_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 w 调斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_w");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_seven_0");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01170_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 0 调斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_seven_0");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_eight_y");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    /*    @Test
        public void test01171_tips_CarInfo_add() throws InterruptedException {
            //新增单箭头 y 左斜右、
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            Click(new Point(1960,1150));//车信控件ID
            Click(GetCenter());
            Click("ll_bg_select_more");//“更多”控件ID
            Click("rb_select_eight_y");
            Click("iv_dri");//附加上方控件ID
            Click("");
            Click("save_button");//保存控件ID
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("车信")));

            ExitMyData();
        }
        */
    @Test
    public void test01172_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 v 右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_v");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_eight_2");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();

    }
    @Test
    public void test01173_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 2 直左斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_2");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_eight_5");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01174_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 5 直右斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_5");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_eight_3");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }
    @Test
    public void test01175_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 3 直左斜右、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_3");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_eight_4");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01176_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 4 直右斜左、
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());

        Click("ll_bg_select_more");//更多
        Click("rb_select_eight_4");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_eight_1");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    @Test
    public void test01177_tips_CarInfo_add() throws InterruptedException {
        //新增单箭头 1 斜左斜右
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        Click(new Point(1960,1150));//车信控件ID
        Click(GetCenter());
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_eight_1");
        Click("iv_dri");//附加上方控件ID
        Click("rb_select_six_r");
        Click("save_button");//保存控件ID
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("车信")));

        ExitMyData();
    }

    private  void SyncInfo() throws UiObjectNotFoundException
    {
        Click("head_icon");
        Click("fmcard_tv_grid_manager");
        Click(GetCenter());
        Click("grid_project_button");
        Click("rb_info_update");
        Click("synchronous_button");
        Click("btn_fm_confirm");
        Click("btn_fm_confirm",5000);

        CheckSyncInfoResult();

        //Click("grid_sync_btn_positive",5000);
        Click("back");
        Click("fmcard_ibtn_back");
    }

    private static Point newRoadNameSign = new Point(366, 1240);
}
