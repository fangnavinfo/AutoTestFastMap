package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 红绿灯
 */

public class Page_Light extends FastMapPage
{
    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;
    @FindResource(Id="et_title")
    public static String ROWKEY;


    @FindResource(Id="camera_button")
    public static String CAMERA_BUTTON;

    public static Page_Light Inst;
    static
    {
        Inst = new Page_Light();
    }

}
