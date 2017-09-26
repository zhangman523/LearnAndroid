package zm.com.livedatatest;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.MainThread;

/**
 * Created by zhangman on 2017/9/26 13:53.
 * Email: zhangman523@126.com
 */

public class LocationLiveData extends LiveData<Location> {
  private LocationManager mLocationManager;
  private static LocationLiveData sInstance;

  private SimpleLocationListener mListener = new SimpleLocationListener() {
    @Override public void onLocationChanged(Location location) {
      setValue(location);
    }
  };

  @MainThread public static LocationLiveData get(Context context) {
    if (sInstance == null) {
      sInstance = new LocationLiveData(context.getApplicationContext());
    }
    return sInstance;
  }

  public LocationLiveData(Context context) {
    mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
  }

  @Override protected void onActive() {
    super.onActive();
    //mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mListener);
    mListener.onLocationChanged(new Location("test"));
  }

  @Override protected void onInactive() {
    super.onInactive();
    mLocationManager.removeUpdates(mListener);
  }
}
