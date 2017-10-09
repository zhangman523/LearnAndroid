package com.zm.databindingtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by zhangman on 2017/9/29 16:59.
 * Email: zhangman523@126.com
 */

public class ListViewDataBindingActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view_data);
    ListView listView = findViewById(R.id.list_view);
    listView.setAdapter(new ListViewDataAdapter());
  }
}
