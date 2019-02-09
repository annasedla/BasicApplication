package com.example.basicapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ContentProviderActivity extends AppCompatActivity {

    EditText mName;
    EditText mPhone;
    EditText mIDNumber;
    TextView mDBView;
    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        mName = (EditText) findViewById(R.id.text_name);
        mPhone = (EditText) findViewById(R.id.text_phone);
        mIDNumber = (EditText) findViewById(R.id.IDNumber);
    }

    public void onInsert(View view) {
        ContentValues values = new ContentValues();
        values.put(ContactDatabase.IDNUMBER, mIDNumber.getText().toString());
        values.put(ContactDatabase.NAME, mName.getText().toString());
        values.put(ContactDatabase.PHONE, mPhone.getText().toString());
        getApplicationContext().getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
        Toast.makeText(this, "Inserted 1 row", Toast.LENGTH_SHORT).show();
        counter++;
    }

    public void onReset(View view) {
        int delcount = getContentResolver().delete(MyContentProvider.CONTENT_URI, null, null);
        Toast.makeText(this, "Delete " + delcount + "rows", Toast.LENGTH_SHORT).show();
        counter = 0;
        onShow(view);
    }
    public void onShow(View view) {
        Uri uri = MyContentProvider.CONTENT_URI;
        Cursor cursor = this.getContentResolver().query(uri, null, null, null, null);

        String[] mobileArray = new String[counter];

        if (counter != 0){
            StringBuilder sb;
            int i = 0;

            while (cursor.moveToNext()){

                sb = new StringBuilder();
                sb.append(cursor.getString(0) + ",");
                sb.append(cursor.getString(1) + ",");
                sb.append(cursor.getString(2) + ",");

                mobileArray[i] = sb.toString();
                i++;
            }

            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    R.layout.activity_listview, mobileArray);

            ListView mDBView =findViewById(R.id.dbview);

            mDBView.setAdapter(adapter);
        } else {
            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    R.layout.activity_listview, mobileArray);

            ListView mDBView =findViewById(R.id.dbview);

            mDBView.setAdapter(adapter);
        }
    }
}
