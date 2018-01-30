package com.fastmap.ui;

/**
 * Created by zhou on 18/1/19.
 * 匝道
 */

public class Page_Ramp extends FastMapPage
{

    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;


    @FindResource(Id="btn_ramp", Text="匝道")
    public static String RAMP;
    @FindResource(Id="btn_not_ramp", Text="非匝道")
    public static String NOT_RAMP;

    public static Page_Ramp Inst;
    static
    {
        Inst = new Page_Ramp();
    }
}
