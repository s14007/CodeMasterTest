package uta.dbtest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);
        setContentView(scrollView);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(layout);

        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query("CodeM", new String[]{"CodeId", "Code", "Name"},
                null, null, null, null, null);
        boolean isEof = c.moveToFirst();
        while (isEof) {
            TextView tv = new TextView(this);
            tv.setText(String.format("%s | %d | %s", c.getString(0), c.getInt(1), c.getString(2)));
            isEof = c.moveToNext();
            layout.addView(tv);
        }
        c.close();

        db.close();
    }
}
