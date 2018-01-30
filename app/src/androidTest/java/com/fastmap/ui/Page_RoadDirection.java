package com.fastmap.ui;

/**
 * Created by zhou on 18/1/19.
 * 道路方向
 */

public class Page_RoadDirection extends FastMapPage
{

    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;


    @FindResource(Id="card_road_direction_unidirectional", Text="单方向")
    public static String UNIDIRECTIONAL;
    @FindResource(Id="card_road_direction_bidirectional", Text="双方向")
    public static String BIDIRECTION;

    public static Page_RoadDirection Inst;
    static
    {
        Inst = new Page_RoadDirection();
    }
}
