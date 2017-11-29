package com.example.jeff.ece354jefftrembackicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;

public class MainActivity extends AppCompatActivity {

    //assignment variables
    TextView result;
    EditText operand1, operand2;
    Button plus, minus, asterisk, slash, power, root, clear;

    double result_num;
    double op3, op4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assignment stuff
        result = (TextView)findViewById(R.id.result);
        operand1 = (EditText)findViewById(R.id.operand1);
        operand2 = (EditText)findViewById(R.id.operand2);

        //assignment stuff
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        asterisk = (Button)findViewById(R.id.asterisk);
        slash = (Button)findViewById(R.id.slash);
        root = (Button)findViewById(R.id.root);
        power = (Button)findViewById(R.id.power);
        clear = (Button)findViewById(R.id.clear);

        final EvaluateString opstring = new EvaluateString();

        //assignment stuff
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op3 = opstring.evaluate(operand1.getText().toString());
                op4 = opstring.evaluate(operand2.getText().toString());
                result_num = op3 + op4;
                result.setText(String.valueOf(result_num));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op3 = opstring.evaluate(operand1.getText().toString());
                op4 = opstring.evaluate(operand2.getText().toString());
                result_num = op3 - op4;
                result.setText(String.valueOf(result_num));
            }
        });

        asterisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op3 = opstring.evaluate(operand1.getText().toString());
                op4 = opstring.evaluate(operand2.getText().toString());
                result_num = op3 * op4;
                result.setText(String.valueOf(result_num));
            }
        });

        slash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op3 = opstring.evaluate(operand1.getText().toString());
                op4 = opstring.evaluate(operand2.getText().toString());
                if(op4 == 0.0){
                    result.setText("Error: division by 0");
                    android.widget.Toast.makeText(MainActivity.this, "Error: Division by zero not allowed!", android.widget.Toast.LENGTH_LONG).show();
                }
                else{
                    result_num = op3 / op4;
                    result.setText(String.valueOf(result_num));
                }
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operand1 != null && operand1.getText() != null) {
                    op3 = opstring.evaluate(operand1.getText().toString());
                }
                if(op3 < 0.0){
                    result.setText("Error: Operand 1 must be positive");
                    android.widget.Toast.makeText(MainActivity.this, "Error: Operand 1 must be postive!", android.widget.Toast.LENGTH_LONG).show();
                }
                else {
                    result_num = java.lang.Math.pow(op3, 0.5);
                    result.setText("SQRT("+ op3 +") = " + String.valueOf(result_num));
                }
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operand1 != null && operand1.getText() != null) {
                    op3 = opstring.evaluate(operand1.getText().toString());

                }
                if(operand2 != null && operand2.getText() != null) {
                    op4 = opstring.evaluate(operand2.getText().toString());
                }
                result_num = java.lang.Math.pow(op3, op4);
                result.setText(String.valueOf(result_num));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand1.setText("");
                operand2.setText("");
                result.setText("");
            }
        });
    }
}
