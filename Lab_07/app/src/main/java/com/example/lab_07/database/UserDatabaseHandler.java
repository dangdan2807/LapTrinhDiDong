package com.example.lab_07.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lab_07.model.UserA;

import java.util.ArrayList;
import java.util.List;

public class UserDatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Lab07";
    private static final String TABLE_NAME = "user";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";


    public UserDatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUserTable = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT" + " )";
        sqLiteDatabase.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public  void resetDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Drop Table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(UserA userA) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, userA.getName());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public UserA getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{KEY_ID, KEY_NAME},
                KEY_ID + "= ?",
                new String[]{String.valueOf(id)}, null, null, null, null
        );

        if (cursor != null)
            cursor.moveToFirst();
        UserA userA = new UserA(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1)
        );
        return userA;
    }

    public List<UserA> getAllUser() {
        List<UserA> userAList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UserA userA = new UserA();
                userA.setId(Integer.parseInt(cursor.getString(0)));
                userA.setName(cursor.getString(1));
                userAList.add(userA);
            } while (cursor.moveToNext());
        }
        return userAList;
    }

    public List<UserA> getAllUserByName(String name) {
        List<UserA> userAList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(selectQuery,
                new String[]{KEY_ID, KEY_NAME},
                KEY_NAME + " like '%?%'",
                new String[]{name},null, null, null, null
            );

        if (cursor.moveToFirst()) {
            do {
                UserA userA = new UserA();
                userA.setId(Integer.parseInt(cursor.getString(0)));
                userA.setName(cursor.getString(1));
                userAList.add(userA);
            } while (cursor.moveToNext());
        }
        return userAList;
    }

    public int updateUser(UserA userA) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, userA.getName());

        // updating row
        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(userA.getId())});
    }

    public void deleteUser(UserA userA) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?",
                new String[]{String.valueOf(userA.getId())});
        db.close();
    }
}
