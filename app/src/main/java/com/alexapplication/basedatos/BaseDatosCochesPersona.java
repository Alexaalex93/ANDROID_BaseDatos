package com.alexapplication.basedatos;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cice on 17/1/17.
 */

public class BaseDatosCochesPersona extends SQLiteOpenHelper {

    private static final String sqlCreacionTablaPersona = "CREATE TABLE PERSONA(id INTEGER PRIMARY KEY, nombre TEXT)";
    private static final String sqlCreacionTablaCoches = "CREATE TABLE COCHE(id INTEGER PRIMARY KETY AUTOINCREMENT, modelo TEXT, idpersona INTEGER, FOREING KEY (idpersona) REFERENCES PERSONA (id))";

    public  BaseDatosCochesPersona (Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreacionTablaPersona);
        db.execSQL(sqlCreacionTablaCoches);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //1 EXTRAER LOS DATOS DE LA VIEJA VERSION
        //2 CREAR LA NUEVA VERSION
        //3 COPIAR LOS DATOS VIEJOS A LA NUEVA VERSION

        //TODO POR SQL

    }

    private void cerraDataBase (SQLiteDatabase db){
        db.close();
    }

    public void insertarPersona (Persona persona){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO PERSONA (id, nombre) VALUES (" + persona.get_id() + " , " + persona.get_nombre() + ")");
        cerraDataBase(db);

    }
}
