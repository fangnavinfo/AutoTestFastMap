package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.fastmap.ui.Page_3D;
import com.fastmap.ui.Page_Accept;
import com.fastmap.ui.Page_CarInfo;
import com.fastmap.ui.Page_Dangerous;
import com.fastmap.ui.Page_ElecEye;
import com.fastmap.ui.Page_Gate;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_IndoorTool;
import com.fastmap.ui.Page_Indoor_Data_List;
import com.fastmap.ui.Page_InfoFrame;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_InfoPoint;
import com.fastmap.ui.Page_InfoReport;
import com.fastmap.ui.Page_LaneChangePoint;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MainMenu;
import com.fastmap.ui.Page_MilePost;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_PAS;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_Ramp;
import com.fastmap.ui.Page_Road_Name;
import com.fastmap.ui.Page_Road_Name_Sign;
import com.fastmap.ui.Page_RoundAbout;
import com.fastmap.ui.Page_Search;
import com.fastmap.ui.Page_SearchResultList;
import com.fastmap.ui.Page_Set;
import com.fastmap.ui.Page_SketchHook;
import com.fastmap.ui.Page_Speed_Limit_Lane;
import com.fastmap.ui.Page_StartEndPoint;
import com.fastmap.ui.Page_SurveyLine;
import com.fastmap.ui.Page_Time_Ctl;
import com.fastmap.ui.Page_TrafficForbidden;
import com.fastmap.ui.Page_TruckForbidden;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static com.example.fang.autotestfastmap.TipsDeepDictionary.ADD_POINT_1700;
import static com.fastmap.ui.Page_CarInfo.T;
import static junit.framework.Assert.fail;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapYL extends testFastMapBase
{
    @BeforeClass
    public static void setClassUp() throws Exception
    {
        //testFastMapBase.setClassUp("collector1","123456");//"collector1","123456"
    }

    @AfterClass
    public static void setClassDown() throws InterruptedException, IOException
    {
    }

    @Before
    public void setUp() throws Exception {
        testFastMapBase.setClassUp("collector1","123456");
    }

    @After
    public  void setAfter() //throws IOException, InterruptedException
    {
        //super.setAfter();
    }



    @Test
    public void test00202_poi_add() throws Exception
    {
        //产品全貌开关关，新增POI点查看相机设置
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.NAME_TYPE);//名称
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_LOW);//分辨率低
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ１");
    }


    @Test
    public void test00203_poi_add() throws Exception
    {
        //产品全貌开关关闭,新增POI点查看相机设置
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.SHUIPAI_TYPE);//水牌
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_MID);//分辨率中
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.CAMERA);//看是否保存了上次置的属性(水牌，中)
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;

        //我的数据
        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ２");
    }

    @Test
    public void test00204_poi_add() throws Exception
    {
        //产品全貌开关关，查看相机设置，因为名称，分辨率中
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(3000);
         Page_POI.Inst.Click(Page_POI.CANCEL);
    }

    @Test
    public void test00205_poi_add() throws Exception
    {
        //产品全貌开关开，新增POI点查看相机设置
        SetConfInfo();//产品全貌开关开，产品全貌，分辨率高
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"测试ＰＯＩ３");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Thread.sleep(2000);
        Page_POI.Inst.Click(Page_POI.CAMERA);//名称，分辨率中
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;
        //我的数据
        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ３");
    }

    @Test
    public void test00206_poi_add() throws Exception
    {
        //产品全貌开关开
        //SetConfInfo();//产品全貌开关开
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_LOW);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//现在的低分辨率(但是这个直不计入本地文件)，产品全貌图
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME,"测试ＰＯＩ４");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.SHUIPAI_TYPE);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_HIG);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.Click(Page_POI.CAMERA); //看是否保存设置(水牌，高)
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;
        //查看我的数据
        CheckMyData(Page_MyData.POI_TYPE,"测试ＰＯＩ４");
    }

    @Test
    public void test00207_poi_add() throws Exception
    {
        //产品全貌开关开，点击新增POI查看设置
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//标签“产品全貌”，分辨率为“高”
        Page_POI.Inst.Click(Page_POI.CANCEL);
        SetConfInfo();//关闭产品全貌开关
    }
    /*
    //问题
    //test
            @Test
            public void test00208_poi_add() throws UiObjectNotFoundException, InterruptedException
            {
                //POI 紧急停车站
                //Page_MainBoard.Inst.Drag();mDevice.drag(700, 823, 1024, 823, 10);Thread.sleep(2000);

                //SetConfInfo();//默认就是关
                Click(newPOIPoint, 6000);
                Click("task_pic_back_img");
                Click("tv_assort_type", 3000);
                Thread.sleep(3000);
                UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
                listScrollable.scrollDescriptionIntoView("交通运输、仓储");
                mDevice.findObject(By.text("交通运输、仓储")).click();
                mDevice.findObject(By.text("道路附属设施")).click();
                mDevice.drag(1242,1250,1208,332,10);
                mDevice.findObject(By.text("紧急停车带")).click();

                Click("save_button");
                poiNum++;

                //我的数据
                GotoMyData("rb_condition_poi");
                assertEditorEqual("tv_my_data_count_2", Integer.toString(poiNum));
                assertNotNull(Until.findObject(By.desc("紧急停车带")));
                ExitMyData();
            }
*/
    @Test
    public void test00209_poi_add() throws Exception {
        //POI 彩票投注站
        //SetConfInfo();//默认就是关
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE,"彩票投注站");
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;

        //我的数据
        CheckMyData(Page_MyData.POI_TYPE,"彩票销售店");
    }

    @Test
    public void test00702_info_Point_testPath() throws Exception
    {
        //添加点情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.INFO_REPORT_POINT);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());

        Page_InfoPoint.Inst.Click(Page_InfoPoint.NAME);
        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME,"测试点ＩＮＦＯ");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.REPORT_TYPE_ROAD);//道路
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        infoRoadNum++;

        //查看我的数据
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
        Page_MyData.Inst.Click(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);
        Page_MyData.Inst.SelectData("自采集情报(道路)(点)");
        String temp = "";
        temp = Page_MyData.Inst.GetGlobalID();
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //数据同步
        SyncInfo();
        infoRoadNum = 0;

        //根据GobalID搜索同步后的情报数据
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(2000);
        Page_Search.Inst.ClickTips("情报");
        Page_Search.Inst.Click(Page_Search.EDITINFO);
        Page_Search.Inst.SetValue(Page_Search.EDITINFO,temp);
        Page_Search.Inst.Click(Page_Search.INFOSEARCH);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.SEARCH_LIST);

        //部分采纳
        Page_Accept.Inst.Click(Page_Accept.ACCEPT);
        Page_InfoReport.Inst.Click(Page_InfoReport.POINTINFO);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        infoRoadNum++;

    }

    @Test
    public void test00802_info_Line_testPath() throws Exception
    {
        //添加线情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.INFO_REPORT_LINE);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME,"测试点ＩＮＦＯ");
        Page_InfoLine.Inst.Click(Page_InfoLine.ROADTYPE);//道路
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);
        infoRoadNum++;

        //查看我的数据
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
        Page_MyData.Inst.Click(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);
        Page_MyData.Inst.SelectData("自采集情报(道路)(线)");
        String temp = "";
        temp = Page_MyData.Inst.GetGlobalID();
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //同步数据
        SyncInfo();
        infoRoadNum = 0;

        //搜索获取同步后自采集情报信息
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(2000);
        Page_Search.Inst.ClickTips("情报");
        Page_Search.Inst.Click(Page_Search.EDITINFO);
        Page_Search.Inst.SetValue(Page_Search.EDITINFO,temp);
        Page_Search.Inst.Click(Page_Search.INFOSEARCH);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.SEARCH_LIST);
        Thread.sleep(3000);
        //部分采纳
        Page_Accept.Inst.Click(Page_Accept.ACCEPT);
        Page_InfoReport.Inst.Click(Page_InfoReport.LINEINFO);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        infoRoadNum++;
    }

    @Test
    public void test00902_info_Frame_testPath() throws Exception
    {
        //添加面情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.INFO_REPORT_FRAME);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.SetValue(Page_InfoFrame.NAME,"测试点ＩＮＦＯ");
        Page_InfoFrame.Inst.Click(Page_InfoFrame.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);
        infoRoadNum++;

        //查看我的数据
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
        Page_MyData.Inst.Click(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);
        Page_MyData.Inst.SelectData("自采集情报(道路)(面)");
        String temp = "";
        temp = Page_MyData.Inst.GetGlobalID();
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //同步情报数据
        SyncInfo();
        infoRoadNum = 0;

        //根据globalID搜索上传后的面情报数据
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(2000);
        Page_Search.Inst.ClickTips("情报");
        Page_Search.Inst.Click(Page_Search.EDITINFO);
        Page_Search.Inst.SetValue(Page_Search.EDITINFO,temp);
        Page_Search.Inst.Click(Page_Search.INFOSEARCH);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.SEARCH_LIST);
        Thread.sleep(3000);
        //部分采纳
        Page_Accept.Inst.Click(Page_Accept.ACCEPT);
        Page_InfoReport.Inst.Click(Page_InfoReport.FRAMEINFO);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        infoRoadNum++;
    }

    @Test
    public void test01001_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 3个字
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"123");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        //查看我的数据
        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }

    @Test
    public void test01002_info_roadnamesign_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"123");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);

        //在室内整理工具中查看我的数据中
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTool.Inst.Click(Page_IndoorTool.MY_DATA);
        Thread.sleep(2000);
        //查看道路名称标牌信息，进入属性编辑页
        //滚动条查找
        Page_Indoor_Data_List.Inst.ClickObject("道路名标牌");
        Thread.sleep(2000);
        Page_Indoor_Data_List.Inst.ClickObject("道路名标牌");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        Page_Indoor_Data_List.Inst.Click(Page_Indoor_Data_List.BACK);
        Page_IndoorTool.Inst.Click(Page_IndoorTool.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
        Page_MyData.Inst.Click(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);

        //ExitMyData();
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    @Test
    public void test01003_info_roadnamesign_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"123");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        Thread.sleep(3000);
        //室内整理工具 我的数据
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTool.Inst.Click(Page_IndoorTool.MY_DATA);
        Thread.sleep(2000);
        //道路名称标牌
        //滚动条查找
        Page_Indoor_Data_List.Inst.ClickObject("道路名标牌");
        Thread.sleep(3000);
        Page_Indoor_Data_List.Inst.ClickObject("道路名标牌");
        //属性编辑中移动点位
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.MOVEPOINT);
        mDevice.drag(700, 823, 1024, 823, 10);//问题
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.MOVEPOINT);
        Thread.sleep(1000);
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        Page_Indoor_Data_List.Inst.Click(Page_Indoor_Data_List.BACK);
        Page_IndoorTool.Inst.Click(Page_IndoorTool.BACK);
        //我的数据
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
        Page_MyData.Inst.Click(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    @Test
    public void test01004_info_roadnamesign_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"123");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        Thread.sleep(3000);
        //室内整理工具 我的数据
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTool.Inst.Click(Page_IndoorTool.MY_DATA);
        Thread.sleep(2000);
        //属性编辑页,道路名称标牌
        //滚动条查找
        //Page_Indoor_Data_List.Inst.scrollClickObject("道路名标牌");
        //Page_Indoor_Data_List.Inst.Click(Page_Indoor_Data_List.LIST);
        Page_Indoor_Data_List.Inst.ClickObject("道路名标牌");
        Thread.sleep(3000);
        Page_Indoor_Data_List.Inst.ClickObject("道路名标牌");
        //编辑端点标牌
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.RADIOPOS);//是的checkboxID
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        Page_Indoor_Data_List.Inst.Click(Page_Indoor_Data_List.BACK);
        Page_IndoorTool.Inst.Click(Page_IndoorTool.BACK);

        //我的数据
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
        Page_MyData.Inst.Click(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);
        Thread.sleep(3000);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    @Test
    public void test01006_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 6个字
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"新道路标牌名");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }

    @Test
    public void test01007_info_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 6个字
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"新道路标牌名");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
        //我的数据
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        //获取道路名标牌点位
        scrollClickObject("道路名标牌");
        Thread.sleep(1000);
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.CANCEL);
        Thread.sleep(2000);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);//复制TipID
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2));
        Page_MainBoard.Inst.Click(new Point(1400,900));
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

    }

    @Test
    public void test01008_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 多个字
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK); //问题
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }

    @Test
    public void test01009_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 端点标牌选是
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"qwe");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.RADIOPOS);
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }

    @Test
    public void test01010_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 新增名称为空 拍照
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"");//标牌名称编辑框ID

        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.CAMERA); //拍照ID
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍摄按键ID
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK); //返回键ID
        Thread.sleep(1000);
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE); //保存按键ID
        Thread.sleep(1000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }
    @Test
    public void test01011_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 新增名称不为空 拍照
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//问题
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//问题
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"wer");//标牌名称编辑框ID

        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.CAMERA);//拍照ID
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍摄按键ID
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK); //返回键ID
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);//保存按键ID
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }

    @Test
    public void test01012_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 取消
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"qwe");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.RADIOPOS);//端点标牌是的ID

        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.CANCEL);
    }

    @Test
    public void test01041_data_check() throws Exception {
        //左侧车道必须大于或等于右侧车道的限速值域（数组从小到大顺序）
        //创建限速车道从左到右分别为90,110，110
        Page_MainBoard.Inst.Click(newLimitSpeed);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2-250, mDevice.getDisplayHeight()/2-250));
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.ROADLIMIT);//选择车道限速
        Page_Speed_Limit_Lane.Inst.RoadLimitCtlDrag();//拖拽限速控件
        Page_MainBoard.Inst.Click(new Point(79,552));//第一个限速车道
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM90);
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM110);
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM110);
        Page_MainBoard.Inst.Click(new Point(75,475));//点限速必选一个 第一个限速标志位
        Thread.sleep(1000);
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.SAVE);
        Thread.sleep(3000);
        //tipsNum++;

        //室内整理工具检查，车道限速
        AssertIndoorCheck("车道限速","中","FM-1113-2-2","左侧车道限速小于右侧车道限速","");//问题
    }

    @Test
    public void test01042_data_check() throws Exception {
        //大门tips关联在测线K13上
        //手绘测线 类型为K13
        //Page_MainBoard.Inst.Click(newLeftFive);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);//手绘测线
        Page_SurveyLine.Inst.Click(Page_SurveyLine.FERRY_RD);//13 轮渡
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2-30, mDevice.getDisplayHeight()/2-30));
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2+80, mDevice.getDisplayHeight()/2+80));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        //tipsNum++;//测线

        //Page_MainBoard.Inst.Click(newHorFour);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.EG);//EG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-3","航线上不能采集大门",""); //问题
    }

    @Test
    public void test01043_data_check() throws Exception {
        //大门tips关联在测线11上
        //手绘测线 类型为K11
        //Page_MainBoard.Inst.Click(newLeftFive);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);//手绘测线
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEOPLE_CROSS_RD);//11 人渡
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2-30, mDevice.getDisplayHeight()/2-30));
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2+80, mDevice.getDisplayHeight()/2+80));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        //tipsNum++;

        //Page_MainBoard.Inst.Click(newHorFour);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);//选择大门
        Thread.sleep(3000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.EG);//EG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        Thread.sleep(1000);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-3","航线上不能采集大门","");//问题
    }

    @Test
    public void test01044_data_check() throws Exception {
        //EG门与障碍物不能同时出现
        //单向路 北清路 592305
        SearchRoadFromLink("592305");//大门关联到这个link上
        //Page_MainBoard.Inst.Click(newHorFour);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);//选择大门
        Thread.sleep(3000);
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2+50));
        Page_Gate.Inst.Click(Page_Gate.EG);//EG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        Thread.sleep(1000);
        //tipsNum++;

        //单向路 北清路 592305
        SearchRoadFromLink("592305");//障碍物关联到这个测线上
        //Page_MainBoard.Inst.Click(new Point(1974,897));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Thread.sleep(1000);
        //Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BARRIER);//障碍物目前有问题
        Page_MainBoard.Inst.Click(new Point(1734,359));
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-4","EG门与障碍物不能同时出现","不能忽视");
    }

    @Test
    public void test01045_data_check() throws Exception {
        //门的方向应与道路通行方向一致,双向门在单车道上
        SearchRoadFromLink("592176");//搜索linkid为592176的单向车道
        //Page_MainBoard.Inst.Click(newHorFour);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);//选择大门 //创建双向门
        Thread.sleep(3000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.PG);//PG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        Thread.sleep(1000);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-5","门的方向应与道路通行方向一致","不能忽视");
    }

    @Test
    public void test01046_data_check() throws Exception {
        //门的方向应与道路通行方向一致,单向门在双向车道上
        SearchRoadFromLink("41774976");
        //Page_MainBoard.Inst.Click(newHorFour);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);//选择大门
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.EG);//EG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-5","门的方向应与道路通行方向一致","不能忽视");
    }

    @Test
    public void test01047_data_check() throws Exception {
        //门的方向应与道路通行方向一致,单向门在单向车道上，但是门道方向相反
        SearchRoadFromLink("32092464");
        //Page_MainBoard.Inst.Click(newHorFour);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2-60));
        Page_Gate.Inst.Click(Page_Gate.KG);//KG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        //tipsNum++;

        SearchRoadFromLink("32092464");
        Page_Gate.Inst.Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2-60));
        Page_Gate.Inst.Click(Page_Gate.CHANGEDIR);
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-5","门的方向应与道路通行方向一致","不能忽视");
    }

    @Test
    public void test01048_data_check() throws Exception {
        //10级路上不能有EG
        SearchRoadFromLink("691986");
        //Page_MainBoard.Inst.Click(newHorFour);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.EG);//EG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        Thread.sleep(1000);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-6","10级路上不能有车行门","不能忽视");
    }

    @Test
    public void test01049_data_check() throws Exception {
        //10级路上不能有PG
        SearchRoadFromLink("691994");
        //Page_MainBoard.Inst.Click(newHorFour);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.PG);//PG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        Thread.sleep(1000);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-6","10级路上不能有车行门","不能忽视");
    }

    @Test
    public void test01050_data_check() throws Exception {
        //10级路上不能有KG
        //绘制K10类型手绘测线
        SearchRoadFromLink("691987");
        //Page_MainBoard.Inst.Click(newHorFour);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Thread.sleep(3000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.KG);//KG大门
        Thread.sleep(1000);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);
        Thread.sleep(1000);
        //tipsNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-6","10级路上不能有车行门","不能忽视");
    }

    @Test
    public void test01052_data_check() throws Exception {
        //车道信息与车道数不一致，可能车道变化点采集遗漏
        //搜索单车道linkID为590729的道路
        SearchRoadFromLink("590729");
        //创建四车道车信
        //Page_MainBoard.Inst.Click(newCarInfo);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信
        //Page_MainBoard.Inst.Click(newCarInfo);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());

        Page_CarInfo.Inst.Click(Page_CarInfo.D);
        Page_CarInfo.Inst.Click(Page_CarInfo.B);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);
        Page_CarInfo.Inst.Click(Page_CarInfo.C);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        Thread.sleep(1000);
        //tipsNum++;

        AssertIndoorCheck("车信","中","FM-1301-6-3","车道信息与车道数不一致，可能车道变化点采集遗漏","不能忽视");
    }

    @Test
    public void test01053_data_check() throws Exception {
        //PG关联的link上有勾选了人行门的POI
        SearchRoadFromLink("691994");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.PG);//PG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        SearchRoadFromLink("691994");//  592176
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ９");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");

        Page_POI.Inst.ScrollClick(Page_POI.PERSION_GATE);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-7","","");
    }

    @Test
    public void test01054_data_check() throws Exception {
        //KG关联的link上有勾选了人行门的POI
        SearchRoadFromLink("691987");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.KG);//KG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        SearchRoadFromLink("691987");//  32092464
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ９");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");

        Page_POI.Inst.ScrollClick(Page_POI.PERSION_GATE);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;

        AssertIndoorCheck("大门","中","FM-1104-6-7","","不能忽视");
    }

    @Test
    public void test01055_data_check() throws Exception {
        //测线与隧道tips相交时，需要制作立交
        SearchRoadFromLink("32092464");
        //在此link上创建隧道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);

        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.TUNNEL_BT);//隧道位置（起终点的）
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2-30, mDevice.getDisplayHeight()/2-30));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);//起终点

        //绘制测线与含有隧道的link相交
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2-80));
        Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2+80));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        //tipsNum++;

        AssertIndoorCheck("测线","中","FM-2001-5-9","新测线与隧道属性道路相交，需要制作立交","不能忽视");
    }

    @Test
    public void test01056_data_check() throws Exception
    {
        //Rdlink具有内部道路属性时，如果新增区域内Tips（增属性）包含此条link，则报LOG。
        SearchRoadFromLink("686517");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.ADD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);
        //tipsNum++;

        AssertIndoorCheck("区域内道路","低","FM-1604-1-3","新增区域内道路（pid：***，多个pid时，用逗号分割）上，已经具有区域内道路属性。不能重复增加属性。","可以忽略");
    }

    @Test
    public void test01057_data_check() throws Exception
    {
        //如果Rdlink上已经新增了区域内属性，则以区域内属性Tips为准（同一link关联在两个增属性的区域内道路tips上）。
        SearchRoadFromLink("686517");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Click(GetCenter());
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.ADD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);
        //tipsNum++;

        AssertIndoorCheck("区域内道路","低","FM-1604-1-3","新增区域内道路（pid：***，多个pid时，用逗号分割）上，已经具有区域内道路属性。不能重复增加属性。","可以忽略");
    }

    @Test
    public void test01058_data_check() throws Exception
    {
        //Rdlink不具有内部道路属性时，如果新增区域内Tips（删属性）包含此条link，则报LOG。
        SearchRoadFromLink("568899");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.DELETE);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);
        //tipsNum++;

        AssertIndoorCheck("区域内道路","低","FM-1604-1-4","新增区域内道路（pid：***，多个pid时，用逗号分割）上，已经具有区域内道路属性。不能重复增加属性。","可以忽略");
    }

    @Test
    public void test01059_data_check() throws Exception
    {
        // 如果Rdlink上已经新增了区域内属性，则以区域内属性Tips为准（同一link关联在两个删属性的区域内道路tips上）。
        //备注：如果超过2个区域内道路tips，则不检查
        SearchRoadFromLink("568899");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.DELETE);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);
        //tipsNum++;

        AssertIndoorCheck("区域内道路","低","FM-1604-1-4","新增区域内道路（pid：***，多个pid时，用逗号分割）上，已经具有区域内道路属性。不能重复增加属性。","可以忽略");
    }

    @Test
    public void test01101_tips_CarInfo_add() throws Exception {
        //点击更多,收起，显示隐藏全部单箭头选项
        //Page_MainBoard.Inst.Click(newCarInfo);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信
        Page_MainBoard.Inst.Click(GetCenter());

        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID //问题
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.R);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }
    /*
    //问题
    //test
    @Test
    public void test01102_tips_CarInfo_add() throws InterruptedException, UiObjectNotFoundException {
        //问题
        //我的数据，Tips下点击车信，进入编辑模式，删除
        Click(newCarInfo);//车信控件ID
        Click(GetCenter());
        Click("rb_select_one_a");//单车道任一控件ID //问题
        Click("ll_bg_select_more");//“更多”控件ID
        Click("rb_select_six_r");

        Click("save_button");

        Click("head_icon");
        Click("fmcard_tv_user_data");

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        objscoll.setMaxSearchSwipes(9);
        UiObject object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "车信", true);
        object.click();
        Click("delete_button");
        Click("btn_fm_confirm");

        ExitMyData();
    }
*/
    @Test
    public void test01103_tips_CarInfo_add() throws Exception {
        //新增单箭头 r 斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID  问题
        Page_CarInfo.Inst.Click(Page_CarInfo.R);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test01104_tips_CarInfo_add() throws Exception {
        //新增单箭头 s 斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.S);//斜右单车道控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test01105_tips_CarInfo_add() throws Exception {
        //新增单箭头 t 直斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(T);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01106_tips_CarInfo_add() throws Exception {
        //新增单箭头 x 直斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE); //“更多”控件ID //问题
        Page_CarInfo.Inst.Click(Page_CarInfo.X);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01107_tips_CarInfo_add() throws Exception {
        //新增单箭头 u 左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE); //“更多”控件ID //问题
        Page_CarInfo.Inst.Click(Page_CarInfo.U);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01108_tips_CarInfo_add() throws Exception {
        //新增单箭头 z 右斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE); //“更多”控件ID //问题
        Page_CarInfo.Inst.Click(Page_CarInfo.Z);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01109_tips_CarInfo_add() throws Exception {
        //新增单箭头 w 调斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE); //“更多”控件ID //问题
        Page_CarInfo.Inst.Click(Page_CarInfo.W);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01110_tips_CarInfo_add() throws Exception {
        //新增单箭头 0 调斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE); //“更多”控件ID //问题
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01111_tips_CarInfo_add() throws Exception {
        //新增单箭头 y 左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.Y);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01112_tips_CarInfo_add() throws Exception {
        //新增单箭头 v 右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.V);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01113_tips_CarInfo_add() throws Exception {
        //新增单箭头 2 直左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.TWO);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01114_tips_CarInfo_add() throws Exception {
        //新增单箭头 5 直右斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.FIVE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01115_tips_CarInfo_add() throws Exception {
        //新增单箭头 3 直左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.THREE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01116_tips_CarInfo_add() throws Exception {
        //新增单箭头 4 直右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.FOUR);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

       CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01117_tips_CarInfo_add() throws Exception {
        //新增单箭头 1 斜左斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ONE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01118_tips_CarInfo_add() throws Exception {
        //增加单车道箭头
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE); //“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.R);//斜左
        Page_CarInfo.Inst.Click(Page_CarInfo.S);//斜右控件ID
        Page_CarInfo.Inst.Click(T);
        Page_CarInfo.Inst.Click(Page_CarInfo.X); //直斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.U);//直斜右控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.Z);//左斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.W);//右斜右控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);//调斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.Y);//调斜右控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.V);//左斜右控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.TWO);//右斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.FIVE);//直左斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.THREE);//直右斜右控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.FOUR);//直左斜右控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ONE);//直右斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01119_tips_CarInfo_add() throws Exception {
        //新增单箭头 s 斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.R);//斜右单车道控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01120_tips_CarInfo_add() throws Exception {
        //新增单箭头 t 直斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.S);//直斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01121_tips_CarInfo_add() throws Exception {
        //新增单箭头 x 直斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(T);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01122_tips_CarInfo_add() throws Exception {
        //新增单箭头 u 左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.X);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01123_tips_CarInfo_add() throws Exception {
        //新增单箭头 z 右斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.U);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01124_tips_CarInfo_add() throws Exception {
        //新增单箭头 w 调斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.Z);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01125_tips_CarInfo_add() throws Exception {
        //新增单箭头 0 调斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.W);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01126_tips_CarInfo_add() throws Exception {
        //新增单箭头 y 左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01127_tips_CarInfo_add() throws Exception {
        //新增单箭头 v 右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.Y);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01128_tips_CarInfo_add() throws Exception {
        //新增单箭头 2 直左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.V);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01129_tips_CarInfo_add() throws Exception {
        //新增单箭头 5 直右斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.TWO);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01130_tips_CarInfo_add() throws Exception {
        //新增单箭头 3 直左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.FIVE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01131_tips_CarInfo_add() throws Exception {
        //新增单箭头 4 直右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//更多
        Page_CarInfo.Inst.Click(Page_CarInfo.THREE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01132_tips_CarInfo_add() throws Exception {
        //新增单箭头 1 斜左斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.FOUR);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01178_tips_CarInfo_add() throws Exception {
        //新增单箭头 1 斜左斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ONE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01133_tips_CarInfo_add() throws Exception {
        //新增单箭头 1 斜左
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.R);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01134_tips_CarInfo_add() throws Exception {
        //新增单箭头 s 斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.S);//斜右单车道控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01135_tips_CarInfo_add() throws Exception {
        //新增单箭头 t 直斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(T);//直斜左控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01136_tips_CarInfo_add() throws Exception {
        //新增单箭头 x 直斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.X);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01137_tips_CarInfo_add() throws Exception {
        //新增单箭头 u 左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.U);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01138_tips_CarInfo_add() throws Exception {
        //新增单箭头 z 右斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.Z);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01139_tips_CarInfo_add() throws Exception {
        //新增单箭头 w 调斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.W);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01140_tips_CarInfo_add() throws Exception {
        //新增单箭头 0 调斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01141_tips_CarInfo_add() throws Exception {
        //新增单箭头 y 左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.Y);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01142_tips_CarInfo_add() throws Exception {
        //新增单箭头 v 右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.V);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");

    }
    @Test
    public void test01143_tips_CarInfo_add() throws Exception {
        //新增单箭头 2 直左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.TWO);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID

        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01144_tips_CarInfo_add() throws Exception {
        //新增单箭头 5 直右斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.FIVE);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID

        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01145_tips_CarInfo_add() throws Exception {
        //新增单箭头 3 直左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.THREE);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID

        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01146_tips_CarInfo_add() throws Exception {
        //新增单箭头 4 直右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//更多
        Page_CarInfo.Inst.Click(Page_CarInfo.FOUR);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01147_tips_CarInfo_add() throws Exception {
        //新增单箭头 1 斜左斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ONE);
        Page_CarInfo.Inst.Click(Page_CarInfo.A);//单车道任一控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }


    @Test
    public void test01148_tips_CarInfo_close() throws Exception {
        //新增单箭头 1 斜左
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.R);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01149_tips_CarInfo_close() throws Exception {
        //新增单箭头 s 斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.S);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01150_tips_CarInfo_close() throws Exception {
        //新增单箭头 t 直斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(T);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01151_tips_CarInfo_close() throws Exception {
        //新增单箭头 x 直斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.X);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01152_tips_CarInfo_close() throws Exception {
        //新增单箭头 u 左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.U);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01153_tips_CarInfo_close() throws Exception {
        //新增单箭头 z 右斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.Z);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01154_tips_CarInfo_close() throws Exception {
        //新增单箭头 w 调斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.W);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01155_tips_CarInfo_close() throws Exception {
        //新增单箭头 0 调斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01156_tips_CarInfo_close() throws Exception {
        //新增单箭头 y 左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.Y);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01157_tips_CarInfo_close() throws Exception {
        //新增单箭头 v 右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.V);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01158_tips_CarInfo_close() throws Exception {
        //新增单箭头 2 直左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.TWO);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01159_tips_CarInfo_close() throws Exception {
        //新增单箭头 5 直右斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.FIVE);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01160_tips_CarInfo_close() throws Exception {
        //新增单箭头 3 直左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.THREE);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01161_tips_CarInfo_close() throws Exception {
        //新增单箭头 4 直右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.FOUR);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

       // CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01162_tips_CarInfo_close() throws Exception {
        //新增单箭头 1 斜左斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.ONE);
        Page_CarInfo.Inst.Click(Page_CarInfo.DELETE);
        Page_CarInfo.Inst.Click(Page_CarInfo.CANCEL);

        //CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    //注意每个ID切换成下一个ID 比如63这个用例
    @Test
    public void test01163_tips_CarInfo_add() throws Exception {
        //新增单箭头 1 斜左
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.R);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);//附加上方控件IDiv_dri
        Page_CarInfo.Inst.Click(Page_CarInfo.S);//斜左斜右控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        // tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01164_tips_CarInfo_add() throws Exception {
        //新增单箭头 s 斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.S);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(T);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01165_tips_CarInfo_add() throws Exception {
        //新增单箭头 t 直斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(T);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.X);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01166_tips_CarInfo_add() throws Exception {
        //新增单箭头 x 直斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.X);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.U);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01167_tips_CarInfo_add() throws Exception {
        //新增单箭头 u 左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.U);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.Z);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01168_tips_CarInfo_add() throws Exception {
        //新增单箭头 z 右斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.Z);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.W);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01169_tips_CarInfo_add() throws Exception {
        //新增单箭头 w 调斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.W);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01170_tips_CarInfo_add() throws Exception {
        //新增单箭头 0 调斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.Y);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01171_tips_CarInfo_add() throws Exception {
        //新增单箭头 y 左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.ZERO);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.Y);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01172_tips_CarInfo_add() throws Exception {
        //新增单箭头 v 右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.V);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.TWO);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01173_tips_CarInfo_add() throws Exception {
        //新增单箭头 2 直左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.TWO);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.FIVE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01174_tips_CarInfo_add() throws Exception {
        //新增单箭头 5 直右斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.FIVE);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.THREE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }
    @Test
    public void test01175_tips_CarInfo_add() throws Exception {
        //新增单箭头 3 直左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.THREE);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.FOUR);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01176_tips_CarInfo_add() throws Exception {
        //新增单箭头 4 直右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);
        Page_CarInfo.Inst.Click(Page_CarInfo.FOUR);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);
        Page_CarInfo.Inst.Click(Page_CarInfo.ONE);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01177_tips_CarInfo_add() throws Exception {
        //新增单箭头 1 斜左斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信控件ID
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.MORE);//“更多”控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.ONE);
        Page_CarInfo.Inst.Click(Page_CarInfo.DRI);//附加上方控件ID
        Page_CarInfo.Inst.Click(Page_CarInfo.R);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01201_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//单击击限速Tips newLimitSpeed
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.POINTLIMIT);//点击点限速
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.POINTLIMIT);//点击点限速
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.MAXNUM);//最高限速
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM40);//40
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.MINNUM);//最低限速值
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM30);//30
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"点限速");
    }

    @Test
    public void test01202_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增红绿灯
        //单击
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);//单击红绿灯
        Page_MainBoard.Inst.Click(GetCenter());
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"红绿灯");
    }

    @Test
    public void test01203_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增危险信息
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);//单击危险信息
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);//点击警示信息
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"危险信息");
    }

    @Test
    public void test01204_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增收费站
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);//单击收费站
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.ClickByText("领卡");
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"收费站");
    }

    @Test
    public void test01205_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增电子眼
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);//单击电子眼
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"电子眼");
    }

    @Test
    public void test01206_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增卡车限制
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);//单击卡车限制
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.CAMERA);//拍照ID
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍摄按键ID
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//返回键ID
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"卡车限制");
    }

    @Test
    public void test01207_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增车道变化点
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);//单击车道变化点
        Page_MainBoard.Inst.Click(GetCenter());
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYLANENUM);//进入车道数
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);//2
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKLANENUM);//退出车道数
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);//1
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车道变化点");
    }

    @Test
    public void test01208_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增普通路口模式图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NORMAL_CROSSROAD_PICTURE);//单击点击普通路口模式图
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.ClickByText("73100000");
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"普通路口模式图");
    }


    @Test
    public void test01209_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增高速入口模式图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_ENTRY_MODE_PICTURE);//单击高速入口模式图
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"高速入口模式图");
    }
/*
    //问题
    @Test
    public void test01210_tips_add_Click() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        //单击手动设置点位信息，新增SA
        //Page_MainBoard.Inst.Drag();
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        //OpenGPS();
        Click(newHorFive);
        Click(newSA);//单击SA
        mDevice.click(1731,214);

        Click("save_button");//问题
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("SA")));

        ExitMyData();
    }
    //问题
    @Test
    public void test01211_tips_add_Click() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        //单击手动设置点位信息，新增PA
        //Page_MainBoard.Inst.Drag();
        mDevice.drag(700, 823, 1024, 823, 10);
        Thread.sleep(1000);

        //OpenGPS();
        Click(newHorFive);
        Click(newPA);//单击PA
        mDevice.click(1354,247);

        Click("save_button"); //问题
        tipsNum++;

        String strType = "rb_condition_tips";
        GotoMyData(strType);

        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
        assertNotNull(Until.findObject(By.desc("PA")));

        ExitMyData();
    }
*/
    @Test
    public void test01212_tips_add_Click() throws Exception
    {
        //单击手动设置点位信息，新增匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"匝道");
    }

    @Test
    public void test01213_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增车信
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);//车信
        Page_MainBoard.Inst.Click(GetCenter());
        Page_CarInfo.Inst.Click(Page_CarInfo.D);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01214_tips_add_Click() throws Exception
    {
        //单击手动设置点位信息，新增交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TruckForbidden.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"禁止驶入");
    }

    @Test
    public void test01215_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增卡车交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.FORB_LEFT);
        Page_TrafficForbidden.Inst.Click(Page_TruckForbidden.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"卡车交限");
    }

    @Test
    public void test01216_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增方向看板
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);//方向看板
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"方向看板");
    }

    @Test
    public void test01217_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增Real Sign
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.REAL_SIGN);//单击Real Sign
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"Real Sign");
    }

    @Test
    public void test01218_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增3D模式图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_3D);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_3D.Inst.Click(Page_3D.ThreeD);//点击3D模式图
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"3D");
    }

    @Test
    public void test01219_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增提左提右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LEFT_OR_RIGHT);//单击提左提右
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.ClickByText("80000800");
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"提左提右");
    }

    @Test
    public void test01220_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增一般道路方面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GENERAL_ROAD_SIDE);//单击一般道路方面
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"一般道路方面");
    }

    @Test
    public void test01221_tips_add_Click() throws Exception {
        //单击手动设置点位信息，新增高速分歧
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_DIVIDER);//单击高速分歧
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"高速分歧");
    }

//    //test
//    @Test
//    public void test01222_tips_add_Click() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
//        //单击手动设置点位信息，新增GPS打点
//        //Page_MainBoard.Inst.Drag();
//        mDevice.drag(700, 823, 1024, 823, 10);
//        Thread.sleep(1000);
//
//        //OpenGPS();
//        Click(newGPSPos);//单击GPS打点
//        Click(GetCenter());
//
//        tipsNum++;
//
//        CheckMyData(Page_MyData.TIPS_TYPE,"GPS打点");
//    }//界面没GPS打点

    //所有双击功能目前是通过点击点位实现的
    @Test
    public void test01223_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增限速
        OpenGPS();
        Page_MainBoard.Inst.DoubleClick(newLimitSpeed);
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.POINTLIMIT);//点击点限速
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.MAXNUM);//最高限速值
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM40);//40
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.MINNUM);//最低限速值
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM30);//30
        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"点限速");
    }

    @Test
    public void test01224_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增红绿灯
        OpenGPS();
        Page_MainBoard.Inst.DoubleClick(newTrafficLight);
        //tipsNum++;
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE,"红绿灯");
    }

    @Test
    public void test01225_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增危险信息
        OpenGPS();
        Page_MainBoard.Inst.Click(newHorFour);
        Page_MainBoard.Inst.DoubleClick(newDangerInfo);//危险信息
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);//点击警示信息
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"危险信息");
    }

    @Test
    public void test01226_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增收费站
        OpenGPS();
        Page_MainBoard.Inst.Click(newHorFour);
        Page_MainBoard.Inst.DoubleClick(newTollStation);
        //mDevice.findObject(By.text("领卡")).click();
        Page_MainBoard.Inst.ClickByText("领卡");
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"收费站");
    }

    @Test
    public void test01227_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增电子眼
        OpenGPS();
        Page_MainBoard.Inst.Click(newHorFour);
        Page_MainBoard.Inst.DoubleClick(newEleEye);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"电子眼");
    }

    @Test
    public void test01228_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增卡车限制
        OpenGPS();
        Page_MainBoard.Inst.Click(newHorFour);
        Page_MainBoard.Inst.DoubleClick(newTruckLimit);//卡车限制
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.CAMERA);//拍摄按键ID
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//返回键ID
        Thread.sleep(3000);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"卡车限制");
    }

    @Test
    public void test01229_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增车道变化点
        //车道变化点
        OpenGPS();
        Page_MainBoard.Inst.DoubleClick(newCarRoadChangePos);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYLANENUM);//进入车道数
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);//2
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKLANENUM);//退出车道数
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);//1
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车道变化点");
    }

    @Test
    public void test01230_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增普通路口模式图
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftFour);//点击方向看板
        Page_MainBoard.Inst.DoubleClick(newNormalRoadEnterPic);//点击普通路口模式图
        Page_MainBoard.Inst.ClickByText("73100000");
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"普通路口模式图");
    }

//    @Test//有问题 自动化测试时双击无响应
//    protected void test01231_tips_add_DoubleClick() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
//        //设置点位信息，新增高速入口模式图
//        OpenGPS();
//        Page_MainBoard.Inst.Click(newLeftFour);//点击方向看板
//        Page_MainBoard.Inst.Click(newHighSpeedEnterPic);
//        Thread.sleep(2000);
//        //Page_MainBoard.Inst.Click(GetCenter());
//        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
//        //tipsNum++;
//
//        CheckMyData(Page_MyData.TIPS_TYPE,"高速入口模式图");
//    }
    /*
        //test

                        @Test
                        public void test01232_tips_add_DoubleClick() throws InterruptedException {
                            //设置点位信息，新增SA
                            mDevice.drag(700, 823, 1024, 823, 10);
                            Thread.sleep(1000);

                            //OpenGPS();
                            Click(newHorFive);
                            //DoubleClick(newSA);//SA
                            mDevice.click(newSA.x,newSA.y);
                            Thread.sleep(100);
                            mDevice.click(newSA.x,newSA.y);

                            Click("save_button");
                            tipsNum++;

                            String strType = "rb_condition_tips";
                            GotoMyData(strType);

                            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
                            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
                            assertNotNull(Until.findObject(By.desc("SA")));

                            ExitMyData();
                        }
            //test
                        @Test
                        public void test01233_tips_add_DoubleClick() throws InterruptedException {
                            //设置点位信息，新增PA
                            mDevice.drag(700, 823, 1024, 823, 10);
                            Thread.sleep(1000);

                            //OpenGPS();
                            Click(newHorFive);
                            //DoubleClick(newPA);//PA
                            mDevice.click(newPA.x,newPA.y);
                            Thread.sleep(100);
                            mDevice.click(newPA.x,newPA.y);

                            Click("save_button");
                            tipsNum++;

                            String strType = "rb_condition_tips";
                            GotoMyData(strType);
                            UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
                            assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
                            assertNotNull(Until.findObject(By.desc("PA")));

                            ExitMyData();
                        }
    */
    @Test
    public void test01234_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增匝道
        OpenGPS();
        Page_MainBoard.Inst.Click(newHorFive);
        Page_MainBoard.Inst.DoubleClick(newRingRoad);//匝道
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"匝道");
    }

    @Test
    public void test01235_tips_add_DoubleClick() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        //设置点位信息，新增车信
        OpenGPS();
        Page_MainBoard.Inst.Click(newCarInfo);
        Page_CarInfo.Inst.Click(Page_CarInfo.D);
        Page_CarInfo.Inst.Click(Page_CarInfo.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"车信");
    }

    @Test
    public void test01236_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增交限
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftThree);
        Page_MainBoard.Inst.DoubleClick(newTrafficLimit);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A1);
        Page_TrafficForbidden.Inst.Click(Page_TruckForbidden.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"交限");
    }

    @Test
    public void test01237_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增卡车交限
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftFive);
        Page_MainBoard.Inst.DoubleClick(newTruckTrafficLimit);//卡车交限
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_c1);
        Page_TrafficForbidden.Inst.Click(Page_TruckForbidden.SAVE);
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"卡车交限");
    }

    @Test
    public void test01238_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增方向看板
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftFour);
        Page_MainBoard.Inst.DoubleClick(newDirectShow);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"方向看板");
    }

    @Test
    public void test01239_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增Real Sign
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftFour);
        Page_MainBoard.Inst.DoubleClick(newRealSign);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"Real Sign");
    }

    @Test
    public void test01240_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增3D模式图
        OpenGPS();
        Click(newLeftFour);
        Page_MainBoard.Inst.DoubleClick(new3D);
        Page_3D.Inst.Click(Page_3D.ThreeD);//点击3D模式图
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"3D");
    }

    @Test
    public void test01241_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增提左提右
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftFour);
        Page_MainBoard.Inst.DoubleClick(newLeftRight);
        Page_MainBoard.Inst.ClickByText("80000800");//点击提左提右
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"提左提右");
    }

    @Test
    public void test01242_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增一般道路方面
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftFour);
        Page_MainBoard.Inst.DoubleClick(newNormalRoad);
        //Page_MainBoard.Inst.ClickByText("80000800");//一般道路方面
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"一般道路方面");
    }

    @Test
    public void test01243_tips_add_DoubleClick() throws Exception {
        //设置点位信息，新增高速分歧
        OpenGPS();
        Page_MainBoard.Inst.Click(newLeftFour);
        Page_MainBoard.Inst.DoubleClick(newHighSpeedDiff);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"高速分歧");
    }

    @Test
    public void test01244_tips_add_DoubleClick() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        //设置点位信息，新增GPS打点
        //无双击打点的功能  无网络的时候选点  有网的时候点击实现打点功能
        OpenGPS();
        //GPS打点
        Click(newGPSPos);
        Thread.sleep(3000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"GPS打点");
    }

    //test
    //////////删除Tips/////////////
/*
            @Test
            public void test01245_tips_delete_Click() throws InterruptedException {
                //设置点位信息，新增删除标记
                mDevice.drag(700, 823, 1024, 823, 10);
                Thread.sleep(1000);

                Click(newDelete,500);//删除标记，单击只删除一个
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

                //DoubleClick(newDelete);//删除标记，删除多个
                mDevice.click(newDelete.x,newDelete.y);
                Thread.sleep(100);
                mDevice.click(newDelete.x,newDelete.y);

                Click(new Point(279,516),3000);
                tipsNum++;
                Thread.sleep(300);
                Click(new Point(1087,213),3000);
                tipsNum++;
                Thread.sleep(300);
                Click(new Point(955,973),3000);
                tipsNum++;

                Thread.sleep(3000);
                Click(newDelete);

                String strType = "rb_condition_tips";
                GotoMyData(strType); //问题

                UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
                assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
                assertNotNull(Until.findObject(By.desc("形状删除")));

                ExitMyData();
            }

*/
    @Test
    public void test01401_diagram_add() throws Exception {
        //挂接
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);//草图
        Page_SketchHook.Inst.Click(Page_SketchHook.SKETCHHOOK1);//挂接1
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_SketchHook.Inst.Click(Page_SketchHook.ICON2082);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"挂接");
    }

    @Test
    public void test01402_diagram_add() throws Exception {
        //挂接
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);//草图
        Page_SketchHook.Inst.Click(Page_SketchHook.SKETCHHOOK2);//挂接2
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_SketchHook.Inst.Click(Page_SketchHook.ICON2113);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"挂接");
    }

    @Test
    public void test01403_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.STAIGHTLINE);//直线
        Page_MainBoard.Inst.Click(new Point(477,700));
        Page_MainBoard.Inst.Click(new Point(794,444));
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01404_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.CURVELINE);//曲线
        Page_SketchHook.Inst.DrawLine();
        Page_MainBoard.Inst.Click( Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01405_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.POLYLINE);//折线
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(new Point(400,500));
        Page_MainBoard.Inst.Click(new Point(400,600));
        Page_MainBoard.Inst.Click(new Point(600,400));
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01406_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.RECTLINE);//矩形
        Page_SketchHook.Inst.DrawLine();
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01407_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.ELLIPSELINE);//圆型
        Page_SketchHook.Inst.DrawLine();
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01408_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.CIRCULARPOINT);//圆点
        Page_MainBoard.Inst.Click(new Point(650,700));
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01409_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.GREENLANDLINE);//草地
        Page_MainBoard.Inst.Click(new Point(500,600));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(900,500));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(700,900));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(900,700));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01410_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.WATERLINE);//水系
        Page_MainBoard.Inst.Click(new Point(500,600));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(900,500));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(700,900));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(900,700));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01411_diagram_add() throws Exception {
        //草图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_SketchHook.Inst.Click(Page_SketchHook.RAILWAYLINE);//铁路
        Page_MainBoard.Inst.Click(new Point(900,500));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(700,900));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(900,700));
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test01501_search_data() throws Exception {
        //经纬度搜索 自动调整比例尺到21级，坐标显示在界面中心  重新登录后坐标点消失
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"162.99");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"3.44");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        testFastMapBase.setClassUp("collector1","123456");

    }

    @Test
    public void test01502_search_data() throws Exception {
        //经纬度搜索  新增多条搜索信息 保留后五次搜索记录 观察历史记录列表数及变化
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"53.44");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"22.99");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"-70");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"84");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"79");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"79.99");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"-50");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"70");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"-30");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"60");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);
    }

    @Test
    public void test01503_search_data() throws Exception {
        ////经纬度搜索  点击历史记录第二条 观察历史记录列表变化
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);

        UiScrollable noteList = new UiScrollable( new UiSelector().scrollable(true));  //would be null if the scrollable widget's not more than one page
        UiObject not = null;
        not = noteList.getChildByText(new UiSelector().className("android.widget.TextView"), "经度:-50.00000  纬度:70.00000", true);
        not.click();
        Thread.sleep(3000);
    }

    @Test
    public void test01504_search_data() throws Exception {
        //经纬度搜索  点击图标坐标点消失 添加poi
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"122.99");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"53.44");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.NAME_TYPE);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_LOW);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ");
    }

    @Test
    public void test01505_search_data() throws Exception {
        //经纬度搜索  点击图标坐标点消失 添加tips
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"53.44");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"72.99");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(GetCenter());
    }

    @Test
    public void test01506_search_data() throws Exception {
        //经纬度搜索  点击图标坐标点消失 添加点门牌
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Thread.sleep(3000);
        Page_MainBoard.Inst.ClickByText("经纬度");
        Thread.sleep(3000);
        Page_Search.Inst.SetValue(Page_Search.LONGITUDE,"122.99");//经度
        Page_Search.Inst.SetValue(Page_Search.LATITUDE,"53.44");//经度
        Page_Search.Inst.Click(Page_Search.SEARCH);//搜索
        Thread.sleep(3000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);//点门牌

        Page_PAS.Inst.SetValue(Page_PAS.NAME,"A");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS,"123");
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
    }

    @Test
    public void test01601_tips_copy() throws Exception {
        //复制电子眼
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_OVERSPEED);//非机动车
        Page_ElecEye.Inst.Scroll();//拖拽滚动条

        Page_ElecEye.Inst.ClickByText("1");
        Page_ElecEye.Inst.ClickByText("2");
        Page_ElecEye.Inst.ClickByText("0");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        //tipsNum++;

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MainBoard.Inst.ClickByText("电子眼");
        Page_ElecEye.Inst.Click(Page_ElecEye.CANCEL);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(new Point(300,360));
        //tipsNum++;
        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MyData.Inst.Click(Page_MyData.DATALIST);
        Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
        Page_MainBoard.Inst.Click(Page_MainBoard.CONFIRM);
        Thread.sleep(3000);
        //tipsNum--;

        Page_MyData.Inst.Click(Page_MyData.DATALIST);
        Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
        Page_MainBoard.Inst.Click(Page_MainBoard.CONFIRM);
        Thread.sleep(3000);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        //tipsNum--;
    }

    @Test
    public void test01602_tips_copy() throws Exception {
        //复制电子眼
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_NO_VECHICLE);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        //tipsNum++;

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        Page_MainBoard.Inst.ClickByText("电子眼");
        Page_ElecEye.Inst.Click(Page_ElecEye.CANCEL);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MainBoard.Inst.Click(new Point(300,360));
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");
    }
/*
    @Test
    public void test01603_tips_copy() throws Exception {
        //复制危险信息

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Click(GetCenter());
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        tipsNum++;

        //
       Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);
        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        objscoll.setMaxSearchSwipes(3);

        UiObject object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "危险信息");
        object.click();
        String temp = "";
        temp = Page_MyData.Inst.GetGlobalID();
        Page_Electronic_Eye.Inst.Click(Page_Electronic_Eye.CANCEL);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //SearchRoadFromLink();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
        Click(GetCenter());
        Click(new Point(300,360));
        tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "危险信息");
    }
*/
    @Test
    public void test01701_tips_add() throws Exception {
        SearchRoadFromLink("607979");
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_MilePost.Inst.SetValue(Page_MilePost.NUM,"E30");
        Page_MilePost.Inst.Click(Page_MilePost.ZERO);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
        //tipsNum++;

        SearchRoadFromLink("607979");
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MilePost.Inst.SetValue(Page_MilePost.NUM,"E30");
        Page_MilePost.Inst.Click(Page_MilePost.ADD);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
        //tipsNum++;

        SearchRoadFromLink("607979");
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MilePost.Inst.SetValue(Page_MilePost.NUM,"E30");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }

    @Test
    public void test01702_tips_add() throws Exception {
        //里程桩 关联rdlink 关联测线
        SearchRoadFromLink("606403");//小黄庄前街
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"道路");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
        Thread.sleep(2000);
        //tipsNum++;

        //Page_MainBoard.Inst.Click(newLeftFive);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);//手绘测线
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_MainBoard.Inst.Click(new Point(426,1185));
        Page_MainBoard.Inst.Click(new Point(1000,1185));
        Page_MainBoard.Inst.Click(Page_MainBoard.SAVE);
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MainBoard.Inst.Click(new Point(600,1185));
        Page_MilePost.Inst.SetValue(Page_MilePost.NUM,"S479");//此时道路名编号应为空
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"手绘道路");//此时道路名称号应为空
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
        //tipsNum++;

        //CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }

    @Test
    public void test01703_tips_add() throws Exception {
        //里程桩 关联两条rdlink 原规则
        SearchRoadFromLink("671765");//小黄庄北街
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        PutinEditor("et_milepost_number","");//此时道路名编号应为空
        PutinEditor("et_milepost_road_name","手绘道路");//此时道路名称号应为空
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
        Thread.sleep(2000);
        //tipsNum++;

        SearchRoadFromLink("732451");//北五环 S50
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2+30));
        //原规则，此时道路名编号自动赋值S50
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);//保存
        //tipsNum++;

        //CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }

    @Test
    public void test01704_tips_add() throws Exception {
        //里程桩 关联两条rdlink 新规则
        SearchRoadFromLink("12512162");//北五环 S50
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2, mDevice.getDisplayHeight()/2+30));
        //原规则，关联rdlink自动赋值rdlink上的编号S50,名称为手绘道路
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
        Thread.sleep(2000);
        //tipsNum++;

        SearchRoadFromLink("342330");//南五环 S50
        Page_MainBoard.Inst.Trigger(ADD_POINT_1700);//打点
        Thread.sleep(2000);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        //新规则，比对道路名编号S50，名称编号都继承
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);//保存
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }


    @Test
    public void test01705_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01706_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01707_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01708_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01709_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01710_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01711_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01712_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01713_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01714_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.PERSON);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01715_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01716_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01717_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01718_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.CAR);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01719_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.CAR);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01720_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.CAR);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01721_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TIMEPERSON);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.PERSON);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01722_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TIMEPERSON);
        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.PERSON);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

//    @Test
//    public void test01723_gate_add() throws Exception {
//        //大门 EG默认值车辆和行人 取消勾选时间清空
//        mDevice.drag(700, 823, 1024, 823, 10);
//        Thread.sleep(1000);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
//        Click(GetCenter());
//        Thread.sleep(2000);
//        Page_Gate.Inst.Click(Page_Gate.EG);
//        Page_Gate.Inst.Click(Page_Gate.TIMEPERSON);
//        Page_Time_Ctl.Inst.Click(Page_Time_Ctl.CONFIRM);
//        Page_Gate.Inst.Click(Page_Gate.PERSON);
//        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
//        Thread.sleep(2000);
//        tipsNum++;
//
//        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
//    }

    @Test
    public void test01724_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 勾选自行车切换至KG
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01725_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01726_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01727_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 勾选自行车切换至KG
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01728_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01729_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(GetCenter());
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }



    @Test
    public void test01801_tips_add() throws Exception {
        //道路名连线
        SearchRoadFromLink("663363");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"测试道路");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;
        SearchRoadFromLink("686517");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"测试道路");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;
        SearchRoadFromLink("591332");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"测试道路");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);//点击道路标牌连线
        //list显示
        //点击连线
        scrollClickObject("道路名连线");
        Page_MainBoard.Inst.ClickByText("连线");
        Thread.sleep(5000);
        Page_Road_Name.Inst.Click(Page_Road_Name.CANCEL);
        //tipsNum++;

    }

    @Test
    public void test01802_tips_add() throws Exception {
        //道路名连线
        SearchRoadFromLink("663363");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"测试道路");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;
        //list显示
        //点击连线
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        scrollClickObject("道路名连线");
        Page_MainBoard.Inst.ClickByText("连线");
        Thread.sleep(5000);
        Page_Road_Name.Inst.Click(Page_Road_Name.CANCEL);
        //tipsNum++;
    }

    @Test
    public void test01803_tips_add() throws Exception {
        //道路名连线
        SearchRoadFromLink("49044116");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"和平里东街");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        Thread.sleep(3000);
        //tipsNum++;

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);//点击道路标牌连线
        //list显示
        //点击连线
        scrollClickObject("道路名连线");
        Page_MainBoard.Inst.ClickByText("连线");
        Thread.sleep(5000);
        //点击复制
        Page_Road_Name.Inst.Click(Page_Road_Name.COPYTYPE);//复制形状
        Page_Road_Name.Inst.Click(Page_Road_Name.MOVE);
        Page_Road_Name.Inst.Click(Page_Road_Name.SAVE);
        //tipsNum++;
        Page_Road_Name.Inst.Click(Page_Road_Name.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    @Test
    public void test01804_tips_add() throws Exception {
        //道路名连线
        SearchRoadFromLink("663363");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"测试道路");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        SearchRoadFromLink("686517");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"测试道路");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        SearchRoadFromLink("591332");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_Road_Name_Sign.Inst.SetValue(Page_Road_Name_Sign.NAME,"测试道路");
        Page_Road_Name_Sign.Inst.Click(Page_Road_Name_Sign.SAVE);
        //tipsNum++;

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);//点击道路标牌连线
        //list显示
        //点击连线
        scrollClickObject("道路名连线");
        Page_MainBoard.Inst.ClickByText("连线");
        Thread.sleep(5000);
        Page_Road_Name.Inst.Click(Page_Road_Name.COPYTYPE);//复制形状
        Page_Road_Name.Inst.Click(Page_Road_Name.MOVE);
        Page_Road_Name.Inst.Click(Page_Road_Name.SAVE);
        //tipsNum++;
        Page_Road_Name.Inst.Click(Page_Road_Name.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }
/*
    @Test
    public void test01805_tips_add() throws Exception {
        //道路名连线
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);//点击道路标牌连线
        //list显示
        //点击连线
        scrollClickObject("道路名连线");

        Page_Road_Name.Inst.Click(Page_Road_Name.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }
*/
    protected void waitObjectEnable(String strObject) throws  InterruptedException{
        int waitCount =0;
        UiObject2 btnBack2 =  mDevice.findObject(By.res(packageName, "iv_search_result_list_back"));
        while (true)
        {
            btnBack2 = mDevice.findObject(By.res(packageName, "iv_search_result_list_back"));
            if (waitCount == 180)
            {
                fail("控件获取超时！");
            }
            if(btnBack2 != null && btnBack2.isEnabled())
            {
                break;
            }
            waitCount++;
            Thread.sleep(1000);
        }

        btnBack2.click();
    }
    private void scrollClickObject(String targetName) throws UiObjectNotFoundException {
        UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
        if(listScrollable.exists()) {
            listScrollable.scrollDescriptionIntoView(targetName);
            mDevice.findObject(By.text(targetName)).click();
        } else {
            mDevice.findObject(By.text(targetName)).click();
        }

    }


    private void scrollBackwardClickObject(String targetName) throws UiObjectNotFoundException {
        UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
        if(listScrollable.exists()) {
            //方法一
            //UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
            //listScrollable.flingForward(); //向后滚动
            //listScrollable.setMaxSearchSwipes(10);
            //listScrollable.scrollTextIntoView(targetName);

            listScrollable.flingToEnd(4);

            listScrollable.flingBackward(); //向后滚动
            //listScrollable.scrollToEnd(5);

        } else {
            mDevice.findObject(By.text(targetName)).click();
        }

    }
    private void SearchRoadFromLink(String  strRoad) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);

        Page_Search.Inst.Click(Page_Search.TYPE_LINK);
        Page_Search.Inst.Click(Page_Search.LINKSEARCH);
        Page_Search.Inst.Click(Page_Search.EXACT_FIND);
        Page_Search.Inst.SetValue(Page_Search.EDITLINK, strRoad);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_LINK);

        Page_SearchResultList.Inst.Click(Page_SearchResultList.SEARCH_LIST);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);
    }

    private  void OpenGPS() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        //打开WIFI
        //Click("iv_map_gps_status");
        Page_MainBoard.Inst.Click(Page_MainBoard.WIFI);
        //Click("location_pop_check_location");
        Page_MainBoard.Inst.Click(Page_MainBoard.LOCATION);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Click(GetCenter());
    }

    private  void SetConfInfo() throws InterruptedException, NoSuchFieldException, ClassNotFoundException, UiObjectNotFoundException {
        //产品全貌开关设置
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        //Click("head_icon");
        //mDevice.drag(292,1270,292,620,10);
        //mDevice.drag(292,1270,292,620,10);
        Page_MainBoard.Inst.Drag();
        Thread.sleep(300);
        //scrollClickObject("设置"); //滚动条滚动，点击设置
        Page_MainMenu.Inst.Click(Page_MainMenu.SET);
        //Click("fmcard_tv_user_settings");
        //Click("checkBox_camera_fullView");//设置产品全貌开关
        Page_Set.Inst.Click(Page_Set.FULLVIEW);

        Page_Set.Inst.Click(Page_Set.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    private  void SyncInfo() throws UiObjectNotFoundException, InterruptedException, NoSuchFieldException, ClassNotFoundException {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(GetCenter());
        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
        //Click("grid_project_button");
        Page_GridManager.Inst.Click(Page_GridManager.INFO_UPDATE);
        //Click("rb_info_update");
        //Page_GridManager.Inst.Click(GetCenter());

        Page_GridManager.Inst.Click(Page_GridManager.SYNCHRONOUS_BUTTON);
        //Click("synchronous_button");
        Page_GridManager.Inst.Click(Page_GridManager.CONFIRM);
        //Click("btn_fm_confirm");
        Thread.sleep(2000);
        Page_GridManager.Inst.Click(Page_GridManager.CONFIRM);
        //Page_GridManager.Inst.waitObjectEnable(Page_GridManager.CONFIRM);
        //Click("btn_fm_confirm",5000);
        Thread.sleep(5000);
        CheckSyncInfoResult();

        //Click("grid_sync_btn_positive",5000);
        Page_GridManager.Inst.Click(Page_GridManager.BACK);
        //Click("back");
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        //Click("fmcard_ibtn_back");
    }

    private static Point newRoadNameSign = new Point(369, 1237);
    private static Point newCopy = new Point(605,1445);//复制Tip
    private static Point newLimitSpeed = new Point(976,1442);//限速Tip
    private static Point newDangerInfo = new Point(729,1021);//危险信息
    private static Point newCarInfo = new Point(1969,1138);//车信
    private static Point newTollStation = new Point(583,1156);//收费站
    private static Point newEleEye = new Point(723,1153);//电子眼
    private static Point newTruckLimit = new Point(846,1144);//卡车限制
    private static Point newCarRoadChangePos= new Point(479,1445);//车道变化点
    private static Point newNormalRoadEnterPic = new Point(360,998);//普通路口模式图
    private static Point newHighSpeedEnterPic = new Point(486,993);//高速入口模式图
    private static Point newSA = new Point(711,1140);//单击SA
    private static Point newPA= new Point(844,1151);//PA
    private static Point newRingRoad = new Point(836,1136);//匝道
    private static Point newTrafficLimit = new Point(487,1040);//交限
    private static Point newTruckTrafficLimit = new Point(363,882);//卡车交限
    private static Point newDirectShow = new Point(222,736);//方向看板
    private static Point newRealSign = new Point(355,745);//Real Sign
    private static Point newLeftRight = new Point(222,864);//提左提右
    private static Point newNormalRoad = new Point(351,869);//一般道路方面
    private static Point newHighSpeedDiff = new Point(232,986);//高速分歧
    private static Point newDoor = new Point(597,1018);//高速分歧
    private static Point newGPSPos = new Point(1318,1448);//GPS打点
    private static Point new3D = new Point(487,743);//3D
    private static Point newDelete = new Point(1084,1442);//删除
    private static Point newHorFour = new Point(726,1456);//水平方向第四个
    private static Point newLeftFour = new Point(101,1153);//左侧方向第四个
    private static Point newHorFive = new Point(853,1419);//水平第五个
    private static Point newLeftFive = new Point(94,1263);//水平第五个
    private static Point newLeftThree = new Point(85,1036);//左侧第三个
    //private static Point newCarRoadChange = new Point(483,1432); //车道变化点
    private static Point newdiagram = new Point(1985,1029);//草图
    private static Point newPosDoor= new Point(1972,1281);//点门牌

    int testflag;
    int testflag_fs;
    private static Point test = new Point(0,0);

   
}
