package com.fastmap.ui;

/**
 * Created by fang on 18/1/22.
 */
public class Page_PAS extends FastMapPage
{
    @FindResource(Id="fm_et_name_pas")
    public static String NAME;

    @FindResource(Id="fm_et_address_pas")
    public static String ADDRESS;

    @FindResource(Id="ck_odd")
    public static String ODD; //奇

    @FindResource(Id="ck_road")
    public static String ROAD_TYPE;

    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_PAS Inst;
    static
    {
        Inst = new Page_PAS();
    }
}
