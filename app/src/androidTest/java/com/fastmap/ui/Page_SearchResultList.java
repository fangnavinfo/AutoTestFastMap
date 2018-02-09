package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 检索结果列表
 */
public class Page_SearchResultList extends FastMapPage
{
    @FindResource(Id="ll_my_data_snap_list")
    public static String DATA_LIST;

    @FindResource(Id="tv_my_data_snap_list_item_name")
    public static String SEARCH_LIST;

    @FindResource(Id="iv_search_result_list_back")
    public static String BACK;

    public static Page_SearchResultList Inst;
    static
    {
        Inst = new Page_SearchResultList();
    }
}