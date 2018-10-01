package com.grseko;

import com.grseko.database.dao.UserDAO;
import com.grseko.database.model.user.UserFactory;
import com.grseko.database.mongo.user.MongoUserDAO;
import com.grseko.database.mongo.user.MongoUserFactory;
import com.grseko.database.mongo.user.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

  @Bean
  @Autowired
  public UserDAO userDAO(MongoUserRepository mongoUserRepository) {
    return new MongoUserDAO(mongoUserRepository);
  }

  @Bean
  public UserFactory userFactory() {
    return new MongoUserFactory();
  }

}
