package com.zm.roomtest;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhangman on 2017/11/20 09:25.
 * Email: zhangman523@126.com
 */

public class SplashActivity extends AppCompatActivity {

  private Handler mHandler = new Handler(new Handler.Callback() {
    @Override public boolean handleMessage(Message msg) {
      switch (msg.what) {
        case 0:
          startActivity(new Intent(SplashActivity.this, MainActivity.class));
          finish();
          break;
      }
      return false;
    }
  });

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    new AsyncTask<Void, Void, Void>() {
      @Override protected Void doInBackground(Void... voids) {
        copyDb();
        return null;
      }
    }.execute();
  }

  private void copyDb() {
    File firesDirs = new File("/data/data/com.zm.roomtest/databases");
    if (!firesDirs.exists()) {
      firesDirs.mkdirs();
    }
    File targetFile = new File(firesDirs, "bank.db");

    InputStream inputStream = null;
    FileOutputStream fileOutputStream = null;

    AssetManager assetManager = getAssets();
    try {
      inputStream = assetManager.open("bank.db");

      fileOutputStream = new FileOutputStream(targetFile);
      int len = 0;
      byte[] buffer = new byte[1024];
      while ((len = inputStream.read(buffer)) != -1) {
        fileOutputStream.write(buffer, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      mHandler.sendEmptyMessage(0);
      try {
        inputStream.close();
        fileOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
