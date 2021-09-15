package ru.gb.dao;

import java.util.List;
import java.util.Optional;
import ru.gb.domain.Product;

public interface ProductDao {

  Optional<Product> findById(Long id);

  List<Product> findAll();

  void deleteById(Long id);

  Product saveOrUpdate(Product product);
}
