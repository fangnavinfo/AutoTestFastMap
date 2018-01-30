package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */

public class Page_LaneInfo extends FastMapPage
{


    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;
    @FindResource(Id="tv_poi_fid_hd")
    public static String FID;

    @FindResource(Id="et_kind_search", Text="请输入搜索内容")
    public static String SEARCH_TYPE;

    @FindResource(Id="top_name_txtinfo")
    public static String SEARCH_TYPE_RESULT;

    @FindResource(Id="edt_contactItem_telNum")
    public static String TEL;

    @FindResource(Id="camera_button")
    public static String CAMERA;

    //单车道
    @FindResource(Id="rb_select_one_d")
    public static String ONE_D;
    @FindResource(Id="rb_select_one_b")
    public static String ONE_B;
    @FindResource(Id="rb_select_one_a")
    public static String ONE_A;
    @FindResource(Id="rb_select_one_c")
    public static String ONE_C;

    //三车道
    @FindResource(Id="rb_select_one_b_a_c")
    public static String ONE_B_A_C;
    @FindResource(Id="rb_select_one_g_a_f")
    public static String ONE_G_A_F;

    public static Page_LaneInfo Inst;
    static
    {
        Inst = new Page_LaneInfo();
    }
}
