package com.zm.roomtest.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import com.zm.roomtest.db.entity.AppConfig;

/**
 * Created by zhangman on 2017/11/20 10:06.
 * Email: zhangman523@126.com
 */
@Dao
public interface AppConfigDao {
  @Query("SELECT * FROM t_AppConfig LIMIT 1")
  LiveData<AppConfig> findAppConfig();

}
