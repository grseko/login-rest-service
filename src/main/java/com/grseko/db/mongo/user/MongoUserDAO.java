package com.grseko.db.mongo.user;

import com.grseko.db.UserDAO;
import com.grseko.db.model.user.User;
import com.grseko.db.mongo.MongoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDAO extends MongoDAO<User, String> implements UserDAO {

  private MongoUserRepository repository;

  @Autowired
  public MongoUserDAO(MongoUserRepository userRepository) {
    this.repository = userRepository;
  }

  @Override
  public User getByUsername(String username) {
    return repository.findByUsername(username);
  }

  @Override
  public MongoRepository<User, String> getRepository() {
    return repository;
  }

}
