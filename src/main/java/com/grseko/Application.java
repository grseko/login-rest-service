package com.grseko;

import com.grseko.db.UserService;
import com.grseko.db.mongo.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private MongoUserRepository repository;

  @Autowired
  private UserService service;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    repository.deleteAll();

    System.out.println("Inserting admin into database");
    service.createUser("admin", "hunter2");

    System.out.println("UserService.getUser: " + service.getUser("admin"));
  }
}
