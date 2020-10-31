package com.ftassara.courseraunam_datosusuario.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context mContext;
    public BaseDatos (Context context){
        super(context,ConstantesDB.DATABASE_NAME,null,ConstantesDB.DATABASE_VERSION);
        this.mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto="CREATE TABLE IF NOT EXISTS "+ ConstantesDB.TABLE_NAME_MASCOTAS +
                " ("+
                ConstantesDB.TABLE_MASCOTAS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesDB.TABLE_MASCOTAS_NOMBRE+" TEXT, "+
                ConstantesDB.TABLE_MASCOTAS_FOTO+" INTEGER"+
                ")";

        String queryCrearTablaRating="CREATE TABLE IF NOT EXISTS "+ ConstantesDB.TABLE_NAME_RATING +
                " ("+
                ConstantesDB.TABLE_RATING_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesDB.TABLE_RATING_MASCOTA_ID+" INTEGER, "+
                ConstantesDB.TABLE_MASCOTAS_RATING+" INTEGER, "+
                "FOREIGN KEY ("+ConstantesDB.TABLE_RATING_MASCOTA_ID+") "+
                "REFERENCES "+ConstantesDB.TABLE_NAME_MASCOTAS+"("+ConstantesDB.TABLE_MASCOTAS_ID+")"+")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaRating);

        Log.d("BaseDatos","Creo Tablas");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ConstantesDB.TABLE_NAME_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS "+ConstantesDB.TABLE_NAME_RATING);
        onCreate(db);
        Log.d("BaseDatos","onUpgrade");
    }

    public ArrayList<Mascotas> obtenerMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesDB.TABLE_NAME_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while  (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesDB.TABLE_MASCOTAS_RATING+")" +
                    " FROM " + ConstantesDB.TABLE_NAME_RATING +
                    " WHERE " + ConstantesDB.TABLE_RATING_MASCOTA_ID + "="+mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRating(registrosLikes.getInt(0));
            }else {
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_NAME_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarRatings(ContentValues contentValues){
        SQLiteDatabase db =this.getWritableDatabase();
        db.insert(ConstantesDB.TABLE_NAME_RATING,null,contentValues);
        Log.d("BaseDatos","Inserto Ratings");
        db.close();
    }

    public int obtenerRating(Mascotas mascotas){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesDB.TABLE_MASCOTAS_RATING+")" +
                " FROM " + ConstantesDB.TABLE_NAME_RATING +
                " WHERE " + ConstantesDB.TABLE_RATING_MASCOTA_ID + "="+mascotas.getId();

        SQLiteDatabase db = this.getWritableDatabase();
            Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public ArrayList<Mascotas> obtenerFavMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();


        String query = "SELECT DISTINCT "+
                ConstantesDB.TABLE_RATING_MASCOTA_ID+", "+
                ConstantesDB.TABLE_MASCOTAS_NOMBRE+", "+
                ConstantesDB.TABLE_MASCOTAS_FOTO+", "+
                ConstantesDB.TABLE_MASCOTAS_RATING
                +" FROM "+ ConstantesDB.TABLE_NAME_MASCOTAS+
                " LEFT JOIN "+ConstantesDB.TABLE_NAME_RATING+" ON ("+
                ConstantesDB.TABLE_NAME_RATING+"."+ConstantesDB.TABLE_RATING_MASCOTA_ID+
                "="+
                ConstantesDB.TABLE_NAME_MASCOTAS+"."+ConstantesDB.TABLE_MASCOTAS_ID+
                ") ORDER BY "+ConstantesDB.TABLE_MASCOTAS_RATING+" DESC LIMIT 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while  (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesDB.TABLE_MASCOTAS_RATING+")" +
                    " FROM " + ConstantesDB.TABLE_NAME_RATING +
                    " WHERE " + ConstantesDB.TABLE_RATING_MASCOTA_ID + "="+mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRating(registrosLikes.getInt(0));
            }else {
                mascotaActual.setRating(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        Log.d("BaseDatos","query fav mascotas exitosa");
        return mascotas;
    }
}
