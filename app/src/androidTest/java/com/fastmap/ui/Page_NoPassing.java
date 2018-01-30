package com.fastmap.ui;

/**
 * Created by zhou on 18/1/19.
 * 禁止穿行
 */

public class Page_NoPassing extends FastMapPage
{

    @FindResource(Id="delete_button", Text="删除")
    public static String DELETE;
    @FindResource(Id="cancel_button", Text="取消")
    public static String CANCEL;
    @FindResource(Id="save_button", Text="保存")
    public static String SAVE;


    public static Page_NoPassing Inst;
    static
    {
        Inst = new Page_NoPassing();
    }
}
