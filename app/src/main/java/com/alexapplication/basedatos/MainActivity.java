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

        baseDatosCochesPersona.insetarCoche(coche1);
        baseDatosCochesPersona.insetarCoche(coche2);
        baseDatosCochesPersona.insetarCoche(coche3);

        List<Coche> lista_coches = baseDatosCochesPersona.buscarCochesPersona(persona2);

        Log.d(getClass().getCanonicalName(), "La persona " + persona2.get_nombre() + " tiene: ");
        for(Coche coche:lista_coches){//Para cada coches que este en la lista de coches

            Log.d(getClass().getCanonicalName(), coche.get_modelo());

        }

    }
}
