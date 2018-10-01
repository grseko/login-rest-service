package com.grseko.database.mongo.user;

import com.grseko.database.model.user.AbstractUser;
import org.springframework.data.annotation.Id;

class MongoUser extends AbstractUser<String> {

  @Id
  private String id;

  MongoUser() {
    super();
  }

  MongoUser(String username, String password) {
    super(username, password);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + (id == null ? "{not persisted}" : id) + '\'' +
        ", username='" + super.getUsername() + '\'' +
        ", password='" + super.getPassword() + '\'' +
        '}';
  }
}
