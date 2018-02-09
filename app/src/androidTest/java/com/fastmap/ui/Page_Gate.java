package com.fastmap.ui;

/**
 * Created by h on 2018/1/29.
 */

public class Page_Gate extends FastMapPage {
    @FindResource(Id = "gate_type_eg")
    public static String EG;

    @FindResource(Id = "gate_type_kg")
    public static String KG;

    @FindResource(Id = "gate_type_pg")
    public static String PG;


    @FindResource(Id = "traffic_object_car_ckb",Text = "车    辆")
    public static String CAR;

    @FindResource(Id = "traffic_object_car_img")
    public static String TIMECAR;

    @FindResource(Id = "traffic_object_person_ckb",Text = "行    人")
    public static String PERSON;

    @FindResource(Id = "traffic_object_person_img")
    public static String TIMEPERSON;

    @FindResource(Id = "traffic_object_bicycle_ckb",Text = "自行车")
    public static String BICYCLE;

    @FindResource(Id = "traffic_object_bicycle_img")
    public static String TIMEBICYCLE;

    @FindResource(Id = "traffic_object_tricycle_ckb",Text = "三轮车")
    public static String TRICYCLE;

    @FindResource(Id = "traffic_object_tricycle_img")
    public static String TIMETRICYCLE;

    @FindResource(Id = "checkBox_single_dir_gate")
    public static String SINGLEGATE;

    @FindResource(Id = "save_button")
    public static String SAVE;

    @FindResource(Id = "card_road_direction_swap",Text = "调整箭头方向")
    public static String CHANGEDIR;

    public static Page_Gate Inst;
    static {
        Inst = new Page_Gate();
    }
}
