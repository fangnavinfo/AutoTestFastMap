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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
public class testFastMapZF extends testFastMapBase
{
    @BeforeClass
    public static void setClassUp() throws Exception
    {
        //testFastMapBase.setClassUp("collector2","123456");
    }

    @AfterClass
    public static void setClassDown() throws InterruptedException, IOException
    {
    }

    @Before
    public void setUp() throws Exception {
        this.setClassUp("collector2", "123456");
    }

    @After
    public  void setAfter() throws IOException, InterruptedException {

        super.setAfter();
    }


    // POI 联系方式去除手机号不能以19开头的限制
    @Test
    public void test00102_poi_telnum_check() throws Exception {
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        //点击新增POI
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(500);

        Click("take_pic_imgbtn",2000); //点击拍照
        Click("task_pic_back_img"); //点击返回

        PutinEditor("fm_et_name", "测试ＰＯＩ２"); //输入POI名称

        Click("tv_assort_type");//点击选择分类

        UiObject object1=new UiObject(new UiSelector().text("中餐馆"));
        object1.click();

        Thread.sleep(3000);
        Click("edt_contactItem_telNum");
        Thread.sleep(1000);
        PutinEditor("edt_contactItem_telNum", "19012345678"); //输入19开头电话号码，这行代码在我这儿运行会直接挂掉，你确认下
        Thread.sleep(1000);

        Click("save_button"); //点击保存
        poiNum++;

        Thread.sleep(3000);

        GotoMyData("rb_condition_poi"); //进入我的数据

        UiObject2 Object = mDevice.wait(Until.findObject(By.text("测试ＰＯＩ２")), 500);
        Object.click();

        //判断新增数据数量与poiNum是否相等
        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        UiObject2 txtTelephoneNo  = mDevice.wait(Until.findObject(By.res(packageName, "edt_contactItem_telNum")), 500);

        if(null != txtAddCount)
        {
            assertEquals(Integer.toString(poiNum), txtAddCount.getText());
            assertEquals("19012345678", txtTelephoneNo.getText());
            assertNotNull(Until.findObject(By.desc("测试ＰＯＩ2"))); //检查是否有"测试ＰＯＩ"对象
        }
        else
        {
            fail("Save POI failed");
        }

        Click("save_button"); //点击保存
        ExitMyData(); //退出我的数据
    }

    //采纳情报fid保存
    @Test
    public void test00103_poi_report_check()  throws InterruptedException, UiObjectNotFoundException {
        // 上报情报
        addReport();
        // 同步情报
        synchronize("rb_info_update");
        // 采纳情报
        accept();
        // 检查情报fid
        checkFid();

    }

    // 删除标记
    @Test
    public void test00104_tips_delete_check() throws Exception {

        //添加红绿灯
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.TRAFFIC_LIGHT);
        Thread.sleep(500);
        Click(new Point(1852,482),500);
        Click("head_icon",500); //点击主界面左上角头像
        Click("fmcard_tv_user_data",1000); //点击我的数据
        UiObject2 listViewObj = mDevice.findObject(By.clazz(ListView.class));
        UiObject2 child = listViewObj.findObject(By.clazz(RelativeLayout.class));
        child.click();
        Thread.sleep(500);
        infoRowkey = mDevice.findObject(By.res(packageName, "et_title")).getText();
        mDevice.pressBack();
        Thread.sleep(500);
        Click("btn_fm_confirm", 500);

        //确认数据
        Click("fmcard_tv_sync_photos", 1000);
        Click("tv_my_data", 1000);
        Click("tv_indoor_my_data_snap_list_item_work_status", 1000);
        mDevice.pressBack();
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(500);

        //同步数据
        synchronize("rb_tips_update");

        //删除红绿灯
        Click("head_icon",500); //点击主界面左上角头像
        Click("fmcard_tv_user_data",1000); //点击我的数据
        listViewObj = mDevice.findObject(By.clazz(ListView.class));
        child = listViewObj.findObject(By.clazz(RelativeLayout.class));
        child.click();
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(500);
        Click("btn_fm_confirm", 500);
        mDevice.pressBack();
        Thread.sleep(500);
        //删除
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.DELETE_ROAD_MARKER);
        Thread.sleep(500);
        Click(GetCenter(),1000);

        listViewObj = mDevice.findObject(By.clazz(ListView.class));
        child = listViewObj.findObject(By.clazz(LinearLayout.class));
        UiObject2 child2 = child.findObject(By.clazz(RelativeLayout.class));
        UiObject2 delete = child2.findObject(By.clazz(Button.class));
        delete.click();

        mDevice.pressBack();
        Thread.sleep(500);
        //Click(deleteButton,500);

        //确认数据
        Click("head_icon", 1000);
        Click("fmcard_tv_sync_photos", 1000);
        Click("tv_my_data", 1000);
        Click("tv_indoor_my_data_snap_list_item_work_status", 1000);
        mDevice.pressBack();
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(500);

        //同步数据
        synchronize("rb_tips_update");

        //确认
        Click("head_icon", 1000);
        Click("fmcard_tv_user_data",1000); //点击我的数据
        listViewObj = mDevice.findObject(By.clazz(ListView.class));
        child = listViewObj.findObject(By.clazz(RelativeLayout.class));
        child.click();
        Thread.sleep(1000);
        String rowkey = mDevice.findObject(By.res(packageName, "et_title")).getText();

        mDevice.pressBack();
        Thread.sleep(500);
        Click("btn_fm_confirm", 500);
        mDevice.pressBack();
        Thread.sleep(500);


        assertEquals(infoRowkey, rowkey);

    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00105_poi_father_error_check() throws Exception {
        mDevice.drag(0, 768, 2048, 768, 10);
        Thread.sleep(500);
        mDevice.drag(0, 768, 1900, 768, 10);

        //点击新增大厦POI
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(500);

        Click("take_pic_imgbtn",2000); //点击拍照
        Click("task_pic_back_img"); //点击返回

        PutinEditor("fm_et_name", "大厦TEST1"); //输入POI名称

        Click("tv_assort_type",1000);//点击选择分类

        PutinEditor("et_kind_search", "200103");
        Thread.sleep(1000);
        Click("top_name_txtinfo",2000);

        Click("save_button"); //点击保存
        poiNum++;

        mDevice.drag(0, 768, 250, 768, 10);


        //点击新增中餐馆子POI
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(500);

        Click("take_pic_imgbtn",2000); //点击拍照
        Click("task_pic_back_img"); //点击返回

        PutinEditor("fm_et_name", "中餐馆TEST1"); //输入POI名称

        Click("tv_assort_type",1000);//点击选择分类

        PutinEditor("et_kind_search", "110101");
        Thread.sleep(1000);
        Click("top_name_txtinfo",2000);

        Click("tv_poi_father",1000);//点击父子关系
        UiObject2 Object = mDevice.wait(Until.findObject(By.text("大厦/写字楼")), 1000);
        Object.click();
        Thread.sleep(1000);

        Click("save_button"); //点击保存
        poiNum++;

        //同步POI数据
        mDevice.drag(0, 768, 600, 768, 10);
        synchronize("rb_poi_update");

        //检查错误列表
        Click("head_icon", 1000);
        Click("fmcard_tv_error_seem", 1000);
        Object = mDevice.wait(Until.findObject(By.text("Poi")), 1000);
        Object.click();

    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00106_poi_same_error_check() throws Exception {

        //同步TIPS数据
        synchronize("rb_tips_update");

        // 放大并找到grid分界
        Click("iv_zoom_in");
        Thread.sleep(500);
        getPosion(0,0,"11130159503");

        Thread.sleep(500);
        mDevice.drag(1, 790, 1035, 590, 50);
        Thread.sleep(500);

        //点击政府机关POI
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(500);

        Click("take_pic_imgbtn",2000); //点击拍照
        Click("task_pic_back_img"); //点击返回

        PutinEditor("fm_et_name", "政府机关TEST"); //输入POI名称

        UiObject2 txtFid =  mDevice.findObject(By.res(packageName, "tv_poi_fid_hd"));
        infoFid = txtFid.getText();

        Click("tv_assort_type",1000);//点击选择分类

        PutinEditor("et_kind_search", "190106");
        Click("top_name_txtinfo",2000);

        Click("save_button"); //点击保存
        poiNum++;

        getPosion(0,0,"11130159503");

        Thread.sleep(500);
        mDevice.drag(1, 790, 1045, 590, 50);
        Thread.sleep(500);


        //点击新增银行POI
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(500);
        Click("fmdialog_tv_ignore_add",2000);

        Click("take_pic_imgbtn",2000); //点击拍照
        Click("task_pic_back_img"); //点击返回

        PutinEditor("fm_et_name", "银行TEST"); //输入POI名称

        Click("tv_assort_type",1000);//点击选择分类

        PutinEditor("et_kind_search", "150101");
        Click("top_name_txtinfo",2000);

        Click("tv_poi_same_one",1000);//点击同一关系
        UiObject2 Object = mDevice.wait(Until.findObject(By.text("区级政府机关(广州市）")), 1000);
        Object.click();

        Click("save_button"); //点击保存
        poiNum++;

        //同步POI数据
        mDevice.drag(0, 768, 600, 768, 10);
        synchronize("rb_poi_update");

        //检查错误列表
        Click("head_icon", 1000);
        Click("fmcard_tv_error_seem", 1000);
        Object = mDevice.wait(Until.findObject(By.text("Poi")), 1000);
        Object.click();
        Object = mDevice.wait(Until.findObject(By.text("查看详情")), 1000);
        if(null == Object) {
            fail("no POI error list");
        }else {
            Object.click();
            Thread.sleep(500);
            UiObject2 errMessage =  mDevice.findObject(By.res(packageName, "tv_content"));
            assertEquals(errMessage.getText(), "同一poi(" + infoFid + ")在库中不存在");
        }
    }

    // FM-1207-6-2
    @Test
    public void test_FM_1207_6_2_check() throws Exception {

        mDevice.drag(700, 650, 1024, 768, 10);

        //增加POI
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.POI_ADD_9001);  //点击新增POI
        Thread.sleep(500);

        Click("take_pic_imgbtn",2000); //点击拍照
        Click("task_pic_back_img"); //点击返回

        PutinEditor("fm_et_name", "测试ＰＯＩ001"); //输入POI名称

        Click("tv_assort_type",1000);//点击选择分类

        mDevice.findObject(By.text("中餐馆")).click();


        Thread.sleep(1000);
        Click("edt_contactItem_telNum");
        Thread.sleep(1000);
        PutinEditor("edt_contactItem_telNum", "19012345678"); //输入19开头电话号码，这行代码在我这儿运行会直接挂掉，你确认下
        Thread.sleep(1000);

        Click("save_button",1000);

        //增加匝道
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.RAMP);
        Thread.sleep(500);

        Click(new Point(1025, 800));
        Click("btn_ramp");
        Click("save_button");

        AssertIndoorCheck("匝道", "低", "FM-1207-6-2", "匝道属性道路连接了POI", "忽略");
    }

    // FM-1208-2-1
    @Test
    public void test_FM_1208_2_1_check() throws Exception {
        mDevice.drag(700, 650, 1024, 768, 10);

        //增加道路方向：单向
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.ROAD_DIRECTION);
        Thread.sleep(500);
        //测线中点
        Click(new Point(1024, 790));
        //保存
        Click("save_button", 500);

        //增加停车场出入口link
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.PARK_ENTRANCE_LINK);
        Thread.sleep(500);

        Click(new Point(730, 800));
        Click("save_button");

        AssertIndoorCheck("停车场出入口link", "中", "FM-1208-2-1", "单方向道路未进行停车场出入口LINK连接", "");
    }

    // FM-1301-6-4
    @Test
    public void test_FM_1301_6_4_1check() throws Exception {

        mDevice.drag(700, 650, 1024, 768, 10);

        //增加车信
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.LANE_INFO);
        Thread.sleep(500);
        Click(new Point(1040, 800));
        Thread.sleep(500);

        Click("rb_select_one_g_a_f",1000);
        Click(new Point(1210, 600),1000);

        //保存
        Click("save_button", 1000);

        AssertIndoorCheck("车信", "低", "FM-1301-6-4", "有附加车信，是否车道变化点采集遗漏", "忽略");

    }

    // FM-1301-6-4
    @Test
    public void test_FM_1301_6_4_2check() throws Exception {

        // 测线
        Point[] arrayPoint = {new Point(1250, 530), new Point(1250, 700)};
        DrawRoad(arrayPoint);

        //增加道路方向：单向
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.ROAD_DIRECTION);
        Thread.sleep(500);
        //测线中点
        Click(new Point(1250, 600));
        //保存
        Click("save_button", 500);

        //增加车信
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.LANE_INFO);
        Thread.sleep(500);
        Click(new Point(720, 800));
        Thread.sleep(500);

        Click("rb_select_one_g_a_f",1000);
        Click(new Point(1210, 600),1000);

        //保存
        Click("save_button", 1000);

        AssertIndoorCheck("车信", "低", "FM-1301-6-4", "有附加车信，是否车道变化点采集遗漏", "忽略");

    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_1check() throws Exception {
        mDevice.drag(700, 650, 1024, 768, 10);

        //增加道路方向：单向
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.ROAD_DIRECTION);
        Thread.sleep(500);
        //测线中点
        Click(new Point(1024, 790));
        //保存
        Click("save_button", 500);

        //交限
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Thread.sleep(500);

        Click(new Point(725, 800));

        Click("traffic_forbidden_no_pull_into",500);

        //保存
        Click("save_button", 500);

        AssertIndoorCheck("禁止驶入", "中", "FM-1305-6-1", "禁止驶入与单行线重复", "");
    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_2check() throws Exception {
        // 测线
        Point[] arrayPoint = {new Point(1250, 530), new Point(1250, 700)};
        DrawRoad(arrayPoint);

        //增加道路方向：单向
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.ROAD_DIRECTION);
        Thread.sleep(500);
        //测线中点
        Click(new Point(1250, 600));
        //保存
        Click("save_button", 500);

        //交限
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Thread.sleep(500);

        Click(new Point(725, 800));

        Click("traffic_forbidden_no_pull_into",500);
        //保存
        Click("save_button", 500);

        AssertIndoorCheck("禁止驶入", "中", "FM-1305-6-1", "禁止驶入与单行线重复", "");
    }

    public void searchObject(String key, String type) throws InterruptedException {
        //默认搜索tips
        mDevice.findObject(By.res(packageName, "img_search")).click();
        Thread.sleep(1000);

        mDevice.findObject(By.res(packageName, "edt_search_tips_input")).setText(key);
        Thread.sleep(1000);
        mDevice.findObject(By.res(packageName, "tv_search_tips_btn")).click();
        Thread.sleep(2000);

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));

        mDevice.findObject(By.res(packageName, "tv_my_data_snap_list_item_name")).click();
        Thread.sleep(1000);
    }

    public void getPosion(int endX, int endY, String key) throws InterruptedException {
        searchObject(key,"TIPS");

        mDevice.pressBack();
        Thread.sleep(1000);
        UiObject2 object = mDevice.wait(Until.findObject(By.text("舍弃")), 1000);
        if(null != object) {
            object.click();
        }
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(1000);

        if(endX == 0 && endY == 0) {

        }else {
            mDevice.drag(1273, 615, endX, endY, 10);
        }
        Thread.sleep(1000);

    }

    // 上报情报
    public void addReport() throws InterruptedException, UiObjectNotFoundException
    {

        Click("btn_infor_report", 1000);  //点上报
        Click("info_pop_add_point", 3000); //点击点情报

        Click(new Point(900,500)); //点击情报位置

        PutinEditor("edt_infor_report_name", "测试上报情报6"); //输入情报名称
        Click("infor_report_type_poi");
        Click("tv_poiReport_time", 1000); //点击选择时间
        Click("btn_fm_confirm", 1000);

        Click("camera_button", 6000);

        Click("take_pic_imgbtn", 3000); //点击拍照
        Click("task_pic_back_img",1000); //点击返回

        Click("save_button",3000); //点击保存

        Click("head_icon"); //点击主界面左上角头像
        Click("fmcard_tv_user_data"); //点击我的数据
        Click("tv_my_data_condition_1"); // 点击Tips数据
        Click("rb_condition_live_information"); //点击对应的数据类型（Tips数据/POI数据/点门牌数据/常规情报/自采集情报）
        Click("tv_condition_confirm_hd"); //点击确定

        Thread.sleep(1000);

        mDevice.findObject(By.res(packageName, "tv_my_data_snap_list_item_name")).click();
        Thread.sleep(1000);

        String txtGlobalid =  mDevice.findObject(By.res(packageName, "et_title")).getText().substring(10);

        globalId = txtGlobalid;

        mDevice.pressBack();
        Click("btn_fm_confirm", 1000);
        mDevice.pressBack();


    }

    // 同步情报
    public void synchronize(String syncType) throws InterruptedException {

        Click("head_icon", 1000);
        Click("fmcard_tv_grid_manager", 1000); //Grid管理
        Click(new Point(mDevice.getDisplayWidth()/2,mDevice.getDisplayHeight()/2));
        Click("grid_project_button", 1000);
        Click(syncType, 1000); //情报数据
        Click("synchronous_button", 1000); //同步
        Click("btn_fm_confirm", 1000);
        Click("btn_fm_confirm", 1000);
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
                if (count == 1500)
                {
                    break;
                }

                Thread.sleep(1000);
                count++;
            }
        }
        Click("grid_sync_btn_positive");
        Thread.sleep(1000);
        UiObject2 object = mDevice.findObject(By.res(packageName, "btn_fm_confirm"));
        if(null != object) {
            object.click();
        }
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(1000);
    }

    // 采纳情报
    public void accept() throws UiObjectNotFoundException, InterruptedException {

        mDevice.findObject(By.res(packageName, "img_search")).click();
        Thread.sleep(1000);

        mDevice.wait(Until.findObject(By.text("情报")), 500).click();
        mDevice.findObject(By.res(packageName, "edt_search_info_input")).setText(globalId);
        Thread.sleep(500);
        mDevice.findObject(By.res(packageName, "tv_search_info_btn")).click();
        Thread.sleep(2000);

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));

        mDevice.findObject(By.res(packageName, "tv_my_data_snap_list_item_name")).click();


        //采纳情报
        Click("save_button",6000); //点击采纳
        Click("take_pic_imgbtn", 3000); //点击拍照
        Click("task_pic_back_img",1000); //点击返回
        Click("tv_assort_type", 3000);//点击选择分类

        UiObject2 txtFid =  mDevice.findObject(By.res(packageName, "tv_poi_fid_hd"));


        // 遍历List
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

        infoFid = txtFid.getText();

        objectRest.click(); //点击中餐馆
        Click("save_button"); //点击保存
        mDevice.pressBack();
        Thread.sleep(1000);
    }

    // 检查情报fid
    public void checkFid() throws UiObjectNotFoundException, InterruptedException {
        Click("head_icon",500); //点击主界面左上角头像

        Click("fmcard_tv_user_data",500); //点击我的数据
        Click("tv_my_data_condition_1",500); // 点击Tips数据
        Click("rb_condition_poi",500); //点击对应的数据类型（Tips数据/POI数据/点门牌数据/常规情报/自采集情报）
        Click("tv_condition_confirm_hd",500); //点击确定

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "测试上报情报６");
        Object.click();
        Thread.sleep(2000);

        UiObject2 txtFid =  mDevice.findObject(By.res(packageName, "tv_poi_fid_hd"));
        String strFid = txtFid.getText();

        mDevice.pressBack();
        Thread.sleep(500);
        Click("btn_fm_confirm", 1000);
        mDevice.pressBack();
        Thread.sleep(500);

        assertEquals(infoFid, strFid);
    }

    private static String globalId = "";
    private static String infoFid = "fid:00002420180118145219";
    private static String infoRowkey = "";
}
