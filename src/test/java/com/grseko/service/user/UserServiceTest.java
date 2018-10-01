package com.grseko.service.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.grseko.db.UserDAO;
import com.grseko.db.model.user.User;
import com.grseko.db.model.user.UserFactory;
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
  void init(@Mock UserDAO userDAO, @Mock UserFactory userFactory) {
    when(userDAO.getByUsername(ADMIN_USER)).thenReturn(new MockUser(ADMIN_USER, ADMIN_PASSWORD));
    when(userFactory.createUser(anyString(), anyString())).thenReturn(new MockUser());

    this.userService = new UserService(userDAO, userFactory);
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

  private class MockUser implements User<String> {

    private String id;
    private String username;
    private String password;

    MockUser() {
    }

    MockUser(String username, String password) {
      this.username = username;
      this.password = password;
    }

    @Override
    public String getId() {
      return id;
    }

    @Override
    public void setId(String id) {
      this.id = id;
    }

    @Override
    public String getUsername() {
      return username;
    }

    @Override
    public void setUsername(String username) {
      this.username = username;
    }

    @Override
    public String getPassword() {
      return password;
    }

    @Override
    public void setPassword(String password) {
      this.password = password;
    }
  }


}