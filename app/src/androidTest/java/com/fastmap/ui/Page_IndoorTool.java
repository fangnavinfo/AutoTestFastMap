package com.fastmap.ui;

/**
 * Created by zhou on 18/1/24.
 * 室内整理工具
 */

public class Page_IndoorTool extends FastMapPage
{
    @FindResource(Id="sync_photos_connect")
    public static String SYNC_PHOTOS_CONNECT;
    @FindResource(Id="sync_photos_upload")
    public static String SYNC_PHOTOS;
    @FindResource(Id="tv_my_data")
    public static String MY_DATA;
    @FindResource(Id="sync_photos_back")
    public static String BACK;

    public static Page_IndoorTool Inst;
    static
    {
        Inst = new Page_IndoorTool();
    }
}