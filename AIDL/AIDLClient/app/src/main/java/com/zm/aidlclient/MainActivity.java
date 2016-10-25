package com.zm.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.zm.R;
import com.zm.aidl.ICalcAIDL;

public class MainActivity extends AppCompatActivity {
  private ICalcAIDL mICalcAIDL;
  private ServiceConnection mServiceConnection = new ServiceConnection() {
    @Override public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
      Log.e("client", "onServiceConnected");
      mICalcAIDL = ICalcAIDL.Stub.asInterface(iBinder);
    }

    @Override public void onServiceDisconnected(ComponentName componentName) {
      Log.e("client", "onServiceDisconnected");
      mICalcAIDL = null;
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  /**
   * BindService按钮时调用
   */
  public void bindService(View view) {
    Intent intent = new Intent();
    intent.setAction("com.zm.aidl.calc");
    intent.setPackage("com.zm.aidl");
    bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
  }

  /**
   * unBindService按钮时调用
   */
  public void unBindService(View view) {
    unbindService(mServiceConnection);
  }

  public void addInvoked(View view) throws Exception {
    if (mICalcAIDL != null) {
      int addRes = mICalcAIDL.add(12, 12);
      Toast.makeText(this, addRes + "", Toast.LENGTH_LONG).show();
    } else {
      Toast.makeText(this, "服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT).show();
    }
  }

  public void minInvoked(View view) throws Exception {
    if (mICalcAIDL != null) {
      int addRes = mICalcAIDL.min(50, 12);
      Toast.makeText(this, addRes + "", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "服务器未绑定或被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT).show();
    }
  }
}
