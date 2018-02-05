package com.example.macbookair.objectrotation;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, View.OnClickListener {

    private View rectangle;
    private RelativeLayout mainLayout;
    private float x1, x2;
    private Button btnReset;
    private GestureDetectorCompat gestureDetectorCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rectangle = findViewById(R.id.rectangle);
        btnReset = findViewById(R.id.resetBtn);
        mainLayout = findViewById(R.id.mainLayout);

        gestureDetectorCompat = new GestureDetectorCompat(this, this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float delta = x2 - x1;

                if (Math.abs(delta) > 0) {
                    // Left to Right swipe action
                    if (x2 > x1) {
                        rectangle.setRotationY(delta);
                    }

                    // Right to left swipe action
                    else {
                        rectangle.setRotationY(Math.abs(x1 - x2));
                    }
                }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public void onClick(View v) {
        rectangle.setRotationY(0);
    }
}
