package com.example.apple.obtag;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getCanonicalName();


    private RelativeLayout back_layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContenViews();
    }

    public void initContenViews()
    {
        back_layouts = (RelativeLayout)findViewById(R.id.back_layouts);

        Button  button = new Button(this);
        button.setText("Tag");
        button.setWidth(80);
        button.setHeight(40);
        button.setOnClickListener(tagClickListener);
        back_layouts.addView(button);




    }

    public View.OnClickListener tagClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {



        }
    };

}
