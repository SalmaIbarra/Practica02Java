package com.example.practica02java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    DecimalFormat df = new DecimalFormat("#.00");
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnCerrar;
    private EditText txtCm;
    private EditText txtKg;
    private EditText txtImc;
    private double cm;
    private double kg;
    private double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);
        btnCerrar=(Button) findViewById(R.id.btnCerar);
        txtCm=(EditText) findViewById(R.id.txtcm);
        txtKg=(EditText) findViewById(R.id.txtkg);
        txtImc=(EditText) findViewById(R.id.txtimc);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Validación de campos
                if(txtCm.getText().toString().matches("") || txtKg.getText().toString().matches("") || txtCm.getText().toString().matches("0") || txtKg.getText().toString().matches("0"))
                {
                    Toast.makeText(MainActivity.this,"Falta Capturar Campos",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    CalcularImc();
                }

            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCm.setText("");
                txtKg.setText("");
                txtImc.setText("");
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void CalcularImc()
    {

        cm=Double.parseDouble(txtCm.getText().toString());//Parseamos el contenido
        kg=Double.parseDouble(txtKg.getText().toString());
        cm=cm/100;//Lo convertimos a metros los centimetros capturados

        imc=kg/(cm*cm);

        txtImc.setText(df.format(imc));


    }
}