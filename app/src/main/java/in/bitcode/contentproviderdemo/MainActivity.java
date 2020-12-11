package in.bitcode.contentproviderdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://in.bitcode.students");
        uri = Uri.withAppendedPath(uri, "students");
        //uri = Uri.withAppendedPath(uri, "11");

        ContentResolver resolver = getContentResolver();

        Cursor c = resolver.query(
                uri,
                null,
                null,
                null,
                null
        );
        /*
        Cursor c = resolver.query(
                uri,
                null,
                "id = ?",
                new String[] {"11"},
                null
        );
        */


        String [] columnNames = c.getColumnNames();

        while(c.moveToNext()) {
            mt(c.getInt(0) + " " + c.getString(1) +  " " + c.getInt(2));
        }

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
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