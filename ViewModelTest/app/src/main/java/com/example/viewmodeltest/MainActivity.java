package com.example.viewmodeltest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    MyViewMedel myViewMedel;
    TextView textView;
    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewMedel = ViewModelProviders.of(this).get(MyViewMedel.class);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView.setText(String.valueOf(myViewMedel.number));//每次重新显示后将保存在myViewModel.number中的数值重新显示出来
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewMedel.number++;//点击按键1之后myViewmodel中保存的数据+1
                textView.setText(String.valueOf(myViewMedel.number));//将myViewModel.numer中的数据转换为string类型显示出来
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewMedel.number += 2 ;
                textView.setText(String.valueOf(myViewMedel.number));
            }
        });
    }
}
