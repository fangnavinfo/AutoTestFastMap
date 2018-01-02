package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void test00102_poi_add() throws InterruptedException
    {
        //产品全貌开关关，新增POI点
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);
        //SetConfInfo();//默认就是关
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
    public void test00103_poi_add() throws InterruptedException
    {
        //产品全貌开关关闭，选择水牌，分辨率中拍摄
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);
        //SetConfInfo();//产品全貌开关
        Click(newPOIPoint, 6000);

        Click("shuipai_btn");
        Click("radio_revolution2");
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

        Click("camera_button");//保存前看是否保存了上次标签和分辨率设置的属性
        Click("task_pic_back_img");
        Thread.sleep(1000);

        Click("save_button");

        poiNum++;

        GotoMyData("rb_condition_poi");

        assertEditorEqual("tv_my_data_count_2", Integer.toString(poiNum));
        assertNotNull(Until.findObject(By.desc("测试ＰＯＩ")));

        ExitMyData();
    }

    @Test
    public void test00104_poi_add() throws InterruptedException
    {
        //产品全貌开关关，再次点击新增POI，查看相机记录信息，标签“名称”，分辨率记录上一次操作的“中”
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);
        Click(newPOIPoint, 6000);

        //Click("take_pic_imgbtn", 3000);
        Thread.sleep(2000);
        Click("task_pic_back_img");

        Click("cancel_button");
    }

    @Test
    public void test00105_poi_add() throws InterruptedException
    {
        //产品全貌开关开，新增高分辨率，产品全貌图片，属性中查看配置
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);
        SetConfInfo();//产品全貌开关开
        Click(newPOIPoint, 6000);


        Click("take_pic_imgbtn", 3000);//默认就是高分辨率，产品全貌图
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

        Click("camera_button");//保存前看是否保存了上次标签名称和中分辨率设置的属性
        Thread.sleep(1000);
        Click("task_pic_back_img");

        Click("save_button");
        poiNum++;

        GotoMyData("rb_condition_poi");

        assertEditorEqual("tv_my_data_count_2", Integer.toString(poiNum));
        assertNotNull(Until.findObject(By.desc("测试ＰＯＩ")));

        ExitMyData();
    }

    @Test
    public void test00106_poi_add() throws InterruptedException
    {
        //产品全貌开关开，新增高分辨率，产品全貌图片，编辑界面再创建水牌，中分辨率图片
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);
        //SetConfInfo();//产品全貌开关开
        Click(newPOIPoint, 6000);

        Click("radio_revolution1");
        Click("take_pic_imgbtn", 3000);//默认就是低分辨率(但是这个直不计入本地文件)，产品全貌图
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

        Click("camera_button");//更改配置
        Click("shuipai_btn");
        Click("radio_revolution3");
        Click("take_pic_imgbtn", 3000);
        Click("task_pic_back_img");

        Click("camera_button");//保存前看是否保存了上次标签水牌和中分辨率设置的属性
        Thread.sleep(1000);
        Click("task_pic_back_img");

        Click("save_button");
        poiNum++;

        GotoMyData("rb_condition_poi");

        assertEditorEqual("tv_my_data_count_2", Integer.toString(poiNum));
        assertNotNull(Until.findObject(By.desc("测试ＰＯＩ")));

        ExitMyData();
    }

    @Test
    public void test00107_poi_add() throws InterruptedException
    {
        //产品全貌开关开，再次点击新增POI，查看相机记录信息，标签“产品全貌”，分辨率为“高”
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);
        Click(newPOIPoint, 6000);

        //Click("take_pic_imgbtn", 3000);
        Thread.sleep(2000);
        Click("task_pic_back_img");

        Click("cancel_button");
        SetConfInfo();
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
        //mDevice.findObject(By.text("道路名标牌")).click();
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
        //mDevice.findObject(By.text("道路名标牌")).click();
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
        //mDevice.findObject(By.text("道路名标牌")).click();
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
        //mDevice.findObject(By.text("道路名标牌")).click();
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
        //mDevice.findObject(By.text("道路名标牌")).click();
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
        //mDevice.pressBack();
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

///////////////待完善////////////
 /*
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
///////////待完善////////////////
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
///////////////////////////////////////////////
  /* @Test
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
////////////////////////////////////////
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

    @Test
    public void test01201_tips_add_Click() throws InterruptedException {
        //单击手动设置点位信息，新增限速
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        OpenGPS();
        Click(new Point(976,1442));//单击击限速Tips
        Click(GetCenter());
        Click("speed_limit_type_point");//点击点限速
        Click("et_speed_limit_number");//最高限速值
        Click("speed_limit_number_40");//40
        Click("et_speed_limit_number_min");//最低限速值
        Click("speed_limit_number_30");//30
        Click("save_button");
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("点限速")));

        ExitMyData();
    }

        @Test
        public void test01202_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增红绿灯
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(373,1450));//单击红绿灯
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
        public void test01203_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增危险信息
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            Click(new Point(729,1021));//单击危险信息
            Click(GetCenter());
            Click("dangerous_information_icon_a1");//点击警示信息
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("危险信息")));

            ExitMyData();
        }

        @Test
        public void test01204_tips_add_Click() throws InterruptedException,UiObjectNotFoundException {
            //单击手动设置点位信息，新增收费站
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            Click(new Point(583,1156));//单击危险信息
            Click(GetCenter());

            mDevice.findObject(By.text("领卡")).click();
            //方法一
            //UiObject2 object1=new UiObject2(new UiSelector().text("领卡"));
            //object1.click();
            //方法二
            //UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
            //UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "测试上报情报６");
            //Object.click();

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("收费站")));

            ExitMyData();
        }

        @Test
        public void test01205_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增电子眼
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            Click(new Point(723,1153));//单击电子眼
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("电子眼")));

            ExitMyData();
        }

        @Test
        public void test01206_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增卡车限制
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            Click(new Point(846,1144));//单击卡车限制
            Click(GetCenter());
            Click("camera_button");//拍照ID
            Click("take_pic_imgbtn", 3000);//拍摄按键ID
            Click("task_pic_back_img");//返回键ID
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("卡车限制")));//可能需要垂直滚动才能看到

            ExitMyData();
        }

        @Test
        public void test01207_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增车道变化点
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(479,1445));//单击车道变化点
            Click(GetCenter());
            Click("et_entry_lane_num");//进入车道数
            Click("lane_number_tow");//2
            Click("et_back_lane_num");//退出车道数
            Click("lane_number_one");//1
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("车道变化点")));

            ExitMyData();
        }

        @Test
        public void test01208_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增普通路口模式图
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(101,1153));//点击方向看板
            Click(new Point(360,998));//单击点击普通路口模式图
            Click(GetCenter());

            //方法一
            //UiObject object = new UiObject(new UiSelector().text("73100000"));
            //object.click();
            mDevice.findObject(By.text("73100000")).click();
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("普通路口模式图")));

            ExitMyData();
        }

        @Test
        public void test01209_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增高速入口模式图
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(101,1153));//点击方向看板
            Click(new Point(486,993));//单击高速入口模式图
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("高速入口模式图")));

            ExitMyData();
        }

        @Test
        public void test01210_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增SA
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(853,1419));
            Click(new Point(711,1140));//单击SA
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("SA")));

            ExitMyData();
        }

        @Test
        public void test01211_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增PA
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(853,1419));
            Click(new Point(844,1151));//单击PA
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("PA")));

            ExitMyData();
        }

        @Test
        public void test01212_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增匝道
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(853,1419));
            Click(new Point(963,1140));//单击匝道
            Click(GetCenter());
            Click("btn_ramp");//点击匝道

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("匝道")));

            ExitMyData();
        }

        @Test
        public void test01213_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增车信
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(1969,1138));//单击车信
            Click(GetCenter());
            Click("rb_select_one_d");//

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
        public void test01214_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增交限
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(1966,1260));//单击交限
            Click(GetCenter());
            Click("traffic_forbidden_icon_a1");

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("交限")));

            ExitMyData();
        }

        @Test
        public void test01215_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增卡车交限
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(94,1263));
            Click(new Point(362,980));//单击卡车交限
            Click(GetCenter());
            Click("traffic_forbidden_icon_c1");

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
        public void test01216_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增方向看板
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            Click(new Point(222,736));//单击方向看板
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("方向看板")));

            ExitMyData();
        }

        @Test
        public void test01217_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增Real Sign
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            Click(new Point(355,745));//单击Real Sign
            //Click(new Point(355,745));//双击Real Sign
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("Real Sign")));

            ExitMyData();
        }

    /*    @Test
        public void test01218_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增3D模式图
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            Click(new Point(487,743));//单击3D模式图
            Click(GetCenter());
            Click("");//点击3D模式图

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("3D")));

            ExitMyData();
        }
*/
        @Test
        public void test01219_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增提左提右
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            Click(new Point(222,864));//单击提左提右
            //Click(new Point(222,864));//单击提左提右
            Click(GetCenter());
            mDevice.findObject(By.text("80000800")).click();

            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("提左提右")));

            ExitMyData();
        }

        @Test
        public void test01220_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增一般道路方面
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(90,1152));
            Click(new Point(351,869));//单击一般道路方面
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("点限速")));

            ExitMyData();
        }

        @Test
        public void test01221_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增高速分歧
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            Click(new Point(232,986));//单击高速分歧
            Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("高速分歧")));

            ExitMyData();
        }
/*/////////////OK///////////////////
        @Test
        public void test01222_tips_add_Click() throws InterruptedException {
            //单击手动设置点位信息，新增GPS打点
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(1974,897));//单击GPS打点
            Click(GetCenter());

            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("GPS打点")));

            ExitMyData();
        }
       //////////////////双击_GPS定位////////////////////////
        @Test
        public void test01223_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增限速
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            DoubleClick(new Point(976,1442));//限速Tips
            //Click(GetCenter());
            Click("speed_limit_type_point");//点击点限速
            Click("et_speed_limit_number");//最高限速值
            Click("speed_limit_number_40");//40
            Click("et_speed_limit_number_min");//最低限速值
            Click("speed_limit_number_30");//30
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("点限速")));

            ExitMyData();
        }

        @Test
        public void test01224_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增红绿灯
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            DoubleClick(new Point(373,1450));//红绿灯
            //Click(GetCenter());

            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("红绿灯")));

            ExitMyData();
        }

        @Test
        public void test01225_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增危险信息
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            DoubleClick(new Point(729,1021));//危险信息
            //Click(GetCenter());
            Click("dangerous_information_icon_a1");//点击警示信息
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("危险信息")));

            ExitMyData();
        }

        @Test
        public void test01226_tips_add_DoubleClick() throws InterruptedException,UiObjectNotFoundException {
            //设置点位信息，新增收费站
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            DoubleClick(new Point(583,1156));
            //Click(GetCenter());

            mDevice.findObject(By.text("领卡")).click();
            //方法一
            //UiObject2 object1=new UiObject2(new UiSelector().text("领卡"));
            //object1.click();
            //方法二
            //UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
            //UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "测试上报情报６");
            //Object.click();

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("收费站")));

            ExitMyData();
        }

        @Test
        public void test01227_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增电子眼
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            DoubleClick(new Point(723,1153));//电子眼
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("电子眼")));

            ExitMyData();
        }

        @Test
        public void test01228_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增卡车限制
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(726,1456));
            DoubleClick(new Point(846,1446));//卡车限制
            //Click(GetCenter());
            Click("camera_button");//拍照ID
            Click("take_pic_imgbtn", 3000);//拍摄按键ID
            Click("task_pic_back_img");//返回键ID
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("卡车限制")));//可能需要垂直滚动才能看到

            ExitMyData();
        }

        @Test
        public void test01229_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增车道变化点
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            DoubleClick(new Point(479,1445));//车道变化点
            //Click(GetCenter());
            Click("et_entry_lane_num");//进入车道数
            Click("lane_number_tow");//2
            Click("et_back_lane_num");//退出车道数
            Click("lane_number_one");//1
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("车道变化点")));

            ExitMyData();
        }

        @Test
        public void test01230_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增普通路口模式图
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(101,1153));//点击方向看板
            DoubleClick(new Point(360,998));//点击普通路口模式图
            //Click(GetCenter());

            //方法一
            //UiObject object = new UiObject(new UiSelector().text("73100000"));
            //object.click();
            mDevice.findObject(By.text("73100000")).click();
            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("普通路口模式图")));

            ExitMyData();
        }

        @Test
        public void test01231_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增高速入口模式图
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(101,1153));//点击方向看板
            DoubleClick(new Point(486,993));//高速入口模式图
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("高速入口模式图")));

            ExitMyData();
        }

        @Test
        public void test01232_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增SA
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(853,1419));
            DoubleClick(new Point(711,1140));//SA
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("SA")));

            ExitMyData();
        }

        @Test
        public void test01233_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增PA
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(853,1419));
            DoubleClick(new Point(844,1151));//PA
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("PA")));

            ExitMyData();
        }

        @Test
        public void test01234_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增匝道
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(853,1419));
            DoubleClick(new Point(963,1140));//匝道
            //Click(GetCenter());
            Click("btn_ramp");//点击匝道

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("匝道")));

            ExitMyData();
        }

        @Test
        public void test01235_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增车信
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            DoubleClick(new Point(1969,1138));//车信
            //Click(GetCenter());
            Click("rb_select_one_d");//

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
        public void test01236_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增交限
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            DoubleClick(new Point(1966,1260));//交限
            //Click(GetCenter());
            Click("traffic_forbidden_icon_a1");

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("交限")));

            ExitMyData();
        }

        @Test
        public void test01237_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增卡车交限
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(94,1263));
            DoubleClick(new Point(362,980));//卡车交限
            //Click(GetCenter());
            Click("traffic_forbidden_icon_c1");

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
        public void test01238_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增方向看板
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            DoubleClick(new Point(222,736));//方向看板
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("方向看板")));

            ExitMyData();
        }

        @Test
        public void test01239_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增Real Sign
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            DoubleClick(new Point(355,745));//Real Sign
            //Click(new Point(355,745));//双击Real Sign
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("Real Sign")));

            ExitMyData();
        }

        @Test
        public void test01240_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增3D模式图
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            DoubleClick(new Point(487,743));//3D模式图
            //Click(GetCenter());
            Click("");//点击3D模式图

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("3D")));

            ExitMyData();
        }

        @Test
        public void test01241_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增提左提右
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            DoubleClick(new Point(222,864));//提左提右
            //Click(new Point(222,864));//双击提左提右
            //Click(GetCenter());
            mDevice.findObject(By.text("80000800")).click();

            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("提左提右")));

            ExitMyData();
        }

        @Test
        public void test01242_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增一般道路方面
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            DoubleClick(new Point(351,876));//一般道路方面
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("点限速")));

            ExitMyData();
        }

        @Test
        public void test012243_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增高速分歧
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            Click(new Point(104,1138));
            DoubleClick(new Point(232,986));//高速分歧
            //Click(GetCenter());

            Click("save_button");
            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("高速分歧")));

            ExitMyData();
        }

        @Test
        public void test01244_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增GPS打点
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            //OpenGPS();
            DoubleClick(new Point(1974,897));//GPS打点
            //Click(GetCenter());

            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("GPS打点")));

            ExitMyData();
        }

        //////////删除Tips/////////////
        @Test
        public void test01245_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，新增删除标记
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            Click(new Point(1082,1438),500);//删除标记，单击只删除一个
            Click(GetCenter());

            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("形状删除")));

            ExitMyData();
        }

        @Test
        public void test01246_tips_add_DoubleClick() throws InterruptedException {
            //设置点位信息，连续删除
            mDevice.drag(700, 823, 1024, 823, 10);
            Thread.sleep(1000);

            DoubleClick(new Point(1082,1438));//删除标记，单击只删除一个
            Click(GetCenter());
            Click(new Point(663,679));
            Click(new Point(1473,879));
            Click(new Point(955,973));
            Click(new Point(1082,1438));

            tipsNum++;

            String strType = "rb_condition_tips";
            GotoMyData(strType);

            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("GPS打点")));

            ExitMyData();
        }

///////////OK////////////*/
    private void DoubleClick(Point point){
        long timeout = Configurator.getInstance().getActionAcknowledgmentTimeout();
        Configurator.getInstance().setActionAcknowledgmentTimeout(0);
        for(int i =0;i <2; i++){
            mDevice.click(point.x,point.y);
        }
        Configurator.getInstance().setActionAcknowledgmentTimeout(timeout);
    }

    private  void OpenGPS()
    {
        //打开WIFI
        Click("iv_map_gps_status");
        Click("location_pop_check_location");
        //Thread.sleep(1000);

        Click(GetCenter());
    }

    private  void SetConfInfo()
    {
        //产品全貌开关设置
        Click("head_icon");
        //Click("fmcard_tv_grid_manager");//滚动条滚动，点击设置
        Click("fmcard_tv_user_settings");
        Click("checkBox_camera_fullView");//设置产品全貌开关

        Click("btn_back");
        Click("fmcard_ibtn_back");
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
