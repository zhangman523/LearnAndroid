package com.zm.databindingtest;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zm.databindingtest.databinding.ItemUserBinding;
import com.zm.databindingtest.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangman on 2017/9/30 17:11.
 * Email: zhangman523@126.com
 */

public class RecyclerViewDataAdapter
    extends RecyclerView.Adapter<RecyclerViewDataAdapter.UserViewHolder> {
  private List<User> mUserList;

  public RecyclerViewDataAdapter() {
    mUserList = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      mUserList.add(new User("test" + i, "lastName" + i));
    }
  }

  @Override public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemUserBinding binding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user,
            parent, false);
    return new UserViewHolder(binding);
  }

  @Override public void onBindViewHolder(UserViewHolder holder, int position) {
    holder.mBinding.setUser(mUserList.get(position));
  }

  @Override public int getItemCount() {
    return mUserList.size();
  }

  static class UserViewHolder extends RecyclerView.ViewHolder {
    TextView mUserNameLabel;
    final ItemUserBinding mBinding;

    public UserViewHolder(ItemUserBinding binding) {
      super(binding.getRoot());
      mBinding = binding;
      mUserNameLabel = mBinding.getRoot().findViewById(R.id.userNameLabel);
    }
  }
}
