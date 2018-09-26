package com.grseko.model;

import com.grseko.db.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business logic
 *
 * Allowed to perform operations on the database through an interface separating the DB layer.
 */
@Service
public class UserService {

  private final UserFacade userFacade;

  @Autowired
  public UserService(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  public boolean authenticateUser(User user) {
    User persistedUser = userFacade.getUser(user.getUsername());
    return persistedUser != null && passwordsMatch(persistedUser, user);
  }

  private boolean passwordsMatch(User userA, User userB) {
    return userA.getPassword().equals(userB.getPassword()); // Totally safe plaintext password storage and comparison!
  }
}
