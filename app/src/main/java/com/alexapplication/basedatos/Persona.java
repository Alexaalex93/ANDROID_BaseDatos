package com.alexapplication.basedatos;

/**
 * Created by cice on 17/1/17.
 */

public class Persona {

    private int _id;
    private String _nombre;


    public Persona(){
        this._id = 0;
        this._nombre = null;

    }
    public Persona(int _id, String _nombre) {
        this._id = _id;
        this._nombre = _nombre;
    }

    public Persona(int _id) {
        this._id = _id;
    }

    public Persona(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
