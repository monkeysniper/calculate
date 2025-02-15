package com.example.calculate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private boolean isOperationClick;
    private boolean isPlusOperation = false;
    private boolean isMinusOperation = false;
    private int first, second;
    private Button btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result = findViewById(R.id.result);
        btn_equal = findViewById(R.id.btn_equal);
    }

    // Метод для обработки нажатия на цифры и кнопки очистки
    public void oneClick(View view) {
        btn_equal.setEnabled(true);
        String textButton = ((MaterialButton) view).getText().toString();

        // Проверка на кнопку очистки "AC"
        if (textButton.equals("AC")) {
            result.setText("0");
            first = 0;
        } else if (result.getText().toString().equals("0") || isOperationClick) {
            result.setText(textButton);
        } else {
            result.append(textButton);
        }

        isOperationClick = false;
    }

    // Метод для обработки нажатия на операции
    public void oneOperationClick(View view) {
        if (view.getId() == R.id.btn_plus) {
            first = Integer.parseInt(result.getText().toString());
            isPlusOperation = true;  // Устанавливаем флаг для сложения
            isMinusOperation = false;  // Сбрасываем флаг для вычитания
        } else if (view.getId() == R.id.btn_minus) {
            first = Integer.parseInt(result.getText().toString());
            isMinusOperation = true;  // Устанавливаем флаг для вычитания
            isPlusOperation = false;  // Сбрасываем флаг для сложения
        } else if (view.getId() == R.id.btn_equal) {
            second = Integer.parseInt(result.getText().toString());

            // Проверяем, какой флаг установлен, и выполняем соответствующую операцию
            if (isPlusOperation) {
                int sum = first + second;
                result.setText(String.valueOf(sum));
            } else if (isMinusOperation) {
                int difference = first - second;
                result.setText(String.valueOf(difference));
            }

            btn_equal.setEnabled(false);
        }

        isOperationClick = true;
    }
}