package com.grseko.db.mongo;

import com.grseko.db.UserService;
import com.grseko.services.login.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoUserService implements UserService {

  private final MongoUserRepository userRepository;

  @Autowired
  public MongoUserService(MongoUserRepository userRepository) {
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
