package com.grseko.rest.user;

import com.grseko.db.model.User;
import java.io.Serializable;

/**
 * Transfer Object for {@link User}.
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
        ", password=" + password + '\'' +
        '}';
  }
}
