package com.example.calculate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView resultOperation=findViewById(R.id.resultOperation);
        String result = getIntent().getStringExtra("result_key");
        resultOperation.setText(result );

        Button btnNext = findViewById(R.id.next);
        ImageView imgHeart = findViewById(R.id.heart);
        imgHeart.setOnClickListener(v -> {
            Boolean isLiked = (Boolean) imgHeart.getTag();
            if(isLiked == null) {
                isLiked = false;
            }
            if(!isLiked) {
                imgHeart.setImageResource(R.drawable.goida1);
                imgHeart.setTag(true);
            } else {
                imgHeart.setImageResource(R.drawable.ukrai);
                imgHeart.setTag(false);
            }
        });
        btnNext.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}