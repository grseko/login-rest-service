package com.grseko.db.mongo;

import com.grseko.db.UserFacade;
import com.grseko.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
  public void createUser(User user) {
    userRepository.insert(user); // TODO Does this automatically update the ID field?
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }

}
