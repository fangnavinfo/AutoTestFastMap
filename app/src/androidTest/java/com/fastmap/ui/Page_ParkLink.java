package com.fastmap.ui;

/**
 * Created by zhou on 18/1/19.
 * 停车场出入口
 */

public class Page_ParkLink extends FastMapPage
{

    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;


    @FindResource(Id="btn_park_on", Text="地面大型")
    public static String PARK_ON;
    @FindResource(Id="btn_park_down", Text="地下或地面小型")
    public static String PARK_DOWN;

    public static Page_ParkLink Inst;
    static
    {
        Inst = new Page_ParkLink();
    }
}
