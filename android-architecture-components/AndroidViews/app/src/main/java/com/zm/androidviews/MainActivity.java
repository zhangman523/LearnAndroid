package com.zm.androidviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = MainActivity.class.getSimpleName();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.touch_button).setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        switch (action) {
          case MotionEvent.ACTION_DOWN:
            Log.d(TAG, "onTouchEvent: ACTION_DOWN");
            break;
          case MotionEvent.ACTION_MOVE:
            Log.d(TAG, "onTouchEvent: ACTION_MOVE");
            break;
          case MotionEvent.ACTION_UP:
            Log.d(TAG, "onTouchEvent: ACTION_UP");
            break;
          default:
            break;
        }
        return false;
      }
    });
  }
}
