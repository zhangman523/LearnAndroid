/*
 * Copyright (C) 2015 备胎金服
 * 未经授权允许不得进行拷贝和修改
 *   http://www.btjf.com/
 */
package com.zm.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhangman on 2016/10/25 14:39.
 * Email: zhangman523@126.com
 */
public class CalcService extends Service {
  private static final String TAG = "Server";

  @Override public void onCreate() {
    Log.e(TAG, "onCreate");
    super.onCreate();
  }

  @Nullable @Override public IBinder onBind(Intent intent) {
    Log.e(TAG, "onBind");
    return mBinder;
  }

  @Override public void onDestroy() {
    Log.e(TAG, "onDestroy");
    super.onDestroy();
  }

  @Override public boolean onUnbind(Intent intent) {
    Log.e(TAG, "onUnbind");
    return super.onUnbind(intent);
  }

  @Override public void onRebind(Intent intent) {
    Log.e(TAG, "onRebind");
    super.onRebind(intent);
  }

  private final ICalcAIDL.Stub mBinder = new ICalcAIDL.Stub() {

    @Override public int add(int x, int y) throws RemoteException {
      return x + y;
    }

    @Override public int min(int x, int y) throws RemoteException {
      return x - y;
    }
  };
}
