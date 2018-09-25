package com.grseko.db;

import com.grseko.services.login.User;

public interface UserService {

  User getUser(String username);

  User createUser(String username, String password);

  void deleteUser(String username);

}
