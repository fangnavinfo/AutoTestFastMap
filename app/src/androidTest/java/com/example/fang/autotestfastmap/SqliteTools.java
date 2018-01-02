package com.example.fang.autotestfastmap;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.ExifInterface;
import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by fang on 17/12/29.
 */
public class SqliteTools {

    public SqliteTools()
    {

    }


    //注意因为sqlite使用了wal缓存机制，所以每次对数据库做增删改操作后，需要调用此函数刷新数据到coremap.sqlite3中，才能从coremap.sqlite3获取对应数据
    public void RefreshData() throws Exception
    {
        testFastMapBase.ReStartApp();
        testFastMapBase.loginProcess();
    }

    public String GetTipsDisplayText(String key) throws Exception
    {
        SQLiteDatabase db=SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY, null);

        String sql = "select * from tips_geo_component where tipsRowkey="+ "\"" + key + "\"" + "and geoTableName=\"tips_point\"";
        Cursor cursor = db.rawQuery(sql, null);
        if(!cursor.moveToFirst())
        {
            throw new Exception("query result is null, exec sql:" + sql);
        }

        int coluid = cursor.getColumnIndex("geoUuid");
        String uuid = cursor.getString(coluid);

        sql = "select * from tips_point where uuid="+ "\"" + uuid + "\"";
        cursor = db.rawQuery(sql, null);
        if(!cursor.moveToFirst())
        {
            throw new Exception("can not find uuid:" + uuid + " in tips_geo_component");
        }

        String displayJson = cursor.getString(cursor.getColumnIndex("display_style"));

        ArrayList<DISPLAY_TEXT> textList = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(displayJson);
        JSONArray  jsonArray  = jsonObject.getJSONArray("icon");
        for (int i = 0; i< jsonArray.length(); i++)
        {
            JSONObject jsonSubObject = jsonArray.getJSONObject(i);
            if (!jsonSubObject.has("name"))
            {
                continue;
            }

            String name = jsonSubObject.getString("name");
            int row = jsonSubObject.getInt("row");
            int col = jsonSubObject.getInt("column");

            textList.add(new DISPLAY_TEXT(name, row, col));
        }

        String rlst = "";
        for (DISPLAY_TEXT test: textList)
        {
            rlst += test.name;
        }

        db.close();

        return rlst;
    }

    static String dbPath = Environment.getExternalStorageDirectory().getPath() + "/FastMap18Summer/Data/Collect/3655/coremap.sqlite";

    class DISPLAY_TEXT implements Comparable<DISPLAY_TEXT>
    {
        public DISPLAY_TEXT(String name, int row, int col)
        {
            this.name = name;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(DISPLAY_TEXT p)
        {
            if(this.row > p.row)
            {
                return 1;
            }
            else if (this.row < p.row)
            {
                return -1;
            }
            else
            {
                if (this.col > p.col)
                {
                    return 1;
                }
                else if (this.col < p.col)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        }


        String name;
        int row;
        int col;

    }
}
