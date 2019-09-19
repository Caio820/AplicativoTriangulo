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
                Double ladoA = getLadoA();
                Double ladoB = getLadoB();
                Double ladoC = getLadoC();

                if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
                    showMessage("Insira um valor maior que 0 nos três campos.");
                } else {
                    intent.putExtra("Lado A", getLadoA());
                    intent.putExtra("Lado B", getLadoB());
                    intent.putExtra("Lado C" , getLadoC());
                    startActivity(intent);
                }
            }
        });

    }

    private Double getLadoA() {

        try {
            EditText text = findViewById(R.id.editTextLadoA);
            Double ladoA = Double.parseDouble(text.getText().toString());
            return ladoA;
        } catch (Exception e) {
            return 0.0;
        }
    }

    private Double getLadoB() {

        try {
            EditText text = findViewById(R.id.editTextLadoB);
            Double ladoB = Double.parseDouble(text.getText().toString());
            return ladoB;
        } catch (Exception e) {
            return 0.0;
        }

    }

    private Double getLadoC(){

        try {
            EditText text = findViewById(R.id.editTextLadoC);
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
