package com.zm.roomtest;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by zhangman on 2017/9/28 13:48.
 * Email: zhangman523@126.com
 */

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

  @NonNull private final Context mContext;

  public ViewModelFactory(@NonNull Context context) {
    mContext = context;
  }

  @Override public <T extends ViewModel> T create(Class<T> modelClass) {
    return (T) new UserViewModel(mContext);
  }
}
