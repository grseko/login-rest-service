package com.grseko.service;

import org.springframework.data.annotation.Id;

/**
 * Business entity
 */
public class User {

  @Id
  private String id;
  private String username;
  private String password; // TODO Further development options - salt and hash this guy before storage!

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
        "id='" + (id == null ? "{not persisted}" : id) + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
