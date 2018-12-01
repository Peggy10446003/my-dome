package com.example.alex.viewpagertest1;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2018/7/11.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static String DB_PATH ="";
    private static String DB_NAME="Glossary.db";
    private SQLiteDatabase mDataBase;
    private Context mcontext = null;

    public DbHelper(Context context) {
        super(context, DB_NAME, null ,1);
//        if(Build.VERSION.SDK_INT >= 17){
//            DB_PATH = context.getApplicationInfo().dataDir+"/database/";
//        }else{
//
//        }
        DB_PATH = "/data/data/com.example.alex.viewpagertest1/databases/";
        mcontext = context;
    }

    @Override
    public synchronized void close() {
        if(mDataBase != null){
            mDataBase.close();
        }
        super.close();
    }

    private boolean checkDataBase(){
        SQLiteDatabase tempDB = null;
        try{
            String path = DB_PATH + DB_NAME;
            tempDB = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
        }catch(Exception e){}
        if(tempDB != null) {
                tempDB.close();
        }
        return tempDB!=null?true:false;
    }

    public void copyDataBase(){
        try{
            InputStream myInput = mcontext.getAssets().open(DB_NAME);
            String outputFileName = DB_PATH + DB_NAME;
            OutputStream myOutput = new FileOutputStream(outputFileName);
            byte[] buffer = new byte[1024];
            int length;
            while( (length=myInput.read(buffer)) > 0){
                myOutput.write(buffer,0,length);
            }

            myOutput.flush();
            myOutput.close();
            myInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openDataBase(){
        String path = DB_PATH+DB_NAME;
        mDataBase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public void createDataBase(){
        boolean isDBExist = checkDataBase();
        if(isDBExist){

        }else{
            this.getReadableDatabase();
            try{
                copyDataBase();
            }catch(Exception e){

            }
        }
    }

    public List<Theme> getAllThemes(){
        List<Theme> temp = new ArrayList<Theme>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try{
            c = db.rawQuery("SELECT * FROM themes",null);
            if(c==null){
                return null;
            }
            c.moveToFirst();
            do{
                Theme theme = new Theme(c.getInt(c.getColumnIndex("_id")),c.getString(c.getColumnIndex("theme")),c.getString(c.getColumnIndex("catalog")));
                temp.add(theme);
            }while(c.moveToNext());
            c.close();

        }catch(Exception e){

        }
        db.close();
        return temp;
    }

    public List<Word> searchWord(String sword){
        List<Word> temp = new ArrayList<Word>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try{
            if(sword.length() >= 1){
                c = db.query(true, "Glossary" , new String[] { "_id", "Word", "Chinese", "Detail_Text"}, "Word Like '" + sword + "%'", null, "Word", null, null, null);
                //c = db.rawQuery("SELECT _id, Distinct Word, Chinese, Detail_Text FROM Glossary WHERE Word Like '" + sword + "%' GROUP BY Word",null);
            if(c==null){
                Log.d("sql","return null");
                return null;
            }
            c.moveToFirst();
            do{
                Word word = new Word(c.getInt(c.getColumnIndex("_id")),c.getString(c.getColumnIndex("Word")),c.getString(c.getColumnIndex("Chinese")),c.getString(c.getColumnIndex("Detail_Text")));
                temp.add(word);
            }while(c.moveToNext());

            c.close();
            }
        }catch(Exception e){

        }

        db.close();
        return temp;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
