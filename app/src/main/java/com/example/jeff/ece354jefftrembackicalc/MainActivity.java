package com.example.jeff.ece354jefftrembackicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;
import java.lang.*;




public class MainActivity extends AppCompatActivity {



    //assignment variables
    TextView result;
    EditText operand1, operand2;
    Button plus, minus, asterisk, slash, power, root, clear;

    double result_num;
    int op1, op2;
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


        //assignment stuff
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                String exp = operand1.getText().toString();

                Stack<String> ops = new Stack<String>();
                Stack<Double> vals = new Stack<Double>();

                for(int i = 0; i < exp.length; i++) {
                    String s = exp[i];
                    if (s.equals("(")) {
                    }
                    else if (s.equals("+") || s.equals("*")) {
                        ops.push(s);
                    } else if (s.equals(")")) {
                        getComp(ops, vals);
                    } else {
                        vals.push(Double.parseDouble(s));
                    }
                }
                getComp(ops, vals);
                System.out.println(vals.pop());
            }

                private static void getComp(Stack<String> ops, Stack<Double> vals) {
                    String op = ops.pop();
                    if (op.equals("+")) {
                        vals.push(vals.pop() + vals.pop());
                    } else if (op.equals("*")) {
                        vals.push(vals.pop() * vals.pop());
                    }
                }
            }

                */

                op1 = Integer.parseInt(operand1.getText().toString());
                op2 = Integer.parseInt(operand2.getText().toString());
                result_num = op1 + op2;
                result.setText(String.valueOf(result_num));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1 = Integer.parseInt(operand1.getText().toString());
                op2 = Integer.parseInt(operand2.getText().toString());
                result_num = op1 - op2;
                result.setText(String.valueOf(result_num));
            }
        });

        asterisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1 = Integer.parseInt(operand1.getText().toString());
                op2 = Integer.parseInt(operand2.getText().toString());
                result_num = op1 * op2;
                result.setText(String.valueOf(result_num));
            }
        });

        slash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1 = Integer.parseInt(operand1.getText().toString());
                op2 = Integer.parseInt(operand2.getText().toString());
                if(op2 == 0){
                    result.setText("Error: division by 0");
                }
                else{
                    result_num = op1 / op2;
                    result.setText(String.valueOf(result_num));
                }
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operand1 != null && operand1.getText() != null) {
                    op3 = Double.parseDouble(operand1.getText().toString());
                }
                if(op3 < 0){
                    result.setText("Error: Operand 1 must be positive");
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
                    op3 = Double.parseDouble(operand1.getText().toString());
                }
                if(operand2 != null && operand2.getText() != null) {
                    op4 = Double.parseDouble(operand2.getText().toString());
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
