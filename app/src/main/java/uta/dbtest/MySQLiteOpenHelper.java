package uta.dbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;

class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static MySQLiteOpenHelper singleton = null;

    final static private int DB_VERSION = 1;
    final static String CREATE_TABLE = "create table CodeM (" +
            "   CodeId integer," +
            "   Code integer," +
            "   Name text," +
            "   primary key(CodeId, Code)" +
            ");";

    final static String CREATE_PRODUCT_TABLE = "create table Account (" +
            "   FirstName text," +
            "   LastName text," +
            "   PrefectureId integer," +
            "   Address text," +
            "   MailAddress text," +
            "   Password text" +
            ");";

    public static synchronized MySQLiteOpenHelper getInstance(Context context) {
        if (singleton == null) {
            singleton = new MySQLiteOpenHelper(context);
        }
        return singleton;
    }

    private MySQLiteOpenHelper(Context context) {
        super(context, null, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // table create
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);

        // table row insert
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 1, '北海道');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 2, '青森');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 3, '岩手');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 4, '宮城');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 5, '秋田');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 6, '山形');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 7, '福島');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 8, '茨城');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 9, '栃木');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 10, '群馬');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 11, '埼玉');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 12, '千葉');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 13, '東京');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 14, '神奈川');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 15, '新潟');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 16, '富山');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 17, '石川');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 18, '福井');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 19, '山梨');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 20, '長野');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 21, '岐阜');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 22, '静岡');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 23, '愛知');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 24, '三重');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 25, '滋賀');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 26, '京都');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 27, '大阪');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 28, '兵庫');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 29, '奈良');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 30, '和歌山');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 31, '鳥取');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 32, '島根');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 33, '岡山');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 34, '広島');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 35, '山口');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 36, '徳島');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 37, '香川');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 38, '愛媛');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 39, '高知');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 40, '福岡');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 41, '佐賀');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 42, '長崎');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 43, '熊本');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 44, '大分');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 45, '宮崎');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 46, '鹿児島');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (1, 47, '沖縄');");
        db.execSQL("insert into CodeM(CodeId,Code,Name) values (2, 1, '30');");

        db.execSQL("insert into Account(FirstName, LastName, PrefectureId, Address, MailAddress, Password) values ('隆史', '山田', 39, '高知市鏡竹奈路', 'newTakashi@gmail.com', 'passttt');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // データベースの変更が生じた場合は、ここに処理を記述する。
    }
}


