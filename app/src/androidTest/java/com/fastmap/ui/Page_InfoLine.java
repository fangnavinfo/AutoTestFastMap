package com.fastmap.ui;

/**
 * Created by fang on 18/1/22.
 */
public class Page_InfoLine extends FastMapPage
{
    @FindResource(Id="draw_line_over")
    public static String DRAW_FINISH;

    @FindResource(Id="edt_infor_report_name")
    public static String NAME;

    @FindResource(Id="infor_report_type_poi")
    public static String POI_TYPE;

    @FindResource(Id="tv_poiReport_time")
    public static String TIME;

    @FindResource(Id="btn_fm_confirm")
    public static String TIME_CONFIRM;

    @FindResource(Id="camera_button")
    public static String CAMERA;

    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_InfoLine Inst;
    static
    {
        Inst = new Page_InfoLine();
    }
}
