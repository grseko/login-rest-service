package com.grseko.model;

/**
 * Business entity
 */
public class User {

  private String username;
  private String password; // TODO Further development options - salt and hash this guy before storage!

  public User() {}

  public User(String username, String password) {
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
