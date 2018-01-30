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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fang on 17/12/29.
 */
public class SqliteTools {

    public static void initialize(String strDBPath)
    {
        mDBPath = strDBPath+"keyboard.db";
    }


    //注意因为sqlite使用了wal缓存机制，所以每次对数据库做增删改操作后，需要调用此函数刷新数据到coremap.sqlite3中，才能从coremap.sqlite3获取对应数据
    public void RefreshData() throws Exception
    {
        testFastMapBase.ReStartApp();
        testFastMapBase.loginProcess();
    }

    public String GetTipsDisplayText(String key) throws Exception
    {
        SQLiteDatabase db=SQLiteDatabase.openDatabase(mDBPath, null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            String sql = "select * from tips_geo_component where tipsRowkey=" + "\"" + key + "\"" + "and geoTableName=\"tips_point\"";
            Cursor cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst()) {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            int coluid = cursor.getColumnIndex("geoUuid");
            String uuid = cursor.getString(coluid);

            sql = "select * from tips_point where uuid=" + "\"" + uuid + "\"";
            cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst()) {
                throw new Exception("can not find uuid:" + uuid + " in tips_geo_component");
            }

            String displayJson = cursor.getString(cursor.getColumnIndex("display_style"));

            ArrayList<DISPLAY_TEXT> textList = new ArrayList<>();

            JSONObject jsonObject = new JSONObject(displayJson);
            JSONArray jsonArray = jsonObject.getJSONArray("icon");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonSubObject = jsonArray.getJSONObject(i);
                if (!jsonSubObject.has("name")) {
                    continue;
                }

                String name = jsonSubObject.getString("name");
                int row = jsonSubObject.getInt("row");
                int col = jsonSubObject.getInt("column");

                textList.add(new DISPLAY_TEXT(name, row, col));
            }

            String rlst = "";
            for (DISPLAY_TEXT test : textList)
            {
                rlst += test.name;
            }

            return rlst;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }


    }

    public int GetRelateChildrenSize(String dbPath, String name) throws Exception
    {
        SQLiteDatabase db=SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            String sql = "select * from edit_pois where name=" + "\"" + name + "\"";
            Cursor cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst()) {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            int relateChildrenIndex = cursor.getColumnIndex("relateChildren");
            byte[] relateChildren = cursor.getBlob(relateChildrenIndex);

            return relateChildren.length;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }


    }



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

    static public int[] GetKeyboardInfo(String type) throws Exception
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath, null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            String sql = "select * from dragviews where tipstype=" + "\"" + type + "\"";
            Cursor cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst()) {
                db.close();

                throw new Exception("query result is null, exec sql:" + sql);
            }

            int areaCodeIntegrated = cursor.getInt(cursor.getColumnIndex("areaCodeIntegrated"));
            int timeIntegrated = cursor.getInt(cursor.getColumnIndex("timeIntegrated"));

            sql = "select count(*) from dragviews where areaCodeIntegrated=" + areaCodeIntegrated;
            cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst()) {
                db.close();

                throw new Exception("query result is null, exec sql:" + sql);
            }

            Long count = cursor.getLong(0);
            if (count > 1) {
                return new int[]{areaCodeIntegrated, timeIntegrated};
            } else {
                return new int[]{areaCodeIntegrated, 0};
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }
    }

    static public HashMap<int[], String> GetKeyboardLeft() throws Exception
    {
        return GetKeyboardByAreaRange(200, 300, "areaCodeIntegrated", "timeIntegrated");
    }

    static public HashMap<int[], String> GetKeyboardBottom() throws Exception
    {
        return GetKeyboardByAreaRange(100, 200, "areaCodeIntegrated", "timeIntegrated");
    }

    static public HashMap<int[], String> GetKeyboardRight() throws Exception
    {
        return GetKeyboardByAreaRange(300, 400, "areaCodeIntegrated", "timeIntegrated");
    }

    static public HashMap<int[], String> GetKeyboardRightWithQC() throws Exception
    {
        return GetKeyboardByAreaRange(300, 400, "areaCodeRoad", "timeRoad");
    }

    static public HashMap<int[], String> GetKeyboardLeftWithQC() throws Exception
    {
        return GetKeyboardByAreaRange(200, 300, "areaCodeRoad", "timeRoad");
    }

    static public HashMap<int[], String> GetKeyboardBottomWithQC() throws Exception
    {
        return GetKeyboardByAreaRange(100, 200, "areaCodeRoad", "timeRoad");
    }


    static private HashMap<int[], String> GetKeyboardByAreaRange(int min, int max, String outter, String inner)
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath, null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            HashMap<int[], String> mapResult = new HashMap<>();

            String sql = "select * from dragviews where " + outter +">"+ min + " and " + outter + "<" + max;
            Cursor cursor = db.rawQuery(sql, null);
            while (cursor.moveToNext())
            {
                String type = cursor.getString(cursor.getColumnIndex("tipstype"));
                int[]  location = new int[]{cursor.getInt(cursor.getColumnIndex(outter)), cursor.getInt(cursor.getColumnIndex(inner))};
                mapResult.put(location, type);
            }

            return mapResult;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }
    }

    static String mDBPath;
}
