package zm.com.livedatatest;

import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by zhangman on 2017/9/26 14:05.
 * Email: zhangman523@126.com
 */

public abstract class SimpleLocationListener implements LocationListener {
  @Override public void onStatusChanged(String s, int i, Bundle bundle) {
    
  }

  @Override public void onProviderEnabled(String s) {

  }

  @Override public void onProviderDisabled(String s) {

  }
}
