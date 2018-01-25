package com.fastmap.ui;

/**
 * Created by fang on 18/1/22.
 */
public class Page_IndoorTools extends FastMapPage
{
    @FindResource(Id="tv_my_data")
    public static String MYDATA;

    @FindResource(Id="fmcard_ibtn_back")
    public static String BACK;

    public static Page_IndoorTools Inst;
    static
    {
        Inst = new Page_IndoorTools();
    }
}
