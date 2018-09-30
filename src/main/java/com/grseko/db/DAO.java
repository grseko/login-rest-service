package com.grseko.db;

import java.util.List;
import java.util.Optional;

public interface DAO<E, T> {

  void create(E e);

  Optional<E> get(T id);

  List<E> getAll();

  void delete(E e);

  void deleteAll();

}
