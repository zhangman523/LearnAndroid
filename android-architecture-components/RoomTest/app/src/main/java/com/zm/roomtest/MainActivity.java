package com.zm.roomtest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private EditText mUserEdit;
  private TextView mUserNameLabel;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mUserEdit = findViewById(R.id.editText);
    mUserNameLabel = findViewById(R.id.user_name_label);
    ViewModelFactory factory = new ViewModelFactory(this);
    final UserViewModel userViewModel =
        ViewModelProviders.of(this, factory).get(UserViewModel.class);
    userViewModel.getUserName().observe(this, new Observer<String>() {
      @Override public void onChanged(@Nullable String s) {
        mUserNameLabel.setText(s);
      }
    });
    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        new AsyncTask<String, Void, Void>() {

          @Override protected Void doInBackground(String... strings) {
            userViewModel.updateUserName(strings[0]);
            return null;
          }

          @Override protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
          }
        }.execute(mUserEdit.getText().toString());
      }
    });
  }
}
