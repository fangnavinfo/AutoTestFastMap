package com.fastmap.ui;

/**
 * Created by h on 2018/1/23.
 */

public class Page_RoundAbout extends FastMapPage {
    @FindResource(Id="card_intra_regional_road",Text = "区域内道路")
    public static String REGION_ROAD;//范围线

    @FindResource(Id="card_add_att",Text = "增属性")
    public static String ADD;//增属性

    @FindResource(Id="card_del_att",Text = "删属性")
    public static String DELETE;//删属性

    @FindResource(Id="save_button",Text = "保存")
    public static String SAVE;//保存

    public static Page_RoundAbout Inst;
    static
    {
        Inst = new Page_RoundAbout();
    }
}
