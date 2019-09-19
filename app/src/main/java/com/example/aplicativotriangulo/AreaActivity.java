package com.example.aplicativotriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AreaActivity extends AppCompatActivity {

    private Button buttonCalculaArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        buttonCalculaArea = findViewById(R.id.buttonCalcularArea);
        buttonCalculaArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AreaActivity.this, ResultadoActivity.class);
                Double altura = getAltura();
                Double base = getBase();

                if (altura <= 0 || base <= 0) {
                    showMessage("Insira um valor maior que 0 nos dois campos.");
                } else {
                    intent.putExtra("Altura", getAltura());
                    intent.putExtra("Peso", getBase());
                    startActivity(intent);
                }
            }
        });

    }

    private Double getAltura() {

        try {
            EditText text = findViewById(R.id.editTextAltura);
            Double altura = Double.parseDouble(text.getText().toString());
            return altura;
        } catch (Exception e) {
            return 0.0;
        }
    }

    private Double getBase() {

        try {
            EditText text = findViewById(R.id.editTextBase);
            Double base = Double.parseDouble(text.getText().toString());
            return base;
        } catch (Exception e) {
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
