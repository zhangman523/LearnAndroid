package zm.com.livedatatest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TextView mGpsLabel;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mGpsLabel = findViewById(R.id.gps_label);
    LiveData<Location> myLocationListener = LocationLiveData.get(this);
    myLocationListener.observe(this, location -> {
      mGpsLabel.setText("latitude:"
          + location.getLatitude()
          + "\n Longitude:"
          + location.getLongitude()
          + "\n time:"
          + location.getTime());
    });
    MutableLiveData<String> userId = new MutableLiveData<>();
    userId.postValue("112");
    LiveData<String> mUserNameData = Transformations.switchMap(userId, user -> {
      return new UserLiveData(user);
    });
    mUserNameData.observe(this, userName -> {
      mGpsLabel.setText(userName);
    });
  }
}
