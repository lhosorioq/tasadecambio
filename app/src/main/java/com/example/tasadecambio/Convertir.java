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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Convertir extends AppCompatActivity {

    private Spinner mSpinner;
    private Spinner mSpinner2;
    //private String origen;
    private TextView monedaorigen;
    //private String final;
    //private double cantidad;
    //private  double resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSpinner= (Spinner) findViewById(R.id.mSpinner);
        mSpinner2= (Spinner) findViewById(R.id.mSpinner2);

        monedaorigen = (TextView) findViewById(R.id.monedaorigen);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("COP - Pesos Colombianos");
        elementos.add("USD - Dolares Americanos");
        elementos.add("EUR - Euros");

        ArrayAdapter adp= new ArrayAdapter(Convertir.this, android.R.layout.simple_spinner_dropdown_item, elementos);

        mSpinner.setAdapter(adp);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento1 = (String) mSpinner.getAdapter().getItem(position);
                String monedainicio = elemento1.substring(0, 3);
                //monedaorigen.setText(android.R.id.input.getText());

                //final inputText monedaorigen = (inputText)findViewById(R.id.monedaorigen);
                //monedaorigen.setText();

                //Toast.makeText(Convertir.this, "Selecciono " + monedaorigen, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSpinner2.setAdapter(adp);
        mSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // validacion de errores posibles
                try{
                    String elemento1= (String) mSpinner.getAdapter().getItem(position);
                    String monedainicio = elemento1.substring(0, 3);

                    String elemento2= (String) mSpinner2.getAdapter().getItem(position);
                    String monedafinal = elemento2.substring(0, 3);

                    if ( monedaorigen != null){
                        Toast.makeText(Convertir.this, "Moneda 1 " + monedainicio + " y moneda 2" + monedafinal, Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Convertir.this, "nulo", Toast.LENGTH_SHORT).show();
                    //}else{
                        String valororigen = monedaorigen.getText().toString();
                        Long valor = new Long(valororigen);
                        Long total = new Long(0);

                        if ( monedainicio == monedafinal ) {
                            Toast.makeText(Convertir.this, "Por favor cambiar las monedas ", Toast.LENGTH_SHORT).show();
                        } else {
                            if ( monedainicio == "EUR") {
                                if ( monedafinal == "USD") {
                                    total = valor;
                                } else {

                                }
                            } else {

                            }
                            Toast.makeText(Convertir.this, "Son " + total + " " + monedafinal, Toast.LENGTH_SHORT).show();
                        }



                        //convertir(monedainicio,monedafinal,valor);
                        //Toast.makeText(Convertir.this, "Y se convertirá a " + valor, Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e){
                    Toast.makeText(Convertir.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }

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
