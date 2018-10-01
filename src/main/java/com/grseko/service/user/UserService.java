package com.grseko.service.user;

import com.grseko.db.model.user.User;
import com.grseko.service.user.exceptions.UserAlreadyExistsException;
import com.grseko.service.user.exceptions.UserAuthenticationException;

public interface UserService {

  /**
   * Verifies the {@link User}'s credentials.
   *
   * @param username name of the user to authenticate
   * @param password the user's password
   * @throws UserAuthenticationException if authentication is unsuccessful
   */
  void authenticateUser(String username, String password) throws UserAuthenticationException;

  /**
   * Registers a new {@link User}.
   *
   * @param username name of the new user
   * @param password password to set
   * @throws UserAlreadyExistsException if a user with the same name already exists
   */
  void registerUser(String username, String password) throws UserAlreadyExistsException;

}
