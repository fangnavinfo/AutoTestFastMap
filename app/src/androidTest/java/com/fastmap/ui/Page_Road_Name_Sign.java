package com.fastmap.ui;

import android.support.test.uiautomator.By;

import static com.fastmap.ui.Page_POI.SEARCH_TYPE;
import static com.fastmap.ui.Page_POI.SEARCH_TYPE_RESULT;
import static com.fastmap.ui.Page_POI.SELECT_TYPE;

/**
 * Created by h on 2018/1/29.
 */

public class Page_Road_Name_Sign extends FastMapPage{
    @FindResource(Id="card_road_name_sign_name_edit")
    public static String NAME;

    @FindResource(Id="save_button")
    public static String SAVE;

    @FindResource(Id="cancel_button")
    public static String CANCEL;

    @FindResource(Id="card_road_name_sign_radio_yes")
    public static String RADIOPOS;

    @FindResource(Id="camera_button")
    public static String CAMERA;

    @FindResource(Id="ck_move_point",Text = "显示点位")
    public static String MOVEPOINT;

    @FindResource(Id="ck_move_line",Text = "引导点位")
    public static String MOVELINE;

    @FindResource(Id="ck_move_point_or_line",Text = "显示/引导点位")
    public static String MOVEPOINTLINE;

    @FindResource(Id="delete_button")
    public static String DELETE;

    @FindResource(Id="btn_fm_confirm")
    public static String CONFIRM;

    public static Page_Road_Name_Sign Inst;
    static
    {
        Inst = new Page_Road_Name_Sign();
    }

    public void SetValue(String findRes, String value) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        if (findRes.equals(SELECT_TYPE))
        {
            Click(SELECT_TYPE);
            SetValue(SEARCH_TYPE, value);
            Click(SEARCH_TYPE_RESULT);
            return;
        }

        super.SetValue(findRes, value);
    }
    public void ClickObject(String tarObject)
    {
        mDevice.findObject(By.text(tarObject)).click();
    }
}
