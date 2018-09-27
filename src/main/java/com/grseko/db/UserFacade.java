package com.grseko.db;

import com.grseko.service.User;

/**
 * An interface which abstracts away the underlying JDBC
 */
// TODO This is a bad Facade. It should be a DAO.
// TODO Further development options: https://www.baeldung.com/java-dao-pattern
public interface UserFacade {

  User getUser(String username);

  void createUser(User user);

  void deleteUser(User user);

}
