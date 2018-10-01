package com.grseko.database.dao;

import com.grseko.database.model.user.User;

public interface UserDAO extends DAO<User, String> {

  User getByUsername(String username);

}
