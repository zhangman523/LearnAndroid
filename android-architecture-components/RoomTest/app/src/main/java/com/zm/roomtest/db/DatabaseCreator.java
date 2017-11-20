package com.zm.roomtest.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.zm.roomtest.db.UsersDatabase.DATABASE_NAME;

/**
 * Created by zhangman on 2017/9/27 16:37.
 * Email: zhangman523@126.com
 */

public class DatabaseCreator {
  private static DatabaseCreator sInstance;
  private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

  private UsersDatabase mDatabase;

  private BankDatabase mBankDatabase;

  private final AtomicBoolean mInitializing = new AtomicBoolean(true);

  private static final Object LOCK = new Object();

  public synchronized static DatabaseCreator getInstance() {
    if (sInstance == null) {
      synchronized (LOCK) {
        if (sInstance == null) {
          sInstance = new DatabaseCreator();
        }
      }
    }
    return sInstance;
  }

  public LiveData<Boolean> isDatabaseCreated() {
    return mIsDatabaseCreated;
  }

  @Nullable public UsersDatabase getDatabase() {
    return mDatabase;
  }

  public void createDb(Context context) {
    Log.d("DatabaseCreator", "Creating DB from " + Thread.currentThread().getName());

    if (!mInitializing.compareAndSet(true, false)) {
      return;//Already initializing
    }
    mIsDatabaseCreated.setValue(false);

    new AsyncTask<Context, Void, Void>() {

      @Override protected Void doInBackground(Context... params) {
        Log.d("DatabaseCreator", "Starting bg job " + Thread.currentThread().getName());

        Context context = params[0].getApplicationContext();

        context.deleteDatabase(DATABASE_NAME);

        UsersDatabase db =
            Room.databaseBuilder(context.getApplicationContext(), UsersDatabase.class,
                DATABASE_NAME).build();

        BankDatabase bankDatabase =
            Room.databaseBuilder(context.getApplicationContext(), BankDatabase.class,
                BankDatabase.DATABASE_NAME).build();
        mBankDatabase = bankDatabase;

        mDatabase = db;
        Log.d("DatabaseCreator", "Create DB Success!");
        return null;
      }

      @Override protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mIsDatabaseCreated.setValue(true);
      }
    }.execute(context.getApplicationContext());
  }

  private void addDelay() {
    try {
      Thread.sleep(4000);
    } catch (InterruptedException ignored) {
    }
  }

  public BankDatabase getBankDatabase() {
    return mBankDatabase;
  }
}
