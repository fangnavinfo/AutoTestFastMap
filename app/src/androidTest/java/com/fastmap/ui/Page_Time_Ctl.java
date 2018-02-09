package com.fastmap.ui;

/**
 * Created by h on 2018/1/30.
 */

public class Page_Time_Ctl extends FastMapPage {
    @FindResource(Id = "btn_fm_confirm",Text = "确定")
    public static String CONFIRM;

    @FindResource(Id = "btn_fm_cancel",Text = "取消")
    public static String CANCEL;

    public static Page_Time_Ctl Inst;
    static{
        Inst = new Page_Time_Ctl();
    }
}
