package com.grseko.service.user.exceptions;

public class UserAlreadyExistsException extends Exception {

  public UserAlreadyExistsException() {
    super("User already exists");
  }

}
