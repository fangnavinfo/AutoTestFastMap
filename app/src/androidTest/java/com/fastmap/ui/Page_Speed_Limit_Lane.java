package com.fastmap.ui;

import static com.fastmap.ui.Page_POI.SEARCH_TYPE;
import static com.fastmap.ui.Page_POI.SEARCH_TYPE_RESULT;
import static com.fastmap.ui.Page_POI.SELECT_TYPE;

/**
 * Created by h on 2018/1/29.
 */

public class Page_Speed_Limit_Lane extends FastMapPage {

    @FindResource(Id="speed_limit_number_90")
    public static String NUM90;

    @FindResource(Id="speed_limit_number_110")
    public static String NUM110;

    @FindResource(Id="save_button")
    public static String SAVE;
    @FindResource(Id="card_speed_limit_type_driveway")
    public static String ROADLIMIT;

    @FindResource(Id="speed_limit_type_point")
    public static String POINTLIMIT;
    @FindResource(Id="et_speed_limit_number")
    public static String MAXNUM;
    @FindResource(Id="speed_limit_number_40")
    public static String NUM40;
    @FindResource(Id="et_speed_limit_number_min")
    public static String MINNUM;
    @FindResource(Id="speed_limit_number_30")
    public static String NUM30;

    public static Page_Speed_Limit_Lane Inst;
    static
    {
        Inst = new Page_Speed_Limit_Lane();
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
    public void RoadLimitCtlDrag()
    {
        //车道限速中控件的拖拽
        mDevice.drag(77, 632, 225, 643, 10);
        mDevice.drag(77, 632, 225, 643, 10);
    }
}
