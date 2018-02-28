package com.fastmap.ui;

/**
 * Created by h on 2018/2/25.
 */

public class Page_SketchHook extends FastMapPage {
    @FindResource(Id = "sketch_hook_1")
    public static String SKETCHHOOK1;

    @FindResource(Id = "sketch_hook_2")
    public static String SKETCHHOOK2;

    @FindResource(Id = "straight_line")
    public static String STAIGHTLINE;

    @FindResource(Id = "curve_line")
    public static String CURVELINE;

    @FindResource(Id = "poly_line")
    public static String POLYLINE;

    @FindResource(Id = "rect_line")
    public static String RECTLINE;

    @FindResource(Id = "ellipse_line")
    public static String ELLIPSELINE;

    @FindResource(Id = "circular_point")
    public static String CIRCULARPOINT;

    @FindResource(Id = "greenland_line")
    public static String GREENLANDLINE;

    @FindResource(Id = "water_line")
    public static String WATERLINE;

    @FindResource(Id = "railway_line")
    public static String RAILWAYLINE;
    @FindResource(Id = "connect_icons_2082")
    public static String ICON2082;

    @FindResource(Id = "connect_icons_2113")
    public static String ICON2113;
    public static Page_SketchHook Inst;
    static {
        Inst = new Page_SketchHook();
    }
    public void DrawLine()
    {
        mDevice.drag(477,698,794,234,10);
    }
}
