package com.learn.kotlin.clazzobj;


import android.widget.Button;
import android.widget.TextView;

//类型声明时的上界
public class Te<T extends TextView & Comparable>{

    public T name;

    public Te(T  a ){
        name = a;
    }

    public void addTT(T t){

    }
}

class B{

}




