package uta.dbtest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CreateAccountActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Button buttonInsert;
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editAddress;
    private EditText editMailAddress;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        LinearLayout layout = (LinearLayout)findViewById(R.id.layout_create);
        editFirstName = new EditText(this);
        editLastName = new EditText(this);
        editAddress = new EditText(this);
        editMailAddress = new EditText(this);
        editPassword = new EditText(this);
        buttonInsert = new Button(this);
        layout.addView(editFirstName);
        layout.addView(editLastName);
        layout.addView(editAddress);
        layout.addView(editMailAddress);
        layout.addView(editPassword);
        layout.addView(buttonInsert);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(39);
            }
        });

        MySQLiteOpenHelper helper = MySQLiteOpenHelper.getInstance(this);
        db = helper.getReadableDatabase();

        Cursor c = db.query("Account", new String[]{"FirstName", "LastName", "PrefectureId",
                "Address", "MailAddress", "Password"}, null, null, null, null, null);
        boolean isCheck = c.moveToFirst();

        while (isCheck) {
            TextView tv = (TextView) findViewById(R.id.text_read);
            tv.setText(String.format("%s | %s | %d | %s | %s | %s |", c.getString(0), c.getString(1), c.getInt(2), c.getString(3), c.getString(4), c.getString(5)));
            isCheck = c.moveToNext();
        }

        c.close();
    }

    private void insert(int prefectureId) {
        ContentValues values = new ContentValues();

        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String address = editAddress.getText().toString();
        String mailAddress = editMailAddress.getText().toString();
        String password = editPassword.getText().toString();

        values.put("FirstName", firstName);
        values.put("LastName", lastName);
        values.put("PrefectureId", prefectureId);
        values.put("Address", address);
        values.put("MailAddress", mailAddress);
        values.put("Password", password);

        db.insert("Account", null, values);
    }
}
