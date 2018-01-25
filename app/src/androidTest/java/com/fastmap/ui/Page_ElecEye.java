package com.fastmap.ui;


/**
 * Created by fang on 18/1/22.
 */
public class Page_ElecEye extends FastMapPage
{
    @FindResource(Id="tv_electronic_eye_type_more")
    public static String TYPE_MORE;

    @FindResource(Id="electronic_eye_overspeed")
    public static String EYE_OVERSPEED;

    @FindResource(Id="electronic_eye_ultra_low_speed")
    public static String EYE_LOWSPEED;

    @FindResource(Id="electronic_eye_move_velocity_measurement")
    public static String EYE_MOVE; //移动测速

    @FindResource(Id="electronic_eye_variable_velocity_measurement")
    public static String EYE_VAR; //可变限速

    @FindResource(Id="electronic_eye_sub_lane_speed_measurement")
    public static String EYE_LANE_SPEED; //车道限速

    @FindResource(Id="electronic_eye_vehicle_metering_speed")
    public static String EYE_VEHICLE;  //分车种限速

    @FindResource(Id="electronic_eye_interval_end")
    public static String EYE_INTERVAL_END; //区间结束

    @FindResource(Id="electronic_eye_bus_lane")
    public static String EYE_BUS_LANE;  //公交车道

    @FindResource(Id="electronic_eye_one_way_street")
    public static String EYE_ONE_WAY; //单行道

    @FindResource(Id="electronic_eye_traffic_controls")
    public static String EYE_NUM_CTRL;  //尾号限行

    @FindResource(Id="electronic_eye_environmental_protection_limit")
    public static String EYE_ENV_PROT; //环境保护

    @FindResource(Id="electronic_eye_not_vehicle_lane")
    public static String EYE_NO_VECHICLE; //非机动车

    @FindResource(Id="electronic_eye_no_turning_around")
    public static String EYE_NO_TURN; //禁止左右转

    @FindResource(Id="electronic_eye_illegal_parking")
    public static String EYE_ILLEGAL_PARKING; //违章停车

    @FindResource(Id="electronic_eye_emergency_lane")
    public static String EYE_EMERG_LANE; //应急车道

    @FindResource(Id="electronic_eye_traffic_lights")
    public static String EYE_TRAFFIC_LIGHT; //闯红灯

    @FindResource(Id="electronic_eye_traffic_marking")
    public static String EYE_TRAFFIC_MARK; //违反禁止线

    @FindResource(Id="electronic_eye_exit_entrance")
    public static String EYE_EXIT_ENTER; //出入口

    @FindResource(Id="electronic_eye_courtesy_pedestrian")
    public static String EYE_PEDESTRIAN; //礼让行人

    @FindResource(Id="electronic_eye_no_audible_warning")
    public static String EYE_AUD_WAIN; //禁止鸣笛

    @FindResource(Id="electronic_eye_no_turn_off")
    public static String EYE_NO_TURNOFF; //禁止掉头

    @FindResource(Id="electronic_eye_violating_lane")
    public static String EYE_VIOLAT_LANE; //违规占道

    @FindResource(Id="electronic_eye_lllegal_corssing")
    public static String EYE_ILLEGAL_CROSS; //违规过路

    @FindResource(Id="electronic_eye_violation_prohibition_sign")
    public static String EYE_VIOLAT_SIGN; //违反禁令

    @FindResource(Id="electronic_eye_lllegal_light")
    public static String EYE_ILLEGAL_LIGHT; //违规用灯

    @FindResource(Id="electronic_eye_no_seat_belt")
    public static String EYE_NO_BELT; //不系安全带

    @FindResource(Id="electronic_eye_drive_cell_phone")
    public static String EYE_DRIVE_PHONE; //开车打手机

    @FindResource(Id="electronic_eye_road_condition_monitoring")
    public static String EYE_ROAD_MONITOR; //路况监控

    @FindResource(Id="electronic_eye_non_annual_inspection")
    public static String EYE_NO_INSPECTION; //未年检

    @FindResource(Id="electronic_eye_tail_gas_exceeding_standard")
    public static String EYE_TAIL_GAS; //尾气超标

    @FindResource(Id="tv_eye_card_add_time", clazz = "android.widget.TextView", Text="增加时间")
    public static String TIME;

    @FindResource(Id="btn_fm_confirm")
    public static String TIME_CONFIRM;

    @FindResource(Id="save_button")
    public static String SAVE;

    @FindResource(Id="delete_button")
    public static String DELETE;

    @FindResource(Id="btn_fm_confirm")
    public static String DELETE_CONFIRM;

    @FindResource(clazz="android.widget.ScrollView")
    public static String SCROLL;

    @FindResource(clazz="android.widget.CheckBox", Text="卡车")
    public static String TRUCK;

    public static Page_ElecEye Inst;
    static
    {
        Inst = new Page_ElecEye();
    }

    public void SetSpeed(String value)
    {
        ClickByText(value);
    }
}

