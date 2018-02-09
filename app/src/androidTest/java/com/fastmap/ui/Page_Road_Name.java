package com.fastmap.ui;

/**
 * Created by h on 2018/1/30.
 */

public class Page_Road_Name extends FastMapPage {
    @FindResource(Id = "save_button",Text = "保存")
    public static String SAVE;

    @FindResource(Id = "cancel_button",Text = "取消")
    public static String CANCEL;

    @FindResource(Id = "et_road_name",Text = "请输入道路名")
    public static String NAME;

    @FindResource(Id = "radio_button_hand",Text = "手绘")
    public static String DRAWTYPE;

    @FindResource(Id = "btn_copy_point",Text = "复制形状")
    public static String COPYTYPE;

    @FindResource(Id = "btn_clear_last_testLine",Text = "上一步")
    public static String PRE;

    @FindResource(Id = "btn_clear_all_testLine",Text = "重绘")
    public static String CLEAR;

    @FindResource(Id = "btn_choose_start_point",Text = "选择起点")
    public static String START;

    @FindResource(Id = "btn_choose_end_point",Text = "选择终点")
    public static String END;

    @FindResource(Id = "btn_copy_point",Text = "复制形状")
    public static String COPY;

    @FindResource(Id = "change_start_end",Text = "交换起终点")
    public static String CHANGE;

    @FindResource(Id = "move_start_end",Text = "移动道路名")
    public static String MOVE;

    @FindResource(Id = "iv_road_name_back")
    public static String BACK;
    public static  Page_Road_Name Inst;
    static {
        Inst = new Page_Road_Name();
    }
}
