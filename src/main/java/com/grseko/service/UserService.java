package com.grseko.service;

import com.grseko.db.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Common API for operations on {@link User users}.
 */
@Service
public class UserService {

  private final UserFacade userFacade;

  @Autowired
  public UserService(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  /**
   * Checks if the {@link User} exists in the database with a matching password.
   *
   * @param user User to authenticate
   * @return `true` if user exists AND has a matching password, `false` otherwise
   */
  public boolean authenticate(User user) {
    User persistedUser = userFacade.getUser(user.getUsername());
    return persistedUser != null && passwordsMatch(persistedUser, user);
  }

  /**
   * Authenticates the {@link User} (verifies username/password) against the DB.
   * If successful, returns the persisted user.
   * If unsuccessful, throws {@link UserAuthenticationException}.
   *
   * @param user user to authenticate
   * @return the authenticated user
   * @throws UserAuthenticationException if authentication is unsuccessful
   */
  public User authenticateUser(User user) throws UserAuthenticationException {
    User persistedUser = userFacade.getUser(user.getUsername());
    if (persistedUser == null) {
      throw new UserAuthenticationException("Wrong username");
    } else
    if (!passwordsMatch(persistedUser, user)) {
      throw new UserAuthenticationException("Wrong password");
    }

    return persistedUser;
  }

  private boolean passwordsMatch(User userA, User userB) {
    return userA.getPassword()
        .equals(userB.getPassword()); // Totally safe plaintext password storage and comparison!
  }
}
