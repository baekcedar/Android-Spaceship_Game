package com.baekcedar.android.spaceshipgame;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by HM on 2016-10-14.
 */
public class Control {

    Context context;
    static MainControlInterface mListener;
    static int updateFlag = 0;
    public Control(Context context){
        this.context = context;
        updateFlag = 0;
        if (context instanceof MainControlInterface) {
            mListener = (MainControlInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public static void spaceshipMove(){

    }
    public void failMenu(){
        // 해당 View 를 생성 및 화면에 뿌려준 후 버튼 제어!

        Button retryBtn = (Button) ((MainActivity)context).findViewById(R.id.retrybtn);
        Button exitBtn = (Button) ((MainActivity)context).findViewById(R.id.exitBtn);

        // 다시하기 버튼 눌렀을 경우
      if(retryBtn != null) {
          retryBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Log.i("TEST", "retryBtn");
                  ((MainActivity) context).recreate();
              }
          });
      }

        // 종료 버튼 눌렀을 경우
        if(exitBtn != null) {
            exitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("TEST", "exitBtn");
                    ((MainActivity) context).finish();
                }
            });
        }
    }

    public static void outLineCheck(float X, float Y){
        if( updateFlag == 0 && ((-15) >= X || (-15) > Y ||
                TouchView.viewHeight-100 < Y ||
                TouchView.viewWidth-20 < X)){
            Log.i("TEST", "선을 넘었다");

            updateFlag = 1;
            mListener.failView();

        }
    }


}
