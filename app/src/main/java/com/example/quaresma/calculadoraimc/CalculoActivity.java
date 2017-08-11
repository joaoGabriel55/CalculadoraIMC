package com.example.quaresma.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoActivity extends AppCompatActivity {

    TextView label;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        label = (TextView) findViewById(R.id.textView3);
        edit = (EditText) findViewById(R.id.editText);

        Bundle params = getIntent().getExtras();

        Boolean isPeso = params.getBoolean("tipo");
        //String editValue = dados.getString("calculo");

        if (isPeso){
            label.setText("Peso:");
            String valor = params.getString("calculo");
            edit.setText(valor);
        }else{
            label.setText("Altura:");
            String valor = params.getString("calculo");
            edit.setText(valor);
        }

    }

    public void clickOk(View v){
        Intent i = new Intent();
        Bundle param = new Bundle();

        param.putString("calculo", edit.getText().toString());

        i.putExtras(param);

        setResult(RESULT_OK, i);
        finish();
    }

    public void clickCancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}
