package com.example.aplicativotriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonEscolher;
    private Boolean area = false, perimetro = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox checkBoxArea = findViewById(R.id.checkBoxArea);
        final CheckBox checkBoxPerimetro = findViewById(R.id.checkBoxPerimetro);

        checkBoxArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxArea.isChecked()) {
                    area = true;
                }else{
                    area = false;
                }
            }
        });
        checkBoxPerimetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxPerimetro.isChecked()) {
                    perimetro = true;
                }else {
                    perimetro = false;
                }
            }
        });

        buttonEscolher = findViewById(R.id.buttonEscolher);
        buttonEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(area == true && perimetro == false){
                    Intent intent = new Intent(MainActivity.this, AreaActivity.class);
                    startActivity(intent);
                }else if (perimetro == true && area == false){
                    Intent intent = new Intent(MainActivity.this, PerimetroActivity.class);
                    startActivity(intent);
                }else if (area == false && perimetro == false){
                    showMessage("Marque uma opção.");
                }else  {
                    showMessage("Selecione apenas uma opção.");
                }
            }
        });

    }

    private void showMessage(String mensagem) {

        Context context = getApplicationContext();
        String text = mensagem;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
