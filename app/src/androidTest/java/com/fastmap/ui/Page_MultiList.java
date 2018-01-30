package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 多点列表
 */

public class Page_MultiList extends FastMapPage
{
    @FindResource(Id="tv_tips_cancel", Text="取消")
    public static String CANCEL;


    public static Page_MultiList Inst;
    static
    {
        Inst = new Page_MultiList();
    }

}
