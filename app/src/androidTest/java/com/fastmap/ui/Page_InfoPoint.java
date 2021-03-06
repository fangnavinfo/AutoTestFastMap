package com.fastmap.ui;

/**
 * Created by fang on 18/1/22.
 */
public class Page_InfoPoint extends FastMapPage
{
    @FindResource(Id="edt_infor_report_name")
    public static String NAME;

    @FindResource(Id="infor_report_type_road")
    public static String REPORT_TYPE_ROAD;

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

    @FindResource(Id="cancel_button")
    public static String CANCEL;

    public static Page_InfoPoint Inst;
    static
    {
        Inst = new Page_InfoPoint();
    }

}