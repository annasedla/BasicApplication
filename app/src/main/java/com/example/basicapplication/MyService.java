package com.example.basicapplication;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyService extends IntentService {

    public MyService(){
        super("MyService");
    }

    public static boolean keepRunning = false;

    @Override
    protected void onHandleIntent(Intent intent) {

        while (keepRunning){

            //get current time
            //intent with a message thats current time
            Calendar cal = Calendar.getInstance();
            Date date=cal.getTime();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String formattedDate=dateFormat.format(date);

            System.out.println(formattedDate);


            Intent intent2 = new Intent();
            intent2.setAction(ServiceActivity.BROADCAST_ACTION);
            intent2.addCategory(Intent.CATEGORY_DEFAULT);
            intent2.putExtra("currentTime", formattedDate);
            sendBroadcast(intent2);
        }
    }
}