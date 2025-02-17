package com.example.calculate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private boolean isOperationClick;
    private int first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
    }

    public void oneClick(View view) {
        String textButton = ((MaterialButton) view).getText().toString();
        if (textButton.equals("AC")) {
            result.setText("0");
        } else if (result.getText().toString().equals("0") || isOperationClick) {
            result.setText(textButton);
        } else {
            result.append(textButton);
        }
        isOperationClick = false;
    }

    public void oneOperationClick(View view) {
        if (view.getId() == R.id.btn_minus) {
            //нажимаем на минус
            first = Integer.parseInt(result.getText().toString());

        } else if (view.getId() == R.id.btn_plus) {
            //нажимаем на плюс
            first = Integer.parseInt(result.getText().toString());
        }else if (view.getId() == R.id.btn_divide) {
            //нажимаем на деление
            first = Integer.parseInt(result.getText().toString());
        } else if (view.getId() == R.id.btn_multiply) {
            //нажимаем на умножение
            first = Integer.parseInt(result.getText().toString());
        } else if (view.getId() == R.id.btn_equal) {
            //нажимаем на равно
            second = Integer.parseInt(result.getText().toString());


            int minus = first - second;
            int plus = first + second;
            int divide = first * second;
            int multiplication = first / second;
            result.setText(String.valueOf(minus));
            result.setText(String.valueOf(plus));
            result.setText(String.valueOf(divide));
            result.setText(String.valueOf(multiplication));
        }
        isOperationClick = true;

    }

    public void onDotClick(View view) {
    }
}


