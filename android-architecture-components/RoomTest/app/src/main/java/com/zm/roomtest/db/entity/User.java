package com.zm.roomtest.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.UUID;

/**
 * Created by zhangman on 2017/9/27 15:58.
 * Email: zhangman523@126.com
 */
@Entity(tableName = "Users")
public class User {
  @PrimaryKey @NonNull
  private String uid;
  @ColumnInfo(name = "userName")
  private String userName;

  @Ignore
  public User(String userName) {
    uid = UUID.randomUUID().toString();
    this.userName = userName;
  }

  public User(String uid, String userName) {
    this.uid = uid;
    this.userName = userName;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
