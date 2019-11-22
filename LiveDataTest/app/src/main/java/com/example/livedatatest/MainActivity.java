package com.example.livedatatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewModelWithLiveData viewModelWithLiveData;
    TextView textView;
    ImageButton imageButtonLiked,imageButtonDisliked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButtonDisliked = findViewById(R.id.imageButton);
        imageButtonLiked = findViewById(R.id.imageButton2);
        textView = findViewById(R.id.textView);
        viewModelWithLiveData = ViewModelProviders.of(this).get(ViewModelWithLiveData.class);
        viewModelWithLiveData.getLikedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });
        imageButtonLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(1 );
            }
        });
        imageButtonDisliked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelWithLiveData.addLikedNumber(-1);
            }
        });
    }
}
