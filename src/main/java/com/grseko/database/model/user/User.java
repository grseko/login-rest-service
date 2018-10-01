package com.grseko.database.model.user;

public interface User<T> {

  T getId();

  void setId(T id);

  String getUsername();

  void setUsername(String username);

  String getPassword();

  void setPassword(String password);

}
