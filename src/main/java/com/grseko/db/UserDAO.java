package com.grseko.db;

import com.grseko.db.model.user.User;

public interface UserDAO extends DAO<User, String> {

  User getByUsername(String username);

}
