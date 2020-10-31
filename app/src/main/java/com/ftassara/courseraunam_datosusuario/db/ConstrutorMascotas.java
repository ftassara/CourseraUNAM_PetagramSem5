package com.ftassara.courseraunam_datosusuario.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import java.util.ArrayList;

public class ConstrutorMascotas {
    private Context mContext;
    private static final int LIKE = 1;
    public ConstrutorMascotas(Context context) {
        this.mContext=context;
    }

    public ArrayList<Mascotas> obtenerMascotas(){

        BaseDatos db = new BaseDatos(mContext);
//        insertarMascotas(db);
        Log.d("ConstructorMascotas","InsertoMascotas");
        return db.obtenerMascotas();
    }

    public ArrayList<Mascotas> obtenerFavMascotas(){

        BaseDatos db = new BaseDatos(mContext);
        insertarMascotas(db);
        Log.d("ConstructorMascotas","obtenerFavMascotas");
        return db.obtenerFavMascotas();
    }
    public void insertarMascotas (BaseDatos db){
        ContentValues contentValues =new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro A");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro1);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro B");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro2);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro C");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro2);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro D");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro1);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro E");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro2);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro F");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro1);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro G");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro2);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro H");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro1);
        db.insertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_NOMBRE,"Perro I");
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_FOTO,R.drawable.perro2);
        db.insertarMascotas(contentValues);


    }
    public void darLikeCotnacto(Mascotas mascota){
        BaseDatos db = new BaseDatos(mContext);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLE_RATING_MASCOTA_ID, mascota.getId());
        contentValues.put(ConstantesDB.TABLE_MASCOTAS_RATING, LIKE);
        db.insertarRatings(contentValues);
    }

    public int obtenerRating(Mascotas mascota){
        BaseDatos db = new BaseDatos(mContext);
        return db.obtenerRating(mascota);
    }

}

