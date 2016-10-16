package com.baekcedar.android.spaceshipgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


class TouchView extends SurfaceView implements SurfaceHolder.Callback {
    static int viewWidth;
    static int viewHeight;
    static int imgsizeW = 50;
    static int imgsizeH = 70;
    static float spaceshipX;
    static float spaceshipY;
    static float touchX;
    static float touchY;
    static float tmpTouchX;
    static float tmpTouchY;

    Bitmap spaceship;
    Bitmap virus;
    TargetJob target;
    static SurfaceHolder mHolder;
    Context context;
    CustomThread mThread;
    public TouchView(Context context) { //생성자
        super(context);
        SurfaceHolder holder = getHolder();
        virus = BitmapFactory.decodeResource(getResources(),
                R.drawable.virus);
        holder.addCallback(this);
        this.mHolder  = holder;
        this.context = context;
        mThread = new CustomThread(mHolder, context, virus);

        // 전체 화면 사이즈 가져오기
        DisplayMetrics dm = getContext().getApplicationContext().getResources().getDisplayMetrics();
        viewWidth = dm.widthPixels;     // 화면 전체 크기
        viewHeight = dm.heightPixels;   // 화면 전체 크기
        // 이미지 불러오기
        Bitmap spaceshipTmp = BitmapFactory.decodeResource(getResources(),
                R.drawable.spaceship);

        //사이즈 변경
        spaceship = spaceshipTmp.createScaledBitmap(spaceshipTmp, imgsizeW, imgsizeH, true);
        spaceshipX = (viewWidth/2)-(imgsizeW/2);
        spaceshipY = (viewHeight/2)-(imgsizeH/2);

        target = new TargetJob();
        new SpaceshipLineCheckupdate(target, context);
    }



    //화면에 객체 표시

//    public void onDraw(Canvas canvas) {
//                        // 화면 표시(이름, X좌표,Y좌표, 이미지편집);
//        canvas.drawBitmap(spaceship, spaceshipX, spaceshipY, null);
//
//    }



    // ------우주선 이동------
//    public boolean onTouchEvent(MotionEvent event) {
//        float eventaction = event.getAction();
//
//
//
//        switch ((int)eventaction) {
//            case MotionEvent.ACTION_DOWN:
//                touchX = event.getX();
//                touchY = event.getY();
//                tmpTouchX = touchX;
//                tmpTouchY = touchY;
//                break;
//            case MotionEvent.ACTION_MOVE: // 닿은 채로 손가락을 움직일 때
//              //  Log.i("TEST", msg);
//                touchX = event.getX();
//                touchY = event.getY();
//                if (touchX > spaceshipX) {
//                    spaceshipX += (touchX - tmpTouchX);
//                    tmpTouchX = touchX;
//                }
//                if (touchY > spaceshipY) {
//                    spaceshipY += (touchY - tmpTouchY);
//                    tmpTouchY = touchY;
//
//                }
//                if (touchX < spaceshipX) {
//                    spaceshipX -= (tmpTouchX - touchX);
//                    tmpTouchX = touchX;
//                }
//                if (touchY < spaceshipY) {
//                    spaceshipY -= (tmpTouchY - touchY );
//                    tmpTouchY = touchY;
//                }
//                //Log.i(" touch: ", "" + touchX + "/"+touchY);
//                target.notifyChanged();
//                invalidate(); //onDraw 다시 실행
//
//                break;
//        }
//
//        return true;
//    }


    @Override   // SurfaceView가 만들어질 때 호출
    public void surfaceCreated(SurfaceHolder holder) {
        mThread.start();
    }

    @Override   // SurfaceView의 크기가 바뀔 때 호출됨
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override   // SurfaceView가 종료될 때 호출됨
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


}
