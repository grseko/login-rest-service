package com.grseko.db;

import com.grseko.model.User;

/**
 * An interface which abstracts away the underlying JDBC
 */
// TODO Is this a 'Facade' or a 'DAO'? Did I just mash the two patterns together?
// TODO Further development options: https://www.baeldung.com/java-dao-pattern
public interface UserFacade {

  User getUser(String username);

  User createUser(String username, String password);

  void deleteUser(String username);

}
