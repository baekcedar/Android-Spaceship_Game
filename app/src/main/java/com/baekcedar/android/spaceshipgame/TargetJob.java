package com.baekcedar.android.spaceshipgame;

import android.content.Context;

import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by HM on 2016-10-13.
 */
class TargetJob  {



    // 현재 태스크를 바라보는 옵저버들을 등록해 두는 배열
    private ArrayList<ObserverInterface> observers = new  ArrayList<>();

    // 옵저버를 등록
    public void attach(ObserverInterface observer){
        observers.add(observer);
    }


    // 실행태스크에 변겨사항이 있으면 전체 옵저버에 알려준다.
    public void notifyChanged(){
        for(ObserverInterface o : observers){
            o.update(TouchView.spaceshipX, TouchView.spaceshipY);
        }
    }

}
class SpaceshipLineCheckupdate implements ObserverInterface {
    Context context;
    TargetJob target;


    public SpaceshipLineCheckupdate(TargetJob target, Context context) {
        this.target = target;
        this.target.attach(this);
        this.context = context;


    }

    @Override
    public void update(float X, float Y) {

        Control.outLineCheck(X, Y);



    }


}