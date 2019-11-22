package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView display;
    Button buttonLeft,buttonRight,button3;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox checkBoxYuwen,checkBoxShuxue,checkBoxYingyu;
    RatingBar ratingBar;
    String yuwen = "";
    String shuxue = "";
    String yingyu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        buttonLeft = findViewById(R.id.button);
        buttonRight = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        aSwitch = findViewById(R.id.switch1);
        progressBar = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editText2);
        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        seekBar = findViewById(R.id.seekBar);
        checkBoxYuwen = findViewById(R.id.checkBox);
        checkBoxShuxue = findViewById(R.id.checkBox2);
        checkBoxYingyu = findViewById(R.id.checkBox3);
        ratingBar = findViewById(R.id.ratingBar);

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button1);
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(R.string.button2);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    display.setText("开");
                } else {
                    display.setText("关");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    s = "0";
                }
                progressBar.setProgress(Integer.valueOf(s));
                display.setText(s);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    imageView.setImageResource(R.drawable.car);
                } else {
                    imageView.setImageResource(R.drawable.air);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                display.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        checkBoxYuwen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    yuwen = "语文";
                } else {
                    yuwen = "";
                }
                display.setText(yuwen+shuxue+yingyu);
            }
        });

        checkBoxShuxue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    shuxue = "数学";
                } else {
                    shuxue = "";
                }
                display.setText(yuwen+shuxue+yingyu);
            }
        });

        checkBoxYingyu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    yingyu = "英语";
                } else {
                    yingyu = "";
                }
                display.setText(yuwen+shuxue+yingyu);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),String.valueOf(rating)+"星评价",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
