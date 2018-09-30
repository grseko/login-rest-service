package com.grseko.db;

import com.grseko.db.model.User;

public interface UserDAO extends DAO<User, String> {

  User getByUsername(String username);

}
