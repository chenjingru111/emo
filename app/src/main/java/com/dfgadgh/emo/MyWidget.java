package com.dfgadgh.emo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.RemoteViews;

import com.dfgadgh.emo.db.DataManager;
import com.dfgadgh.emo.db.DatabaseHelper;

public class MyWidget extends AppWidgetProvider {

private static Handler handler = new Handler();

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        String randomEmoText = DataManager.getRandomEmoText(context);
        // 创建远程视图对象并设置布局
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.mywidget);

       /* // 设置按钮的点击事件
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.widget_button, pendingIntent);

        // 更新小组件的文本
        views.setTextViewText(R.id.widget_text, "Hello Widget!");*/

        views.setTextViewText(R.id.tv_show, randomEmoText);

        // 更新小组件
        appWidgetManager.updateAppWidget(appWidgetId, views);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                updateAppWidget(context, appWidgetManager, appWidgetId);
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {

    }

    @Override
    public void onDisabled(Context context) {
        handler.removeCallbacksAndMessages(null);
    }





}
