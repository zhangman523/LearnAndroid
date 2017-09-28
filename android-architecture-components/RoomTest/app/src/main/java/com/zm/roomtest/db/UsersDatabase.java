package com.zm.roomtest.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.zm.roomtest.db.dao.UserDao;
import com.zm.roomtest.db.entity.User;

/**
 * Created by zhangman on 2017/9/27 16:21.
 * Email: zhangman523@126.com
 */
@Database(entities = { User.class }, version = 1) public abstract class UsersDatabase
    extends RoomDatabase {
  static final String DATABASE_NAME = "basic-sample-db";

  public abstract UserDao userDao();
}
