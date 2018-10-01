package com.grseko.db.model.user;

// TODO Singleton in Java SE?
public abstract class AbstractUser<T> implements User<T> {

  private String username;
  private String password; // TODO Further development options - salt and hash before storage!

  public AbstractUser() {
  }

  public AbstractUser(String username, String password) {
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
        "id='" + (getId() == null ? "{not persisted}" : getId()) + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
