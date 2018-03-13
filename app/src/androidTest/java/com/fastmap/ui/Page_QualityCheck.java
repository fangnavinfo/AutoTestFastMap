package com.fastmap.ui;

/**
 * Created by h on 2018/3/13.
 */

public class Page_QualityCheck extends FastMapPage {
    @FindResource(Id="image_id_minimize")
    public static String MIN;

    @FindResource(Id="btn_data_check_initial_reasons")
    public static String INIT_REASON;

    @FindResource(Id="btn_data_check_rca")
    public static String RCA;

    @FindResource(Id="btn_data_check_big_type")
    public static String BIG_TYPE;

    @FindResource(Id="btn_data_check_small_type")
    public static String SMALL_TYPE;

    @FindResource(Id="edit_problem_describe")
    public static String EDIT;

    @FindResource(Id="btn_save_data_check")
    public static String SAVE;
    public static Page_QualityCheck Inst;
    static
    {
        Inst = new Page_QualityCheck();
    }
}
