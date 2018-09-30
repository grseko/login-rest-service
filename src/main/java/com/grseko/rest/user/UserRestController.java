package com.grseko.rest.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.grseko.service.user.UserService;
import com.grseko.service.user.exceptions.UserAlreadyExistsException;
import com.grseko.service.user.exceptions.UserAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  private static final String USER_SERVICE_PATH = "/user/";

  private final UserService userService;

  @Autowired
  public UserRestController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = USER_SERVICE_PATH + "login", method = POST)
  public ResponseEntity login(@RequestBody UserDTO userDTO) {
    try {
      userService.authenticateUser(userDTO.getUsername(), userDTO.getPassword());
      System.out.println("User '" + userDTO.getUsername() + "' authenticated");
      return ResponseEntity.status(HttpStatus.OK)
          .body("You're logged in as " + userDTO.getUsername());

    } catch (UserAuthenticationException e) {
      System.out
          .println("Error while authenticating user " + userDTO + ". Reason: " + e.getMessage());
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("Wrong username/password combination");
    }
  }

  @RequestMapping(value = USER_SERVICE_PATH + "register", method = POST)
  public ResponseEntity register(@RequestBody UserDTO userDTO) {
    try {
      userService.registerUser(userDTO.getUsername(), userDTO.getPassword());
      System.out.println("User '" + userDTO.getUsername() + "' registered.");
      return ResponseEntity.status(HttpStatus.CREATED)
          .body("You're registered as " + userDTO.getUsername());

    } catch (UserAlreadyExistsException e) {
      System.out.println("Error while creating user: " + e.getMessage());
      return ResponseEntity.status(HttpStatus.FORBIDDEN)
          .body("User already exists");
    }
  }

}
