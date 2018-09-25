package com.grseko.db.mongo;

import com.grseko.services.login.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<User, String> {

  User findByUsername(String username);

}
