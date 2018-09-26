package com.grseko.rest;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.grseko.model.User;
import com.grseko.model.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
  public String login(@RequestBody UserDto userDto) {
    System.out.println("'/login' endpoint called with UserDto: " + userDto);
    User user = convertToEntity(userDto);
    System.out.println("User from UserDto: " + user);

    if (userService.authenticateUser(user)) {
      return "You're logged in! Or you would be, if sessions existed.";
    } else {
      return "Wrong username/password combination";
    }
  }

  private User convertToEntity(UserDto userDto) {
    return modelMapper.map(userDto, User.class);
  }
}
