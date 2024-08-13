package com.example.secondproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button_one);

        CardView cardView = findViewById(R.id.card_view);

        LinearLayout container = findViewById(R.id.container);


        button.setOnClickListener(view -> {
            //обработка клика
            if (cardView.getAlpha() == 1){
                cardView.animate().alpha(0);
            }else {
                cardView.animate().alpha(1);
            }
        });

        findViewById(R.id.button_big).setOnClickListener(view -> {
            if(container.getVisibility() == View.GONE){
                container.setVisibility(View.VISIBLE);
            }else {
                container.setVisibility(View.GONE);
            }
        });

        EditText editText = findViewById(R.id.edit_text);

        findViewById(R.id.button_circle).setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_SHORT).show();
        });
    }
}