package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */

public class Page_POI extends FastMapPage
{
    @FindResource(Id="fm_et_name")
    public static String NAME;

    @FindResource(Id="tv_assort_type", Text="请选择分类")
    public static String SELECT_TYPE;

    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;

    @FindResource(Id="et_kind_search", Text="请输入搜索内容")
    public static String SEARCH_TYPE;

    @FindResource(Id="top_name_txtinfo")
    public static String SEARCH_TYPE_RESULT;

    @FindResource(Id="edt_contactItem_telNum")
    public static String TEL;

    public static Page_POI Inst;
    static
    {
        Inst = new Page_POI();
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

}
