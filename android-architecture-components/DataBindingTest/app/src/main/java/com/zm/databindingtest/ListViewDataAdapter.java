package com.zm.databindingtest;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.zm.databindingtest.databinding.ItemUserBinding;
import com.zm.databindingtest.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangman on 2017/9/30 16:16.
 * Email: zhangman523@126.com
 */

public class ListViewDataAdapter extends BaseAdapter {
  private List<User> mUserList;

  public ListViewDataAdapter() {
    mUserList = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      mUserList.add(new User("test" + i, "lastName" + i));
    }
  }

  @Override public int getCount() {
    return mUserList == null ? 0 : mUserList.size();
  }

  @Override public User getItem(int i) {
    return mUserList.get(i);
  }

  @Override public long getItemId(int i) {
    return i;
  }

  @Override public View getView(int i, View view, ViewGroup viewGroup) {
    User user = getItem(i);
    ItemUserBinding binding;
    if (view == null) {
      binding =
          ItemUserBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
    } else {
      binding = DataBindingUtil.getBinding(view);
    }
    binding.setUser(user);
    return binding.getRoot();
  }
}
