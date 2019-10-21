package com.example.asifahmed.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class DatabaseHelperClass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final String TABLE_NAME = "student_details";
    private static final int VERSION_NUMBER = 4;
    private Context context;


    private static final String COLUMN_ONE = "_Id";
    private static final String COLUMN_TWO = "Name";
    private static final String COLUMN_THREE = "Age";
    private static final String COLUMN_FOUR = "Gender";
//    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+COLUMN_ONE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_TWO+" VARCHAR(100), "+COLUMN_THREE+" INTEGER)";
    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+COLUMN_ONE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_TWO+" VARCHAR(100), "+COLUMN_THREE+" INTEGER, "+COLUMN_FOUR+" VARCHAR(10))";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String RETRIEVE_ALL_DATA = "SELECT * FROM " + TABLE_NAME;


    public DatabaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null , VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context,"onCreate is called",Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : " + e,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : " + e,Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(String name, String age, String gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TWO,name);
        contentValues.put(COLUMN_THREE,age);
        contentValues.put(COLUMN_FOUR,gender);

        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return rowId;
    }

    public Cursor displayData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from student_details", null);

        return cursor;
    }


}
