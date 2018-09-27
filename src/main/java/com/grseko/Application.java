package com.grseko;

import com.grseko.db.UserFacade;
import com.grseko.db.mongo.MongoUserRepository;
import com.grseko.service.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

  // TODO Separate DB, business, and REST layers into separate modules entirely to prevent circular dependencies.

  @Autowired
  private MongoUserRepository userRepository;

  @Autowired
  private UserFacade userFacade;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();

    System.out.println("Inserting admin into database");
    User user = new User("admin", "hunter2");
    System.out.println("'user' before storage: " + user);
    userFacade.createUser(user);
    System.out.println("'user' after storage: " + user);

    System.out.println("UserFacade.getUser: " + userFacade.getUser("admin"));
  }

  // Beans

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
