package com.example.quaresma.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoActivity extends AppCompatActivity {

    EditText edit;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        label = (TextView) findViewById(R.id.textView3);
        edit = (EditText) findViewById(R.id.editText);

        Bundle params = getIntent().getExtras();

        Boolean isPeso = params.getBoolean("tipo");
        String editValue = params.getString("dado");

        if(isPeso){
            label.setText("Peso: ");
        }else{
            label.setText("Altura: ");
        }

        edit.setText(editValue);

    }

    public void clickOk(View v){

        Intent i = new Intent();
        Bundle param = new Bundle();

        param.putDouble("resultado", Double.parseDouble(edit.getText().toString()));

        i.putExtras(param);

        setResult(RESULT_OK, i);
        finish();
    }

    public void clickCancel(View v){

        setResult(RESULT_CANCELED);
        finish();

    }



}
