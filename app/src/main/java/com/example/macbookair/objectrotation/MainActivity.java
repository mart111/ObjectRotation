package com.example.macbookair.objectrotation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private View rectangle;
    private RelativeLayout mainLayout;
    private float newX, newY;
    private TextView txt;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rectangle = findViewById(R.id.rectangle);
        txt = findViewById(R.id.txt);
        btnReset = findViewById(R.id.resetBtn);
        mainLayout = findViewById(R.id.mainLayout);

        mainLayout.setOnTouchListener(this);
        btnReset.setOnClickListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        newX = event.getX() - v.getX();
        newY = event.getY() - v.getY();

        rectangle.setRotationX(newX);
        rectangle.setRotationY(newY);


        txt.setText("X= " + newX + "\n" + "Y= " + newY + "\n" + "Angle= " + rectangle.getRotation());


        return true;
    }


    @Override
    public void onClick(View v) {
        rectangle.setRotationX(0);
        rectangle.setRotationY(0);
        txt.setText("");
    }
}
