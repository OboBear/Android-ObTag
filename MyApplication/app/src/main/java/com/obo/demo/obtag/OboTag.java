package com.obo.demo.obtag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by obo on 15/8/15.
 */
public class OboTag extends Button {

    public static String TAG = OboTag.class.getCanonicalName();

    private Context context;

    public boolean boarderFlag = true;


    public OboTag(Context context)
    {
        super(context);
        this.context = context;
    }

    public OboTag(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
    }


    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

//        canvas.drawCircle(100, 100, 50, new Paint());

        Paint paint = new Paint();
        paint.setAntiAlias(true); //消除锯齿
        paint.setStyle(Paint.Style.STROKE);  //绘制空心圆或 空心矩形
        if (boarderFlag)
        {
            paint.setColor(Color.alpha(0));
        }

        canvas.drawRect(1,1,this.getWidth() - 3 ,this.getHeight() - 3,paint);


        Log.i(TAG,"height:"+this.getHeight());

    }



}
