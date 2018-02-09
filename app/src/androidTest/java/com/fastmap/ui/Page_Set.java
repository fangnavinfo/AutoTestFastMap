package com.fastmap.ui;

/**
 * Created by h on 2018/2/6.
 */

public class Page_Set extends FastMapPage {
    @FindResource(Id = "btn_back")
    public static String BACK;

    @FindResource(Id = "checkBox_camera_fullView")
    public static String FULLVIEW;

    public static Page_Set Inst;
    static {
        Inst = new Page_Set();
    }
}
