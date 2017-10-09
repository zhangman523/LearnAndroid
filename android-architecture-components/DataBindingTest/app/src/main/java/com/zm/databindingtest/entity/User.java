package com.zm.databindingtest.entity;

/**
 * Created by zhangman on 2017/9/29 15:28.
 * Email: zhangman523@126.com
 */

public class User {
  private final String firstName;
  private final String lastName;

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
