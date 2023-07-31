package com.dfgadgh.emo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "emo_db";
    private static final int DATABASE_VERSION = 3;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String emo = "CREATE TABLE emo (id INTEGER PRIMARY KEY AUTOINCREMENT, text TEXT);";
        db.execSQL(emo);
        String emo1 = "INSERT INTO emo ( text) VALUES ('你能回头看看我吗');";
        db.execSQL(emo1);
        String emo2 = "INSERT INTO emo (text) VALUES ('你到底有没有爱过我');";
        db.execSQL(emo2);
        String emo3 = "INSERT INTO emo (text) VALUES ('取消置顶后才发现你垫底');";
        db.execSQL(emo3);
        String emo4 = "INSERT INTO emo (text) VALUES ('我释怀了 把心腾干净了 可我发现我不会爱人了');";
        db.execSQL(emo4);
        String emo5 = "INSERT INTO emo (text) VALUES ('忘记一个人是先忘记脸还是先忘记声音');";
        db.execSQL(emo5);
        String emo6 = "INSERT INTO emo (text) VALUES ('突然很奇怪我当时为什么非要问清楚');";
        db.execSQL(emo6);
        String emo7 = "INSERT INTO emo (text) VALUES ('停止联系是我们做过最默契的事');";
        db.execSQL(emo7);
        String emo8 = "INSERT INTO emo (text) VALUES ('我们的聊天记录是我看过最难过的小说');";
        db.execSQL(emo8);
        String emo9 = "INSERT INTO emo (text) VALUES ('你我这段恋情我走不出来，是我没本事');";
        db.execSQL(emo9);
        String emo10 = "INSERT INTO emo (text) VALUES ('祝走散的人永远别相见');";
        db.execSQL(emo10);
        String emo11 = "INSERT INTO emo (text) VALUES ('脸已经忘了，声音还记得');";
        db.execSQL(emo11);
        String emo12 = "INSERT INTO emo (text) VALUES ('把备注改为全名，是有多失望');";
        db.execSQL(emo12);
        String emo13 = "INSERT INTO emo (text) VALUES ('有空见一面吧 我把一见钟情还给你');";
        db.execSQL(emo13);
        String emo14 = "INSERT INTO emo (text) VALUES ('哭的最惨的那天你一定成长不少吧');";
        db.execSQL(emo14);
        String emo15 = "INSERT INTO emo (text) VALUES ('非她不可吗');";
        db.execSQL(emo15);
        String emo16 = "INSERT INTO emo (text) VALUES ('世间好多遗憾 一切都有替代');";
        db.execSQL(emo16);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // database upgrade code goes here
    }
}
