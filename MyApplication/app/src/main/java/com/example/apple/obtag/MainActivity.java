package com.example.apple.obtag;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.obo.util.DisplayUtil;
import com.obo.util.WidgetController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getCanonicalName();


    private RelativeLayout back_layouts;


    private String []alterTagStrings ;//= new ArrayList<String>();
    private String []choosedTagStrings ;//= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPredatas();

        initContenViews();
    }

    private  void initPredatas()
    {
        alterTagStrings = new String[]{
                "1",
                "2",
                "3"
        };

        choosedTagStrings = new String[]{
                "4",
                "5",
                "6",
                "7"
        };
    }


    public void initContenViews()
    {
        back_layouts = (RelativeLayout)findViewById(R.id.back_layouts);



        for (int i =0; i<alterTagStrings.length ; i++)
        {

            Button  button = new Button(this);
            button.setText(alterTagStrings[i]);

            TextPaint paint = button.getPaint();
            float textLength = paint.measureText(alterTagStrings[i]);
            int heightPx= DisplayUtil.dip2px(this, 40);



            button.setLayoutParams(new ViewGroup.LayoutParams(120, heightPx));
            WidgetController.setLayout(button, 120 * i, 80 * i);

            button.setOnClickListener(tagClickListener);

            back_layouts.addView(button);

//            button.setBackgroundColor(Color.RED);
        }



    }

    public View.OnClickListener tagClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }
    };



}
