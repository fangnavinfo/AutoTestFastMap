package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 多点列表
 */

public class Page_MultiList extends FastMapPage
{
    @FindResource(Id="tv_pois_filter", Text="筛选")
    public static String FILTER;
    @FindResource(Id="tv_pois_cancel", Text="取消")
    public static String CANCEL_POI;
    @FindResource(Id="cb_new_add", Text="新 增")
    public static String ADD;
    @FindResource(Id="cb_select_all", Text="全选")
    public static String SELECT_ALL;
    @FindResource(Id="ck_poi_move", Text="移动点位")
    public static String MOVE;
    @FindResource(Id="ck_poi_move_point", Text="移点")
    public static String MOVE_POINT;
    @FindResource(Id="ck_poi_move_line", Text="移线")
    public static String MOVE_LINE;
    @FindResource(Id="ck_poi_move_point_and_line", Text="移点/移线")
    public static String MOVE_POINT_AND_LINE;


    @FindResource(Id="cb_snap_check_list_item")
    public static String CHECK_LIST_ITEM;


    public static Page_MultiList Inst;
    static
    {
        Inst = new Page_MultiList();
    }

}
