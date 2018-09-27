package com.grseko.rest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.grseko.service.User;
import com.grseko.service.UserAuthenticationException;
import com.grseko.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

  private final ModelMapper modelMapper;
  private final UserService userService;

  @Autowired
  public UserRestController(ModelMapper modelMapper, UserService userService) {
    this.modelMapper = modelMapper;
    this.userService = userService;
  }

  @RequestMapping(value = "/login", method = POST)
  public ResponseEntity login(@RequestBody UserDTO userDto) {
    System.out.println("'/login' endpoint called with UserDTO: " + userDto);
    User user = convertToEntity(userDto);
    System.out.println("User from UserDTO: " + user);

    try {
      User authenticatedUser = userService.authenticateUser(user);
      System.out.println("User " + user.getUsername() + " authenticated: " + authenticatedUser);
      return ResponseEntity.status(HttpStatus.OK)
          .body("You're logged in as " + authenticatedUser.getUsername());

    } catch (UserAuthenticationException e) {
      System.out.println("Error while authenticating user " + user + ". Reason: " + e.getMessage());
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("Wrong username/password combination");
    }
  }

  private User convertToEntity(UserDTO userDto) {
    return modelMapper.map(userDto, User.class);
  }

}
