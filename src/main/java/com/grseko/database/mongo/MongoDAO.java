package com.grseko.database.mongo;

import com.grseko.database.dao.DAO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class MongoDAO<E, T> implements DAO<E, T> {

  @Override
  public void create(E e) {
    getRepository().insert(e);
  }

  @Override
  public Optional<E> get(T id) {
    return getRepository().findById(id);
  }

  @Override
  public List<E> getAll() {
    return getRepository().findAll();
  }

  @Override
  public void delete(E e) {
    getRepository().delete(e);
  }

  @Override
  public void deleteAll() {
    getRepository().deleteAll();
  }

  protected abstract MongoRepository<E, T> getRepository();
}
