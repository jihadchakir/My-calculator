package com.example.macalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final char add = '+';
    private static final char sub = '-';
    private static final char mul = '*';
    private static final char div = '/';
    private static final char pourcent = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;

    private double secondValue;
    private TextView inputDisp, outputDisp;
    private DecimalFormat decimalFormat;
    private MaterialButton button0, button1, button2, button3, button4, button5,  button6, button7,button8,
            button9, buttonPoin, buttonMul, buttonAdd, buttonSous, buttonDiv, buttonEgal, buttonPourcentage,
            buttonClear, buttonOFF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.#########");
        inputDisp = findViewById(R.id.input);
        outputDisp = findViewById(R.id.output);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        buttonAdd = findViewById(R.id.addition);
        buttonSous = findViewById(R.id.substraction);
        buttonDiv = findViewById(R.id.division);
        buttonMul = findViewById(R.id.multiplication);
        buttonPourcentage = findViewById(R.id.percent);
        buttonPoin = findViewById(R.id.btnPoint);
        buttonClear = findViewById(R.id.clear);
        buttonEgal = findViewById(R.id.equal);
        buttonOFF = findViewById(R.id.off);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisp.setText(inputDisp.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Callculations();
                currentSymbol = add;
                outputDisp.setText(decimalFormat.format(firstValue) + "+");
                inputDisp.setText(null);
            }
        });

        buttonSous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Callculations();
                currentSymbol = sub;
                outputDisp.setText(decimalFormat.format(firstValue) + "-");
                inputDisp.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Callculations();
                currentSymbol = mul;
                outputDisp.setText(decimalFormat.format(firstValue) + "×");
                inputDisp.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Callculations();
                currentSymbol = div;
                outputDisp.setText(decimalFormat.format(firstValue) + "÷");
                inputDisp.setText(null);
            }
        });

        buttonPourcentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Callculations();
                currentSymbol = pourcent;
                outputDisp.setText(decimalFormat.format(firstValue) + "%");
                inputDisp.setText(null);
            }
        });

        buttonPoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputDisp.setText(inputDisp.getText() + ".");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputDisp.getText().length() > 0){
                    CharSequence currentText = inputDisp.getText();
                    inputDisp.setText(currentText.subSequence(0,currentText.length() - 1));
                } else{
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputDisp.setText("");
                    outputDisp.setText("");
                }

                inputDisp.setText(inputDisp.getText() + ".");
            }
        });

        buttonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Callculations();
                outputDisp.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });

    }

    private void Callculations(){
        if(!Double.isNaN(firstValue)){
            secondValue = Double.parseDouble(inputDisp.getText().toString());
            inputDisp.setText(null);

            if(currentSymbol == add)
                firstValue = this.firstValue + secondValue;
            else if(currentSymbol == sub)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == mul)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == div)
                firstValue = this.firstValue / secondValue;
            else if (currentSymbol == pourcent)
                firstValue = this.firstValue % secondValue;
        }else{
            try{
                firstValue = Double.parseDouble(inputDisp.getText().toString());
            }catch(Exception e){

            }
        }
    }
}