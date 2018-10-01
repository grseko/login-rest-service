package com.grseko.database.mongo.user;

import com.grseko.database.model.user.User;
import com.grseko.database.model.user.UserFactory;

public class MongoUserFactory implements UserFactory {

  @Override
  public User createUser(String username, String password) {
    return new MongoUser(username, password);
  }
}
