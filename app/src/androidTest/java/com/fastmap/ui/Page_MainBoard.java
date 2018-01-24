package com.fastmap.ui;

/**
 * Created by fang on 18/1/19.
 */
public class Page_MainBoard extends FastMapPage
{
    @FindResource(Id="back")
    public static String BACK;
    @FindResource(Id="head_icon")
    public static String MAIN_MENU;
    @FindResource(Id="iv_zoom_out")
    public static String ZOOM_OUT;
    @FindResource(Id="iv_zoom_in")
    public static String ZOOM_IN;

    public static Page_MainBoard Inst;
    static
    {
        Inst = new Page_MainBoard();
    }

    public void Trigger(String tips) throws Exception
    {
        FastMapUI.pressBtnMainBoard(tips);
    }
}