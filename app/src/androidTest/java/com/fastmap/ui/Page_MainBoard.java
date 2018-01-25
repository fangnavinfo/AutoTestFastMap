package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MainBoard extends FastMapPage
{
    @FindResource(Id="head_icon")
    public static String MAIN_MENU;

    @FindResource(Id="btn_indoor_data_check_open")
    public static String QC_TASK;

    @FindResource(Id="btn_infor_report")
    public static String REPORT;

    @FindResource(Id="info_pop_add_point")
    public static String POINT_INFO;

    @FindResource(Id="info_pop_add_line")
    public static String LINE_INFO;

    @FindResource(Id="info_pop_add_frame")
    public static String FRAME_INFO;

    public static Page_MainBoard Inst;
    static
    {
        Inst = new Page_MainBoard();
    }

    public void Trigger(String tips) throws Exception
    {
        FastMapUI.pressBtnMainBoard(tips);
    }
}