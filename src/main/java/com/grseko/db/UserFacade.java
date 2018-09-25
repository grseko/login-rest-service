package com.grseko.db;

import com.grseko.model.User;

public interface UserFacade {

  User getUser(String username);

  User createUser(String username, String password);

  void deleteUser(String username);

}
