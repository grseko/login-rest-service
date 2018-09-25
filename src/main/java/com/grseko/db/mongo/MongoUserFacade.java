package com.grseko.db.mongo;

import com.grseko.db.UserFacade;
import com.grseko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MongoUserFacade implements UserFacade {

  private final MongoUserRepository userRepository;

  @Autowired
  public MongoUserFacade(MongoUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public User createUser(String username, String password) {
    User user = new MongoUser(username, password);
    userRepository.insert(user);
    return user;
  }

  @Override
  public void deleteUser(String username) {
    User user = getUser(username);
    userRepository.delete(user);
  }

}
