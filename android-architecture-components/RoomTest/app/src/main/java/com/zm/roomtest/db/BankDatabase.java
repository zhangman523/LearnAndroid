package com.zm.roomtest.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.zm.roomtest.db.dao.AppConfigDao;
import com.zm.roomtest.db.entity.AppConfig;

/**
 * Created by zhangman on 2017/11/20 10:04.
 * Email: zhangman523@126.com
 */
@Database(entities = { AppConfig.class},version = 1)
public abstract class BankDatabase extends RoomDatabase{
  static final String DATABASE_NAME = "bank.db";

  public abstract AppConfigDao appConfigDao();
}
