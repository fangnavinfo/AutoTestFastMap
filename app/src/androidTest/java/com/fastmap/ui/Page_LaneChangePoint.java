package com.fastmap.ui;

/**
 * Created by h on 2018/2/25.
 */

public class Page_LaneChangePoint extends FastMapPage{
    @FindResource(Id="et_entry_lane_num")
    public static String ENTRYLANENUM;

    @FindResource(Id="et_back_lane_num")
    public static String BACKLANENUM;

    @FindResource(Id="lane_number_tow")
    public static String NUM2;

    @FindResource(Id="lane_number_one")
    public static String NUM1;

    @FindResource(Id="save_button")
    public static String SAVE;
    public static Page_LaneChangePoint Inst;
    static
    {
        Inst = new Page_LaneChangePoint();
    }
}
