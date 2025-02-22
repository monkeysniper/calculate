package com.example.calculate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btnResultActivity;
    private int firstOperand, secondOperand;
    private boolean isOperationClick;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.result);
        btnResultActivity = findViewById(R.id.btn_result);

        btnResultActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("result_key", textView.getText().toString());
            startActivity(intent);
        });
    }

    public void oneClick(View view) {
        if (btnResultActivity.getVisibility() == View.VISIBLE) {
            btnResultActivity.setVisibility(View.GONE);
        }

        String textButton = ((MaterialButton) view).getText().toString();

        if (textButton.equals("AC")) {
            textView.setText("0");
            firstOperand = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOperationClick = false;
    }

    public void oneOperationClick(View view) {
        if (view.getId() != R.id.btn_equal && btnResultActivity.getVisibility() == View.VISIBLE) {
            btnResultActivity.setVisibility(View.GONE);
        }

        if (view.getId() == R.id.btn_plus) {
            firstOperand = Integer.parseInt(textView.getText().toString());
            operator = "+";
        } else if (view.getId() == R.id.btn_minus) {
            firstOperand = Integer.parseInt(textView.getText().toString());
            operator = "-";
        } else if (view.getId() == R.id.btn_multiply) {
            firstOperand = Integer.parseInt(textView.getText().toString());
            operator = "*";
        } else if (view.getId() == R.id.btn_divide) {
            firstOperand = Integer.parseInt(textView.getText().toString());
            operator = "/";
        } else if (view.getId() == R.id.btn_equal) {
            secondOperand = Integer.parseInt(textView.getText().toString());
            int result = 0;

            if (operator.equals("+")) {
                result = firstOperand + secondOperand;
            } else if (operator.equals("-")) {
                result = firstOperand - secondOperand;
            } else if (operator.equals("*")) {
                result = firstOperand * secondOperand;
            } else if (operator.equals("/")) {
                result = firstOperand / secondOperand;
            }
            textView.setText(String.valueOf(result));
            btnResultActivity.setVisibility(View.VISIBLE);
        }
        isOperationClick = true;
    }

}