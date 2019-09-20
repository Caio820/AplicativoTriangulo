package com.example.aplicativotriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private Canvas canvas;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(new CustomView(this));
        setContentView(R.layout.activity_resultado);
        Intent intent = getIntent();
        int opcao = intent.getExtras().getInt("Opçao");
        textViewResult = findViewById(R.id.textView3);

        if(opcao == 1){
            Double resultadoArea = calculaArea();
            String resultado = getStringResult(resultadoArea);
            textViewResult.setText("Área = " + resultado);
        }else{
            Double resultadoPerimetro = calculaPerimetro();
            String resultado = getStringResult(resultadoPerimetro);
            textViewResult.setText("Perímetro = " + resultado);
        }

    }

    private Double calculaArea() {
        Intent intent = getIntent();
        Double altura = intent.getExtras().getDouble("Altura");
        Double base = intent.getExtras().getDouble("Base");

        Double area = (base * altura) / 2;

        //String imcS = String.format("%.2f", imc);

        return area;
    }

    private Double calculaPerimetro(){
            Intent intent = getIntent();
            Double lado1 = intent.getExtras().getDouble("Lado 1");
            Double lado2 = intent.getExtras().getDouble("Lado 2");
            Double lado3 = intent.getExtras().getDouble("Lado 3");

            Double perimetro = lado1 + lado2 + lado3;

            //String imcS = String.format("%.2f", imc);

            return perimetro;
    }

    private String getStringResult(Double valor) {
        String sResult = valor.toString();
        int i = sResult.indexOf('.');
        sResult = sResult.substring(0,i+2);
        return sResult;
    }

}
