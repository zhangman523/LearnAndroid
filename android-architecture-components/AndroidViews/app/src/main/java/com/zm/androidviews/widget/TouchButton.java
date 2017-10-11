package com.zm.androidviews.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by zhangman on 2017/10/10 15:11.
 * Email: zhangman523@126.com
 */

public class TouchButton extends AppCompatButton {
  private static final String TAG = TouchButton.class.getSimpleName();

  public TouchButton(Context context) {
    super(context);
  }

  public TouchButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public TouchButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    int action = event.getAction();
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
    return super.onTouchEvent(event);
  }

  @Override public boolean dispatchTouchEvent(MotionEvent event) {
    int action = event.getAction();
    switch (action) {
      case MotionEvent.ACTION_DOWN:
        Log.d(TAG, "dispatchTouchEvent: ACTION_DOWN");
        break;
      case MotionEvent.ACTION_MOVE:
        Log.d(TAG, "dispatchTouchEvent: ACTION_MOVE");
        break;
      case MotionEvent.ACTION_UP:
        Log.d(TAG, "dispatchTouchEvent: ACTION_UP");
        break;
      default:
        break;
    }
    return super.dispatchTouchEvent(event);
  }
}
