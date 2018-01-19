package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import com.fastmap.ui.FastMapUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapZF_hm extends testFastMapBase
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

        this.setClassUp("zhanglingling03655", "036550", true);
    }

    @After
    public  void setAfter() throws IOException, InterruptedException {

        super.setAfter();
    }

    // POI 分类品牌表增加港澳标识
    @Test
    public void test00101_poi_hm_brand_check() throws Exception {

        //点击新增POI
        FastMapUI.pressBtnMainBoard(TipsDeepDictionary.POI_ADD_9001);
        Thread.sleep(500);

        Click("take_pic_imgbtn"); //点击拍照
        Click("task_pic_back_img"); //点击返回

        PutinEditor("fm_et_name", "测试ＰＯＩ"); //输入POI名称

        Click("tv_assort_type",1000);//点击选择分类

        PutinEditor("et_kind_search", "140201");
        Click("top_name_txtinfo",2000);
        Click("tv_poi_brand",500);

        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        objscoll.scrollForward();

        mDevice.wait(Until.findObject(By.text("丰田维修")), 500).click();

        Click("save_button"); //点击保存
        poiNum++;

        Thread.sleep(3000);

        GotoMyData("rb_condition_poi"); //进入我的数据

        UiObject2 Object = mDevice.wait(Until.findObject(By.text("测试ＰＯＩ")), 500);
        Object.click();

        //判断新增数据数量与poiNum是否相等
        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
        UiObject2 txtTelephoneNo  = mDevice.wait(Until.findObject(By.res(packageName, "edt_contactItem_telNum")), 500);

        if(null != txtAddCount)
        {
            assertEquals(Integer.toString(poiNum), txtAddCount.getText());
            assertNotNull(Until.findObject(By.desc("测试ＰＯＩ"))); //检查是否有"测试ＰＯＩ"对象
        }
        else
        {
            fail("Save POI failed");
        }

        Click("save_button"); //点击保存
        ExitMyData(); //退出我的数据
    }

    private static String globalId = "";
    private static String infoFid = "0010071128WT200493";
    private static String infoRowkey = "";
}
