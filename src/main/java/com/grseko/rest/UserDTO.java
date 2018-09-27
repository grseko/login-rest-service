package com.grseko.rest;

import java.io.Serializable;

/**
 * Transfer Object for {@link com.grseko.service.User}.
 */
public class UserDTO implements
    Serializable {

  private String id;
  private String username;
  private String password;

  public UserDTO() {
  }

  public UserDTO(String username, String password) {
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
        (id == null ? "" : ("id='" + id + "', ")) +
        // TODO There's probably a library which converts POJOs into a String representation like this
        "username='" + this.username + '\'' +
        ", password='" + this.password + '\'' +
        '}';
  }
}
