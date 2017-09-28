package com.zm.roomtest.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.zm.roomtest.db.entity.User;

/**
 * Created by zhangman on 2017/9/27 16:01.
 * Email: zhangman523@126.com
 */
@Dao
public interface UserDao {
  @Query("SELECT * FROM Users LIMIT 1")
  LiveData<User> findUserName();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertUser(User user);

  @Query("DELETE FROM Users")
  void deleteAllUser();
}
