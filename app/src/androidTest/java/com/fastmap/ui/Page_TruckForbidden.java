package com.fastmap.ui;

/**
 * Created by fang on 18/1/22.
 */
public class Page_TruckForbidden extends FastMapPage
{
    @FindResource(Id="traffic_forbidden_icon_c2")
    public static String FORB_LEFT;//禁止左转

    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_TruckForbidden Inst;
    static
    {
        Inst = new Page_TruckForbidden();
    }
}
