package com.example.tasadecambio;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Convertir extends AppCompatActivity {

    private Spinner mSpinner;
    private Spinner mSpinner2;
    private String origen;
    private String final;
    private double cantidad;
    private  double resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSpinner= (Spinner) findViewById(R.id.mSpinner);
        mSpinner2= (Spinner) findViewById(R.id.mSpinner2);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("COP - Pesos Colombianos");
        elementos.add("USD - Dolares Americanos");
        elementos.add("EUR - Euros");

        ArrayAdapter adp= new ArrayAdapter(Convertir.this, android.R.layout.simple_spinner_dropdown_item, elementos);

        private double convertir(String origen, String  final, double cantidad) {
            double resutlado = 0.0;

            if ( origen == "EUR") {
                if (final == "USD" ) {
                    resutlado = cantidad * 1.09457;
                } else {
                    resutlado = cantidad * 3735.77058;
                }
            } else {
                if ( final == "USD" ) {
                    if ( origen == "EUR") {

                    } else {

                    }
                } else {

                }
            }
        }

        mSpinner.setAdapter(adp);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) mSpinner.getAdapter().getItem(position);

                //Toast.makeText(Convertir.this, "Selecciono " + elemento, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSpinner2.setAdapter(adp);
        mSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String elemento1= (String) mSpinner.getAdapter().getItem(position);
                String monedaorigen = elemento1.substring(0, 3);

                String elemento2= (String) mSp1inner2.getAdapter().getItem(position);
                String monedafinal = elemento2.substring(0, 3);

                Toast.makeText(Convertir.this, "Y se convertirá a " + moneda2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        /*function valores(Origen, Final) {
            if ( Origen == 'EUR' ) {

            }
        }*/

    }

}
