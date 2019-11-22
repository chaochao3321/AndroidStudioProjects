package com.example.localization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        textview.setText("");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(R.string.Message);
            }
        });
    }
}
