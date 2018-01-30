package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 对话框
 */

public class Page_Dialog extends FastMapPage
{
    @FindResource(Id="tv_content")
    public static String CONTENT;
    @FindResource(Id="btn_fm_cancel", Text="取消")
    public static String CANCEL;
    @FindResource(Id="btn_fm_confirm", Text="确认")
    public static String OK;


    public static Page_Dialog Inst;
    static
    {
        Inst = new Page_Dialog();
    }

}
