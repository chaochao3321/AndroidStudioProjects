package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    TextView textView;
//    Button button;
    MyViewModel myViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

//        textView = findViewById(R.id.textView);
//        button = findViewById(R.id.button);
        myViewModel =  ViewModelProviders.of(this).get(MyViewModel.class);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
//        myViewModel.getNumber().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.textView.setText(String.valueOf(integer));//当上一行的integer发生改变时，将integer的值包装为String类型赋值给TextView
//            }
//        });
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myViewModel.add();
//            }
//        });
    }
}
