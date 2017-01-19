package com.alexapplication.basedatos;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cice on 17/1/17.
 */

public class BaseDatosCochesPersona extends SQLiteOpenHelper {

    private static final String sqlCreacionTablaPersona = "CREATE TABLE PERSONA(id INTEGER PRIMARY KEY, nombre TEXT)";
    private static final String sqlCreacionTablaCoches = "CREATE TABLE COCHE(id INTEGER PRIMARY KEY AUTOINCREMENT, modelo TEXT, idpersona INTEGER, FOREIGN KEY (idpersona) REFERENCES PERSONA (id))";

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

    private void cerrarDataBase (SQLiteDatabase db){
        db.close();
    }

    public void insertarPersona (Persona persona){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO PERSONA (id, nombre) VALUES (" + persona.get_id() + " , '" + persona.get_nombre() + "')"); //TEXTO COMO ES LITERAL ENTRE COMILLAS SIMPLES
        cerrarDataBase(db);

    }

    public void insertarCoche (Coche coche){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO COCHE (modelo, idpersona) VALUES ('" + coche.get_modelo() + "', " + coche.get_persona().get_id() + ") "); //Falt comillas
        cerrarDataBase(db);

    }
    public List<Persona> buscarPersona (String name){

        List<Persona> list_persona = null;
        String consulta = "SELECT id FROM PERSONA WHERE nombre = '" + name + "' ";
        Persona persona = null;
        String modelo = null;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(consulta, null);

        if (cursor != null && cursor.getCount() >= 0){

            cursor.moveToFirst();
            list_persona = new ArrayList<>(cursor.getCount());

            do {

                 modelo = cursor.getString(0);
                persona = new Persona(modelo);
                list_persona.add(persona);

            }while(cursor.moveToNext());

            cursor.close();

        }

        this.cerrarDataBase(db);

        return  list_persona;
    }

    public List<Coche> buscarCochesPersona (Persona persona){

        List<Coche> lista_coches = null;
        String modelo = null;
        String consulta = "SELECT modelo FROM COCHE WHERE idpersona = " + persona.get_id(); //Consulta a la base de datos
        Coche coche_aux = null;

        SQLiteDatabase db = this.getReadableDatabase(); //Esta vez únicamente necesitas leer
        Cursor cursor = db.rawQuery(consulta, null);//La base de datos te devuelve un cursor

        if (cursor != null && cursor.getCount() >= 0){
            //La consulta ha recuperado datos
            cursor.moveToFirst();
            lista_coches = new ArrayList<Coche>(cursor.getCount());
            //Puedes declararlo como LinkedList. No haria falta declarar tamaño, ya que se pone como tamaño 1 y va aumentando poco a poco

            do {
                modelo = cursor.getString(0); //Como solo le he dicho que quieres el modelo será la posicion 0
                coche_aux = new Coche(modelo);
                lista_coches.add(coche_aux);
            }while(cursor.moveToNext()); //Eso devuelve un boolean, mientras sea true sigue iterando

            cursor.close();//Ceramos el cursor

        }
         //Ya que he usado la base de datos, la cierro
        this.cerrarDataBase(db);

        return  lista_coches;
    }
}
