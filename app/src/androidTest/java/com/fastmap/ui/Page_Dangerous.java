package com.fastmap.ui;

/**
 * Created by h on 2018/1/22.
 */

public class Page_Dangerous extends FastMapPage {
    @FindResource(Id="dangerous_information_icon_a1")
    public static String ICON_1;

    @FindResource(Id="cancel_button")
    public static String CANCEL;

    @FindResource(Id="save_button")
    public static String SAVE;

    public static Page_Dangerous Inst;
    static
    {
        Inst = new Page_Dangerous();
    }
}
