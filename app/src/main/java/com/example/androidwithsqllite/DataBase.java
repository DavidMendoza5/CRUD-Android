package com.example.androidwithsqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final String dbName = "users.db";
    private static final int dbVersion = 1;
    private static final String userTable = "CREATE TABLE USER(RFC TEXT PRIMARY KEY, NAME TEXT, PHONE TEXT, EMAIL TEXT)";

    public DataBase(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(userTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS User");
        sqLiteDatabase.execSQL(userTable);
    }

    public void addUser(String rfc, String name, int phone, String email) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null) {
            db.execSQL("INSERT INTO USER VALUES('"+rfc+"', '"+name+"', '"+phone+"', '"+email+"')");
            db.close();
        }
    }
}
