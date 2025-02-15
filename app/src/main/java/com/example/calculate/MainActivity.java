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
    private boolean isPlusOperation = false;
    private boolean isMinusOperation = false;
    private boolean isMultiplyOperation = false;
    private boolean isDivideOperation = false;
    private double first, second;
    private Button btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        btn_equal = findViewById(R.id.btn_equal);
    }

    public void oneClick(View view) {
        btn_equal.setEnabled(true);
        String textButton = ((MaterialButton) view).getText().toString();

        if (textButton.equals("AC")) {
            result.setText("0");
            first = 0;
            second = 0;
            isPlusOperation = false;
            isMinusOperation = false;
            isMultiplyOperation = false;
            isDivideOperation = false;
        } else if (result.getText().toString().equals("0") || isOperationClick) {
            result.setText(textButton);
        } else {
            result.append(textButton);
        }

        isOperationClick = false;
    }

    public void oneOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            first = Double.parseDouble(result.getText().toString());
            isPlusOperation = true;
            isMinusOperation = false;
            isMultiplyOperation = false;
            isDivideOperation = false;
        } else if (view.getId() == R.id.btn_minus) {
            first = Double.parseDouble(result.getText().toString());
            isMinusOperation = true;
            isPlusOperation = false;
            isMultiplyOperation = false;
            isDivideOperation = false;
        } else if (view.getId() == R.id.btn_multiply) {
            first = Double.parseDouble(result.getText().toString());
            isMultiplyOperation = true;
            isPlusOperation = false;
            isMinusOperation = false;
            isDivideOperation = false;
        } else if (view.getId() == R.id.btn_divide) {
            first = Double.parseDouble(result.getText().toString());
            isDivideOperation = true;
            isPlusOperation = false;
            isMinusOperation = false;
            isMultiplyOperation = false;
        } else if (view.getId() == R.id.btn_equal) {
            second = Double.parseDouble(result.getText().toString());

            if (isPlusOperation) {
                setResult(first + second);
            } else if (isMinusOperation) {
                setResult(first - second);
            } else if (isMultiplyOperation) {
                setResult(first * second);
            } else if (isDivideOperation) {
                if (second != 0) {
                    setResult(first / second);
                } else {
                    result.setText("ошибка");
                }
            }

            isPlusOperation = false;
            isMinusOperation = false;
            isMultiplyOperation = false;
            isDivideOperation = false;
            btn_equal.setEnabled(false);
        }

        isOperationClick = true;
    }


    private void setResult(double value) {
        if (isInteger(value)) {
            result.setText(String.valueOf((int) value));
        } else {
            result.setText(String.valueOf(value));
        }
    }

    private boolean isInteger(double value) {
        return value == (int) value;
    }

    public void onDotClick(View view) {
        String currentText = result.getText().toString();
        if (!currentText.contains(".")) {
            result.append(".");
        }
    }
}