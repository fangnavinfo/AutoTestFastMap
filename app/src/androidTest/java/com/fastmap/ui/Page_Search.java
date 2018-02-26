package com.fastmap.ui;

import android.support.test.uiautomator.By;

/**
 * Created by h on 2018/1/30.
 * 搜索
 */

public class Page_Search extends FastMapPage
{
    @FindResource(Text = "Link")
    public static String TYPE_LINK;

    @FindResource(Id = "edt_search_link_input")
    public static String EDITLINK;

    @FindResource(Id = "tv_search_link_btn")
    public static String SEARCH_START_LINK;

    @FindResource(Id = "tv_search_link_btn")
    public static String LINKSEARCH;

    @FindResource(Id = "edt_search_info_input")
    public static String EDITINFO;

    @FindResource(Id = "tv_search_info_btn")
    public static String INFOSEARCH;

    @FindResource(Id = "edt_search_location_longitude")
    public static String LONGITUDE;

    @FindResource(Id = "edt_search_location_latitude")
    public static String LATITUDE;

    @FindResource(Id = "tv_search_location_btn")
    public static String SEARCH;

    @FindResource(Text = "精确匹配")
    public static String EXACT_FIND;

    public static Page_Search Inst;
    static{
        Inst = new Page_Search();
    }

    public void ClickTips(String tips) throws Exception
    {
        mDevice.findObject(By.text(tips)).click();
    }
}
