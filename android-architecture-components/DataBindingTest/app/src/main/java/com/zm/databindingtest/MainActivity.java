package com.zm.databindingtest;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.zm.databindingtest.databinding.ActivityMainBinding;
import com.zm.databindingtest.entity.User;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    User user = new User("Test origin ", null);
    binding.setUser(user);
    binding.setListDataClick(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, ListViewDataBindingActivity.class));
      }
    });
    binding.setRecyclerDataClick(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, RecyclerViewDataBindingActivity.class));
      }
    });
  }
}
