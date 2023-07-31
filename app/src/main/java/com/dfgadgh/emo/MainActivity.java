package com.dfgadgh.emo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.dfgadgh.emo.db.DataManager;
import com.dfgadgh.emo.db.EmoData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EmoData emoData = new EmoData(this);
        findViewById(R.id.btn_list).setOnClickListener(v -> {
            List<String> allEmoTexts = emoData.getAllEmoTexts();
            showEmoList(allEmoTexts,this);

        });

    }

    public void showEmoList(List<String> emoList,Context context) {
        // 创建适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, emoList);

        // 实例化 ListView
        ListView listView = new ListView(context);

        // 设置适配器
        listView.setAdapter(adapter);

        // 显示 ListView
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Emo List");
        builder.setView(listView);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}