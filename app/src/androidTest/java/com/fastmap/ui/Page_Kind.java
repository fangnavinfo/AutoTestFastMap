package com.fastmap.ui;

/**
 * Created by h on 2018/3/14.
 */

public class Page_Kind extends FastMapPage {
    @FindResource(Id="camera_button_myselt")
    public static String CAMERA_MYSELT;

    @FindResource(Id="card_high_speed")
    public static String K1;

    @FindResource(Id="save_button")
    public static String SAVE;
    public static Page_Kind Inst;
    static
    {
        Inst = new Page_Kind();
    }
}
