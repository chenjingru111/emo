package com.dfgadgh.emo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataManager {
    private static final String TAG = "DataManager";

   /* public DataManager(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }*/

    public static String getEmoCount(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM emo", null);
        String count = "0";

        if (cursor.moveToFirst()) {
            count = String.valueOf(cursor.getInt(0));
        }

        cursor.close();
        return count;
    }
    public static String getRandomEmoText(Context context) {
        String emoCount = getEmoCount(context);
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] columns = {"text"};
        Cursor cursor = db.query("emo", columns, null, null, null, null, "RANDOM()", emoCount);
        String emoText = "";

        if (cursor.moveToNext()) {
            int columnIndex = cursor.getColumnIndex("text");
            if (columnIndex >= 0) {
                emoText = cursor.getString(columnIndex);
            } else {
                Log.e(TAG, "Column 'text' not found in cursor");
            }
        }

        System.out.println("kkkkkkkkkkkkk"+" "+emoText);
        System.out.println("qqqqqqqqqqqqq"+" "+emoCount);
        cursor.close();
        return emoText;
    }

    
}
