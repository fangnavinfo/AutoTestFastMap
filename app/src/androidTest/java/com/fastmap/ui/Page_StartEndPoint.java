package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */
public class Page_StartEndPoint extends FastMapPage
{
    @FindResource(Id="bridge_bt")
    public static String BRIDGE_BT;
    @FindResource(Id="tunnel_bt")
    public static String TUNNEL_BT;
    @FindResource(Id="cross_line_overpass_bt")
    public static String CROSS_LINE_OVERPASS_BT;
    @FindResource(Id="walking_street_bt")
    public static String WALKING_STREET_BT;
    @FindResource(Id="overhead_road_bt")
    public static String OVERHEAD_ROAD_BT;
    @FindResource(Id="under_construction_bt")
    public static String UNDER_CONSTRUCTION_BT;
    @FindResource(Id="repair_bt")
    public static String REPAIR_BT;
    @FindResource(Id="up_low_separation_bt")
    public static String UP_LOW_SAPARATION_BT;
    @FindResource(Id="side_road_bt")
    public static String SIDE_ROAD_BT;
    @FindResource(Id="bus_lane_bt")
    public static String BUS_LANE_BT;
    @FindResource(Id="pavement_cover_bt")
    public static String PAVEMENT_COVER_BT;
    @FindResource(Id="narrow_lane_bt")
    public static String NARROW_LANE_BT;
    @FindResource(Id="overpass_bt")
    public static String OVERPASS_BT;
    @FindResource(Id="under_pass_bt")
    public static String UNDER_PASS_BT;
    @FindResource(Id="seasonal_closure_bt")
    public static String SEASONAL_CLOSURE_BT;
    @FindResource(Id="usage_fee_required_bt")
    public static String USAGE_FEE_REQUIRED_BT;
    @FindResource(Id="bypath_bt")
    public static String BYPATH_BT;
    @FindResource(Id="traveling_bridge_bt")
    public static String TRAVELING_BRIDGE_BT;


    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_StartEndPoint Inst;
    static
    {
        Inst = new Page_StartEndPoint();
    }
}