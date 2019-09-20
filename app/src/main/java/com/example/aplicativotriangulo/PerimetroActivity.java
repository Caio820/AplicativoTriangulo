package com.example.aplicativotriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PerimetroActivity extends AppCompatActivity {

    private Button buttonCalculaPerimetro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimetro);
        buttonCalculaPerimetro = findViewById(R.id.buttonCalcularPerimetro);
        buttonCalculaPerimetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerimetroActivity.this, ResultadoActivity.class);
                Double ladoA = getLado1();
                Double ladoB = getLado2();
                Double ladoC = getLado3();

                if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
                    showMessage("Insira um valor maior que 0 nos três campos.");
                } else {
                    intent.putExtra("Lado 1", getLado1());
                    intent.putExtra("Lado 2", getLado2());
                    intent.putExtra("Lado 3" , getLado3());
                    intent.putExtra("Opçao" , 2);
                    startActivity(intent);
                }
            }
        });

    }

    private Double getLado1() {

        try {
            EditText text = findViewById(R.id.editTextLado1);
            Double ladoA = Double.parseDouble(text.getText().toString());
            return ladoA;
        } catch (Exception e) {
            return 0.0;
        }
    }

    private Double getLado2() {

        try {
            EditText text = findViewById(R.id.editTextLado2);
            Double ladoB = Double.parseDouble(text.getText().toString());
            return ladoB;
        } catch (Exception e) {
            return 0.0;
        }

    }

    private Double getLado3(){

        try {
            EditText text = findViewById(R.id.editTextLado3);
            Double ladoC = Double.parseDouble(text.getText().toString());
            return ladoC;
        } catch (Exception e){
            return 0.0;
        }
    }

    private void showMessage(String mensagem){

        Context context = getApplicationContext();
        String text = mensagem;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
