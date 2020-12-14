package in.bitcode.contentproviderdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver = getContentResolver();
        /*
        Cursor c = resolver.query(CallLog.Calls.CONTENT_URI, null, null, null, null);

        mt("----------------------------");
        for(String colName : c.getColumnNames()) {
                mt("col: " + colName);
        }
        mt("----------------------------");


        int colNumber = c.getColumnIndex(CallLog.Calls.NUMBER);
        int colName = c.getColumnIndex(CallLog.Calls.CACHED_NAME);
        int colType = c.getColumnIndex(CallLog.Calls.TYPE);
        int colDuration = c.getColumnIndex(CallLog.Calls.DURATION);

        while(c.moveToNext()) {
            mt( c.getString(colNumber) + " -> " + c.getString(colName) + " -> " + c.getInt(colType) + " -> " + c.getLong(colDuration));
        }
        */

        Uri uri = Uri.parse("content://sms/");
        Cursor c = resolver.query(uri, null, null, null, null);
        mt("----------------------------");
        for(String colName : c.getColumnNames()) {
            mt("col: " + colName);
        }
        mt("----------------------------");

        int colThreadId = c.getColumnIndex("thread_id");
        int colType = c.getColumnIndex("type");
        int colDate = c.getColumnIndex("date");
        int colAddress = c.getColumnIndex("address");
        int colBody = c.getColumnIndex("body");

        while( c.moveToNext() ) {
            mt( c.getLong(colThreadId ) + "\n" + c.getInt(colType) + "\n" + c.getString(colDate) + "\n" + c.getString(colAddress) + "\n" + c.getString(colBody));
        }





        /*
        Uri uri = Uri.parse("content://in.bitcode.students");
        uri = Uri.withAppendedPath(uri, "students");

        ContentValues values = new ContentValues();
        values.put("id", 66);
        values.put("name", "FF");
        values.put("marks", 90);

        uri = resolver.insert(uri, values);
        Log.e("tag", "Got Uri: " + uri);
        */
        //content://in.bitcode.storage/students/66



        //uri = Uri.withAppendedPath(uri, "33");

        /*
        Cursor c = resolver.query(
                uri,
                null,
                null,
                null,
                null
        );
        */

        /*
        Cursor c = resolver.query(
                uri,
                null,
                "id = ?",
                new String[] {"11"},
                null
        );
        */


        /*
        String [] columnNames = c.getColumnNames();
        while(c.moveToNext()) {
            mt(c.getInt(0) + " " + c.getString(1) +  " " + c.getInt(2));
        }
        */

        /*
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
         */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mt(data.getData().toString());
    }

    private void mt(String text) {
        Log.e("tag", text);
    }
}