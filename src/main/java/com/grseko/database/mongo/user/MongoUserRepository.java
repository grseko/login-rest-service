package com.grseko.database.mongo.user;

import com.grseko.database.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<User, String> {

  User findByUsername(String username);

}
