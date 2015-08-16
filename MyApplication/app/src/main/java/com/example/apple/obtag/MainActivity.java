package com.example.apple.obtag;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.obo.demo.obtag.OboTag;
import com.obo.util.DisplayUtil;
import com.obo.util.WidgetController;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getCanonicalName();


    public static float TAG_SET_HEIGHT = 140f;

    private RelativeLayout back_layouts;

    private String []alterTagStrings ;
    private String []choosedTagStrings ;

    private List<OboTag>alterTagList = new ArrayList<OboTag>();
    private List<OboTag>choosedTagList = new ArrayList<OboTag>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPredatas();

        initContenViews();

        resetPosition();
    }

    private  void initPredatas()
    {
        alterTagStrings = new String[]{
                "旅游",
                "电影",
                "音乐"
        };

        choosedTagStrings = new String[]{
                "美食节目",
                "搞笑233",
                "文艺",
                "古典"
        };
    }


    public void initContenViews()
    {
        back_layouts = (RelativeLayout)findViewById(R.id.back_layouts);

        for (int i =0; i<alterTagStrings.length ; i++)
        {

            OboTag  button = new OboTag(this);
            button.setText(alterTagStrings[i]);

            TextPaint paint = button.getPaint();
//            Rect rect=new Rect();
//            paint.getTextBounds(alterTagStrings[i],0,alterTagStrings[i].length(), rect);
            float width = paint.measureText(alterTagStrings[i]);
//            float width = rect.width();

            int heightPx= DisplayUtil.dip2px(this, 40);
            int widthPx = DisplayUtil.dip2px(this,width/2 + 20);

            button.setLayoutParams(new ViewGroup.LayoutParams(widthPx, heightPx));
            button.setOnClickListener(tagClickListener);

            back_layouts.addView(button);

            button.setBackgroundColor(Color.RED);
            button.setTextColor(Color.WHITE);
            alterTagList.add(button);

            button.setTag(false);
        }

        for (int i =0; i<choosedTagStrings.length ; i++)
        {
            OboTag  button = new OboTag(this);
            button.setText(choosedTagStrings[i]);
            TextPaint paint = button.getPaint();

            Rect rect=new Rect();
            paint.getTextBounds(choosedTagStrings[i],0,choosedTagStrings[i].length(), rect);

            float width = paint.measureText(choosedTagStrings[i]);
//            float width = rect.width();


            int heightPx= DisplayUtil.dip2px(this, 40);
            int widthPx = DisplayUtil.dip2px(this,width/2 + 20 );

            button.setLayoutParams(new ViewGroup.LayoutParams(widthPx, heightPx));
            button.setOnClickListener(tagClickListener);

            back_layouts.addView(button);

            button.setBackgroundColor(Color.RED);
            button.setTextColor(Color.WHITE);
            choosedTagList.add(button);

            button.setTag(true);
        }

    }

    private void resetPosition()
    {
        for (int i=0;i<alterTagList.size();i++)
        {
            OboTag button = alterTagList.get(i);
            TextPaint paint = button.getPaint();
            int widthPx = DisplayUtil.dip2px(this, 80);

            WidgetController.setLayout(button, 20 + (20 + widthPx) * i, 20);

            if(i == 0)
            {
                WidgetController.setLayout(button, 20, 20);
            }
            else
            {
                OboTag lastButton = alterTagList.get(i - 1);

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lastButton.getLayoutParams();

                int left = layoutParams.leftMargin;

                WidgetController.setLayout(button, left + lastButton.getLayoutParams().width +20, 20);
            }

        }


        for (int i=0;i<choosedTagList.size();i++)
        {
            OboTag button = choosedTagList.get(i);
            TextPaint paint = button.getPaint();

            if(i == 0)
            {
                WidgetController.setLayout(button, 20, 20+DisplayUtil.dip2px(this, TAG_SET_HEIGHT));
            }
            else
            {
                OboTag lastButton = choosedTagList.get(i - 1);

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lastButton.getLayoutParams();

                int left = layoutParams.leftMargin;

                WidgetController.setLayout(button, left + lastButton.getLayoutParams().width +20, 20+DisplayUtil.dip2px(this, TAG_SET_HEIGHT));
            }
        }
    }

    public View.OnClickListener tagClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if ((boolean)v.getTag())
            {
                v.setTag(false);

                alterTagList.add((OboTag) v);
                choosedTagList.remove(v);
            }
            else
            {
                v.setTag(true);

                choosedTagList.add((OboTag) v);
                alterTagList.remove(v);
            }

            resetPosition();

        }
    };



}
