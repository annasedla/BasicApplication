package com.example.basicapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("here");
        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
    }
}
