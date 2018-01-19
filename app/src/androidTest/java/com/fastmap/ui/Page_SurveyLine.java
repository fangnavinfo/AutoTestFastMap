package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */
public class Page_SurveyLine extends FastMapPage
{
    @FindResource(Id="card_high_speed")
    public static String HIGH_SPEED;

    @FindResource(Id="lane_num_1")
    public static String LANE_NUM_1;

    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_SurveyLine Inst;
    static
    {
        Inst = new Page_SurveyLine();
    }
}