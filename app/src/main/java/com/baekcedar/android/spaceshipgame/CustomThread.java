package com.baekcedar.android.spaceshipgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by HM on 2016-10-14.
 */
/*
 별도로 Thread 생성으로 여러개가 각자의 동작
 */
class CustomThread extends Thread {
    Context context;
    Bitmap virus;
    Canvas canvas;
    SurfaceHolder mHolder;
    int X=0;
    int Y=0;
    public CustomThread(SurfaceHolder mHolder, Context context, Bitmap virus) {
        // 초기값 X,Y  지정
        super();
        this. mHolder = mHolder;
        this.context = context;
        this.virus = virus;



    }

    @Override
    public void run() {

        while( true ){

            try{
                canvas = mHolder.lockCanvas();
                synchronized (mHolder) {
                    Log.i("test","test");
                    Thread.sleep(500); // 속도조절
                    canvas.drawBitmap(virus, X, Y, null);
                    X++;
                    Y++;

                }

            } catch (Exception e){}

            finally {
                 // canvas의 내용을 View에 전송
                if(canvas != null)
                    mHolder.unlockCanvasAndPost(canvas);
            }

        }
    }
}