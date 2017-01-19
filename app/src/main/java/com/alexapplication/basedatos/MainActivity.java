package com.alexapplication.basedatos;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String na = "MiBaseDatos";
        Log.d(getClass().getCanonicalName(), "NA = " + na);

        BaseDatosCochesPersona baseDatosCochesPersona = new BaseDatosCochesPersona(this, "MiDB", null, 1);

        Persona persona1 = new Persona(1, "Juan");
        Persona persona2 = new Persona(2, "Conchi");
        Persona persona3 = new Persona(3, "Manolo");

        baseDatosCochesPersona.insertarPersona(persona1);
        baseDatosCochesPersona.insertarPersona(persona2);
        baseDatosCochesPersona.insertarPersona(persona3);

        Coche coche1 = new Coche("Ferrari", persona2);
        Coche coche2 = new Coche("Renault", persona2);
        Coche coche3 = new Coche("Fiat", persona1);

        baseDatosCochesPersona.insertarCoche(coche1);
        baseDatosCochesPersona.insertarCoche(coche2);
        baseDatosCochesPersona.insertarCoche(coche3);

        List<Persona> list_personas = baseDatosCochesPersona.buscarPersona(persona2.get_nombre());

        Log.d(getClass().getCanonicalName(), "La persona " + "Juan" + " tiene: ");
        for(Persona persona: list_personas){//Para cada coches que este en la lista de coches

            Log.d(getClass().getCanonicalName(), persona.get_nombre() +" " + persona.get_id());

        }

    }
}
