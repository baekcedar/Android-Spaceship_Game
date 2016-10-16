package com.baekcedar.android.spaceshipgame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainControlInterface {
    Control control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        control = new Control(this);
        //전체 화면 설정
        TouchView touchView = new TouchView(this);
        touchView.setBackgroundColor(Color.rgb(0, 0, 0)); //배경색 지정
        setContentView(touchView);


    }

    public void failView(){
        setContentView(R.layout.fail_view);
        control.failMenu();
    }


}


