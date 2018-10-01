package com.grseko;

import com.grseko.database.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
