package com.grseko.services.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.grseko.db.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  private final UserFacade userFacade;

  @Autowired
  public UserRestController(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  @RequestMapping(value = "/login", method = POST)
  public String login() {
    System.out.println("'/login' endpoint called!");
    return "Here's a user for you: " + userFacade.getUser("admin");
  }
}
