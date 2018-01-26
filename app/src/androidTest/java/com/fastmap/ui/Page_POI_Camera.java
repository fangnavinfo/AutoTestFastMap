package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */
public class Page_POI_Camera extends FastMapPage
{
    @FindResource(Id="take_pic_imgbtn")
    public static String TAKE_PIC;

    @FindResource(Id="task_pic_back_img")
    public static String BACK;

    @FindResource(Id="mingcheng_btn")
    public static String NAME_TYPE;

    @FindResource(Id="radio_revolution1")
    public static String RADIO_LOW; //低分辨率

    @FindResource(Id="shuipai_btn")
    public static String SHUIPAI_TYPE;

    @FindResource(Id="radio_revolution1")
    public static String RADIO_MID;

    public static Page_POI_Camera Inst;
    static
    {
        Inst = new Page_POI_Camera();
    }
}
