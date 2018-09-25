package com.grseko.services.login;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.grseko.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  private final UserService userService;

  @Autowired
  public UserRestController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/login", method = POST)
  public String login() {
    System.out.println("'/login' endpoint called!");
    return "Here's a user for you: " + userService.getUser("admin");
  }
}
