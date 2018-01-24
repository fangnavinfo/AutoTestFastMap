package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 交限TIPS
 */
public class Page_TrafficForbidden extends FastMapPage
{
    @FindResource(Id="traffic_forbidden_no_pull_into")
    public static String NO_PULL_INTO;


    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_TrafficForbidden Inst;
    static
    {
        Inst = new Page_TrafficForbidden();
    }
}