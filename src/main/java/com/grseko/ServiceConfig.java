package com.grseko;

import com.grseko.database.dao.UserDAO;
import com.grseko.database.model.user.UserFactory;
import com.grseko.service.user.DefaultUserService;
import com.grseko.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  @Bean
  @Autowired
  public UserService userService(UserDAO userDAO, UserFactory userFactory) {
    return new DefaultUserService(userDAO, userFactory);
  }

}
