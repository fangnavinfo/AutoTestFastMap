package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MainBoard extends FastMapPage
{
    @FindResource(Id="back")
    public static String BACK;
    @FindResource(Id="head_icon")
    public static String MAIN_MENU;
    @FindResource(Id="btn_infor_report")
    public static String INFO_REPORT;
    @FindResource(Id="info_pop_add_point")
    public static String INFO_REPORT_POINT;
    @FindResource(Id="info_pop_add_line")
    public static String INFO_REPORT_LINE;
    @FindResource(Id="info_pop_add_frame")
    public static String INFO_REPORT_FRAME;
    @FindResource(Id="img_search")
    public static String SEARCH;
    @FindResource(Text="Tips")
    public static String SEARCH_TIPS;
    @FindResource(Id="edt_search_tips_input")
    public static String SEARCH_TIPS_INPUT;
    @FindResource(Id="tv_search_tips_btn")
    public static String SEARCH_TIPS_BTN;
    @FindResource(Text="POI")
    public static String SEARCH_POI;
    @FindResource(Id="edt_search_poi_input")
    public static String SEARCH_POI_INPUT;
    @FindResource(Id="tv_search_poi_btn")
    public static String SEARCH_POI_BTN;
    @FindResource(Text="点门牌")
    public static String SEARCH_PAS;
    @FindResource(Id="edt_search_pas_input")
    public static String SEARCH_PAS_INPUT;
    @FindResource(Id="tv_search_pas_btn")
    public static String SEARCH_PAS_BTN;
    @FindResource(Text="情报")
    public static String SEARCH_INFO;
    @FindResource(Id="edt_search_info_input")
    public static String SEARCH_INFO_INPUT;
    @FindResource(Id="tv_search_info_btn")
    public static String SEARCH_INFO_BTN;
    @FindResource(Text="Link")
    public static String SEARCH_LINK;
    @FindResource(Id="edt_search_link_input")
    public static String SEARCH_LINK_INPUT;
    @FindResource(Id="tv_search_link_btn")
    public static String SEARCH_LINK_BTN;


    @FindResource(Id="iv_zoom_out")
    public static String ZOOM_OUT;
    @FindResource(Id="iv_zoom_in")
    public static String ZOOM_IN;

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

    @FindResource(Id="card_speed_limit_type_driveway")
    public static String ROAD_SPEED_LIMIT;

    @FindResource(Id="save_button")
    public static String SAVE;
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