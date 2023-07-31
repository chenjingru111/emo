package com.dfgadgh.emo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EmoData {
    private Context context;

    public EmoData(Context context) {
        this.context = context;
    }

    public List<String> getAllEmoTexts() {
        List<String> emoList = new ArrayList<>();

        // 实例化DatabaseHelper
        DatabaseHelper dbHelper = new DatabaseHelper(context);

        // 获取可读的数据库实例
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT text FROM emo", null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("text");
            if (columnIndex >= 0) {
                do {
                    String text = cursor.getString(columnIndex);
                    emoList.add(text);
                } while (cursor.moveToNext());
            }
        }

        // 关闭cursor和数据库连接
        cursor.close();
        db.close();

        return emoList;
    }
}
