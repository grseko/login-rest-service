package com.grseko.service.user;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.grseko.db.UserDAO;
import com.grseko.db.model.User;
import com.grseko.mockito.MockitoExtension;
import com.grseko.service.user.exceptions.UserAlreadyExistsException;
import com.grseko.service.user.exceptions.UserAuthenticationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  private static final String ADMIN_PASSWORD = "adminpassword";
  private static final String ADMIN_USER = "admin";

  private UserService userService;
  private UserDAO userDAO;

  @BeforeEach
  void init(@Mock UserDAO userDAO) {
    User user = new User(ADMIN_USER, ADMIN_PASSWORD);
    user.setId("adminUserId");

    when(userDAO.getByUsername(ADMIN_USER)).thenReturn(user);

    this.userService = new UserService(userDAO);
    this.userDAO = userDAO;
  }

  @Test
  void givenValidUserWithMatchingPassword_authenticateUser_shouldReturnPersistedUser()
      throws UserAuthenticationException {
    userService.authenticateUser(ADMIN_USER, ADMIN_PASSWORD);
    verify(userDAO, times(1)).getByUsername(ADMIN_USER);
  }

  @Test
  void givenValidUserWithWrongPassword_authenticateUser_shouldThrowException() {
    Exception exception = assertThrows(UserAuthenticationException.class, () ->
        userService.authenticateUser(ADMIN_USER, "wrong_password")
    );
    assertEquals("Wrong password", exception.getMessage());
  }

  @Test
  void givenInvalidUser_authenticateUser_shouldThrowException() {
    Exception exception = assertThrows(UserAuthenticationException.class, () ->
        userService.authenticateUser("bob", "bobs_password")
    );
    assertEquals("Wrong username", exception.getMessage());
  }
  @Test
  void givenNewUser_registerUser_shouldCreateNewUser() throws UserAlreadyExistsException {
    userService.registerUser("newbob", "newbobs_password");
    verify(userDAO, times(1)).create(any(User.class));
  }

  @Test
  void givenExistingUser_registerUser_shouldThrowException() {
    assertThrows(UserAlreadyExistsException.class, () ->
        userService.registerUser(ADMIN_USER, ADMIN_PASSWORD)
    );
  }

}