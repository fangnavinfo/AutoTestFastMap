package com.fastmap.ui;

/**
 * Created by h on 2018/3/14.
 */

public class Page_TestLine extends FastMapPage{
    @FindResource(Id="card_high_speed")
    public static String K1;

    @FindResource(Id="card_people_crossing")
    public static String K11;
    @FindResource(Id="save_button")
    public static String SAVE;

    @FindResource(Id="lane_num_2")
    public static String NUM2;
    public static Page_TestLine Inst;
    static
    {
        Inst = new Page_TestLine();
    }
}
