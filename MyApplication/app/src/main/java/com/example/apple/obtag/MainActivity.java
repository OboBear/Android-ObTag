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
import android.widget.TextView;

import com.obo.demo.obtag.OboTag;
import com.obo.util.DisplayUtil;
import com.obo.util.ScreenUtil;
import com.obo.util.WidgetController;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getCanonicalName();


    public static float TAG_SET_HEIGHT = 140f;

    private RelativeLayout back_layouts;

    private String []alterTagStrings ;
    private String []choosedTagStrings ;
//    @"#7ecef4", @"#84ccc9", @"#88abda",@"#7dc1dd",@"#b6b8de"

    private int [] tagColors = {
            Color.parseColor("#7ecef4"),
            Color.parseColor("#84ccc9"),
            Color.parseColor("#88abda"),
            Color.parseColor("#7dc1dd"),
            Color.parseColor("#b6b8de")
    };

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
            float width = paint.measureText(alterTagStrings[i]);

            int heightPx= DisplayUtil.dip2px(this, 40);
            int widthPx = DisplayUtil.dip2px(this,width/2 + 20);

            button.setLayoutParams(new ViewGroup.LayoutParams(widthPx, heightPx));
            button.setOnClickListener(tagClickListener);

            back_layouts.addView(button);

            button.setBackgroundColor(tagColors[new Integer((int) (Math.random() * 100)) % tagColors.length]);

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

            int heightPx = DisplayUtil.dip2px(this, 40);
            int widthPx = DisplayUtil.dip2px(this, width / 2 + 20 );

            button.setLayoutParams(new ViewGroup.LayoutParams(widthPx, heightPx));
            button.setOnClickListener(tagClickListener);
            back_layouts.addView(button);

            button.setTextColor(Color.WHITE);
            button.setBackgroundColor(Color.GRAY);

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

                int top  = layoutParams.topMargin;

                if (left + lastButton.getLayoutParams().width +40 + button.getLayoutParams().width > ScreenUtil.getScreenWidth(this))
                {
                    WidgetController.setLayout(button, 20, top+ DisplayUtil.dip2px(this, 40) + 20);
                }
                else
                {
                    WidgetController.setLayout(button, left + lastButton.getLayoutParams().width +20,top );
                }

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


                int top  = layoutParams.topMargin;

                if (left + lastButton.getLayoutParams().width +40 + button.getLayoutParams().width > ScreenUtil.getScreenWidth(this))
                {
                    WidgetController.setLayout(button, 20, top+DisplayUtil.dip2px(this, 40) + 20);
                }
                else
                {
                    WidgetController.setLayout(button, left + lastButton.getLayoutParams().width +20, top);
                }



            }
        }
    }

    public View.OnClickListener tagClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((OboTag)v).boarderFlag = (boolean)v.getTag();
            if ((boolean)v.getTag())
            {
                v.setTag(false);

                ((TextView)v).setTextColor(Color.WHITE);
                v.setBackgroundColor(tagColors[new Integer((int) (Math.random() * 100)) % tagColors.length]);

                alterTagList.add((OboTag) v);
                choosedTagList.remove(v);
            }
            else
            {
                v.setTag(true);

                ((TextView)v).setTextColor(Color.WHITE);
                v.setBackgroundColor(Color.GRAY);

                choosedTagList.add((OboTag) v);
                alterTagList.remove(v);
            }

            resetPosition();

        }
    };



}
