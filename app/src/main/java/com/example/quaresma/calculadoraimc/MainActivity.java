package com.example.quaresma.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int PESO = 1;
    public static int ALTURA = 2;

    TextView peso;
    TextView altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = (TextView) findViewById(R.id.textView8);
        altura = (TextView) findViewById(R.id.textView7);

    }

    public void clickPeso(View v){

        Intent intent = new Intent(this,CalculoActivity.class);
        Bundle params = new Bundle();

        TextView peso = (TextView) findViewById(R.id.textView8);

        params.putString("calculo", peso.getText().toString());
        params.putBoolean("tipo", true);

        intent.putExtras(params);

        startActivityForResult(intent, PESO);
    }

    public void clickAltura(View v){

        Intent intent = new Intent(this,CalculoActivity.class);
        Bundle params = new Bundle();

        TextView altura = (TextView) findViewById(R.id.textView7);

        params.putString("calculo", altura.getText().toString());
        params.putBoolean("tipo", false);

        intent.putExtras(params);

        startActivityForResult(intent, ALTURA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ALTURA) {
            if (resultCode == RESULT_OK) {

                altura.setText(data.getStringExtra("resultado"));

            } else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        } else if (resultCode == PESO) {
            if (resultCode == RESULT_OK) {

                peso.setText(data.getStringExtra("resultado"));

            } else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void calcula(View v){

        Double num_peso = Double.parseDouble(peso.getText().toString());
        Double num_altura = Double.parseDouble(altura.getText().toString());

        Double result = num_peso / (num_altura * num_peso);

        TextView textResult = (TextView) findViewById(R.id.textView6);
        textResult.setText(String.format("Seu IMC é: %.2f " , result));
    }

}
