package com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DAVID OGUNDEPO on 05/18/2017.
 *
 */

public class FoodHistoryDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "StudentsFoodA.db";
    public static final String DESK_NAME = "studentsfood_desk";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "WHITE-RICE";
    public static final String COL_3 = "JOLLOF-RICE";
    public static final String COL_4 = "FRIED-RICE";
    public static final String COL_5 = "BEEF";
    public static final String COL_6 = "CHICKEN";
    public static final String COL_7 = "MOI-MOI";
    public static final String COL_8 = "PLANTAIN";
    public static final String COL_9 = "EGG";
    public static final String COL_10 = "COLESLAW";
    public static final String COL_11 = "BEANS";



    public FoodHistoryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create desk " + DESK_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,SURNAME TEXT, MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP DESK IF EXISTS"+DESK_NAME);
        onCreate(db);
    }

    public boolean insertFoodKiaKia(String white, String jollof, String fried, String eran, String sheekeen, String moimoi, String dodo, String eyin, String salad, String ewa) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, white);
        values.put(COL_3, jollof);
        values.put(COL_4, fried);
        values.put(COL_5, eran);
        values.put(COL_6, sheekeen);
        values.put(COL_7, moimoi);
        values.put(COL_8, dodo);
        values.put(COL_9, eyin);
        values.put(COL_10, salad);
        values.put(COL_11, ewa);
        long howLong = database.insert(DESK_NAME, null, values);
        if (howLong== -1)
            return false;
        else
            return true;
    }

    public Cursor getFoodKiaKia() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DESK_NAME, null);
        return cursor;
    }
}
