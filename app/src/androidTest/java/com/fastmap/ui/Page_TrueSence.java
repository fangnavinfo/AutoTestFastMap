package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 实景图TIPS
 */
public class Page_TrueSence extends FastMapPage
{
    @FindResource(Id="et_title")
    public static String ROWKEY;
    @FindResource(Id="common_load")
    public static String COMMON_LOAD;
    @FindResource(Id="highway_load_out")
    public static String HIGHWAY_LOAD_OUT;
    @FindResource(Id="highway_load_in")
    public static String HIGHWAY_LOAD_IN;
    @FindResource(Id="et_img_number")
    public static String ET_IMG_NUMBER;
    @FindResource(Id="camera_button")
    public static String CAMERA_BUTTON;

    @FindResource(Id="cancel_button")
    public static String CANCEL;
    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_TrueSence Inst;
    static
    {
        Inst = new Page_TrueSence();
    }
}