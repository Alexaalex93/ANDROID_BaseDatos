package com.alexapplication.basedatos;

/**
 * Created by cice on 17/1/17.
 */

public class Coche {

    private int _id;
    private String _modelo;
    private Persona _persona;

    public Coche(int _id, Persona _persona, String _modelo) {
        this._id = _id;
        this._persona = _persona;
        this._modelo = _modelo;
    }

    public Coche(){}

    public Coche (int id, String modelo){
        this._id = id;
        this._modelo = modelo;
    }

    public Coche(String modelo){
        this._modelo = modelo;
    }

    public Coche(String modelo, Persona persona){
        this._persona = persona;
        this._modelo = modelo;
    }

    public Coche(int id, String modelo, Persona persona){
        this._id = id;
        this._modelo = modelo;
        this._persona = persona;
    }

    public Persona get_persona() {
        return _persona;
    }

    public void set_persona(Persona _persona) {
        this._persona = _persona;
    }

    public String get_modelo() {
        return _modelo;
    }

    public void set_modelo(String _modelo) {
        this._modelo = _modelo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
