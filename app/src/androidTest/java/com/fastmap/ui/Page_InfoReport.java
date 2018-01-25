package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 情报上报
 */

public class Page_InfoReport extends FastMapPage
{
    @FindResource(Id="cancel_button")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;
    @FindResource(Id="et_title")
    public static String GLOBAL_ID;

    @FindResource(Id="edt_infor_report_name")
    public static String REPORT_NAME;

    @FindResource(Id="infor_report_type_poi")
    public static String REPORT_TYPE_POI;

    @FindResource(Id="infor_report_type_road")
    public static String REPORT_TYPE_ROAD;

    @FindResource(Id="infor_report_level_1")
    public static String REPORT_LEVEL_1;

    @FindResource(Id="infor_report_level_2")
    public static String REPORT_LEVEL_2;

    @FindResource(Id="infor_report_level_3")
    public static String REPORT_LEVEL_3;

    @FindResource(Id="infor_report_proposal_add")
    public static String REPORT_ADD;

    @FindResource(Id="infor_report_proposal_edit")
    public static String REPORT_EDIT;

    @FindResource(Id="infor_report_proposal_delete")
    public static String REPORT_DELETE;

    @FindResource(Id="infor_report_opened_not")
    public static String REPORT_OPENED_NOT;

    @FindResource(Id="infor_report_opened_yes")
    public static String REPORT_OPENED_YES;

    @FindResource(Id="tv_poiReport_time", Text="点击选择时间")
    public static String CHOOSE_TIME;

    @FindResource(Id="camera_button")
    public static String CAMERA_BUTTON;

    public static Page_InfoReport Inst;
    static
    {
        Inst = new Page_InfoReport();
    }

}
