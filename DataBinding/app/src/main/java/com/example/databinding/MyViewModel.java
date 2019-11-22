package com.example.databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        //给LiveData变量number设置初值
        if(number == null) {
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }
        return number;
    }
    //声明增加的功能函数
    public void add() {
        if (number == null) {
            number.setValue(0);
        }
        number.setValue(number.getValue() + 1);
    }
}
