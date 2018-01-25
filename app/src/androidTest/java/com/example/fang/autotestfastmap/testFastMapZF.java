package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
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

import com.fastmap.ui.FastMapUI;
import com.fastmap.ui.Page_IndoorTool;
import com.fastmap.ui.Page_InfoReport;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MainMenu;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_SearchResultList;
import com.fastmap.ui.Page_SelectTime;
import com.fastmap.ui.Page_StartEndPoint;
import com.fastmap.ui.Page_SurveyLine;
import com.fastmap.ui.Page_TrafficForbidden;
import com.fastmap.ui.Page_TrueSence;

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

        //点击新增POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //输入POI名称
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");

        //中餐馆类型
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");

        //输入19开头电话号码
        Page_POI.Inst.SetValue(Page_POI.TEL, "19012345678");

        //点击保存
        Page_POI.Inst.Click(Page_POI.SAVE);

        poiNum++;

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        mDevice.wait(Until.findObject(By.text("测试ＰＯＩ２")), 500).click();

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

        Page_POI.Inst.Click(Page_POI.SAVE); //点击保存
        ExitMyData(); //退出我的数据
    }

    //采纳情报fid保存
    @Test
    public void test00103_poi_report_check() throws InterruptedException, UiObjectNotFoundException, NoSuchFieldException, ClassNotFoundException {
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

        UiObject2 txtFid =  mDevice.findObject(By.res(packageName, "tv_poi_fid_hd"));
        infoFid = txtFid.getText();

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
        mDevice.drag(600, 768, 0, 768, 10);
        synchronize("rb_poi_update");

        //检查错误列表
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
            String txtErrMessage = errMessage.getText();
            Thread.sleep(500);
            Click("btn_fm_cancel", 1000);
            mDevice.pressBack();
            Thread.sleep(500);
            mDevice.pressBack();
            Thread.sleep(500);
            assertEquals(txtErrMessage, "子(" + infoFid + ")不存在");
        }

    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00106_poi_same_error_check() throws Exception {

        //同步TIPS数据
        synchronize("rb_tips_update");

        // 放大并找到grid分界
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);

        getPosion("11130159503");

        Thread.sleep(500);
        mDevice.drag(1, 790, 2048, 490, 100);
        Thread.sleep(500);
        mDevice.drag(1, 790, 1075, 790, 100);
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

        getPosion("11130159503");

        Thread.sleep(500);
        mDevice.drag(1, 790, 2048, 490, 100);
        Thread.sleep(500);
        mDevice.drag(1, 790, 1140, 790, 100);
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
            String txtErrMessage = errMessage.getText();
            Thread.sleep(500);
            Click("btn_fm_cancel", 1000);
            mDevice.pressBack();
            Thread.sleep(500);
            mDevice.pressBack();
            Thread.sleep(500);
            assertEquals(txtErrMessage, "同一poi(" + infoFid + ")在库中不存在");
        }
    }

    // 高速实景图手动录入编号
    @Test
    public void test00107_tips_true_sence_check() throws Exception {

        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        mDevice.drag(2030, 50, 10, 1525, 10);

        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(700,268));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER, "abCD1234");

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA_BUTTON);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        //获取rowkey
        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        mDevice.wait(Until.findObject(By.text("实景图")), 500).click();
        String rowkey = Page_TrueSence.Inst.GetValue(Page_TrueSence.ROWKEY).substring(7);
        Page_TrueSence.Inst.Click(Page_TrueSence.CANCEL);
        ExitMyData(); //退出我的数据

        //确认数据
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTool.Inst.Click(Page_MainMenu.MY_DATA);
        Click("ll_indoor_data_snap_item");
        Click("iv_my_data_back");
        Page_IndoorTool.Inst.Click(Page_MainMenu.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //同步数据
        synchronize("rb_tips_update");

        //根据rowkey查找该实景图
        searchObject(rowkey,"TIPS");

        //获取编号
        String code = Page_TrueSence.Inst.GetValue(Page_TrueSence.ET_IMG_NUMBER);

        Page_TrueSence.Inst.Click(Page_TrueSence.CANCEL);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);

        assertEquals("abCD1234", code);


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
    public void test_FM_1301_6_4_1_check() throws Exception {

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
    public void test_FM_1301_6_4_2_check() throws Exception {

        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

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


    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_1_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);

        //禁止穿行1级道路
        getPosion("11111011274124");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(1120,740),500);
        Click("save_button", 500);



        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_2_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);

        //禁止穿行2级道路
        getPosion("11111011274124");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(1215,1155),500);
        Click("save_button", 500);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_3_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);


        //禁止穿行3级道路
        getPosion("11111011274124");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(790,590),500);
        Click("save_button", 500);


        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_4_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);

        //禁止穿行4级道路
        getPosion("11111011274124");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(1140,1340),500);
        Click("save_button", 500);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_5_check() throws Exception {

        //同步tips
        synchronize("rb_tips_update");

        //禁止穿行1级道路（测线且t_sync=1）
        getPosion("1112036063743");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(1100,850),500);
        Click("save_button", 500);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_6_check() throws Exception {

        //同步tips
        synchronize("rb_tips_update");

        //禁止穿行2级道路（测线且t_sync=1）
        getPosion("1112036063743");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(1100,970),500);
        Click("save_button", 500);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_7_check() throws Exception {

        mDevice.drag(2030, 50, 10, 1525, 10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(1200,800),500);
        Click("save_button", 500);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_8_check() throws Exception {

        mDevice.drag(2030, 50, 10, 1525, 10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Click(new Point(1200,1020),500);
        Click("save_button", 500);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_1_check() throws Exception {
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
    public void test_FM_1305_6_1_2_check() throws Exception {
        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

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


    // FM-1305-6-2
    @Test
    public void test_FM_1305_6_2_1_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);

        //禁止驶入1级道路
        getPosion("11111011274124");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(1120,740),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_2_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);

        //禁止驶入2级道路
        getPosion("11111011274124");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(1215,1155),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_3_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);


        //禁止驶入3级道路
        getPosion("11111011274124");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(790,590),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_4_check() throws Exception {

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_OUT);

        //同步tips
        synchronize("rb_tips_update", new Point(1720,1150));

        //找到符合要求的位置
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);

        //禁止驶入4级道路
        getPosion("11111011274124");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(1140,1340),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_5_check() throws Exception {

        //同步tips
        synchronize("rb_tips_update");

        //禁止驶入1级道路（测线且t_sync=1）
        getPosion("1112036063743");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(1100,850),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_6_check() throws Exception {

        //同步tips
        synchronize("rb_tips_update");

        //禁止驶入2级道路（测线且t_sync=1）
        getPosion("1112036063743");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(1100,970),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_7_check() throws Exception {

        mDevice.drag(2030, 50, 10, 1525, 10);

        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(1200,800),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_8_check() throws Exception {

        mDevice.drag(2030, 50, 10, 1525, 10);

        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入4级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Click(new Point(1100,960),500);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    //FM-1503-6-1
    @Test
    public void test_FM_1503_6_1_1_check() throws Exception {

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(580, 498));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(820, 498));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        //绘制跨越桥
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(700, 498));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1000, 498));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERPASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    @Test
    public void test_FM_1503_6_1_2_check() throws Exception {

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(580, 498));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(820, 498));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        //绘制穿越地道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(700, 498));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1000, 498));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.UNDER_PASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    @Test
    public void test_FM_1503_6_1_3_check() throws Exception {

        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(550, 450));
        Page_MainBoard.Inst.Click(new Point(1050, 450));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(580, 450));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(820, 450));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        //绘制跨越桥
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(700, 450));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1000, 450));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERPASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    @Test
    public void test_FM_1503_6_1_4_check() throws Exception {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(550, 450));
        Page_MainBoard.Inst.Click(new Point(1050, 450));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(580, 450));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(820, 450));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        //绘制穿越地道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(700, 450));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1000, 450));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.UNDER_PASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存","");
    }

    //FM-1521-1-2
    @Test
    public void test_FM_1521_1_2_check() throws Exception {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(550, 550));
        Page_MainBoard.Inst.Click(new Point(1050, 550));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //移动式桥
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(600, 550));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1000, 550));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.TRAVELING_BRIDGE_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        //删除测线
        GotoMyData(Page_MyData.TIPS_TYPE);
        mDevice.wait(Until.findObject(By.text("测线")), 500).click();
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        mDevice.wait(Until.findObject(By.text("仅删除测线")), 500).click();
        ExitMyData();

        AssertIndoorCheck("移动式桥", "中", "FM-1521-1-2", "Tips没有关联道路或测线或Node","");
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

    public void getPosion(String key) throws InterruptedException {
        searchObject(key,"TIPS");

        mDevice.pressBack();
        Thread.sleep(1000);
        UiObject2 object = mDevice.wait(Until.findObject(By.text("舍弃")), 1000);
        if(null != object) {
            object.click();
        }
        Thread.sleep(500);
        mDevice.pressBack();
        Thread.sleep(2000);
    }

    // 上报情报
    public void addReport() throws InterruptedException, UiObjectNotFoundException, NoSuchFieldException, ClassNotFoundException {

        Page_MainBoard.Inst.Click(Page_MainBoard.INFO_REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.INFO_REPORT_POINT); //点击点情报

        Page_MainBoard.Inst.Click(new Point(900,500)); //点击情报位置

        Page_InfoReport.Inst.SetValue(Page_InfoReport.REPORT_NAME, "测试上报情报6"); //输入情报名称
        Page_InfoReport.Inst.Click(Page_InfoReport.REPORT_TYPE_POI);
        Page_InfoReport.Inst.Click(Page_InfoReport.CHOOSE_TIME); //点击选择时间
        Page_SelectTime.Inst.Click(Page_SelectTime.OK);

        Page_InfoReport.Inst.Click(Page_InfoReport.CAMERA_BUTTON);//拍照

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoReport.Inst.Click(Page_InfoReport.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.LIVE_INFORMATION_TYPE); //进入我的数据,自采集情报
        mDevice.wait(Until.findObject(By.text("自采集情报(POI)(点)")), 500).click();
        globalId = Page_InfoReport.Inst.GetValue(Page_InfoReport.GLOBAL_ID).substring(10);
        Page_InfoReport.Inst.Click(Page_InfoReport.CANCEL);
        ExitMyData(); //退出我的数据

    }

    // 同步情报
    public void synchronize(String syncType, Point... syncGridPositon) throws InterruptedException, NoSuchFieldException, ClassNotFoundException {

        Click("head_icon", 1000);
        Click("fmcard_tv_grid_manager", 1000); //Grid管理
        Click("grid_project_button", 1000);
        if(syncGridPositon.length > 0) {
            Click(syncGridPositon[0]);
        }else {
            Click(new Point(mDevice.getDisplayWidth()/2,mDevice.getDisplayHeight()/2));
        }

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
        Page_MainBoard.Inst.Click(Page_MainBoard.BACK);
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
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

    @Override
    protected void GotoMyData(String strType) {
        try {
            Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
            Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
            Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
            Page_MyData.Inst.Click(strType);
            Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);
        } catch (Exception e) {
            e.printStackTrace();
        }

        eCurrLayer = EnumLayer.Layer_MyData;
    }

    @Override
    protected  void ExitMyData()
    {
        Click("iv_my_data_back");
        Click("fmcard_ibtn_back");
        eCurrLayer = EnumLayer.Layer_Main;
    }

    private static String globalId = "";
    private static String infoFid = "fid:00002420180118145219";
    private static String infoRowkey = "";
}
