package com.grseko.rest;

import java.io.Serializable;

public class UserDto implements
    Serializable {

  private String username;
  private String password;

  public UserDto() {
  }

  public UserDto(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + this.username + '\'' +
        ", password='" + this.password + '\'' +
        '}';
  }
}
