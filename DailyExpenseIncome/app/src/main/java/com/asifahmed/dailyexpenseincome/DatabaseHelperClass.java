package com.asifahmed.dailyexpenseincome;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "account.db";
    private static final String TABLE_NAME = "transaction_report";
    private static final int VERSION_NUMBER = 2;
    private Context context;


//    private static final String COLUMN_ONE = "_Id";
    private static final String COLUMN_ONE = "amount";
    private static final String COLUMN_TWO = "description";
    private static final String COLUMN_THREE = "transaction_type";
    private static final String COLUMN_FOUR = "transaction_purpose";
    private static final String COLUMN_FIVE = "date_time";


    //    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+COLUMN_ONE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_TWO+" VARCHAR(100), "+COLUMN_THREE+" INTEGER)";
//    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+COLUMN_ONE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_TWO+" VARCHAR(100), "+COLUMN_THREE+" INTEGER, "+COLUMN_FOUR+" VARCHAR(10))";
    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+COLUMN_ONE+" DOUBLE ,"+COLUMN_TWO+" VARCHAR(100), "+COLUMN_THREE+" VARCHAR(20), "+COLUMN_FOUR+" VARCHAR(20), "+COLUMN_FIVE+" VARCHAR(50))";


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
            Toast.makeText(context,"Table created successfully",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(context,"Exception : " + e,Toast.LENGTH_SHORT).show();
        }
    }



    public long insertTransaction(String amount, String description, String transaction_type, String transaction_purpose, String date_time) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ONE,amount);
        contentValues.put(COLUMN_TWO,description);
        contentValues.put(COLUMN_THREE,transaction_type);
        contentValues.put(COLUMN_FOUR,transaction_purpose);
        contentValues.put(COLUMN_FIVE,date_time);

        return sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
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




    public Cursor currentBalance(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(amount) FROM transaction_report where transaction_type='Deposit'", null);
        return cursor;
    }

    public Cursor currentExpense(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(amount) FROM transaction_report where transaction_type='Expense'", null);
        return cursor;
    }


    public Cursor displayTransaction(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select *from transaction_report ORDER BY date_time DESC", null);

        return cursor;
    }
}
