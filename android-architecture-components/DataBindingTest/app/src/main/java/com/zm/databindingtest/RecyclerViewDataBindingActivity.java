package com.zm.databindingtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by zhangman on 2017/9/30 17:02.
 * Email: zhangman523@126.com
 */

public class RecyclerViewDataBindingActivity extends AppCompatActivity {
  private RecyclerView mRecyclerView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recyler_view);
    mRecyclerView = findViewById(R.id.recycler_view);
    RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter();
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(adapter);
  }
}
