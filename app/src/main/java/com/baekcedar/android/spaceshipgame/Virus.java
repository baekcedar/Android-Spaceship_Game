package com.baekcedar.android.spaceshipgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by HM on 2016-10-13.
 */
public class Virus {
    public Bitmap getVirus(Context context){
        return BitmapFactory.decodeResource(context.getResources(),
                R.drawable.virus);

    }
}
