package uta.dbtest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MySQLiteOpenHelper helper;
    private SQLiteDatabase db;
    private LinearLayout layout;
    private List<String> list;

    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        Button btnNewCreate = (Button)findViewById(R.id.btn_start_newCreate);
        btnNewCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        helper = MySQLiteOpenHelper.getInstance(this);
        readDB();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        readDB();
    }

    private void readDB() {
        list = new ArrayList<>();
        db = helper.getReadableDatabase();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, list);
        /*Cursor c = db.query("CodeM", new String[]{"CodeId", "Code", "Name"},
                null, null, null, null, null);
        boolean isEof = c.moveToFirst();
        while (isEof) {
//            TextView tv = new TextView(this);
//            tv.setText(String.format("%s | %d | %s", c.getString(0), c.getInt(1), c.getString(2)));
            list.add(String.format("%s | %d | %s", c.getString(0), c.getInt(1), c.getString(2)));
            isEof = c.moveToNext();
//            layout.addView(tv);
        }
        Log.e("list:", String.valueOf(list.size()));

        ListView listView = (ListView)findViewById(R.id.list_view);



        listView.setAdapter(adapter);

        adapter.setNotifyOnChange(true);

        // Table取得したデータをListViewにセットするためのスレッド
        (new Thread(new Runnable() {
            @Override
            public void run() {

                //メインスレッドのメッセージキューにメッセージを登録します。
                handler.post(new Runnable (){
                    //run()の中の処理はメインスレッドで動作されます。
                    public void run(){
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        })).start();*/


        Cursor c = db.query("Account", new String[]{"FirstName", "LastName", "PrefectureId",
                "Address", "MailAddress", "Password"}, null, null, null, null, null);
        c.moveToFirst();

        boolean isCheck = c.moveToFirst();
        while (isCheck) {
//            TextView tv = new TextView(this);
            list.add(String.format("%s | %s | %d | %s | %s | %s |", c.getString(0), c.getString(1), c.getInt(2), c.getString(3), c.getString(4), c.getString(5)));
            isCheck = c.moveToNext();
//            tv.setText();
//            layout.addView(tv);
        }

        ListView listView = (ListView)findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        adapter.setNotifyOnChange(true);

        // Table取得したデータをListViewにセットするためのスレッド
        (new Thread(new Runnable() {
            @Override
            public void run() {

                //メインスレッドのメッセージキューにメッセージを登録します。
                handler.post(new Runnable (){
                    //run()の中の処理はメインスレッドで動作されます。
                    public void run(){
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        })).start();

        c.close();
        db.close();
    }
}
