package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 * 测线
 */
public class Page_SurveyLine extends FastMapPage
{
    @FindResource(Id="card_high_speed")
    public static String HIGH_SPEED;

    @FindResource(Id="card_city_high_speed")
    public static String CITY_HIGH_SPEED;

    @FindResource(Id="card_national_rd")
    public static String NATIONAL_RD;

    @FindResource(Id="card_provincial_rd")
    public static String PROVINCIAL_RD; //省道

    @FindResource(Id="card_pedestrian_rd")
    public static String PEDESTRIAN_RD;  //行人道路

    @FindResource(Id="card_people_crossing")
    public static String PEOPLE_CROSS_RD; //人渡

    @FindResource(Id="card_ferry")
    public static String FERRY_RD; //轮渡

    @FindResource(Id="lane_num_1")
    public static String LANE_NUM_1; //1车道

    @FindResource(Id="lane_num_2")
    public static String LANE_NUM_2;

    @FindResource(Id="delete_button")
    public static String DELETE;
    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_SurveyLine Inst;
    static
    {
        Inst = new Page_SurveyLine();
    }
}