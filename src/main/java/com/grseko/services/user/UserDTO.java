package com.grseko.services.user;

import java.io.Serializable;

public class UserDTO implements Serializable { // TODO Create a UserService for validation and UserDAOHelper for transformation

  private String username;
  private String password;

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

}
