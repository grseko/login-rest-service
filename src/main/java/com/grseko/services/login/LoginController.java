package com.grseko.services.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @RequestMapping("/login")
  public String login() {
    System.out.println("'/login' service was called");
    return "You called the '/login' service";
  }
}
