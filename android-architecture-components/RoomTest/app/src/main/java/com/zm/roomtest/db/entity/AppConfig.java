package com.zm.roomtest.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by zhangman on 2017/11/20 10:01.
 * Email: zhangman523@126.com
 */

@Entity(tableName = "t_AppConfig")
public class AppConfig {
  @PrimaryKey @NonNull
  public int id;
  @ColumnInfo(name = "buildTypeName")
  public String buildTypeName;
  @ColumnInfo(name = "baseUrl")
  public String baseUrl;

  public AppConfig(@NonNull int id, String buildTypeName, String baseUrl) {
    this.id = id;
    this.buildTypeName = buildTypeName;
    this.baseUrl = baseUrl;
  }
}
