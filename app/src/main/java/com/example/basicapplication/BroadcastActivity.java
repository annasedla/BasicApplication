package com.example.basicapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class BroadcastActivity extends Activity {

    /** Called when the activity is first created. */
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }

    // Send an intended message
    public void broadcastIntent(View view) {
//        Intent intent = new Intent("com.unitedcoders.android.broadcasttest2.SHOWTOAST");
        Intent intent = new Intent("com.example.demo");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("msg", "Broadcast event!");
        sendBroadcast(intent);
        System.out.println("Send");
    }
}
