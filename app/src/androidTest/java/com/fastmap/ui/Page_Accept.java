package com.fastmap.ui;

/**
 * Created by h on 2018/1/31.
 */

public class Page_Accept extends FastMapPage {
    @FindResource(Id = "other_button",Text = "部分采纳")
    public static String ACCEPT;


    public static  Page_Accept Inst;
    static{
        Inst = new Page_Accept();
    }
}
