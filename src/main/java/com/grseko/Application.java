package com.grseko;

import com.grseko.db.UserDAO;
import com.grseko.db.model.user.UserFactory;
import com.grseko.db.mongo.user.MongoUserDAO;
import com.grseko.db.mongo.user.MongoUserFactory;
import com.grseko.db.mongo.user.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private UserDAO userDAO;

  @Autowired
  public Application(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  // TODO Testing purposes
  @Override
  public void run(String... args) throws Exception {
    userDAO.deleteAll();
    System.out.println("Deleted all User entries in DB");
  }

  // Beans

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
