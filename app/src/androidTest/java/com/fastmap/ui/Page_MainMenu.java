package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MainMenu extends FastMapPage
{
    @FindResource(Id="fmcard_tv_user_data")
    public static String MY_DATA; //我的数据

    @FindResource(Id="fmcard_tv_sync_photos")
    public static String INDOOR_TOOLS; //室内整理工具

    @FindResource(Id="fmcard_ibtn_back")
    public static String BACK;

    public static Page_MainMenu Inst;
    static
    {
        Inst = new Page_MainMenu();
    }
}
