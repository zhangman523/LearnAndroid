package zm.com.livedatatest;

import android.arch.lifecycle.LiveData;

/**
 * Created by zhangman on 2017/9/26 17:45.
 * Email: zhangman523@126.com
 */

public class UserLiveData extends LiveData<String> {
  private String userName;

  public UserLiveData(String userName) {
    this.userName = userName;
  }

  @Override protected void onActive() {
    super.onActive();
    setValue(userName);
  }

  @Override protected void onInactive() {
    super.onInactive();
  }
}
