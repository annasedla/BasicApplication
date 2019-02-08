package com.example.basicapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    TextView tx;

    public static String BROADCAST_ACTION =
            "com.unitedcoders.android.broadcasttest.SHOWTOAST";

    BroadcastReceiver br = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            tx = findViewById(R.id.textView1);
            tx.setText(intent.getStringExtra("currentTime"));
        }
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        tx = findViewById(R.id.textView1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        IntentFilter filter = new IntentFilter();
        filter.addAction(BROADCAST_ACTION);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(br, filter);
    }

    // Method to start service
    public void startService(View view) {
        MyService.keepRunning = true;
        startService(new Intent(getBaseContext(), MyService.class));

    }

    // Method to stop the service
    public void stopService(View view) {
        MyService.keepRunning = false;
    }

    @Override
    protected void onDestroy() {
        // Unregister since the activity is about to be closed.
        unregisterReceiver(br);
        super.onDestroy();
    }
}
