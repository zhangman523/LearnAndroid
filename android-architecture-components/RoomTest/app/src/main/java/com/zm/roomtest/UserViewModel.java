package com.zm.roomtest;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import com.zm.roomtest.db.DatabaseCreator;
import com.zm.roomtest.db.entity.AppConfig;
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

  private static final MutableLiveData APPCONFIG = new MutableLiveData();

  {
    APPCONFIG.setValue(new AppConfig(2, "release1", "www.cesi.com1"));
  }

  private final LiveData<String> mUserName;
  private final LiveData<AppConfig> mAppConfigLiveData;
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
    mAppConfigLiveData = Transformations.switchMap(databaseCreator.isDatabaseCreated(),
        new Function<Boolean, LiveData<AppConfig>>() {
          @Override public LiveData<AppConfig> apply(Boolean isDbCreated) {
            if (!isDbCreated) {
              return APPCONFIG;
            } else {
              return Transformations.map(
                  databaseCreator.getBankDatabase().appConfigDao().findAppConfig(),
                  new Function<AppConfig, AppConfig>() {
                    @Override public AppConfig apply(AppConfig input) {
                      if (input == null) {
                        return new AppConfig(2, "release", "www.cesi.com");
                      } else {
                        return input;
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

  public LiveData<AppConfig> getAppConfig() {
    return mAppConfigLiveData;
  }

  public void updateUserName(String userName) {
    mUser = mUser == null ? new User(userName) : new User(mUser.getUid(), userName);
    databaseCreator.getDatabase().userDao().insertUser(mUser);
  }
}
