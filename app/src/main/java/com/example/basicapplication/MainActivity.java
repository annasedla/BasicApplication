package com.example.basicapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Go to broadcast
    public void goToBroadcast (View view){
        Intent intent = new Intent (this, BroadcastActivity.class);
        startActivity(intent);
    }
}