package com.grseko.db.mongo;

import com.grseko.model.User;
import org.springframework.data.annotation.Id;

class MongoUser extends User {

  @Id
  private String id;

  public MongoUser(String username, String password) {
    super(username, password);
  }

  @Override
  public String toString() {
    return "MongoUser{" +
        "id='" + id + '\'' +
        ", username='" + super.getUsername() + '\'' +
        ", password='" + super.getPassword() + '\'' +
        '}';
  }
}
