package com.example.androidwithsqllite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserModel> showUsers() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER", null);
        List<UserModel> users = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                users.add(new UserModel(cursor.getString(0), cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
        }

        return users;
    }
}
