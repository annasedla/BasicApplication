package com.example.basicapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context,  final Intent intent) {
        new Handler(Looper.getMainLooper()).post (new Runnable() {

            public void run() {
                System.out.println("here");
                Toast.makeText(context, intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
            }
        });
    }
}
