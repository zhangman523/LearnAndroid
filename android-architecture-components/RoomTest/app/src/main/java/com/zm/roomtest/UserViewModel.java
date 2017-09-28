package com.zm.roomtest;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.zm.roomtest.db.DatabaseCreator;
import com.zm.roomtest.db.entity.User;

/**
 * Created by zhangman on 2017/9/28 10:32.
 * Email: zhangman523@126.com
 */

public class UserViewModel extends ViewModel {
  private static final MutableLiveData ABSENT = new MutableLiveData();

  {
    //noinspection unchecked
    ABSENT.setValue("Database no create");
  }

  private final LiveData<String> mUserName;
  private User mUser;
  private final DatabaseCreator databaseCreator;

  public UserViewModel(Context context) {
    databaseCreator = DatabaseCreator.getInstance();

    mUserName = Transformations.switchMap(databaseCreator.isDatabaseCreated(),
        new Function<Boolean, LiveData<String>>() {
          @Override public LiveData<String> apply(Boolean isDbCreated) {
            if (!isDbCreated) {
              return ABSENT;
            } else {
              return Transformations.map(databaseCreator.getDatabase().userDao().findUserName(),
                  new Function<User, String>() {
                    @Override public String apply(User user) {
                      if (user == null) {
                        return "user is null";
                      } else {
                        mUser = user;
                        return user.getUserName();
                      }
                    }
                  });
            }
          }
        });
    databaseCreator.createDb(context.getApplicationContext());
  }

  public LiveData<String> getUserName() {
    return mUserName;
  }

  public void updateUserName(String userName) {
    mUser = mUser == null ? new User(userName) : new User(mUser.getUid(), userName);
    databaseCreator.getDatabase().userDao().insertUser(mUser);
  }
}
