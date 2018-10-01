package com.grseko.db.mongo.user;

import com.grseko.db.model.user.User;
import com.grseko.db.model.user.UserFactory;

public class MongoUserFactory implements UserFactory {

  @Override
  public User createUser(String username, String password) {
    return new MongoUser(username, password);
  }
}
