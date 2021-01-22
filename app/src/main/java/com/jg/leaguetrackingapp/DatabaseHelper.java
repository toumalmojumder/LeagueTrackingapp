package com.jg.leaguetrackingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jg.leaguetrackingapp.Model.Player;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "player";
    private static final String COL1 = "_id";
    private static final String COL2 = "name";
    private static final String COL3 = "wins";
    private static final String COL4 = "losses";
    private static final String COL5 = "ties";



    public DatabaseHelper(@Nullable Context context) {
        super(context,TABLE_NAME,null,1);

    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME+ " ("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL2 + " TEXT, "+
                COL3 + " INTEGER, "+
                COL4 + " INTEGER, "+
                COL5 + " INTEGER)"
                ;
        sqLiteDatabase.execSQL(createTable);
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,"joel");
        contentValues.put(COL3,0);
        contentValues.put(COL4,0);
        contentValues.put(COL5,0);
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public boolean addData(String name,int wins, int looses, int ties){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,wins);
        contentValues.put(COL4,looses);
        contentValues.put(COL5,ties);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }



    public boolean updateData(String id,String name,int wins, int looses, int ties){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,wins);
        contentValues.put(COL4,looses);
        contentValues.put(COL5,ties);


        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where _id = ?",new String[]{id});
        if(cursor.getCount()>0){
    long result = db.update(TABLE_NAME, contentValues,"_id= ?",new String[]{id});
    if(result == -1){
        return false;
    }
    else{
        return true;
    }
}
else{
    return false;
}


    }
    public boolean updateScore(String name,int wins, int looses, int ties){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL3,wins);
        contentValues.put(COL4,looses);
        contentValues.put(COL5,ties);


        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where name = ?",new String[]{name});
        if(cursor.getCount()>0){
            long result = db.update(TABLE_NAME, contentValues,"name= ?",new String[]{name});
            if(result == -1){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }


    }



    public boolean deleteData(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where name = ?",new String[]{name});

        if(cursor.getCount()>0){
            long result = db.delete(TABLE_NAME,"name=?",new String[]{name});
            if(result == -1){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }

   /* public Cursor getdata(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME ,null);
        return cursor;
    }*/

   public ArrayList<Player> getAllData() {
       ArrayList<Player> arrayList = new ArrayList<>();
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);

       while (cursor.moveToNext()) {
           int id = cursor.getInt(0);
           String name = cursor.getString(1);
           int win = cursor.getInt(2);
           int losses = cursor.getInt(3);
           int ties = cursor.getInt(4);
           Player player = new Player(id, name, win, losses, ties);
           arrayList.add(player);

       }
       return arrayList;
   }
}
