package com.grseko.service.user;

import com.grseko.db.UserDAO;
import com.grseko.db.model.User;
import com.grseko.service.user.exceptions.UserAlreadyExistsException;
import com.grseko.service.user.exceptions.UserAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Common API for operations on {@link User users}.
 */
@Service
public class UserService {

  private final UserDAO userDAO;

  @Autowired
  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  /**
   * Verifies the {@link User user}'s username & password against the DB. Throws {@link
   * UserAuthenticationException} if unsuccessful, otherwise nothing happens
   *
   * TODO Sessions!
   *
   * @param username name of the user to authenticate
   * @param password the user's password
   * @throws UserAuthenticationException if authentication is unsuccessful
   */
  public void authenticateUser(String username, String password)
      throws UserAuthenticationException {
    User user = userDAO.getByUsername(username);
    if (user == null) {
      throw new UserAuthenticationException("Wrong username");
    } else if (!user.getPassword().equals(password)) {
      throw new UserAuthenticationException("Wrong password");
    }

    // TODO Further development: Create and manage sessions
  }

  public void registerUser(String username, String password) throws UserAlreadyExistsException {
    if (userExists(username)) {
      throw new UserAlreadyExistsException();
    }

    User user = new User(username, password);
    userDAO.create(user);
  }

  private boolean userExists(String username) {
    User user = userDAO.getByUsername(username);
    return user != null;
  }
}
