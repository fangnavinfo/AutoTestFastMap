package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * GRID管理
 */
public class Page_GridManager extends FastMapPage
{
    @FindResource(Id="rb_poi_update")
    public static String POI_UPDATE;
    @FindResource(Id="rb_tips_update")
    public static String TIPS_UPDATE;
    @FindResource(Id="rb_integrate_update")
    public static String INTEGRATE_UPDATE;
    @FindResource(Id="rb_info_update")
    public static String INFO_UPDATE;
    @FindResource(Id="synchronous_button")
    public static String SYNCHRONOUS_BUTTON;

    @FindResource(Id="grid_project_button")
    public static String PROJECT_BUTTON;


    @FindResource(Id="back")
    public static String BACK;
    @FindResource(Id="btn_fm_confirm")
    public static String CONFIRM;
    @FindResource(Id="btn_fm_cancel")
    public static String CANCEL;
    @FindResource(Id="grid_sync_btn_positive")
    public static String GRID_SYNC_BTN_POSITIVE;

    public static Page_GridManager Inst;
    static
    {
        Inst = new Page_GridManager();
    }
}