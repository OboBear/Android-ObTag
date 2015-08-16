package com.obo.demo.obtag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * Created by obo on 15/8/15.
 */
public class OboTag extends Button {

    public static String TAG = OboTag.class.getCanonicalName();

    private Context context;


    public OboTag(Context context)
    {
        super(context);
        this.context = context;
    }

    public OboTag(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
    }


//    @Override
//    public void onDraw(Canvas canvas)
//    {
//        super.onDraw(canvas);
//
//        canvas.drawCircle(100 , 100,50,new Paint());
//
//
//    }



}
