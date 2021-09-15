package ru.gb.service;

import java.util.List;
import ru.gb.domain.Product;

public interface ProductService {

  Product getById(long id);

  List<Product> getAll();

}
